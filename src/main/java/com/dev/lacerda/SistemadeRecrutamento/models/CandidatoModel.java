package com.dev.lacerda.SistemadeRecrutamento.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_candidatos")
public class CandidatoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String telefone;

    @Column
    private String curriculoUrl;

    @OneToMany(mappedBy = "candidato")
    private List<CandidaturaModel> candidaturas;


    @ManyToMany
    @JoinTable(name = "tb_candidato_vaga",
            joinColumns = @JoinColumn(name ="candidato_id"),
            inverseJoinColumns = @JoinColumn(name ="vaga_id")
    )
    private List<VagaModel> vagas = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCurriculoUrl() {
        return curriculoUrl;
    }

    public void setCurriculoUrl(String curriculoUrl) {
        this.curriculoUrl = curriculoUrl;
    }
}
