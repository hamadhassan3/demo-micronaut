package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;

public record RoleRequest(@NotBlank String name) {
}
