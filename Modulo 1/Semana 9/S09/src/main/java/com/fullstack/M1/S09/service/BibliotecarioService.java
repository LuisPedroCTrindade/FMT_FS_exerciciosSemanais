package com.fullstack.M1.S09.service;

import com.fullstack.M1.S09.entity.BibliotecarioEntity;
import com.fullstack.M1.S09.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    public BibliotecarioEntity salvarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        return bibliotecarioRepository.save(bibliotecarioEntity);
    }

    public List<BibliotecarioEntity> buscarAllBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public ResponseEntity<?> deletarBibliotecario(Long id) {
        if (!bibliotecarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O bibliotecário de ID " + id + " não foi localizado no sistema.");
        }
        bibliotecarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Bibliotecário de ID " + id + " excluído com sucesso.");
    }

    public BibliotecarioEntity atualizarBibliotecarioQuery(BibliotecarioEntity bibliotecarioEntity) {
        Long id = bibliotecarioEntity.getId();
        if (id == null || !bibliotecarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return bibliotecarioRepository.save(bibliotecarioEntity);
    }

    public BibliotecarioEntity atualizarBibliotecario(BibliotecarioEntity bibliotecarioEntity) {
        Long id = bibliotecarioEntity.getId();
        if (id == null || !bibliotecarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return bibliotecarioRepository.save(bibliotecarioEntity);
    }
}
