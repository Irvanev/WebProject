package com.example.webwork.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users extends BaseEntity {
    private Role role;
    private List<Offer> offers;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageURL;

    protected Users() {};

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "users", cascade = CascadeType.REMOVE)
    public List<Offer> getOffers() {
        return offers;
    }
    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Column(name="userName", length = 255, nullable = false)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="password", length = 255, nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="firstName", length = 255, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastName", length = 255, nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(name="imageURL", length = 255, nullable = false)
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
