package br.com.M3S02.M3S02.repository;

import br.com.M3S02.M3S02.entity.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository extends JpaRepository<SugestaoEntity, Long> {
}
