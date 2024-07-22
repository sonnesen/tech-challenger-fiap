package br.com.fotoexpress.fotoexpress.pedido.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

    @GetMapping
//    @Operation(summary = "get summary", description = "Get description",
//            responses = @ApiResponse(responseCode = "200", description = "Ok", content = {@Content(schema = @Schema(implementation = String.class))}))
    public String get() {
        return "OK podemos comecar os pedidos";
    }


}
