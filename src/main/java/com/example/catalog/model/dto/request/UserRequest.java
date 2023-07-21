package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserRequest(@NotBlank String username,
                          @NotBlank String password,
                          @NotNull Long role) {
}
