package br.com.M3S02.M3S02.controller.dto.request;

import java.time.LocalDateTime;

public record ComentarioRequest(
        Long sugestaoId,
        String texto,
        LocalDateTime dataEnvio
) {}
