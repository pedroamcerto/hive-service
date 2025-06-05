package com.hive.core.annotations.validators;

import com.hive.core.annotations.interfaces.ValidDateRangeOrder;
import com.hive.dto.mission.CreateMissionDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

/**
 * Validador personalizado para verificar a relação entre as datas de início e término de uma missão.
 * Garante que a data de início (startDate) não seja posterior à data de término (endDate).
 */
public class DateRangeValidator implements ConstraintValidator<ValidDateRangeOrder, CreateMissionDto> {

    @Override
    public void initialize(ValidDateRangeOrder constraintAnnotation) {
        // Não é necessário inicializar no caso desta validação
    }

    /**
     * Valida se a data de início (startDate) não é posterior à data de término (endDate).
     *
     * @param dto O DTO que contém as datas de início e término da missão.
     * @param context O contexto da validação, fornecido pelo framework.
     * @return `true` se a data de início não for posterior à data de término, `false` caso contrário.
     */
    @Override
    public boolean isValid(CreateMissionDto dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true; // Se o DTO for nulo, considera válido
        }

        LocalDateTime startDate = dto.getStartDate();
        LocalDateTime endDate = dto.getEndDate();

        // Se qualquer data for nula, considera válida, pois a validação de @NotNull deve ser feita separadamente
        if (startDate == null || endDate == null) {
            return true;
        }

        // Verifica se a data de início não é posterior à data de término
        return !startDate.isAfter(endDate);
    }
}
