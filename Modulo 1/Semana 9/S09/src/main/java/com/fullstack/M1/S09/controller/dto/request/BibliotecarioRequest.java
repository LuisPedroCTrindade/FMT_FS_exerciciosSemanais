package com.fullstack.M1.S09.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BibliotecarioRequest {
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
