package com.hive.controller;

import com.hive.dto.mission.CreateMissionDto;
import com.hive.dto.mission.GetMissionDto;
import com.hive.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<Void> createMission(@RequestBody CreateMissionDto createMissionDto) {
        missionService.create(createMissionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMission(@PathVariable Long id, @RequestBody CreateMissionDto createMissionDto) {
        missionService.update(id, createMissionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMissionDto> getMissionById(@PathVariable Long id) {
        GetMissionDto mission = missionService.getById(id);
        return new ResponseEntity<>(mission, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GetMissionDto>> getAllMissions() {
        List<GetMissionDto> missions = missionService.getAll();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        missionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
