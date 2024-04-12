package com.M1.S11_1.controller;

import com.M1.S11_1.dto.request.CriarNotaRequest;
import com.M1.S11_1.dto.response.NotaResponse;
import com.M1.S11_1.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaResponse>> getAll(@RequestHeader(name = "Authorization") String token) {
        String tokenReal = token.split(" ")[1];
        return ResponseEntity.ok(notaService.buscarTodos(token.substring(7)));
    }

    @GetMapping("{id}")
    public ResponseEntity<NotaResponse> getId(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws Exception {
        String tokenReal = token.split(" ")[1];
        return ResponseEntity.ok(notaService.buscarPorId(id, token.substring(7)));
    }

    @PostMapping
    public ResponseEntity<NotaResponse> post(@RequestBody CriarNotaRequest criarNotaRequest, @RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(notaService.salvar(criarNotaRequest, token.substring(7)));
    }

    @PutMapping("{id}")
    public ResponseEntity<NotaResponse> put(@PathVariable Integer id, @RequestBody CriarNotaRequest criarNotaRequest, @RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(notaService.atualizar(id, criarNotaRequest, token.substring(7)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) {
        notaService.deletar(id, token.substring(7));
        return ResponseEntity.noContent().build();
    }
}
