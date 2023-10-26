package com.example.webwork.repositories;

import com.example.webwork.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, String> {
    List<Offer> findAllByYear (int year);
}
