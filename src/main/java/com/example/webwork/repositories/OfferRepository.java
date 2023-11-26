package com.example.webwork.repositories;

import com.example.webwork.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, String> {
    List<Offer> findAllByYear (int year);
    @Query("SELECT o from Offer o JOIN o.users u WHERE u.userName = :user_name")
    List<Offer> findAllByUserName (String user_name);
}
