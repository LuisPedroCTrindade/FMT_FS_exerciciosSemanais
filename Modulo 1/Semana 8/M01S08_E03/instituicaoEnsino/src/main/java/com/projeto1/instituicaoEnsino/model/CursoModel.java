package com.projeto1.instituicaoEnsino.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CursoModel {

    private static Integer proximoId = 1;
    private static List<CursoModel> cursosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;

    public static CursoModel salvar(CursoModel curso) {
        curso.id = proximoId++;
        cursosCadastrados.add(curso);
        return curso;
    }
}
