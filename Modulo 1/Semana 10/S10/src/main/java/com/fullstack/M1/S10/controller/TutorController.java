package com.fullstack.M1.S10.controller;

import com.fullstack.M1.S10.controller.dto.request.TutorRequest;
import com.fullstack.M1.S10.entity.TutorEntity;
import com.fullstack.M1.S10.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tutor")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<TutorEntity>> getAll() {
        List<TutorEntity> todosTutors = tutorService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosTutors);
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> getId(@PathVariable Long id) {
        TutorEntity tutorRetornado = tutorService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(tutorRetornado);
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorRequest tutorRequest) {
        TutorEntity tutorCriado = tutorService.salvar(
                new TutorEntity(
                        tutorRequest.getNome(),
                        tutorRequest.getEspecialidade()
                ));
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorCriado);
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> put(@PathVariable Long id, @RequestBody TutorRequest tutorRequest) {
        TutorEntity tutorAlterado = tutorService.atualizar(id, new TutorEntity(
                tutorRequest.getId(),
                tutorRequest.getNome(),
                tutorRequest.getEspecialidade()
        ));
        return ResponseEntity.status(HttpStatus.OK).body(tutorAlterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
