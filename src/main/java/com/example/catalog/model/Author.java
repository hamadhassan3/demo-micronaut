package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MappedEntity
public class Author {

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    @MappedProperty(value = "first_name", definition = "VARCHAR(255)")
    private String firstName;

    @NotBlank
    @MappedProperty(value = "last_name", definition = "VARCHAR(255)")
    private String lastName;

    @NotNull
    @MappedProperty(value = "date_of_birth", definition = "DATETIME")
    private Date dateOfBirth;

    @MappedProperty(value = "date_of_death", definition = "DATETIME")
    private Date dateOfDeath;

    @NotNull
    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "author")
    @MappedProperty(value = "books")
    private List<Book> books;

    public Author(Long id, String firstName, String lastName, Date dateOfBirth, Date dateOfDeath, List<Book> books) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.books = books;
    }

    public Author() {
        this.books = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
