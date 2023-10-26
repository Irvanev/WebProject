package com.example.webwork.repositories;

import com.example.webwork.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, String> {
    List<Model> findAllByName (String name);
}
