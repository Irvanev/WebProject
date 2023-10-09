package com.example.webwork.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Users extends Base {

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    private List<Offer> offers;
    @Column(name="userName", length = 255, nullable = false)
    private String userName;
    @Column(name="password", length = 255, nullable = false)
    private String password;
    @Column(name="firstName", length = 255, nullable = false)
    private String firstName;
    @Column(name="lastName", length = 255, nullable = false)
    private String lastName;
    private boolean isActive;
    @Column(name="imageURL", length = 255, nullable = false)
    private String imageURL;
    @Column(name="created", length = 6, nullable = false)
    private Date created;
    @Column(name="modified", length = 6, nullable = false)
    private Date modified;

}
