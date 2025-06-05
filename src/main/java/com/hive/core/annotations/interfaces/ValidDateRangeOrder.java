package com.hive.core.annotations.interfaces;

import com.hive.core.annotations.validators.DateRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação personalizada usada para validar a relação entre as datas de início e término.
 * Esta anotação garante que a data de início não seja posterior à data de término.
 */
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRangeOrder {

    /**
     * Mensagem padrão exibida quando a validação falha.
     *
     * @return A mensagem de erro que será exibida quando a data de início for posterior à data de término.
     */
    String message() default "A data de início não pode ser posterior à data de término";

    /**
     * Grupos de validação que podem ser usados para aplicar diferentes regras de validação.
     *
     * @return Os grupos de validação que podem ser usados com esta anotação.
     */
    Class<?>[] groups() default {};

    /**
     * Dados adicionais que podem ser fornecidos para a validação.
     *
     * @return Dados adicionais para a validação.
     */
    Class<? extends Payload>[] payload() default {};
}
