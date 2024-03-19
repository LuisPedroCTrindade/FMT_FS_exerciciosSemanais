package br.com.FMT.fullstack.education.M1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class AlunoModel {
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    @Getter private static List<AlunoModel> alunosRegistrados = new ArrayList<>();

    private static Integer proximoId = 1;

    private static Integer getProximoId() {
        return proximoId++;
    }

    public static AlunoModel registrar(AlunoModel aluno) {
        aluno.id = aluno.getProximoId();
        alunosRegistrados.add(aluno);
        return aluno;
    }

    public static AlunoModel buscarPorId(Integer id) throws Exception {
        for (AlunoModel aluno : alunosRegistrados) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }
}
