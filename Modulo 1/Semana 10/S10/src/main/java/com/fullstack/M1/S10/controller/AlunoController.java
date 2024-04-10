package com.fullstack.M1.S10.controller;

import com.fullstack.M1.S10.controller.dto.request.AlunoRequest;
import com.fullstack.M1.S10.entity.AlunoEntity;
import com.fullstack.M1.S10.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> getAll() {
        List<AlunoEntity> todosAlunos = alunoService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosAlunos);
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getId(@PathVariable Long id) {
        AlunoEntity alunoRetornado = alunoService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRetornado);
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoRequest alunoRequest) {
        AlunoEntity alunoCriado = alunoService.salvar(
                new AlunoEntity(
                        alunoRequest.getNome()
                ));
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCriado);
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
        AlunoEntity alunoAlterado = alunoService.atualizar(id, new AlunoEntity(
                alunoRequest.getId(),
                alunoRequest.getNome()
        ));
        return ResponseEntity.status(HttpStatus.OK).body(alunoAlterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
