package com.example.webwork.services;

import com.example.webwork.dtos.OfferDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferService {
    OfferDto registerOffer(OfferDto offer);
    List<OfferDto> getAllOffers();
    Optional<OfferDto> getOffer(String id);
    List<OfferDto> findOfferByYear(int year);
    void deleteOffer(String id);
    OfferDto updateOffer(OfferDto offer);
    List<OfferDto> findOfferByUserName(String user_name);
}
