package com.hive.dto.carbonCredit;

import com.hive.dto.mission.GetMissionDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetCarbonCredit {
    private Long id;
    private LocalDateTime emmitDate;
    private Double carbonTon;
    private GetMissionDto mission;
}
