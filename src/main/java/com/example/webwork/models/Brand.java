package com.example.webwork.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Brand extends Base {

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Model> models;

    @Column(name="name", length = 255, nullable = false)
    private String name;
    @Column(name="created", length = 6, nullable = false)
    private Date created;
    @Column(name="modified", length = 6, nullable = false)
    private Date modified;

    protected Brand() {};

}
