package br.com.fotoexpress.formalizacao.resources;

import br.com.fotoexpress.formalizacao.model.dto.DocuSignRequestDTO;
import br.com.fotoexpress.formalizacao.model.dto.FormalizacaoDTO;
import br.com.fotoexpress.formalizacao.model.dto.FormalizacaoRequestDTO;
import br.com.fotoexpress.formalizacao.services.FormalizacaoService;
import br.com.fotoexpress.pedido.services.PacotesService;
import br.com.fotoexpress.pedido.services.PedidoService;
import com.docusign.esign.client.ApiException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/formalizacao")
public class FormalizacaoResource {
    private FormalizacaoService formalizacaoService;

    @Autowired
    public FormalizacaoResource(FormalizacaoService formalizacaoService) {
        this.formalizacaoService = formalizacaoService;
    }

    @GetMapping
    public String get() {
        return "OK podemos comecar as formalizacoes";
    }

    @PostMapping
    @Operation(summary = "Cria uma nova formalização para o pedido", description = "Cria nova formalização para o pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<FormalizacaoDTO> save(@RequestBody FormalizacaoRequestDTO formalizacaoRequestDTO) throws IOException, ApiException {
        FormalizacaoDTO formalizacaoDTO = formalizacaoService.save(formalizacaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(formalizacaoDTO);
    }

    @PostMapping("contrato-assinado")
    @Operation(summary = "Assinatura de contrato", description = "Recebe o evento de assinatura de contrato")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<FormalizacaoDTO> assinarContrato(@RequestBody DocuSignRequestDTO docuSignRequestDTO) {
        FormalizacaoDTO formalizacaoDTO = formalizacaoService.assinarContrato(docuSignRequestDTO);
        return  ResponseEntity.ok().body(formalizacaoDTO);
    }
}
