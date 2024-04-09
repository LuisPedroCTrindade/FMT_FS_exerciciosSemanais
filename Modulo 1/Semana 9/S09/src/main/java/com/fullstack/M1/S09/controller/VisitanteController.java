package com.fullstack.M1.S09.controller;

import com.fullstack.M1.S09.controller.dto.request.VisitanteRequest;
import com.fullstack.M1.S09.entity.VisitanteEntity;
import com.fullstack.M1.S09.repository.VisitanteRepository;
import com.fullstack.M1.S09.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visitante")
@RequiredArgsConstructor

public class VisitanteController {

    private final VisitanteService visitanteService;

    @PostMapping
    public VisitanteEntity criarVisitante(@RequestBody VisitanteRequest visitanteRequest) {
        return visitanteService.salvarVisitante(
                new VisitanteEntity(
                        visitanteRequest.getNome(),
                        visitanteRequest.getTelefone()
                ));
    }

    @GetMapping("/visitante")
    public List<VisitanteEntity> retornarAllVisitantes() {
        return visitanteService.buscarAllVisitantes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirVisitante(@PathVariable Long id) {
        return visitanteService.deletarVisitante(id);
    }

    @PutMapping("/query")
    public VisitanteEntity alterarVisitanteQuery(@RequestBody VisitanteRequest visitanteRequest) {
        return visitanteService.atualizarVisitanteQuery(
                new VisitanteEntity(
                        visitanteRequest.getId(),
                        visitanteRequest.getNome(),
                        visitanteRequest.getTelefone()
                ));
    }

    @PutMapping
    public VisitanteEntity alterarVisitante(@RequestBody VisitanteRequest visitanteRequest) {
        return visitanteService.atualizarVisitante(
                new VisitanteEntity(
                        visitanteRequest.getId(),
                        visitanteRequest.getNome(),
                        visitanteRequest.getTelefone()
                ));
    }
}
