package com.dev.lacerda.SistemadeRecrutamento.models;

import com.dev.lacerda.SistemadeRecrutamento.enums.StatusCandidatura;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_candidaturas")
public class CandidaturaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidato_id")
    private CandidatoModel candidato;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private VagaModel vaga;

    private LocalDateTime dataAplicacao;

    @Enumerated(EnumType.STRING)
    private StatusCandidatura status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDateTime dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatoModel candidato) {
        this.candidato = candidato;
    }

    public VagaModel getVaga() {
        return vaga;
    }

    public void setVaga(VagaModel vaga) {
        this.vaga = vaga;
    }

    public StatusCandidatura getStatus() {
        return status;
    }

    public void setStatus(StatusCandidatura status) {
        this.status = status;
    }
}
