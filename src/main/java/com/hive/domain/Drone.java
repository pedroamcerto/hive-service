package com.hive.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "drone")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @Column(name = "dt_fabricacao")
    private LocalDate dtFabricacao;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_base")
    private Base base;

    public Drone() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDtFabricacao() {
        return dtFabricacao;
    }
    public void setDtFabricacao(LocalDate dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Base getBase() {
        return base;
    }
    public void setBase(Base base) {
        this.base = base;
    }
}
