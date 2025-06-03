package com.hive.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tamanho")
    private String tamanho;

    @Column(name = "capacidade_carga")
    private Double capacidadeCarga;

    @Column(name = "tempo_max")
    private Integer tempoMax;

    @Column(name = "distancia_max")
    private Double distanciaMax;

    @Column(name = "software_version")
    private String softwareVersion;

    public Modelo() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public Integer getTempoMax() {
        return tempoMax;
    }
    public void setTempoMax(Integer tempoMax) {
        this.tempoMax = tempoMax;
    }

    public Double getDistanciaMax() {
        return distanciaMax;
    }
    public void setDistanciaMax(Double distanciaMax) {
        this.distanciaMax = distanciaMax;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }
}

