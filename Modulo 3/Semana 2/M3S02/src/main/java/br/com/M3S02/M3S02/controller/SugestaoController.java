package br.com.M3S02.M3S02.controller;

import br.com.M3S02.M3S02.entity.SugestaoEntity;
import br.com.M3S02.M3S02.service.SugestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sugestoes")
@CrossOrigin(origins = "http://localhost:4200")
public class SugestaoController {

    @Autowired
    private SugestaoService sugestaoService;

    @GetMapping
    public List<SugestaoEntity> getAllSugestoes() {
        return sugestaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SugestaoEntity> getSugestaoById(@PathVariable Long id) {
        Optional<SugestaoEntity> sugestao = sugestaoService.findById(id);
        return sugestao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SugestaoEntity criarSugestao(@RequestBody SugestaoEntity sugestao) {
        return sugestaoService.save(sugestao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SugestaoEntity> atualizarSugestao(@PathVariable Long id, @RequestBody SugestaoEntity sugestao) {
        if (!sugestaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sugestao.setId(id);
        return ResponseEntity.ok(sugestaoService.save(sugestao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSugestao(@PathVariable Long id) {
        if (!sugestaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sugestaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
