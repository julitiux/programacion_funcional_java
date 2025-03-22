package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.model.Persona;
import com.circulosiete.curso.funcional.clase11.model.PersonaSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Lab02TestCase {
    @Test
    void shouldValidateAsInvalidBecauseNull() {
        final var validationResult = Lab02.validate(null);
        assertTrue(validationResult.isInvalid());
    }

    @Test
    void shouldValidateAsInvalidBecauseEmpty() {
        final var validationResult = Lab02.validate(new PersonaSimple(null));
        assertTrue(validationResult.isInvalid());
        System.out.printf("Error de validación: '%s'%n", validationResult.getError());
    }

    @Test
    void shouldValidateAsValid() {
        final var validationResult = Lab02.validate(new PersonaSimple("Juan"));
        assertTrue(validationResult.isValid());
        var person = validationResult.get();
        String nombre = person.nombre();
        System.out.printf("La persona es: '%s'%n", nombre);
        assertNotNull(nombre);
    }

    @Test
    void shouldFailBecausePersonHasInvalidData() {
        var persona = new Persona(
            null, null, null, null
        );

        var validationResult = Lab02.validate(persona);

        assertTrue(validationResult.isInvalid());

        validationResult
            // dado que previamente validamos que es inválido,
            // obtenemos el error...
            .getError()
            // podemos acceder a los detalles
            .details()
            .ifPresentOrElse(
                // aquí los errores de validación
                failures -> {
                    assertEquals(4, failures.size());
                    System.out.printf("Hay %d errores de validación:%n", failures.size());
                    failures.forEach(
                        failure -> System.out.println("\t" + failure)
                    );
                },
                // es un caso imposible,
                // pero bueno estar preparado,
                // solo en caso
                () -> fail("WTF!"));
    }
}
