package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record AuthorRequest(@NotBlank String firstName,
                            @NotBlank String lastName, @NotNull Date dateOfBirth,
                            Date dateOfDeath) {
}
