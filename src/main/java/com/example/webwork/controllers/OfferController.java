package com.example.webwork.controllers;

import com.example.webwork.dtos.OfferDto;
import com.example.webwork.exceptions.OfferNotFoundException;
import com.example.webwork.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;
    @GetMapping()
    Iterable<OfferDto> all() {
        return offerService.getAll();
    }
    @GetMapping("/{id}")
    OfferDto get(@PathVariable UUID id) {
        return offerService.get(id).orElseThrow(() -> new OfferNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void deleteOffer(@PathVariable UUID id) {
        offerService.delete(id);
    }
    @PutMapping()
    OfferDto update(@RequestBody OfferDto offer) {
        return offerService.update(offer);
    }
}
