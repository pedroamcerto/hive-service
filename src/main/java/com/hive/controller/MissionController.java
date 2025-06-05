package com.hive.controller;

import com.hive.dto.mission.CreateMissionDto;
import com.hive.dto.mission.GetMissionDto;
import com.hive.dto.mission.UpdateMissionStatusDto;
import com.hive.service.MissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável pela gestão de missões.
 * Este controlador fornece endpoints para criar, atualizar, recuperar, listar e excluir missões.
 */
@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    /**
     * Cria uma nova missão.
     *
     * @param createMissionDto DTO contendo os dados necessários para criar a missão.
     * @return Um objeto `ResponseEntity` com o status HTTP 201 (CREATED) após a criação da missão.
     * @throws com.hive.core.exception.BadRequestException Se houver algum problema com os dados da missão.
     */
    @PostMapping
    public ResponseEntity<Void> createMission(@Valid @RequestBody CreateMissionDto createMissionDto) {
        missionService.create(createMissionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Atualiza uma missão existente.
     *
     * @param id O ID da missão a ser atualizada.
     * @param createMissionDto DTO contendo os novos dados para a missão.
     * @return Um objeto `ResponseEntity` com o status HTTP 200 (OK) após a atualização da missão.
     * @throws com.hive.core.exception.NotFoundException Se a missão não for encontrada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMission(@PathVariable Long id, @Valid @RequestBody CreateMissionDto createMissionDto) {
        missionService.update(id, createMissionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Atualiza o status de uma missão existente.
     *
     * @param id O ID da missão cujo status será atualizado.
     * @param missionStatusDto DTO contendo o novo status da missão.
     * @return Um objeto `ResponseEntity` com o status HTTP 200 (OK) após a atualização do status.
     * @throws com.hive.core.exception.NotFoundException Se a missão não for encontrada.
     * @throws com.hive.core.exception.BadRequestException Se a mudança de status não for permitida (por exemplo, status inválido).
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateMissionStatus(@PathVariable Long id, @Valid @RequestBody UpdateMissionStatusDto missionStatusDto) {
        missionService.updateStatus(id, missionStatusDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Recupera uma missão específica pelo seu ID.
     *
     * @param id O ID da missão a ser recuperada.
     * @return Um objeto `ResponseEntity` contendo o DTO da missão e o status HTTP 200 (OK).
     * @throws com.hive.core.exception.NotFoundException Se a missão não for encontrada.
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetMissionDto> getMissionById(@PathVariable Long id) {
        GetMissionDto mission = missionService.getById(id);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    /**
     * Recupera todas as missões cadastradas.
     *
     * @return Um objeto `ResponseEntity` contendo a lista de missões e o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<GetMissionDto>> getAllMissions() {
        List<GetMissionDto> missions = missionService.getAll();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    /**
     * Deleta uma missão pelo seu ID.
     *
     * @param id O ID da missão a ser deletada.
     * @return Um objeto `ResponseEntity` com o status HTTP 204 (NO CONTENT) após a exclusão da missão.
     * @throws com.hive.core.exception.NotFoundException Se a missão não for encontrada.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        missionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
