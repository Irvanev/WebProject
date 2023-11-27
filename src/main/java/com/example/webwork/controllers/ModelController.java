package com.example.webwork.controllers;

import com.example.webwork.dtos.BrandDto;
import com.example.webwork.dtos.ModelDto;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.ModelNotFoundException;
import com.example.webwork.services.ModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

/*@RestController*/
@Controller
@RequestMapping("/models")
public class ModelController {
    private ModelService modelService;
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public String getAllModels(Model model) {
        model.addAttribute("models", modelService.getAllModels());
        return "models";
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

    @ModelAttribute("modelsModel")
    public ModelDto initModel() {
        return new ModelDto();
    }
    @PostMapping("/add")
    public String addModel(@Valid ModelDto modelDto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("modelsModel", modelDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modelsModel",
                    result);
            return "redirect:/models/all";
        }
        modelService.registerModel(modelDto);

        return "redirect:/models/all";
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
