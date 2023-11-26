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
    private  BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    Iterable<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }
    @GetMapping("/{id}")
    BrandDto getBrand(@PathVariable String id) {
        return brandService.getBrand(id).orElseThrow(() -> new BrandNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteBrand(@PathVariable String id) {
        brandService.deleteBrand(id);
    }
    @PutMapping("/update")
    BrandDto updateBrand(@RequestBody BrandDto brand) {
        return brandService.updateBrand(brand);
    }

    @PostMapping("/add")
    BrandDto createBrand(@RequestBody BrandDto brand) {
        return brandService.registerBrand(brand);
    }
}
