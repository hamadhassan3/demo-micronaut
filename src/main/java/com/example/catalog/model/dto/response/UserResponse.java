package com.example.catalog.model.dto.response;

import com.example.catalog.model.User;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@ReflectiveAccess
public record UserResponse(@NotNull Long id, @NotBlank String username,
                           @NotBlank String password) {

    /**
     * Maps or projects User type to UserResponse dto
     * @param user The language to be mapped
     */
    public UserResponse(User user){
        this(user.getId(), user.getUsername(), user.getPassword());
    }
}
