package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.errorhandling.Failure;
import com.circulosiete.curso.funcional.clase11.model.Persona;
import com.circulosiete.curso.funcional.clase11.repository.PersonaRepository;
import com.circulosiete.curso.funcional.clase11.service.PersonaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Lab04TestCase {
    @Test
    void shouldValidateLetrasHispanicas() {
        var service = new PersonaService(new PersonaRepository());
        var result = service.validarLetrasHispanicas("Juan");
        assertTrue(result.isValid());
        System.out.println(result.get());

        result = service.validarLetrasHispanicas("Juan@");
        assertTrue(result.isInvalid());
        System.out.println(result.getError());

        result = service.validarLetrasHispanicas("Juan@CirculoSiete");
        assertTrue(result.isInvalid());
        System.out.println(result.getError());
    }

    @Test
    void shouldValidateAsValidPerson() {
        var service = new PersonaService(new PersonaRepository());
        var persona = new Persona("Juan", "Suarez", "<EMAIL>", 46);
        var result = service.validaReglasNegocio(persona);
        assertTrue(result.isRight());
        System.out.println(result.get());
    }

    @Test
    void shouldValidateBusinessRules() {
        var service = new PersonaService(new PersonaRepository());
        var persona = new Persona("Juan@", "Suarez@", "<EMAIL>", 46);
        var result = service.validaReglasNegocio(persona);
        assertTrue(result.isLeft());
        Failure<String, ?> failure = result.getLeft();
        failure.details()
            .ifPresentOrElse(
                failures -> {
                    System.out.println(failures);
                    assertEquals(2, failures.size());
                },
                () -> fail("WTF!"));

        System.out.println(failure);
    }

    @Test
    void shouldValidateAsInvalidPerson() {
        var service = new PersonaService(new PersonaRepository());
        var persona = new Persona("Domingo@", "Suarez@", "domingo@circulosiete.com", 46);
        var result = service.addPersona(persona);

        assertTrue(result.isLeft());
        System.out.println(result.getLeft());
    }
}
