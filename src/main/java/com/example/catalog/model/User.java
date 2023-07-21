package com.example.catalog.model;

import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JoinColumn;
import io.micronaut.data.jdbc.annotation.JoinTable;

import javax.validation.constraints.NotBlank;
import java.util.List;

@MappedEntity
public class User {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "username", definition = "VARCHAR(255)")
    private String username;

    @MappedProperty(value = "password", definition = "VARCHAR(255)")
    private String password;

    @MappedProperty(value = "role")
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
