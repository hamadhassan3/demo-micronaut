package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@MappedEntity
public class Role {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "name", definition = "VARCHAR(255)")
    private String name;

    @MappedProperty(value = "users")
    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "roles")
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
