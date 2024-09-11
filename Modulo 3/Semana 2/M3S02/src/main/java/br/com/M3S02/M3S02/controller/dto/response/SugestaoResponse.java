package br.com.M3S02.M3S02.controller.dto.response;

import java.time.LocalDateTime;

public record SugestaoResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataEnvio,
        LocalDateTime dataAtualizacao
) {
}
