package com.M1.S11_1.repository;

import com.M1.S11_1.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<NotaEntity, Integer> {
    List<NotaEntity> findAllByUsuario(Integer idUsuario);

    Optional<NotaEntity> findByUsuarioAndId(Integer idUsuario, Integer id);
}
