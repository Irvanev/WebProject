package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.BrandConflictException;
import com.example.webwork.exceptions.BrandNotFoundException;
import com.example.webwork.dtos.BrandDto;
import com.example.webwork.models.Brand;
import com.example.webwork.repositories.BrandRepository;
import com.example.webwork.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public BrandDto register(BrandDto brand) {
        Brand b = modelMapper.map(brand, Brand.class);
        String brandId = b.getId();
        if (brandId == null || brandRepository.findById(brandId).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), BrandDto.class);
        } else {
            throw new BrandConflictException("A brand with this id already exists");
        }
    }

    @Override
    public List<BrandDto> getAll() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDto> get(String id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public List<BrandDto> findBrandByName (String name) {
        return brandRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandNotFoundException(id);
        }
    }

    @Override
    public BrandDto update(BrandDto brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brand.class)), BrandDto.class);
        } else {
            throw new BrandNotFoundException(brand.getId());
        }
    }
}
