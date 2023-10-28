package com.example.webwork.dtos;

import jakarta.validation.constraints.NotEmpty;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class BrandDto {
    private String id;
    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Name must be more than two characters!")
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    public BrandDto(String id, String name, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    protected BrandDto() {};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
