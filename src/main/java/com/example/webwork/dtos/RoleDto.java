package com.example.webwork.dtos;

import com.example.webwork.constants.RoleEnum;


public class RoleDto {
    private String id;
    private RoleEnum roleEnum;

    public RoleDto() {};

    public RoleDto(String id, RoleEnum roleEnum) {
        this.id = id;
        this.roleEnum = roleEnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
