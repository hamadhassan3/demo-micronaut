package com.example.catalog.model.dto.response;

import com.example.catalog.model.Book;
import com.example.catalog.model.BookInstance;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Serdeable
@ReflectiveAccess
public record BookInstanceResponse(@NotNull Long id, @NotBlank String imprint, @NotNull Date dueBack,
                                   @NotBlank BookInstance.LOAN_STATUS status) {

    /**
     * Maps or projects BookInstance type to BookInstanceResponse dto
     * @param bookInstance The book instance to be mapped
     */
    public BookInstanceResponse(BookInstance bookInstance){
        this(bookInstance.getId(), bookInstance.getImprint(),
                bookInstance.getDueBack(), bookInstance.getStatus());
    }

}
