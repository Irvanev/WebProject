package com.example.webwork.controllers;

import com.example.webwork.dtos.BrandDto;
import com.example.webwork.exceptions.BrandNotFoundException;
import com.example.webwork.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping()
    Iterable<BrandDto> all() {
        return brandService.getAll();
    }
    @GetMapping("/{id}")
    BrandDto get(@PathVariable UUID id) {
        return brandService.get(id).orElseThrow(() -> new BrandNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable UUID id) {
        brandService.delete(id);
    }
    @PutMapping()
    BrandDto update(@RequestBody BrandDto brand) {
        return brandService.update(brand);
    }

}
