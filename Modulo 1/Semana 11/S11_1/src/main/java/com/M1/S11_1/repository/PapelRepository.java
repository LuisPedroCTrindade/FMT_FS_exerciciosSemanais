package com.M1.S11_1.repository;

import com.M1.S11_1.entity.PapelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PapelRepository extends JpaRepository<PapelEntity, Integer> {
    Optional<PapelEntity> findByNome(String nomePapel);
}
