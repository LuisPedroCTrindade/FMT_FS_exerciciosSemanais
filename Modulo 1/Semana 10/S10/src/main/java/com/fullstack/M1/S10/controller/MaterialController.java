package com.fullstack.M1.S10.controller;

import com.fullstack.M1.S10.controller.dto.request.MaterialRequest;
import com.fullstack.M1.S10.entity.MaterialEntity;
import com.fullstack.M1.S10.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialEntity>> getAll() {
        List<MaterialEntity> todosMaterials = materialService.buscarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todosMaterials);
    }

    @GetMapping("{id}")
    public ResponseEntity<MaterialEntity> getId(@PathVariable Long id) {
        MaterialEntity materialRetornado = materialService.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(materialRetornado);
    }

    @PostMapping
    public ResponseEntity<MaterialEntity> post(@RequestBody MaterialRequest materialRequest) {
        MaterialEntity materialCriado = materialService.salvar(
                new MaterialEntity(
                        materialRequest.getAgenda(),
                        materialRequest.getDescricao(),
                        materialRequest.getArquivo()
                ));
        return ResponseEntity.status(HttpStatus.CREATED).body(materialCriado);
    }

    @PutMapping("{id}")
    public ResponseEntity<MaterialEntity> put(@PathVariable Long id, @RequestBody MaterialRequest materialRequest) {
        MaterialEntity materialAlterado = materialService.atualizar(id, new MaterialEntity(
                materialRequest.getId(),
                materialRequest.getAgenda(),
                materialRequest.getDescricao(),
                materialRequest.getArquivo()
        ));
        return ResponseEntity.status(HttpStatus.OK).body(materialAlterado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
