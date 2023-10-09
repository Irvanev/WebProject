package com.example.webwork.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Offer extends Base {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name="description", length = 500, nullable = false)
    private String description;
    @Column(name="engine", length = 11, nullable = false)
    private int engine;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="mileage", length = 11, nullable = false)
    private int mileage;
    @Column(name="price", length = 20, nullable = false)
    private BigDecimal price;
    @Column(name="transmission", length = 11, nullable = false)
    private int transmission;
    @Column(name="year", length = 11, nullable = false)
    private int year;
    @Column(name="created", length = 6, nullable = false)
    private Date created;
    @Column(name="modified", length = 6, nullable = false)
    private Date modified;
}
