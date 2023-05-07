package com.example.catalog.model.dto.response;

import com.example.catalog.model.Book;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@ReflectiveAccess
public record BookResponse (@NotNull Long id, @NotBlank String title, @NotBlank String summary,
                            @NotBlank String isbn) {

    /**
     * Maps or projects Book type to BookResponse dto
     * @param book The book to be mapped
     */
    public BookResponse(Book book){
        this(book.getId(), book.getTitle(),
                book.getSummary(), book.getIsbn());
    }
}
