package com.hive.dto.mission;

import com.hive.domain.enumerated.MissionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateMissionStatusDto {
    @NotNull
    MissionStatus status;
}
