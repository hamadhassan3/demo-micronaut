package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;

public record LanguageRequest(@NotBlank String name) {
}
