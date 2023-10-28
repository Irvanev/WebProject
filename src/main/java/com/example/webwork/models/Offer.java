package com.example.webwork.models;

import com.example.webwork.constants.EngineEnum;
import com.example.webwork.constants.TransmissionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Offer extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name="description", length = 500, nullable = false)
    private String description;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="engine", length = 11, nullable = false)
    private EngineEnum engineEnum;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageUrl;
    @Column(name="mileage", length = 11, nullable = false)
    private int mileage;
    @Column(name="price", length = 20, nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.ORDINAL)
    @Column(name="transmission", length = 11, nullable = false)
    private TransmissionEnum transmissionEnum;
    @Column(name="year", length = 11, nullable = false)
    private int year;

    protected Offer() {};

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngineEnum() {
        return engineEnum;
    }

    public void setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public void setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
