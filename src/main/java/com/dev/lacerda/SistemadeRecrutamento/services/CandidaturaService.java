package com.dev.lacerda.SistemadeRecrutamento.services;

import com.dev.lacerda.SistemadeRecrutamento.models.CandidatoModel;
import com.dev.lacerda.SistemadeRecrutamento.models.CandidaturaModel;
import com.dev.lacerda.SistemadeRecrutamento.enums.StatusCandidatura;
import com.dev.lacerda.SistemadeRecrutamento.models.VagaModel;
import com.dev.lacerda.SistemadeRecrutamento.repositories.CandidatoRepository;
import com.dev.lacerda.SistemadeRecrutamento.repositories.CandidaturaRepository;
import com.dev.lacerda.SistemadeRecrutamento.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CandidaturaService {

    private final CandidatoRepository candidatoRepository;
    private final VagaRepository vagaRepository;
    private final CandidaturaRepository candidaturaRepository;

    public CandidaturaService(
            CandidatoRepository candidatoRepository,
            VagaRepository vagaRepository,
            CandidaturaRepository candidaturaRepository) {

        this.candidatoRepository = candidatoRepository;
        this.vagaRepository = vagaRepository;
        this.candidaturaRepository = candidaturaRepository;
    }

    public CandidaturaModel aplicar(Long candidatoId, Long vagaId) {

        CandidatoModel candidato = candidatoRepository.findById(candidatoId)
                .orElseThrow();

        VagaModel vaga = vagaRepository.findById(vagaId)
                .orElseThrow();

        CandidaturaModel candidatura = new CandidaturaModel();
        candidatura.setCandidato(candidato);
        candidatura.setVaga(vaga);
        candidatura.setStatus(StatusCandidatura.EM_ANALISE);
        candidatura.setDataAplicacao(LocalDateTime.now());

        return candidaturaRepository.save(candidatura);
    }

}
