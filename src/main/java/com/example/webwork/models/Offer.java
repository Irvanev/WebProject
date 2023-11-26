package com.example.webwork.models;

import com.example.webwork.constants.EngineEnum;
import com.example.webwork.constants.TransmissionEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Offer extends BaseEntity {
    private Model model;
    private Users users;
    private String description;
    private EngineEnum engineEnum;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionEnum transmissionEnum;
    private int year;

    protected Offer() {};

    @ManyToOne
    @JoinColumn(name = "model_id")
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUsers() {
        return users;
    }
    public void setUsers(Users users) {
        this.users = users;
    }

    @Column(name="description", length = 500, nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="engine", length = 11, nullable = false)
    public EngineEnum getEngineEnum() {
        return engineEnum;
    }
    public void setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
    }

    @Column(name="imageURL", length = 255, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name="mileage", length = 11, nullable = false)
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name="price", length = 20, nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="transmission", length = 11, nullable = false)
    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }
    public void setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
    }

    @Column(name="year", length = 11, nullable = false)
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
