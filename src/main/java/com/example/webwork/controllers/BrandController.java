package com.example.webwork.controllers;

import com.example.webwork.dtos.BrandDto;
import com.example.webwork.dtos.ModelDto;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.BrandNotFoundException;
import com.example.webwork.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private  BrandService brandService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getAllBrands(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        return "brands";
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

    @ModelAttribute("brandsModel")
    public BrandDto initBrand() {
        return new BrandDto();
    }
    @PostMapping("/add")
    public String addBrand(@Valid BrandDto brandDto, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("brandsModel", brandDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.brandsModel",
                    result);
            return "redirect:/brands/all";
        }
        brandService.registerBrand(brandDto);

        return "redirect:/brands/all";
    }
}
