
package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;

//Código DTO para transferir dados para o banco de dados
public record APIRecordDto(@NotBlank String name,  @NotBlank String endpoint, @NotBlank String metodos, @NotBlank String parametros) {
}
