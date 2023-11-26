package com.example.webwork.controllers;

import com.example.webwork.dtos.ModelDto;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    Iterable<ModelDto> getAllModels() {
        return modelService.getAllModels();
    }
    @GetMapping("/{id}")
    ModelDto getModel(@PathVariable String id) {
        return modelService.getModel(id).orElseThrow(() -> new ModelNotFoundException(id));
    }
    @GetMapping("/byBrandName")
    public ResponseEntity<List<ModelDto>> getModelByBrandName(@RequestParam String brandName) {
        List<ModelDto> models = modelService.findModelByBrandName(brandName);
        return ResponseEntity.ok(models);
    }

    @GetMapping("/byCategory")
    public ResponseEntity<List<ModelDto>> getModelByCategory(@RequestParam int number) {
        List<ModelDto> models = modelService.findModelByCategory(number);
        return ResponseEntity.ok(models);
    }

    @PostMapping("/add")
    ModelDto createModel(@RequestBody ModelDto model) {
        return modelService.registerModel(model);
    }
    @DeleteMapping("/{id}")
    void deleteModel(@PathVariable String id) {
        modelService.deleteModel(id);
    }
    @PutMapping("/update")
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.updateModel(model);
    }
}
