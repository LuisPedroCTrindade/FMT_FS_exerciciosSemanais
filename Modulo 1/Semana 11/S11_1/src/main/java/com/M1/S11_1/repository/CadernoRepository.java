package com.M1.S11_1.repository;

import com.M1.S11_1.dto.response.CadernoResponse;
import com.M1.S11_1.entity.CadernoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CadernoRepository extends JpaRepository<CadernoEntity, Integer> {
    List<CadernoEntity> findAllByUsuario(Integer idUsuario);

    Optional<CadernoEntity> findByUsuarioAndId(Integer idUsuario, Integer id);
}
