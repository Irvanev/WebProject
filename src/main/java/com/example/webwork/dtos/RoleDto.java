package com.example.webwork.dtos;

import com.example.webwork.models.enums.RoleEnum;

public class RoleDto {
    private Long id;
    private RoleEnum roleEnum;

    protected RoleDto() {};

    public RoleDto(Long id, RoleEnum roleEnum) {
        this.id = id;
        this.roleEnum = roleEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roleEnum=" + roleEnum +
                '}';
    }
}
