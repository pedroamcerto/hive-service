package com.hive.dto.carbonCredit;

import com.hive.dto.RelationshipDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateCarbonCreditDto {
    private Long id;
    @NotNull
    private LocalDateTime emmitDate;
    @NotNull
    @Min(value = 0, message = "O valor de toneladas de carbono tem que ser maior ou igual a 0")
    private Double carbonTon;

    @Valid
    @NotNull
    private RelationshipDto mission;
}
