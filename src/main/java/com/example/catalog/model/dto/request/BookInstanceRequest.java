package com.example.catalog.model.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record BookInstanceRequest(@NotBlank String imprint, @NotNull Date dueBack,
                                  @NotBlank String status) {
}
