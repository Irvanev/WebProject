package com.example.webwork.models;

import com.example.webwork.models.enums.RoleEnum;
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
