package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.BrandConflictException;
import com.example.webwork.exceptions.BrandNotFoundException;
import com.example.webwork.dtos.BrandDto;
import com.example.webwork.models.Brand;
import com.example.webwork.repositories.BrandRepository;
import com.example.webwork.services.BrandService;
import com.example.webwork.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;
    private final ValidationUtil validationUtil;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.brandRepository = brandRepository;
    }
    @Override
    public BrandDto registerBrand(BrandDto brand) {
        if (!this.validationUtil.isValid(brand)) {
            this.validationUtil
                    .violations(brand)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments!");
        }
        Brand b = modelMapper.map(brand, Brand.class);
        String brandId = b.getId();
        if (brandId == null || brandRepository.findById(brandId).isEmpty()) {
            return modelMapper.map(brandRepository.save(b), BrandDto.class);
        } else {
            throw new BrandConflictException("A brand with this id already exists");
        }
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return brandRepository.findAll().stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<BrandDto> getBrand(String id) {
        return Optional.ofNullable(modelMapper.map(brandRepository.findById(id), BrandDto.class));
    }

    @Override
    public List<BrandDto> findBrandByName (String name) {
        return brandRepository.findAllByName(name).stream().map((s) -> modelMapper.map(s, BrandDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteBrand(String id) {
        if (brandRepository.findById(id).isPresent()) {
            brandRepository.deleteById(id);
        } else {
            throw new BrandNotFoundException(id);
        }
    }

    @Override
    public BrandDto updateBrand(BrandDto brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            return modelMapper.map(brandRepository.save(modelMapper.map(brand, Brand.class)), BrandDto.class);
        } else {
            throw new BrandNotFoundException(brand.getId());
        }
    }
}
