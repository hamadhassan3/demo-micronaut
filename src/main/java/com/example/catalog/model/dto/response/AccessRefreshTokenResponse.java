package com.example.catalog.model.dto.response;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public record AccessRefreshTokenResponse(@NotBlank String username, @NotBlank String access, @NotBlank String refresh,
                                         @NotBlank String tokenType, @NotNull Integer expiresIn,
                                         @NotNull Collection<String> roles) {
}
