package br.com.fotoexpress.formalizacao.services;

import br.com.fotoexpress.exceptions.FormalizacaoException;
import br.com.fotoexpress.exceptions.PedidoException;
import br.com.fotoexpress.formalizacao.model.Formalizacao;
import br.com.fotoexpress.formalizacao.model.dto.DocuSignRequestDTO;
import br.com.fotoexpress.formalizacao.model.dto.FormalizacaoDTO;
import br.com.fotoexpress.formalizacao.model.dto.FormalizacaoRequestDTO;
import br.com.fotoexpress.formalizacao.repository.FormalizacaoRepository;
import br.com.fotoexpress.pedido.model.Pedido;
import br.com.fotoexpress.pedido.model.enums.StatusPedido;
import br.com.fotoexpress.pedido.services.PedidoService;
import com.docusign.esign.client.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FormalizacaoService {
    private FormalizacaoRepository formalizacaoRepository;
    private DocuSignService docuSignService;
    private ContratoPDFService contratoPDFService;
    private PedidoService pedidoService;

    @Autowired
    public FormalizacaoService(
            FormalizacaoRepository formalizacaoRepository,
            DocuSignService docuSignService,
            ContratoPDFService contratoPDFService,
            PedidoService pedidoService
            ) {
        this.formalizacaoRepository = formalizacaoRepository;
        this.docuSignService = docuSignService;
        this.contratoPDFService = contratoPDFService;
        this.pedidoService = pedidoService;
    }

    public FormalizacaoDTO save(FormalizacaoRequestDTO formalizacaoRequestDTO) throws IOException, ApiException {
        try {
            Formalizacao formalizacaoExistente = formalizacaoRepository.buscaFormalizacaoPorPedidoId(formalizacaoRequestDTO.pedidoId());
            if (formalizacaoExistente != null) {
                throw new FormalizacaoException("O pedido já possui uma formalização.", HttpStatus.BAD_REQUEST);
            }

            Pedido pedido = pedidoService.buscaPedidoPorId(formalizacaoRequestDTO.pedidoId());
            if(pedido == null) {
                throw new PedidoException("Pedido não encontrado pelo id, " + formalizacaoRequestDTO.pedidoId(), HttpStatus.NOT_FOUND);
            }

            byte[] contrato = contratoPDFService.get();
            String docuSignId = docuSignService.sendEnvelope(pedido.getCliente().getEmail(), pedido.getCliente().getNome(), contrato);

            Formalizacao formalizacao = new Formalizacao();
            formalizacao.setPedido(pedido);
            formalizacao.setContratoId(docuSignId);
            formalizacao.formalizar();

            formalizacaoRepository.save(formalizacao);

            pedidoService.adicionarContratoIdaoPedido(formalizacaoRequestDTO.pedidoId(), docuSignId);

            return toFormalizacaoDTO(formalizacao);
        } catch (ApiException e) {
            throw new ApiException(500, "Erro ao enviar envelope DocuSign: " + e.getMessage());
        } catch (IOException e) {
            throw new IOException("Erro ao buscar o arquivo");
        } catch (FormalizacaoException e) {
            throw new FormalizacaoException("Erro ao tentar formalizar o pedido: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public FormalizacaoDTO assinarContrato(DocuSignRequestDTO docuSignRequestDTO) {
        try {
            Formalizacao formalizacao = formalizacaoRepository.buscaFormalizacaoPorContratoId(docuSignRequestDTO.envelopeId());
            if(formalizacao == null) {
                throw new FormalizacaoException("Não foi encontrado uma formalização para este contrato.", HttpStatus.NOT_FOUND);
            }
            formalizacao.assinarContrato();
            formalizacaoRepository.save(formalizacao);
            pedidoService.mudaStatusPedido(formalizacao.getPedido().getId(), StatusPedido.AGENDAR.getId());

            return toFormalizacaoDTO(formalizacao);
        }  catch (FormalizacaoException e) {
            throw new FormalizacaoException("Erro ao tentar formalizar o pedido: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    private FormalizacaoDTO toFormalizacaoDTO(Formalizacao formalizacao) {
        return new FormalizacaoDTO(
                formalizacao.getId(),
                formalizacao.getPedido().getId(),
                formalizacao.getPedido().getCliente().getNome(),
                formalizacao.getPedido().getCliente().getEmail(),
                formalizacao.getDataFormalizacao(),
                formalizacao.getContratoId(),
                formalizacao.getStatusFormalizacao()
        );
    }

    private Formalizacao toFormalizacao(FormalizacaoDTO formalizacaoDTO) {
        Pedido pedido = pedidoService.buscaPedidoPorId(formalizacaoDTO.pedidoId());
        return new Formalizacao(
                formalizacaoDTO.id(),
                formalizacaoDTO.dataFormalizacao(),
                formalizacaoDTO.contratoEnviadoId(),
                formalizacaoDTO.statusFormalizacao(),
                pedido
        );
    }
}
