package com.fullstack.M1.S09.controller;

import com.fullstack.M1.S09.controller.dto.request.MembroRequest;
import com.fullstack.M1.S09.entity.MembroEntity;
import com.fullstack.M1.S09.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membro")
@RequiredArgsConstructor

public class MembroController {

    private final MembroService membroService;

    @PostMapping
    public MembroEntity criarMembro(@RequestBody MembroRequest membroRequest) {
        return membroService.salvarMembro(
                new MembroEntity(
                        membroRequest.getNome(),
                        membroRequest.getEndereco(),
                        membroRequest.getTelefone()
                )
        );
    }

    @GetMapping("/membro")
    public List<MembroEntity> retornarAllMembros() {
        return membroService.buscarAllMembros();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirMembro(@PathVariable Long id) {
        return membroService.deletarMembro(id);
    }

    @PutMapping("/query")
    public MembroEntity alterarMembroQuery(@RequestBody MembroRequest membroRequest) {
        return membroService.atualizarMembroQuery(
                new MembroEntity(
                        membroRequest.getId(),
                        membroRequest.getNome(),
                        membroRequest.getEndereco(),
                        membroRequest.getTelefone()
                ));
    }

    @PutMapping
    public MembroEntity alterarMembro(@RequestBody MembroRequest membroRequest) {
        return membroService.atualizarMembro(
                new MembroEntity(
                        membroRequest.getId(),
                        membroRequest.getNome(),
                        membroRequest.getEndereco(),
                        membroRequest.getTelefone()
                ));
    }
}
