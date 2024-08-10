package br.com.fotoexpress.pedido.services;

import br.com.fotoexpress.exceptions.PedidoException;
import br.com.fotoexpress.pedido.model.Cliente;
import br.com.fotoexpress.pedido.model.Pedido;
import br.com.fotoexpress.pedido.model.dto.PacoteDTO;
import br.com.fotoexpress.pedido.model.dto.PedidoRequest;
import br.com.fotoexpress.pedido.model.dto.PedidoResponse;
import br.com.fotoexpress.pedido.model.enums.StatusPedido;
import br.com.fotoexpress.pedido.model.mappers.PacoteMapper;
import br.com.fotoexpress.pedido.model.mappers.PedidoResponseMapper;
import br.com.fotoexpress.pedido.repository.PedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PedidoService {

    private PacotesService pacotesService;
    private ClienteService clienteService;
    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PacotesService pacotesService,
                         ClienteService clienteService,
                         PedidoRepository pedidoRepository) {
        this.pacotesService = pacotesService;
        this.clienteService = clienteService;
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoResponse> buscaPedidosCadastrados() {
        List<Pedido> pedidos = pedidoRepository.findAll();

        return pedidos
                .stream()
                .map(PedidoResponseMapper.builder().build()::getPedidoDTO)
                .collect(Collectors.toList());
    }

    public void salvaPedido(PedidoRequest pedidoDTO) {

        List<PacoteDTO> pacotes = pacotesService.buscaListaPacotesPorId(pedidoDTO.getIdPacotes());

        Cliente cliente = clienteService.buscaClientePorId(pedidoDTO.getIdCliente());

        Pedido pedido = Pedido
                .builder()
                .status(StatusPedido.EM_ANDAMENTO)
                .dataPedido(LocalDateTime.now())
                .pacotes(
                        pacotes
                                .stream()
                                .map(PacoteMapper.builder().build()::getPacoteEntity)
                                .collect(Collectors.toList()))
                .cliente(cliente)
                .valor(pedidoDTO.getValorPacotes(pacotes))
                .desconto(pedidoDTO.getDesconto())
                .build();
        try {
            pedidoRepository.save(pedido);
        } catch (PedidoException e) {
            log.info("Erro ao salvar pedido");
            throw new PedidoException("Não foi possivel salvar o pedido, erro:" + e.getMessage());
        }

    }

    public void mudaStatusPacote(Long idPacote, int status) {

        try {
           var pedido = pedidoRepository
                    .findById(idPacote).orElseThrow();

            pedido.setStatus(StatusPedido.getById(status));

            pedidoRepository.save(pedido);
       } catch (PedidoException e) {
            log.info("Erro ao atualizar o pedido, erro:" + e.getMessage());
            throw new PedidoException("Não foi possivel salvar o pedido, erro:" + e.getMessage());
        }

    }
  
    public Pedido buscaPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}
