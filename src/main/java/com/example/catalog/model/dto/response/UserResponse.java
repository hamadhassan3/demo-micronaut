package com.example.catalog.model.dto.response;

import com.example.catalog.model.User;
import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Serdeable
@ReflectiveAccess
public record UserResponse(@NotNull Long id, @NotBlank String username,
                           @NotBlank String password, @NotEmpty List<RoleResponse> roles) {

    /**
     * Maps or projects User type to UserResponse dto
     * @param user The language to be mapped
     */
    public UserResponse(User user){
        this(user.getId(), user.getUsername(), user.getPassword(),
                user.getRoles().stream().map((RoleResponse::new)).collect(Collectors.toList()));
    }
}
