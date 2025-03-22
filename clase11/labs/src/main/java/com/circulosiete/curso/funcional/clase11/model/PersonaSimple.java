package com.circulosiete.curso.funcional.clase11.model;

import jakarta.validation.constraints.NotEmpty;

public record PersonaSimple(
    @NotEmpty
    String nombre
) {
}
