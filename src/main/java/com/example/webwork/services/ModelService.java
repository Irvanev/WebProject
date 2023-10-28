package com.example.webwork.services;

import com.example.webwork.dtos.ModelDto;

import java.util.List;
import java.util.Optional;

public interface ModelService {
    ModelDto registerModel(ModelDto model);

    List<ModelDto> getAllModels();

    Optional<ModelDto> getModel(String id);
    List<ModelDto> findModelByName (String name);

    void deleteModel(String id);

    ModelDto updateModel(ModelDto model);
}
