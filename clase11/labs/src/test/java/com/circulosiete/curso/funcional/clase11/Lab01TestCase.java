package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.model.PersonaSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab01TestCase {

    @Test
    void shouldValidateAsInvalidBecauseNull() {
        final var validationResult = Lab01.validate(null);
        assertTrue(validationResult.isInvalid());
    }

    @Test
    void shouldValidateAsInvalidBecauseEmpty() {
        final var validationResult = Lab01.validate(new PersonaSimple(null));
        assertTrue(validationResult.isInvalid());
        System.out.printf("Error de validación: '%s'%n", validationResult.getError());
    }

    @Test
    void shouldValidateAsValid() {
        final var validationResult = Lab01.validate(new PersonaSimple("Juan"));
        assertTrue(validationResult.isValid());
        var person = validationResult.get();
        String nombre = person.nombre();
        System.out.printf("La persona es: '%s'%n", nombre);
        assertNotNull(nombre);
    }
}
