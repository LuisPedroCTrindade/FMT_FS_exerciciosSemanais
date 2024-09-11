package br.com.M3S02.M3S02.controller.dto.request;

import java.time.LocalDateTime;

public record SugestaoRequest(
        String titulo,
        String descricao,
        LocalDateTime dataEnvio,
        LocalDateTime dataAtualizacao
) {}
