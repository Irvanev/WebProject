package com.example.webwork.controllers;

import com.example.webwork.dtos.BrandDto;
import com.example.webwork.exceptions.BrandNotFoundException;
import com.example.webwork.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    Iterable<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }
    @GetMapping("brand/{id}")
    BrandDto getBrand(@PathVariable String id) {
        return brandService.getBrand(id).orElseThrow(() -> new BrandNotFoundException(id));
    }
    @DeleteMapping("brand/{id}")
    void deleteBrand(@PathVariable String id) {
        brandService.deleteBrand(id);
    }
    @PutMapping("brand")
    BrandDto updateBrand(@RequestBody BrandDto brand) {
        return brandService.updateBrand(brand);
    }

    @PostMapping("brand")
    BrandDto createBrand(@RequestBody BrandDto brand) {
        return brandService.registerBrand(brand);
    }
}
