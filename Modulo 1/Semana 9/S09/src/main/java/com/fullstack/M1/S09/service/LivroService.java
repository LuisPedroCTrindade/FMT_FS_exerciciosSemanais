package com.fullstack.M1.S09.service;

import com.fullstack.M1.S09.entity.LivroEntity;
import com.fullstack.M1.S09.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroEntity salvarLivro(LivroEntity livroEntity) {
        return livroRepository.save(livroEntity);
    }

    public List<LivroEntity> buscarAllLivros() {
        return livroRepository.findAll();
    }

    public ResponseEntity<?> deletarLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O livro de ID " + id + " não foi localizado no sistema.");
        }
        livroRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Livro de ID " + id + " excluído com sucesso.");
    }

    public LivroEntity atualizarLivroQuery(LivroEntity livroEntity) {
        Long id = livroEntity.getId();
        if (id == null || !livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return livroRepository.save(livroEntity);
    }

    public LivroEntity atualizarLivro(LivroEntity livroEntity) {
        Long id = livroEntity.getId();
        if (id == null || !livroRepository.existsById(id)) {
            throw new IllegalArgumentException("Bibliotecário de ID " + id + " não encontrado no sistema.");
        }

        return livroRepository.save(livroEntity);
    }
}
