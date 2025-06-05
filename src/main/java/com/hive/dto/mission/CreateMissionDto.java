package com.hive.dto.mission;

import com.hive.core.annotations.interfaces.ValidDateRange;
import com.hive.core.annotations.interfaces.ValidDateRangeOrder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ValidDateRangeOrder
public class CreateMissionDto {
    @NotBlank
    private String nome;
    @NotNull
    @ValidDateRange(message = "O valor da data do campo startDate deve ser a partir do dia de hoje.")
    private LocalDateTime startDate;
    @NotNull
    @ValidDateRange(message = "O valor da data do campo endDate deve ser a partir do dia de hoje.")
    private LocalDateTime endDate;
    @NotNull
    @Min(value = 0, message = "O valor de totalTon deve ser igual ou maior que 0")
    private Double totalTon;
}
