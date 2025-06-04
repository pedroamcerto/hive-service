package com.hive.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "carbon_credit")
public class CarbonCredit extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emmit_date")
    private LocalDateTime emmitDate;

    @Column(name = "carbon_ton")
    private Double carbonTon;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCarbonTon() {
        return carbonTon;
    }

    public void setCarbonTon(Double carbonTon) {
        this.carbonTon = carbonTon;
    }

    public LocalDateTime getEmmitDate() {
        return emmitDate;
    }

    public void setEmmitDate(LocalDateTime emmitDate) {
        this.emmitDate = emmitDate;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
