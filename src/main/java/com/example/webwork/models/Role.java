package com.example.webwork.models;

import com.example.webwork.constants.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role extends Base {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    private List<Users> users;
    @Column(name="name", length = 11, nullable = false)
    private RoleEnum roleEnum;

    protected Role() {};

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
