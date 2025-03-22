package com.circulosiete.curso.funcional.clase11.model;

import java.util.UUID;

public record PersonaInSystem(
    UUID id,
    Persona persona
) {
}
