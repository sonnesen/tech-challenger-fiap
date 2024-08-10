package br.com.fotoexpress.formalizacao.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ContratoPDFService {
    public byte[] get() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("documentos/contrato_fotoexpress.pdf");
        Path pdf = classPathResource.getFile().toPath();
        return Files.readAllBytes(pdf);
    }
}
