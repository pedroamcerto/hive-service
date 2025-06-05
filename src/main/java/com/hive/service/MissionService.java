package com.hive.service;

import com.hive.core.exception.BadRequestException;
import com.hive.core.exception.NotFoundException;
import com.hive.domain.CarbonCredit;
import com.hive.domain.Mission;
import com.hive.domain.enumerated.MissionStatus;
import com.hive.domain.interfaces.ServiceInterface;
import com.hive.dto.mission.CreateMissionDto;
import com.hive.dto.mission.GetMissionDto;
import com.hive.dto.mission.UpdateMissionStatusDto;
import com.hive.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela gestão das missões. Implementa operações CRUD (criação, atualização, leitura e exclusão) para as missões.
 */
@Service
@RequiredArgsConstructor
public class MissionService implements ServiceInterface<GetMissionDto, CreateMissionDto> {

    private final MissionRepository missionRepository;
    private final ModelMapper modelMapper;

    /**
     * Cria uma nova missão.
     *
     * @param entity Objeto DTO que contém os dados da missão a ser criada.
     * @throws BadRequestException Se a missão não puder ser criada devido a algum erro de validação.
     */
    @Override
    public void create(CreateMissionDto entity) {
        Mission savedMission = modelMapper.map(entity, Mission.class);
        savedMission.setStatus(MissionStatus.WAITING);

        missionRepository.save(savedMission);
    }

    /**
     * Atualiza uma missão existente.
     *
     * @param id O ID da missão a ser atualizada.
     * @param entity Objeto DTO que contém os novos dados para a missão.
     * @throws NotFoundException Se a missão não for encontrada no banco de dados.
     */
    public void update(Long id, CreateMissionDto entity) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada")
        );

        modelMapper.map(entity, mission);
        missionRepository.save(mission);
    }

    /**
     * Recupera uma missão pelo seu ID.
     *
     * @param id O ID da missão a ser recuperada.
     * @return Um DTO contendo os dados da missão recuperada.
     * @throws NotFoundException Se a missão não for encontrada no banco de dados.
     */
    @Override
    public GetMissionDto getById(Long id) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada.")
        );

        return modelMapper.map(mission, GetMissionDto.class);
    }

    /**
     * Recupera todas as missões.
     *
     * @return Uma lista de DTOs contendo os dados de todas as missões.
     */
    @Override
    public List<GetMissionDto> getAll() {
        return missionRepository.findAll().stream()
                .map(mission -> modelMapper.map(mission, GetMissionDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Deleta uma missão existente pelo seu ID.
     *
     * @param id O ID da missão a ser deletada.
     * @throws NotFoundException Se a missão não for encontrada no banco de dados.
     */
    @Override
    public void delete(Long id) {
        if(!missionRepository.existsById(id)){
            throw new NotFoundException("Missão não encontrada.");
        }

        missionRepository.deleteById(id);
    }

    /**
     * Atualiza o status de uma missão existente.
     *
     * @param id O ID da missão cujo status será atualizado.
     * @param newStatus Objeto DTO contendo o novo status para a missão.
     * @throws NotFoundException Se a missão não for encontrada no banco de dados.
     * @throws BadRequestException Se a mudança de status não for permitida (por exemplo, voltar para o status inicial).
     */
    public void updateStatus(Long id, UpdateMissionStatusDto newStatus) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada.")
        );

        if(newStatus.getStatus().equals(MissionStatus.WAITING)){
            throw new BadRequestException("Não é possível retornar a missão para o status inicial");
        }

        mission.setStatus(newStatus.getStatus());

        missionRepository.save(mission);
    }
}
