package com.fullstack.M1.S09.service;

import com.fullstack.M1.S09.entity.MembroEntity;
import com.fullstack.M1.S09.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;


    public MembroEntity salvarMembro(MembroEntity membroEntity) {
        return membroRepository.save(membroEntity);
    }

    public List<MembroEntity> buscarAllMembros() {
        return membroRepository.findAll();
    }

    public ResponseEntity<?> deletarMembro(Long id) {
        if (!membroRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O membro de ID " + id + " não foi localizado no sistema.");
        }
        membroRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Membro de ID " + id + " excluído com sucesso.");
    }

    public MembroEntity atualizarMembroQuery(MembroEntity membroEntity) {
        Long id = membroEntity.getId();
        if (id == null || !membroRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return membroRepository.save(membroEntity);
    }

    public MembroEntity atualizarMembro(MembroEntity membroEntity) {
        Long id = membroEntity.getId();
        if (id == null || !membroRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return membroRepository.save(membroEntity);
    }
}
