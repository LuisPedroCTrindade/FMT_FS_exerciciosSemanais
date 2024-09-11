package br.com.M3S02.M3S02.service;

import br.com.M3S02.M3S02.entity.ComentarioEntity;
import br.com.M3S02.M3S02.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<ComentarioEntity> findAll() {
        return comentarioRepository.findAll();
    }

    public Optional<ComentarioEntity> findById(Long id) {
        return comentarioRepository.findById(id);
    }

    public ComentarioEntity save(ComentarioEntity comentario) {
        return comentarioRepository.save(comentario);
    }

    public void deleteById(Long id) {
        comentarioRepository.deleteById(id);
    }
}
