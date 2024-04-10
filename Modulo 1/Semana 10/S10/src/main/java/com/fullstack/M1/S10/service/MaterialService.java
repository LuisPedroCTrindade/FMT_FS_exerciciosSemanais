package com.fullstack.M1.S10.service;

import com.fullstack.M1.S10.entity.MaterialEntity;
import com.fullstack.M1.S10.exception.NotFoundException;
import com.fullstack.M1.S10.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public List<MaterialEntity> buscarTodos() {
        return materialRepository.findAll();
    }
    
    public MaterialEntity buscarPorId(Long id) {
        return materialRepository.findById(id).orElseThrow(() -> new NotFoundException("Material de ID " + id + " não encontrado."));
    }

    public MaterialEntity salvar(MaterialEntity materialEntity) {
        materialEntity.setId(null);

        return materialRepository.save(materialEntity);
    }

    public MaterialEntity atualizar(Long id, MaterialEntity materialEntity) {
        MaterialEntity materialAlterado = buscarPorId(id);

        materialAlterado.setAgenda(materialEntity.getAgenda());
        materialAlterado.setDescricao(materialEntity.getDescricao());
        materialAlterado.setArquivo(materialEntity.getArquivo());

        return materialRepository.save(materialAlterado);
    }

    public void excluir(Long id) {
        MaterialEntity materialEntity = buscarPorId(id);
        materialRepository.delete(materialEntity);
    }
}
