package com.fullstack.M1.S09.service;

import com.fullstack.M1.S09.entity.EmprestimoEntity;
import com.fullstack.M1.S09.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;


    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimoEntity) {
        return emprestimoRepository.save(emprestimoEntity);
    }

    public List<EmprestimoEntity> buscarAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public ResponseEntity<?> deletarEmprestimo(Long id) {
        if (!emprestimoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O empréstimo de ID " + id + " não foi localizado no sistema.");
        }
        emprestimoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Empréstimo de ID " + id + " excluído com sucesso.");
    }

    public EmprestimoEntity atualizarEmprestimoQuery(EmprestimoEntity emprestimoEntity) {
        Long id = emprestimoEntity.getId();
        if (id == null || !emprestimoRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return emprestimoRepository.save(emprestimoEntity);
    }

    public EmprestimoEntity atualizarEmprestimo(EmprestimoEntity emprestimoEntity) {
        Long id = emprestimoEntity.getId();
        if (id == null || !emprestimoRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return emprestimoRepository.save(emprestimoEntity);
    }
}
