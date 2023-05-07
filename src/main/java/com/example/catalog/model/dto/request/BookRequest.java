package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;

public record BookRequest(@NotBlank String title, @NotBlank String summary,
                          @NotBlank String isbn) {
}
