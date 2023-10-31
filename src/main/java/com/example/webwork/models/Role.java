package com.example.webwork.models;

import com.example.webwork.constants.RoleEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@AttributeOverrides({
        @AttributeOverride(name = "created", column = @Column(insertable = false, updatable = false)),
        @AttributeOverride(name = "modified", column = @Column(insertable = false, updatable = false))
})

public class Role extends BaseEntity {
    private List<Users> users;
    private RoleEnum roleEnum;

    protected Role() {};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role", cascade = CascadeType.REMOVE)
    public List<Users> getUsers() {
        return users;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name="name", length = 11, nullable = false)
    public RoleEnum getRoleEnum() {
        return roleEnum;
    }
    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }
}
