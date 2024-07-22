package br.com.fotoexpress.fotoexpress.formalizacao.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formalizacao")
public class FormalizacaoResource {

    @GetMapping
    public String get() {
        return "OK podemos comecar as formalizacoes";
    }


}
