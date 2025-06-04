package com.hive.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Entity(name = "project")
@Data
public class Project extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customer;
    private Double creditNumber;
    private Double creditPrice;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<CarbonCredit> carbonCredits;
}
