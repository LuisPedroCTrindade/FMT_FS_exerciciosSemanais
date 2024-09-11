package br.com.M3S02.M3S02.controller.dto.response;

import java.time.LocalDateTime;

public record ComentarioResponse(
        Long id,
        Long sugestaoId,
        String texto,
        LocalDateTime dataEnvio
) {
}
