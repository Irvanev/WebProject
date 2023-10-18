package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.ModelConflictException;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.dtos.ModelDto;
import com.example.webwork.models.Model;
import com.example.webwork.repositories.ModelRepository;
import com.example.webwork.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public ModelDto register(ModelDto model) {
        Model m = modelMapper.map(model, Model.class);
        UUID modelId = m.getId();
        if (modelId == null || modelRepository.findById(modelId).isEmpty()) {
            return modelMapper.map(modelRepository.save(m), ModelDto.class);
        } else {
            throw new ModelConflictException("A brand with this id already exists");
        }
    }

    @Override
    public List<ModelDto> getAll() {
        return modelRepository.findAll().stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ModelDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public void delete(UUID id) {
        if (modelRepository.findById(id).isPresent()) {
            modelRepository.deleteById(id);
        } else {
            throw new ModelNotFoundException(id);
        }
    }

    @Override
    public ModelDto update(ModelDto model) {
        if (modelRepository.findById(model.getId()).isPresent()) {
            return modelMapper.map(modelRepository.save(modelMapper.map(model, Model.class)), ModelDto.class);
        } else {
            throw new ModelNotFoundException(model.getId());
        }
    }
}
