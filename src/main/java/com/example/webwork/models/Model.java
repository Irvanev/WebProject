package com.example.webwork.models;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
public class Model extends Base {
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    private List<Offer> offers;

    @Column(name="name", length = 255, nullable = false)
    private String name;
    @Column(name="category", length = 11, nullable = false)
    private int category;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="startYear", length = 11, nullable = false)
    private int startYear;
    @Column(name="endYear", length = 11, nullable = false)
    private int endYear;
    @Column(name="created", length = 6, nullable = false)
    private Date created;
    @Column(name="modified", length = 6, nullable = false)
    private Date modified;

}
