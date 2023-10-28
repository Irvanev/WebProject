package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.OfferConflictException;
import com.example.webwork.exceptions.OfferNotFoundException;
import com.example.webwork.dtos.OfferDto;
import com.example.webwork.models.Offer;
import com.example.webwork.repositories.OfferRepository;
import com.example.webwork.services.OfferService;
import com.example.webwork.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final ValidationUtil validationUtil;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public OfferDto registerOffer(OfferDto offer) {

        if(!this.validationUtil.isValid(offer)) {
            this.validationUtil
                    .violations(offer)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Offer!");
        }

        Offer o = modelMapper.map(offer, Offer.class);
        String offerId = o.getId();
        if (offerId == null || offerRepository.findById(offerId).isEmpty()) {
            return modelMapper.map(offerRepository.save(o), OfferDto.class);
        } else {
            throw new OfferConflictException("A offer with this id already exists");
        }
    }

    @Override
    public List<OfferDto> getAllOffers() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OfferDto> getOffer(String id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }
    @Override
    public List<OfferDto> findOfferByYear(int year) {
        return offerRepository.findAllByYear(year).stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteOffer(String id) {
        if (offerRepository.findById(id).isPresent()) {
            offerRepository.deleteById(id);
        } else {
            throw new OfferNotFoundException(id);
        }
    }

    @Override
    public OfferDto updateOffer(OfferDto offer) {
        if (offerRepository.findById(offer.getId()).isPresent()) {
            return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offer.class)), OfferDto.class);
        } else {
            throw new OfferNotFoundException(offer.getId());
        }
    }
}
