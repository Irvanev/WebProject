package com.example.webwork.services;

import com.example.webwork.dtos.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto register(BrandDto brand);

    List<BrandDto> getAll();

    Optional<BrandDto> get(String id);
    List<BrandDto> findBrandByName(String name);

    void delete(String id);

    BrandDto update(BrandDto brand);
}
