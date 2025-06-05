package com.hive.dto.carbonCredit;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetCarbonCreditMissionDto {
    private Long id;
    private LocalDateTime emmitDate;
    private Double carbonTon;
}
