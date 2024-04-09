package com.fullstack.M1.S09.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LivroRequest {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
}
