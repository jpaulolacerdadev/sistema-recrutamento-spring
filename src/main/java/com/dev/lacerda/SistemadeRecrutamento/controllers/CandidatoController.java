package com.dev.lacerda.SistemadeRecrutamento.controllers;


import com.dev.lacerda.SistemadeRecrutamento.models.CandidatoModel;
import com.dev.lacerda.SistemadeRecrutamento.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity<CandidatoModel> criarCandidato(@RequestBody CandidatoModel candidato) {
        return ResponseEntity.ok(
                candidatoService.criarCandidato(candidato)
        );
    }


    @GetMapping
    public List<CandidatoModel> listarCandidatos() {
        return candidatoService.listarCandidatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatoModel> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                candidatoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCandidato(@PathVariable Long id) {
        candidatoService.deletarCandidato(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<CandidatoModel> atualizarCandidato(@PathVariable Long id, @RequestBody CandidatoModel candidato) {

        return ResponseEntity.ok(
                candidatoService.atualizarCandidato(id, candidato)
        );

    }
}
