package com.projeto1.instituicaoEnsino.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class AlunoModel {

    private static Integer proximoId = 1;
    private static List<AlunoModel> alunosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private Date dataNascimento;

    public static AlunoModel salvarAluno(AlunoModel aluno) {
        aluno.id = proximoId++;
        return aluno;
    }
}
