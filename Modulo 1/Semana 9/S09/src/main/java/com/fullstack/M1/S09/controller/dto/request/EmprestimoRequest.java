package com.fullstack.M1.S09.controller.dto.request;

import com.fullstack.M1.S09.entity.LivroEntity;
import com.fullstack.M1.S09.entity.MembroEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmprestimoRequest {

    private Long id;
    private LivroEntity livroId;
    private MembroEntity membroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}