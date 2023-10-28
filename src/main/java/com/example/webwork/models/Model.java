package com.example.webwork.models;

import com.example.webwork.constants.CategoryEnum;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Model extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    private List<Offer> offers;

    @Column(name="name", length = 255, nullable = false)
    private String name;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="category", length = 11, nullable = false)
    private CategoryEnum categoryEnum;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="startYear", length = 11, nullable = false)
    private int startYear;
    @Column(name="endYear", length = 11, nullable = false)
    private int endYear;

    protected Model() {};

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
}
