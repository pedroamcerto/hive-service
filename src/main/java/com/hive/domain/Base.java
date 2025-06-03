package com.hive.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "base")
public class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    private String endereco;

    private Double latitude;

    private Double longitude;

    private Double tamanho;

    private Boolean status;

    private String telefone;

    private String email;

    @Column(name = "dt_criacao")
    private LocalDate dtCriacao;

    @OneToMany(mappedBy = "base", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Drone> drones = new HashSet<>();

    @OneToMany(mappedBy = "base", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Estoque> estoques = new HashSet<>();

    public Base() {}

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

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getTamanho() { return tamanho; }
    public void setTamanho(Double tamanho) { this.tamanho = tamanho; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDtCriacao() { return dtCriacao; }
    public void setDtCriacao(LocalDate dtCriacao) { this.dtCriacao = dtCriacao; }

    public Set<Drone> getDrones() { return drones; }
    public void setDrones(Set<Drone> drones) { this.drones = drones; }

    public Set<Estoque> getEstoques() { return estoques; }
    public void setEstoques(Set<Estoque> estoques) { this.estoques = estoques; }
}
