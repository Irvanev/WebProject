package com.example.webwork.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Role extends Base {

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<Users> users;
    @Column(name="name", length = 11, nullable = false)
    private String name;
}
