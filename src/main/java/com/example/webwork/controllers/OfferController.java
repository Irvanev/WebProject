package com.example.webwork.controllers;

import com.example.webwork.dtos.OfferDto;
import com.example.webwork.exceptions.OfferNotFoundException;
import com.example.webwork.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private OfferService offerService;

    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/all")
    Iterable<OfferDto> getAllOffers() {
        return offerService.getAllOffers();
    }
    @GetMapping("/{id}")
    OfferDto getOffer(@PathVariable String id) {
        return offerService.getOffer(id).orElseThrow(() -> new OfferNotFoundException(id));
    }

    @GetMapping("/byUserName")
    public ResponseEntity<List<OfferDto>> getOfferByUserName(@RequestParam String user_name) {
        List<OfferDto> offers = offerService.findOfferByUserName(user_name);
        return ResponseEntity.ok(offers);
    }
    @PostMapping("/add")
    OfferDto createOffer(@RequestBody OfferDto offer) {
        return offerService.registerOffer(offer);
    }
    @DeleteMapping("/{id}")
    void deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
    }
    @PutMapping("/update")
    OfferDto updateOffer(@RequestBody OfferDto offer) {
        return offerService.updateOffer(offer);
    }
}
