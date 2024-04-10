package com.fullstack.M1.S10.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoRequest {
    private Long id;
    private String nome;
}
