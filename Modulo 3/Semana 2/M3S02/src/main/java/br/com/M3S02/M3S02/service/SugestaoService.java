package br.com.M3S02.M3S02.service;

import br.com.M3S02.M3S02.entity.SugestaoEntity;
import br.com.M3S02.M3S02.repository.SugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SugestaoService {

    @Autowired
    private SugestaoRepository sugestaoRepository;

    public List<SugestaoEntity> findAll() {
        return sugestaoRepository.findAll();
    }

    public Optional<SugestaoEntity> findById(Long id) {
        return sugestaoRepository.findById(id);
    }

    public SugestaoEntity save(SugestaoEntity sugestao) {
        return sugestaoRepository.save(sugestao);
    }

    public void deleteById(Long id) {
        sugestaoRepository.deleteById(id);
    }
}
