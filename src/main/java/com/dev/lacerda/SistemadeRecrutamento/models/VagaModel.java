package com.dev.lacerda.SistemadeRecrutamento.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_vagas")
public class VagaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String salario;

    @Column
    private String nivel;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private EmpresaModel empresa;

    @ManyToMany(mappedBy = "vagas", fetch = FetchType.LAZY)
    private List<CandidatoModel> candidatos = new ArrayList<>();

    @OneToMany(mappedBy = "vaga")
    private List<CandidaturaModel> candidaturas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public List<CandidatoModel> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<CandidatoModel> candidatos) {
        this.candidatos = candidatos;
    }

    public List<CandidaturaModel> getCandidaturas() {
        return candidaturas;
    }

    public void setCandidaturas(List<CandidaturaModel> candidaturas) {
        this.candidaturas = candidaturas;
    }
}
