package com.example.catalog.model;

import io.micronaut.data.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedEntity
public class BookInstance {

    /**
     * An enumeration for the status of the book instance.
     */
    public enum LOAN_STATUS {
        MAINTENANCE,
        ON_LOAN,
        AVAILABLE,
        RESERVED,
    };

    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotNull
    // A book has many book instances, and many book instances are associated with a single book
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    @MappedProperty(value = "book")
    private Book book;

    @NotBlank
    @MappedProperty(value = "imprint", definition = "VARCHAR(255)")
    private String imprint;

    @NotNull
    @MappedProperty(value = "due_back")
    private Date dueBack;

    @NotNull
    @MappedProperty(value = "status")
    private LOAN_STATUS status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public Date getDueBack() {
        return dueBack;
    }

    public void setDueBack(Date dueBack) {
        this.dueBack = dueBack;
    }

    public LOAN_STATUS getStatus() {
        return status;
    }

    public void setStatus(LOAN_STATUS status) {
        this.status = status;
    }
}
