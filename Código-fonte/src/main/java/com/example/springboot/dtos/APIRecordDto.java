package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

public record APIRecordDto(@NotBlank String name,  @NotBlank String endpoint, @NotBlank String metodos, @NotBlank String parametros) {
}
