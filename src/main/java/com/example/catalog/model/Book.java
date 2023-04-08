package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@MappedEntity
public class Book {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    @MappedProperty(value = "id")
    private Long id;

    @NotBlank
    @MappedProperty(value = "title", definition = "VARCHAR(255)")
    private String title;

    @NotNull
    // A book can have only one author, but authors can have multiple books
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    @MappedProperty(value = "author")
    private Author author;

    @NotBlank
    @MappedProperty(value = "summary", definition = "VARCHAR(1000)")
    private String summary;

    @NotBlank
    @MappedProperty(value = "isbn", definition = "VARCHAR(1000)")
    private String isbn;

    @NotNull
    // A book has many instances
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "book")
    @MappedProperty(value = "book_instances")
    private List<BookInstance> bookInstances;

    @NotNull
    // A book can have only one language, but a language can be used for multiple books
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    @MappedProperty(value = "language")
    private Language language;

    @NotNull
    // A book can have many genres and a genre can have many books
    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "books")
    @MappedProperty(value = "genres")
    private List<Genre> genres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
