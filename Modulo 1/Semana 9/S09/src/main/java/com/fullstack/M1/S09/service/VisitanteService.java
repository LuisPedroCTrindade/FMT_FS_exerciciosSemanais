package com.fullstack.M1.S09.service;

import com.fullstack.M1.S09.entity.VisitanteEntity;
import com.fullstack.M1.S09.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitanteService {

    private final VisitanteRepository visitanteRepository;


    public VisitanteEntity salvarVisitante(VisitanteEntity visitanteEntity) {
        return visitanteRepository.save(visitanteEntity);
    }

    public List<VisitanteEntity> buscarAllVisitantes() {
        return visitanteRepository.findAll();
    }

    public ResponseEntity<?> deletarVisitante(Long id) {
        if (!visitanteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O visitante de ID " + id + " não foi localizado no sistema.");
        }
        visitanteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Visitante de ID " + id + " excluído com sucesso.");
    }

    public VisitanteEntity atualizarVisitanteQuery(VisitanteEntity visitanteEntity) {
        Long id = visitanteEntity.getId();
        if (id == null || !visitanteRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return visitanteRepository.save(visitanteEntity);
    }

    public VisitanteEntity atualizarVisitante(VisitanteEntity visitanteEntity) {
        Long id = visitanteEntity.getId();
        if (id == null || !visitanteRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return visitanteRepository.save(visitanteEntity);
    }
}
