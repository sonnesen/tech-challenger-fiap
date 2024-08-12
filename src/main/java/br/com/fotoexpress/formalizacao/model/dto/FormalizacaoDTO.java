package br.com.fotoexpress.formalizacao.model.dto;

import br.com.fotoexpress.formalizacao.model.enums.StatusFormalizacao;

import java.time.LocalDateTime;

public record FormalizacaoDTO(
        Long id,
        Long pedidoId,
        String nomeCliente,
        String emailCliente,
        LocalDateTime dataFormalizacao,
        String contratoEnviadoId,
        StatusFormalizacao statusFormalizacao
) {
}
