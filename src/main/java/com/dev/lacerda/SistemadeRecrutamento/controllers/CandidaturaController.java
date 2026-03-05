package com.dev.lacerda.SistemadeRecrutamento.controllers;

import com.dev.lacerda.SistemadeRecrutamento.models.CandidaturaModel;
import com.dev.lacerda.SistemadeRecrutamento.services.CandidaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    private final CandidaturaService candidaturaService;

    public CandidaturaController(CandidaturaService candidaturaService) {
        this.candidaturaService = candidaturaService;
    }

    @PostMapping
    public ResponseEntity<CandidaturaModel> aplicar(
            @RequestParam Long candidatoId,
            @RequestParam Long vagaId) {

        return ResponseEntity.ok(
                candidaturaService.aplicar(candidatoId, vagaId)
        );
    }
}
