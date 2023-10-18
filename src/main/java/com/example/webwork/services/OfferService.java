package com.example.webwork.services;

import com.example.webwork.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    OfferDto register(OfferDto offer);

    List<OfferDto> getAll();

    Optional<OfferDto> get(UUID id);

    void delete(UUID id);

    OfferDto update(OfferDto offer);
}
