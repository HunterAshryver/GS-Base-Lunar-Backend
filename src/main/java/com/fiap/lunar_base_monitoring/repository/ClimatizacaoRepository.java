package com.fiap.lunar_base_monitoring.repository;

import com.fiap.lunar_base_monitoring.model.Climatizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimatizacaoRepository extends JpaRepository<Climatizacao, Long> {
}
