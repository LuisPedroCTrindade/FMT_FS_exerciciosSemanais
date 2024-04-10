package com.fullstack.M1.S10.controller;

import com.fullstack.M1.S10.controller.dto.request.AgendaRequest;
import com.fullstack.M1.S10.entity.AgendaEntity;
import com.fullstack.M1.S10.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/agenda")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> getAll() {
        List<AgendaEntity> todosAgendas = agendaService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosAgendas);
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getId(@PathVariable Long id) {
        AgendaEntity agendaRetornado = agendaService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(agendaRetornado);
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaRequest agendaRequest) {
        AgendaEntity agendaCriado = agendaService.salvar(
                new AgendaEntity(
                        agendaRequest.getAluno(),
                        agendaRequest.getTutor(),
                        agendaRequest.getData(),
                        agendaRequest.getStatus(),
                        agendaRequest.getTema(),
                        agendaRequest.getDescricaoBreve()
                ));
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaCriado);
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> put(@PathVariable Long id, @RequestBody AgendaRequest agendaRequest) {
        AgendaEntity agendaAlterado = agendaService.atualizar(id, new AgendaEntity(
                agendaRequest.getId(),
                agendaRequest.getAluno(),
                agendaRequest.getTutor(),
                agendaRequest.getData(),
                agendaRequest.getStatus(),
                agendaRequest.getTema(),
                agendaRequest.getDescricaoBreve()
        ));
        return ResponseEntity.status(HttpStatus.OK).body(agendaAlterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //CONSULTAS DE AGENDAMENTO

    @GetMapping("aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(agendaService.buscarPorAluno(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(agendaService.buscarPorTutor(tutorId));
    }

    @GetMapping("aluno-id/{alunoId}/futuro")
    public ResponseEntity<List<AgendaEntity>> getProximosPorAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(agendaService.buscarProximosPorAluno(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}/futuro")
    public ResponseEntity<List<AgendaEntity>> getProximosPorTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok(agendaService.buscarProximosPorTutor(tutorId));
    }
}
