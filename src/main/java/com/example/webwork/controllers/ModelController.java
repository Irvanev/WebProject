package com.example.webwork.controllers;

import com.example.webwork.dtos.ModelDto;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;
    @GetMapping()
    Iterable<ModelDto> all() {
        return modelService.getAll();
    }
    @GetMapping("/{id}")
    ModelDto get(@PathVariable UUID id) {
        return modelService.get(id).orElseThrow(() -> new ModelNotFoundException(id));
    }
    @PostMapping
    ModelDto createModel(@RequestBody ModelDto model) {
        return modelService.register(model);
    }
    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable UUID id) {
        modelService.delete(id);
    }
    @PutMapping()
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.update(model);
    }
}
