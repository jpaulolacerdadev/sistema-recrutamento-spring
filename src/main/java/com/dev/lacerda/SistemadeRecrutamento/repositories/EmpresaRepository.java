package com.dev.lacerda.SistemadeRecrutamento.repositories;

import com.dev.lacerda.SistemadeRecrutamento.models.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {
}
