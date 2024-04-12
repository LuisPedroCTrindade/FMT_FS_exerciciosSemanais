package com.M1.S11_1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public record CriarNotaRequest(String titulo) {
}
