package com.dev.lacerda.SistemadeRecrutamento.controllers;

import com.dev.lacerda.SistemadeRecrutamento.models.VagaModel;
import com.dev.lacerda.SistemadeRecrutamento.services.VagaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<VagaModel> criarVaga(
            @PathVariable Long empresaId,
            @RequestBody VagaModel vaga) {

        return ResponseEntity.ok(
                vagaService.criarVaga(empresaId, vaga)
        );
    }

    @GetMapping
    public List<VagaModel> listarVagas() {
        return vagaService.listarVagas();
    }

}
