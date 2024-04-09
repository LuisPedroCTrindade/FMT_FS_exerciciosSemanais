package com.fullstack.M1.S09.controller;

import com.fullstack.M1.S09.controller.dto.request.BibliotecarioRequest;
import com.fullstack.M1.S09.entity.BibliotecarioEntity;
import com.fullstack.M1.S09.service.BibliotecarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecario")
@RequiredArgsConstructor
public class BibliotecarioController {

    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    public BibliotecarioEntity criarBibliotecario(@RequestBody BibliotecarioRequest bibliotecarioRequest) {
        return bibliotecarioService.salvarBibliotecario(
                new BibliotecarioEntity(
                        bibliotecarioRequest.getNome(),
                        bibliotecarioRequest.getEmail(),
                        bibliotecarioRequest.getSenha()
                ));
    }

    @GetMapping
    public List<BibliotecarioEntity> retornarAllBibliotecarios() {
        return bibliotecarioService.buscarAllBibliotecarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirBibliotecario(@PathVariable Long id) {
        return bibliotecarioService.deletarBibliotecario(id);
    }

    @PutMapping("/query")
    public BibliotecarioEntity alterarBibliotecarioQuery(@RequestBody BibliotecarioRequest bibliotecarioRequest) {
        return bibliotecarioService.atualizarBibliotecarioQuery(
                new BibliotecarioEntity(
                        bibliotecarioRequest.getId(),
                        bibliotecarioRequest.getNome(),
                        bibliotecarioRequest.getEmail(),
                        bibliotecarioRequest.getSenha()
                ));
    }

    @PutMapping
    public BibliotecarioEntity alterarBibliotecario(@RequestBody BibliotecarioRequest bibliotecarioRequest) {
        return bibliotecarioService.atualizarBibliotecario(
                new BibliotecarioEntity(
                        bibliotecarioRequest.getId(),
                        bibliotecarioRequest.getNome(),
                        bibliotecarioRequest.getEmail(),
                        bibliotecarioRequest.getSenha()
                ));
    }
}
