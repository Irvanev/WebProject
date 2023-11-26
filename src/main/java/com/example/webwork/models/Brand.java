package com.example.webwork.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand extends BaseEntity {
    private List<Model> models;
    private String name;

    protected Brand() {};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    public List<Model> getModels() {
        return models;
    }
    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Column(name="name", length = 255, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
