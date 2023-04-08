package com.example.catalog.model.dto.response;

import com.example.catalog.model.Genre;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@ReflectiveAccess
public record GenreResponse(@NotNull Long id, @NotBlank String name) {

    /**
     * Maps or projects Genre type to GenreResponse dto
     * @param genre The genre to be mapped
     */
    public GenreResponse(Genre genre){
        this(genre.getId(), genre.getName());
    }
}
