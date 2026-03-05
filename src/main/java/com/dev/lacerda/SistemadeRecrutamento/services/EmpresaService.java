package com.dev.lacerda.SistemadeRecrutamento.services;

import com.dev.lacerda.SistemadeRecrutamento.models.EmpresaModel;
import com.dev.lacerda.SistemadeRecrutamento.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaModel criarEmpresa(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaModel> listarEmpresas() {
        return empresaRepository.findAll();
    }
}
