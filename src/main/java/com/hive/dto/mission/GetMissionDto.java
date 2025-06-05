package com.hive.dto.mission;

import com.hive.domain.enumerated.MissionStatus;

import com.hive.dto.carbonCredit.GetCarbonCreditMissionDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetMissionDto {
    private Long id;
    private String nome;
    private MissionStatus status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double totalTon;
    private List<GetCarbonCreditMissionDto> carbonCredits;
}
