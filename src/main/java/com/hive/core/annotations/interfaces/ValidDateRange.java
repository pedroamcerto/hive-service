package com.hive.core.annotations.interfaces;

import com.hive.core.annotations.validators.DateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação personalizada usada para validar que uma data não seja anterior ao dia atual.
 * Esta anotação pode ser aplicada a campos, métodos, parâmetros ou outros tipos de elementos
 * que requerem validação de data para garantir que a data fornecida não seja anterior à data atual.
 */
@Constraint(validatedBy = DateValidator.class) // Define o validador a ser usado (DateValidator)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {

    /**
     * Mensagem padrão exibida quando a validação falha.
     *
     * @return A mensagem de erro que será exibida quando a data for inválida.
     */
    String message() default "A data não pode ser antes do dia atual";

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
