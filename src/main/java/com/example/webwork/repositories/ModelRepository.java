package com.example.webwork.repositories;

import com.example.webwork.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, String> {
    List<Model> findAllByName(String name);
    @Query("SELECT m FROM Model m JOIN m.brand b WHERE b.name = :brandName")
    List<Model> findAllByBrandName(@Param("brandName") String brandName);
    List<Model> findAllByCategoryEnum(int number);
}
