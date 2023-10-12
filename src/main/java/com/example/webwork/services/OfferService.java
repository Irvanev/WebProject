package com.example.webwork.services;

import com.example.webwork.dtos.OfferDto;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    OfferDto register(OfferDto offer);

    List<OfferDto> getAll();

    Optional<OfferDto> get(Long id);

    void delete(Long id);

    OfferDto update(OfferDto offer);
}
