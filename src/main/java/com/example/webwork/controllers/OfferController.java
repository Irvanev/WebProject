package com.example.webwork.controllers;

import com.example.webwork.dtos.OfferDto;
import com.example.webwork.exceptions.OfferNotFoundException;
import com.example.webwork.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("offers")
    Iterable<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("offer/{id}")
    OfferDto getOffer(@PathVariable String id) {
        return offerService.getOffer(id).orElseThrow(() -> new OfferNotFoundException(id));
    }
    @PostMapping("offer")
    OfferDto createOffer(@RequestBody OfferDto offer) {
        return offerService.registerOffer(offer);
    }
    @DeleteMapping("offer/{id}")
    void deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
    }
    @PutMapping("offer")
    OfferDto updateOffer(@RequestBody OfferDto offer) {
        return offerService.updateOffer(offer);
    }
}
