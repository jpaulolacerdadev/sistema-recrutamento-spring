package com.dev.lacerda.SistemadeRecrutamento.services;

import com.dev.lacerda.SistemadeRecrutamento.models.CandidatoModel;
import com.dev.lacerda.SistemadeRecrutamento.repositories.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public CandidatoModel criarCandidato(CandidatoModel candidato) {
        return candidatoRepository.save(candidato);
    }

    public List<CandidatoModel> listarCandidatos() {
        return candidatoRepository.findAll();
    }

    public CandidatoModel buscarPorId(Long id) {
        return candidatoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Candidato não encontrado"));
    }

    public void deletarCandidato(Long id) {
        candidatoRepository.deleteById(id);
    }

    public CandidatoModel atualizarCandidato(Long id, CandidatoModel candidatoatualizado) {

        CandidatoModel candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));

        candidato.setNome(candidatoatualizado.getNome());
        candidato.setEmail(candidatoatualizado.getEmail());

        return candidatoRepository.save(candidato);
    }
}
