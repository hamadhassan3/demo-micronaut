package com.example.catalog.model;

import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JoinTable;

import javax.validation.constraints.NotBlank;
import java.util.List;

@MappedEntity
public class Role {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "name", definition = "VARCHAR(255)")
    private String name;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "role")
    private List<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
