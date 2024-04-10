package com.fullstack.M1.S10.service;

import com.fullstack.M1.S10.controller.dto.request.AlunoRequest;
import com.fullstack.M1.S10.entity.AlunoEntity;
import com.fullstack.M1.S10.exception.NotFoundException;
import com.fullstack.M1.S10.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<AlunoEntity> buscarTodos() {
        return alunoRepository.findAll();
    }
    
    public AlunoEntity buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new NotFoundException("Aluno de ID " + id + " não encontrado."));
    }

    public AlunoEntity salvar(AlunoEntity alunoEntity) {
        alunoEntity.setId(null);

        return alunoRepository.save(alunoEntity);
    }

    public AlunoEntity atualizar(Long id, AlunoEntity alunoEntity) {
        AlunoEntity alunoAlterado = buscarPorId(id);

        alunoAlterado.setNome(alunoEntity.getNome());

        return alunoRepository.save(alunoAlterado);
    }

    public void excluir(Long id) {
        AlunoEntity alunoEntity = buscarPorId(id);
        alunoRepository.delete(alunoEntity);
    }
}
