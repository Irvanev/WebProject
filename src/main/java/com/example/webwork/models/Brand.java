package com.example.webwork.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Brand extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Model> models;

    @Column(name="name", length = 255, nullable = false)
    private String name;

    protected Brand() {};

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
