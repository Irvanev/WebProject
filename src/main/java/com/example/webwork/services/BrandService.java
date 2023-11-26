package com.example.webwork.services;

import com.example.webwork.dtos.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto registerBrand(BrandDto brand);

    List<BrandDto> getAllBrands();

    Optional<BrandDto> getBrand(String id);
    List<BrandDto> findBrandByName(String name);

    void deleteBrand(String id);

    BrandDto updateBrand(BrandDto brand);
}
