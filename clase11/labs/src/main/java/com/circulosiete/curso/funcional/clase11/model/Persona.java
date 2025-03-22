package com.circulosiete.curso.funcional.clase11.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record Persona(
    @NotEmpty
    String nombre,
    @NotEmpty
    String apellidos,
    @NotNull
    @Email
    String email,
    @NotNull
    @Min(17)
    Integer edad
) {
}
