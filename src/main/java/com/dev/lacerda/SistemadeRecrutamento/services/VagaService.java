package com.dev.lacerda.SistemadeRecrutamento.services;

import com.dev.lacerda.SistemadeRecrutamento.models.EmpresaModel;
import com.dev.lacerda.SistemadeRecrutamento.models.VagaModel;
import com.dev.lacerda.SistemadeRecrutamento.repositories.EmpresaRepository;
import com.dev.lacerda.SistemadeRecrutamento.repositories.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository;

    public VagaService(
            VagaRepository vagaRepository,
            EmpresaRepository empresaRepository) {

        this.vagaRepository = vagaRepository;
        this.empresaRepository = empresaRepository;
    }

    public VagaModel criarVaga(Long empresaId, VagaModel vaga) {

        EmpresaModel empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        vaga.setEmpresa(empresa);

        return vagaRepository.save(vaga);
    }

    public List<VagaModel> listarVagas() {
        return vagaRepository.findAll();
    }
}
