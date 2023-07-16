package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public record UserRequest(@NotBlank String username,
                          @NotBlank String password,
                          @NotEmpty List<Long> roles) {
}
