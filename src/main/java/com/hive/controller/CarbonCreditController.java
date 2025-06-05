package com.hive.controller;

import com.hive.dto.carbonCredit.CreateCarbonCreditDto;
import com.hive.dto.carbonCredit.GetCarbonCredit;
import com.hive.service.CarbonCreditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável pela gestão de créditos de carbono.
 * Este controlador define as operações para criar, recuperar e listar créditos de carbono.
 */
@RestController
@RequestMapping("/api/v1/carbon-credit")
@RequiredArgsConstructor
@Validated
public class CarbonCreditController {

    private final CarbonCreditService carbonCreditService;

    /**
     * Recupera todos os créditos de carbono.
     *
     * @return Uma lista com os DTOs de todos os créditos de carbono.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetCarbonCredit> getAllCarbonCredits() {
        return carbonCreditService.getAll();
    }

    /**
     * Recupera um crédito de carbono específico pelo seu ID.
     *
     * @param id O ID do crédito de carbono a ser recuperado.
     * @return Um objeto `ResponseEntity` contendo o DTO do crédito de carbono e o status HTTP.
     * @throws com.hive.core.exception.NotFoundException Se o crédito de carbono não for encontrado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetCarbonCredit> getById(@PathVariable Long id) {
        GetCarbonCredit carbonCredit = carbonCreditService.getById(id);
        return new ResponseEntity<>(carbonCredit, HttpStatus.OK);
    }

    /**
     * Cria um novo crédito de carbono.
     *
     * @param createCarbonCreditDto DTO com os dados do crédito de carbono a ser criado.
     * @return Um objeto `ResponseEntity` com status HTTP `201 CREATED` após a criação do crédito de carbono.
     * @throws com.hive.core.exception.BadRequestException Se a missão associada ao crédito de carbono não estiver ativa ou já tiver atingido a meta.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateCarbonCreditDto createCarbonCreditDto) {
        carbonCreditService.create(createCarbonCreditDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
