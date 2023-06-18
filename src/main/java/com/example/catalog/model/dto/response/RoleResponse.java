package com.example.catalog.model.dto.response;

import com.example.catalog.model.Language;
import com.example.catalog.model.Role;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Serdeable
@ReflectiveAccess
public record RoleResponse(@NotNull Long id, @NotBlank String name) {

    /**
     * Maps or projects Role type to RoleResponse dto
     * @param role The language to be mapped
     */
    public RoleResponse(Role role){
        this(role.getId(), role.getName());
    }
}