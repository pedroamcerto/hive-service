package com.hive.core.annotations.validators;

import com.hive.core.annotations.interfaces.ValidDateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

/**
 * Validador personalizado para garantir que uma data não seja anterior ao dia atual.
 * Esta validação é usada para garantir que as datas associadas a um campo não sejam anteriores à data atual.
 */
public class DateValidator implements ConstraintValidator<ValidDateRange, LocalDateTime> {

    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
        // Não é necessário inicializar no caso desta validação
    }

    /**
     * Valida se a data fornecida não é anterior à data atual.
     *
     * @param value A data a ser validada.
     * @param context O contexto da validação, fornecido pelo framework.
     * @return `true` se a data não for anterior à data atual, `false` caso contrário.
     */
    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        LocalDateTime now = LocalDateTime.now().toLocalDate().atStartOfDay();

        return !value.toLocalDate().isBefore(now.toLocalDate());
    }
}
