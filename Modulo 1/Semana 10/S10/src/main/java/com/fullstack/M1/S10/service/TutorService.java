package com.fullstack.M1.S10.service;

import com.fullstack.M1.S10.entity.TutorEntity;
import com.fullstack.M1.S10.exception.NotFoundException;
import com.fullstack.M1.S10.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public List<TutorEntity> buscarTodos() {
        return tutorRepository.findAll();
    }
    
    public TutorEntity buscarPorId(Long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new NotFoundException("Tutor de ID " + id + " não encontrado."));
    }

    public TutorEntity salvar(TutorEntity tutorEntity) {
        tutorEntity.setId(null);

        return tutorRepository.save(tutorEntity);
    }

    public TutorEntity atualizar(Long id, TutorEntity tutorEntity) {
        TutorEntity tutorAlterado = buscarPorId(id);

        tutorAlterado.setNome(tutorEntity.getNome());
        tutorAlterado.setEspecialidade(tutorEntity.getEspecialidade());

        return tutorRepository.save(tutorAlterado);
    }

    public void excluir(Long id) {
        TutorEntity tutorEntity = buscarPorId(id);
        tutorRepository.delete(tutorEntity);
    }
}
