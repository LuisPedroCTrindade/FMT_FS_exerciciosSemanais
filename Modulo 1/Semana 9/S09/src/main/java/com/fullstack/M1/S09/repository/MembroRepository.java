package com.fullstack.M1.S09.repository;

import com.fullstack.M1.S09.entity.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {
}
