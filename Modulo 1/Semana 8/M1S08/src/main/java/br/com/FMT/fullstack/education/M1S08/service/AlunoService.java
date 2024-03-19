package br.com.FMT.fullstack.education.M1S08.service;

import br.com.FMT.fullstack.education.M1S08.model.AlunoModel;
import br.com.FMT.fullstack.education.M1S08.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    public List<AlunoModel> buscarTodos() {
        return AlunoModel.getAlunosRegistrados();
    }

    public AlunoModel buscarPorId(Integer id) throws Exception {
        return AlunoModel.buscarPorId(id);
    }

    public AlunoModel registrar(AlunoModel aluno) throws Exception {
        if (validar(aluno)) {
            return AlunoModel.registrar(aluno);
        }
        return null;
    }

    private boolean validar (AlunoModel aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório.");
        }
        if (aluno.getDataNascimento() == null) {
            throw new Exception("Data de nascimento é obrigatória.");
        }
        return true;
    }
}
