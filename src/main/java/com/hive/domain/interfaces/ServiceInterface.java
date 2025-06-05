package com.hive.domain.interfaces;

import com.hive.dto.mission.CreateMissionDto;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface ServiceInterface<D, E> {

    void create(E entity);
    void update(Long id, E entity);

    D getById(Long id);
    List<D> getAll();
    void delete(Long id);
}
