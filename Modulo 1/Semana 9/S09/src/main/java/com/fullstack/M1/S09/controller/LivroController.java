package com.fullstack.M1.S09.controller;

import com.fullstack.M1.S09.controller.dto.request.LivroRequest;
import com.fullstack.M1.S09.entity.LivroEntity;
import com.fullstack.M1.S09.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor

public class LivroController {

    private final LivroService livroService;

    @PostMapping
    public LivroEntity criarLivro(@RequestBody LivroRequest livroRequest) {
        return livroService.salvarLivro(
                new LivroEntity(
                        livroRequest.getTitulo(),
                        livroRequest.getAutor(),
                        livroRequest.getAnoPublicacao()
                )
        );
    }

    @GetMapping("/livro")
    public List<LivroEntity> retornarAllLivros() {
        return livroService.buscarAllLivros();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirLivro(@PathVariable Long id) {
        return livroService.deletarLivro(id);
    }

    @PutMapping("/query")
    public LivroEntity alterarLivroQuery(@RequestBody LivroRequest livroRequest) {
        return livroService.atualizarLivroQuery(
                new LivroEntity(
                        livroRequest.getId(),
                        livroRequest.getTitulo(),
                        livroRequest.getAutor(),
                        livroRequest.getAnoPublicacao()
                ));
    }

    @PutMapping
    public LivroEntity alterarLivro(@RequestBody LivroRequest livroRequest) {
        return livroService.atualizarLivro(
                new LivroEntity(
                        livroRequest.getId(),
                        livroRequest.getTitulo(),
                        livroRequest.getAutor(),
                        livroRequest.getAnoPublicacao()
                ));
    }
}
