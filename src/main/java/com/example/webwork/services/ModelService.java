package com.example.webwork.services;

import com.example.webwork.dtos.ModelDto;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    ModelDto register(ModelDto model);

    List<ModelDto> getAll();

    Optional<ModelDto> get(String id);
    List<ModelDto> findModelByName (String name);

    void delete(String id);

    ModelDto update(ModelDto model);
}
