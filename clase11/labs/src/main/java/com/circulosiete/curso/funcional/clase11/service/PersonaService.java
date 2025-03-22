package com.circulosiete.curso.funcional.clase11.service;

import com.circulosiete.curso.funcional.clase11.Lab02;
import com.circulosiete.curso.funcional.clase11.errorhandling.Failure;
import com.circulosiete.curso.funcional.clase11.model.Persona;
import com.circulosiete.curso.funcional.clase11.model.PersonaInSystem;
import com.circulosiete.curso.funcional.clase11.repository.PersonaRepository;
import io.vavr.collection.List;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import jakarta.validation.ConstraintViolation;
import java.util.Optional;

/**
 * PersonaService provides service methods to manage and validate Persona objects,
 * ensuring compliance with specific domain rules and business constraints.
 */
public class PersonaService {
    private final PersonaRepository personaRepository;
    public static final String VALID_HISPANIC_CHARS = "^[A-Za-zÁÉÍÓÚÜÑáéíóúüñ]+$";

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Either<Failure<String, String>, PersonaInSystem> addPersona(Persona persona) {
        return Lab02.validate(persona)
            .toEither()
            .mapLeft(PersonaService::createFailureFromViolation)
            .flatMap(this::validaReglasNegocio)
            .flatMap(this.personaRepository::save);
    }

    private static Failure<String, String> createFailureFromViolation(Failure<String, ConstraintViolation<Persona>> violation) {
        return fromBrokenBusinessRules(violation.message(), Optional.empty(), Optional.empty());
    }

    public Either<Failure<String, String>, Persona> validaReglasNegocio(Persona persona) {
        var brokenBusinessRules = List.of(
                this.validarLetrasHispanicas(persona.nombre()),
                this.validarLetrasHispanicas(persona.apellidos())
            )
            .filter(Validation::isInvalid)
            .map(PersonaService::fromValidation)
            .toJavaList();

        if (brokenBusinessRules.isEmpty()) {
            return Either.right(persona);
        } else {
            return Either.left(
                fromBrokenBusinessRules(
                    "Reglas de negocio rotas.",
                    Optional.of(brokenBusinessRules),
                    Optional.of("")
                )
            );
        }
    }

    public Validation<String, String> validarLetrasHispanicas(String nombre) {
        return Option.of(nombre)
            .filter(value -> value.matches(VALID_HISPANIC_CHARS))
            .toValidation(() -> "Nombre inválido: '%s'".formatted(nombre));
    }

    private static Failure<String, String> fromBrokenBusinessRules(
        String message,
        Optional<java.util.List<Failure<String, Void>>> map,
        Optional<String> x
    ) {
        return new Failure<>(
            message,
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            map,
            x
        );
    }

    private static Failure<String, Void> fromValidation(Validation<String, String> strings) {
        return new Failure<>(
            strings.getError(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.of(strings.getError())
        );
    }


}
