package com.example.catalog.model;

import io.micronaut.data.annotation.*;

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
    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "users")
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
