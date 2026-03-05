package com.dev.lacerda.SistemadeRecrutamento.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_empresas")
public class EmpresaModel implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String nomeEmpresa;

        @Column
        private String email;

        @Column
        private String password;

        @Column
        private String descricao;

        @OneToMany(mappedBy ="empresa", cascade = CascadeType.ALL)
        private List<VagaModel> vagas = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
