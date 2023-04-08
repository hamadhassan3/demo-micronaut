package com.example.catalog.model.dto.response;

import com.example.catalog.model.Author;
import com.example.catalog.model.Genre;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Serdeable
@ReflectiveAccess
public record AuthorResponse(@NotNull Long id, @NotBlank String firstName,
                             @NotBlank String lastName, @NotNull Date dateOfBirth,
                             Date dateOfDeath) {

    /**
     * Maps or projects Author type to AuthorResponse dto
     * @param author The author to be mapped
     */
    public AuthorResponse(Author author){
        this(author.getId(), author.getFirstName(),
                author.getLastName(), author.getDateOfBirth(),
                author.getDateOfDeath());
    }
}
