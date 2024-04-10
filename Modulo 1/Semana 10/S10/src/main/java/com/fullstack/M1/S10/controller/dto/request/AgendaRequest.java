package com.fullstack.M1.S10.controller.dto.request;

import com.fullstack.M1.S10.entity.AlunoEntity;
import com.fullstack.M1.S10.entity.TutorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AgendaRequest {
    private Long id;
    private AlunoEntity aluno;
    private TutorEntity tutor;
    private LocalDate data;
    private String status;
    private String tema;
    private String descricaoBreve;
}
