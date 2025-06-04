package com.hive.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RelationshipDto {
    @NotNull
    private Long id;
}
