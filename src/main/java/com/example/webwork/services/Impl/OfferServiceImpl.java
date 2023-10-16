package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.OfferConflictException;
import com.example.webwork.exceptions.OfferNotFoundException;
import com.example.webwork.dtos.OfferDto;
import com.example.webwork.models.Offer;
import com.example.webwork.repositories.OfferRepository;
import com.example.webwork.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public OfferDto register(OfferDto offer) {
        Offer b = modelMapper.map(offer, Offer.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(offerRepository.save(b), OfferDto.class);
        } else {
            throw new OfferConflictException("A offer with this id already exists");
        }
    }

    @Override
    public List<OfferDto> getAll() {
        return offerRepository.findAll().stream().map((s) -> modelMapper.map(s, OfferDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OfferDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(offerRepository.findById(id), OfferDto.class));
    }

    @Override
    public void delete(Long id) {
        if (offerRepository.findById(id).isPresent()) {
            offerRepository.deleteById(id);
        } else {
            throw new OfferNotFoundException(id);
        }
    }

    @Override
    public OfferDto update(OfferDto offer) {
        if (offerRepository.findById(offer.getId()).isPresent()) {
            return modelMapper.map(offerRepository.save(modelMapper.map(offer, Offer.class)), OfferDto.class);
        } else {
            throw new OfferNotFoundException(offer.getId());
        }
    }
}
