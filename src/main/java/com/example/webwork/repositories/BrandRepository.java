package com.example.webwork.repositories;

import com.example.webwork.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, String> {
    List<Brand> findAllByName(String name);
}
