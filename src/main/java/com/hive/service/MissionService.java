package com.hive.service;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService implements ServiceInterface<GetMissionDto,CreateMissionDto> {

    private final MissionRepository missionRepository;
    private final ModelMapper modelMapper;

    @Override
    public void create(CreateMissionDto entity) {
        Mission savedMission = modelMapper.map(entity, Mission.class);
        savedMission.setStatus(MissionStatus.WAITING);

        missionRepository.save(savedMission);
    }

    public void update(Long id, CreateMissionDto entity) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada")
        );

        modelMapper.map(entity, mission);
        missionRepository.save(mission);
    }

    @Override
    public GetMissionDto getById(Long id) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada.")
        );

        return modelMapper.map(mission, GetMissionDto.class);
    }

    @Override
    public List<GetMissionDto> getAll() {
        return missionRepository.findAll().stream()
                .map(mission -> modelMapper.map(mission, GetMissionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(!missionRepository.existsById(id)){
            throw new NotFoundException("Missão não encontrada.");
        }

        missionRepository.deleteById(id);
    }

    public void updateStatus(Long id, UpdateMissionStatusDto newStatus) {
        Mission mission = missionRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Missão não encontrada.")
        );

        mission.setStatus(newStatus.getStatus());

        missionRepository.save(mission);
    }
}
