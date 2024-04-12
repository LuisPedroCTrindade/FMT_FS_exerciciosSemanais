package com.M1.S11_1.controller;

import com.M1.S11_1.dto.request.CriarCadernoRequest;
import com.M1.S11_1.dto.response.CadernoResponse;
import com.M1.S11_1.service.CadernoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadernos")
@RequiredArgsConstructor
public class CadernoController {

    private final CadernoService cadernoService;

    @GetMapping
    public ResponseEntity<List<CadernoResponse>> getAll(@RequestHeader(name = "Authorization") String token) {
        String tokenReal = token.split(" ")[1];
        return ResponseEntity.ok(cadernoService.buscarTodos(token.substring(7)));
    }

    @GetMapping("{id}")
    public ResponseEntity<CadernoResponse> getId(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws Exception {
        String tokenReal = token.split(" ")[1];
        return ResponseEntity.ok(cadernoService.buscarPorId(id, token.substring(7)));
    }

    @PostMapping
    public ResponseEntity<CadernoResponse> post(@RequestBody CriarCadernoRequest criarCadernoRequest, @RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(cadernoService.salvar(criarCadernoRequest, token.substring(7)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CadernoResponse> put(@PathVariable Integer id, @RequestBody CriarCadernoRequest criarCadernoRequest, @RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(cadernoService.atualizar(id, criarCadernoRequest, token.substring(7)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) {
        cadernoService.deletar(id, token.substring(7));
        return ResponseEntity.noContent().build();
    }
}
