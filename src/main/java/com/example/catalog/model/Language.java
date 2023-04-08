package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@MappedEntity
public class Language {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "name", definition = "VARCHAR(255)")
    private String name;

    @NotNull
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "language")
    @MappedProperty(value = "books")
    private List<Book> books;

    public Language() {
        this.books = new ArrayList<>();
    }

    public Language(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

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
}
