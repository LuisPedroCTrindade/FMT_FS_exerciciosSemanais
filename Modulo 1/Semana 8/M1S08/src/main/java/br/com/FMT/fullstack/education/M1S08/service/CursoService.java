package br.com.FMT.fullstack.education.M1S08.service;

import br.com.FMT.fullstack.education.M1S08.model.AlunoModel;
import br.com.FMT.fullstack.education.M1S08.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<CursoModel> buscarTodos() {
        return CursoModel.getCursosRegistrados();
    }

    public CursoModel buscarPorId(Integer id) throws Exception {
        return CursoModel.buscarPorId(id);
    }

    public CursoModel registrar(CursoModel curso) throws Exception {
        if (validar(curso)) {
            return CursoModel.registrar(curso);
        }
        return null;
    }

    public CursoModel matricular(Integer id, Integer idAluno) throws Exception {
        CursoModel curso = buscarPorId(id);
        AlunoModel aluno = alunoService.buscarPorId(idAluno);
        CursoModel.matricular(curso, aluno);
        return curso;
    }

    private boolean validar (CursoModel curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório.");
        }
        if (curso.getCargaHoraria() == null) {
            throw new Exception("Carga horária é obrigatória.");
        }
        return true;
    }
}
