package com.fullstack.M1.S09.controller;

import com.fullstack.M1.S09.controller.dto.request.EmprestimoRequest;
import com.fullstack.M1.S09.entity.EmprestimoEntity;
import com.fullstack.M1.S09.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor

public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoEntity criarEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest) {
        return emprestimoService.salvarEmprestimo(
                new EmprestimoEntity(
                        emprestimoRequest.getLivroId(),
                        emprestimoRequest.getMembroId(),
                        emprestimoRequest.getDataEmprestimo(),
                        emprestimoRequest.getDataDevolucao()
        ));
    }

    @GetMapping("/emprestimo")
    public List<EmprestimoEntity> retornarAllEmprestimos() {
        return emprestimoService.buscarAllEmprestimos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEmprestimo(@PathVariable Long id) {
        return emprestimoService.deletarEmprestimo(id);
    }

    @PutMapping("/query")
    public EmprestimoEntity alterarEmprestimoQuery(@RequestBody EmprestimoRequest emprestimoRequest) {
        return emprestimoService.atualizarEmprestimoQuery(
                new EmprestimoEntity(
                        emprestimoRequest.getId(),
                        emprestimoRequest.getLivroId(),
                        emprestimoRequest.getMembroId(),
                        emprestimoRequest.getDataEmprestimo(),
                        emprestimoRequest.getDataDevolucao()
                ));
    }

    @PutMapping
    public EmprestimoEntity alterarEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest) {
        return emprestimoService.atualizarEmprestimo(
                new EmprestimoEntity(
                        emprestimoRequest.getId(),
                        emprestimoRequest.getLivroId(),
                        emprestimoRequest.getMembroId(),
                        emprestimoRequest.getDataEmprestimo(),
                        emprestimoRequest.getDataDevolucao()
                ));
    }
}
