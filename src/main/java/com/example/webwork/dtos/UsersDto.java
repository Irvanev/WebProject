package com.example.webwork.dtos;

import jakarta.validation.constraints.NotEmpty;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class UsersDto {
    private String id;
    private RoleDto role;
    @NotNull
    @NotEmpty
    @Length(min = 5, message = "UserName must be more than 5 characters!")
    private String userName;
    @NotNull
    @NotEmpty
    @Length(min = 10, message = "Password must be more than 10 characters!")
    private String password;
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "FirstName must be more than 2 characters!")
    private String firstName;
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "LastName must be more than 2 characters!")
    private String lastName;
    private boolean isActive;
    private String imageURL;
    private LocalDateTime created;
    private LocalDateTime modified;

    public UsersDto() {};

    public UsersDto(String id, RoleDto role, String userName, String password, String firstName, String lastName,
                    boolean isActive, String imageURL, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageURL = imageURL;
        this.created = created;
        this.modified = modified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "id=" + id +
                ", role=" + role +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", imageURL='" + imageURL + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
