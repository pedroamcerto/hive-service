package com.hive.core.configurations;

import com.hive.core.exception.BadRequestException;
import com.hive.core.exception.NotFoundException;
import com.hive.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ErrorResponseDto> handleNotFloudException(NotFoundException ex, HttpServletRequest request) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        // Extrai os erros de validação
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> "Campo '" + fieldError.getField() + "': " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        // Constrói a mensagem final
        String errorMessage = "A solicitação contém campos inválidos: " + errors;

        return buildErrorResponse(errorMessage, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    private ResponseEntity<ErrorResponseDto> handleUnsupportedOperationException(UnsupportedOperationException ex, HttpServletRequest request) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED, request);
    }

    private ResponseEntity<ErrorResponseDto> buildErrorResponse(String message, HttpStatus status, HttpServletRequest request) {
        return ResponseEntity.status(status)
                .body(new ErrorResponseDto(
                        message,
                        status.value(),
                        LocalDateTime.now(),
                        request.getRequestURI()
                ));
    }
}
