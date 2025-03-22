package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.model.Persona;
import com.circulosiete.curso.funcional.clase11.repository.PersonaRepository;
import com.circulosiete.curso.funcional.clase11.service.PersonaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Lab05TestCase {
    PersonaRepository personaRepository = new PersonaRepository();
    PersonaService personaService = new PersonaService(personaRepository);

    @Test
    void shouldFail() {
        var persona = new Persona(
            "Juan",
            "Suarez",
            "<EMAIL>",
            46
        );
        var savedPersonResult = personaService
            .addPersona(persona);

        assertTrue(savedPersonResult.isLeft());
        System.out.println(savedPersonResult.getLeft());
    }

    @Test
    void shouldPass() {
        var persona = new Persona(
            "Juan",
            "Suarez",
            "juan@circulosiete.com",
            46
        );
        var savedPersonResult = personaService
            .addPersona(persona);

        assertTrue(savedPersonResult.isRight());
        assertNotNull(savedPersonResult.get().id());

        System.out.println(savedPersonResult.get());
    }
}
