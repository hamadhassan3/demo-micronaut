package com.example.catalog.model.dto.response;

import com.example.catalog.model.Language;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@ReflectiveAccess
public record LanguageResponse(@NotNull Long id, @NotBlank String name) {

    /**
     * Maps or projects Genre type to GenreResponse dto
     * @param language The language to be mapped
     */
    public LanguageResponse(Language language){
        this(language.getId(), language.getName());
    }
}
