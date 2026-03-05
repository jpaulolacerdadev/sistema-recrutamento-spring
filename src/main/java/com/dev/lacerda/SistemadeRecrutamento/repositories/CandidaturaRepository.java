package com.dev.lacerda.SistemadeRecrutamento.repositories;

import com.dev.lacerda.SistemadeRecrutamento.models.CandidaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidaturaRepository extends JpaRepository<CandidaturaModel, Long> {
}
