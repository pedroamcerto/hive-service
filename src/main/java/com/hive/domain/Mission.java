package com.hive.domain;

import com.hive.domain.enumerated.MissionStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "mission")
public class Mission extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "total_ton")
    private Double totalTon;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarbonCredit> carbonCredits;

    // Getters and setters
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

    public MissionStatus getStatus() {
        return status;
    }

    public void setStatus(MissionStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<CarbonCredit> getCarbonCredits() {
        return carbonCredits;
    }

    public void setCarbonCredits(List<CarbonCredit> carbonCredits) {
        this.carbonCredits = carbonCredits;
    }

    public Double getTotalTon() {
        return totalTon;
    }

    public void setTotalTon(Double totalTon) {
        this.totalTon = totalTon;
    }
}
