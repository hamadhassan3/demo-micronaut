package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@MappedEntity
public class Genre {
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "name", definition = "VARCHAR(255)")
    private String name;

    @NotNull
    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "genres")
    @MappedProperty(value = "books")
    private List<Book> books;

    public Genre() {
        this.books = new ArrayList<>();
    }

    public Genre(Long id, String name, List<Book> books) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
