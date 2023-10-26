package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.ModelConflictException;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.dtos.ModelDto;
import com.example.webwork.models.Model;
import com.example.webwork.repositories.ModelRepository;
import com.example.webwork.services.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDto register(ModelDto model) {
        Model m = modelMapper.map(model, Model.class);
        String modelId = m.getId();
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
    public Optional<ModelDto> get(String id) {
        return Optional.ofNullable(modelMapper.map(modelRepository.findById(id), ModelDto.class));
    }

    @Override
    public List<ModelDto> findModelByName (String name) {
        return modelRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, ModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
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
