package com.dev.lacerda.SistemadeRecrutamento.controllers;


import com.dev.lacerda.SistemadeRecrutamento.models.EmpresaModel;
import com.dev.lacerda.SistemadeRecrutamento.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<EmpresaModel> criarEmpresa(
            @RequestBody EmpresaModel empresa) {

        return ResponseEntity.ok(
                empresaService.criarEmpresa(empresa)
        );
    }

    @GetMapping
    public List<EmpresaModel> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaModel> atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaModel empresa ) {
        return ResponseEntity.ok(
                empresaService.atualizarEmpresa(id, empresa)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.ok().build();
    }
}
