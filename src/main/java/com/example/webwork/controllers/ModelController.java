package com.example.webwork.controllers;

import com.example.webwork.dtos.ModelDto;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/models")
    Iterable<ModelDto> getAllModels() {
        return modelService.getAllModels();
    }
    @GetMapping("model/{id}")
    ModelDto getModel(@PathVariable String id) {
        return modelService.getModel(id).orElseThrow(() -> new ModelNotFoundException(id));
    }
    @GetMapping("models/byBrandName")
    public ResponseEntity<List<ModelDto>> getModelByBrandName(@RequestParam String brandName) {
        List<ModelDto> models = modelService.findModelByBrandName(brandName);
        return ResponseEntity.ok(models);
    }

    @PostMapping("model")
    ModelDto createModel(@RequestBody ModelDto model) {
        return modelService.registerModel(model);
    }
    @DeleteMapping("model/{id}")
    void deleteModel(@PathVariable String id) {
        modelService.deleteModel(id);
    }
    @PutMapping("model")
    ModelDto update(@RequestBody ModelDto model) {
        return modelService.updateModel(model);
    }
}
