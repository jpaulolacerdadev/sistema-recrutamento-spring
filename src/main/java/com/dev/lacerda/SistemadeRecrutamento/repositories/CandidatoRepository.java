package com.dev.lacerda.SistemadeRecrutamento.repositories;

import com.dev.lacerda.SistemadeRecrutamento.models.CandidatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<CandidatoModel, Long> {
}
