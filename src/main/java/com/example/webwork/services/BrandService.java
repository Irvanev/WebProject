package com.example.webwork.services;

import com.example.webwork.dtos.BrandDto;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    BrandDto register(BrandDto brand);

    List<BrandDto> getAll();

    Optional<BrandDto> get(Long id);

    void delete(Long id);

    BrandDto update(BrandDto brand);
}
