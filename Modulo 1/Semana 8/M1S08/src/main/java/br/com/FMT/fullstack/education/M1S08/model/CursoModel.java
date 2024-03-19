package br.com.FMT.fullstack.education.M1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CursoModel {
    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private List<AlunoModel> alunosMatriculados = new ArrayList<>();

    @Getter private static List<CursoModel> cursosRegistrados = new ArrayList<>();

    private static Integer proximoId = 1;

    private Integer getProximoId() {
        return proximoId++;
    }

    public static CursoModel registrar(CursoModel curso) {
        curso.id = curso.getProximoId();
        cursosRegistrados.add(curso);
        return curso;
    }

    public static CursoModel buscarPorId(Integer id) throws Exception {
        for (CursoModel curso : cursosRegistrados) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    public static void matricular(CursoModel curso, AlunoModel aluno) {
        curso.getAlunosMatriculados().add(aluno);
    }
}