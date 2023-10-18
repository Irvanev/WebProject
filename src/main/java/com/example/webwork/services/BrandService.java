package com.example.webwork.services;

import com.example.webwork.dtos.BrandDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {
    BrandDto register(BrandDto brand);

    List<BrandDto> getAll();

    Optional<BrandDto> get(UUID id);

    void delete(UUID id);

    BrandDto update(BrandDto brand);
}
