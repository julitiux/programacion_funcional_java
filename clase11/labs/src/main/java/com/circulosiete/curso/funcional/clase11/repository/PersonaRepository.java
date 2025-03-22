package com.circulosiete.curso.funcional.clase11.repository;

import com.circulosiete.curso.funcional.clase11.errorhandling.Failure;
import com.circulosiete.curso.funcional.clase11.model.Persona;
import com.circulosiete.curso.funcional.clase11.model.PersonaInSystem;
import io.vavr.control.Either;
import io.vavr.control.Try;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

public class PersonaRepository {
    public Either<Failure<String, String>, PersonaInSystem> save(Persona persona) {
        return Try.of(() -> savePersonaInDb(persona))
            .toEither()
            .mapLeft(this::recoverFrom)
            .peekLeft(failure -> {
                // tal vez aquí algo de telemetría
                // considerando los datos del Failure...
            });
    }

    private static PersonaInSystem savePersonaInDb(Persona persona) {
        // aqui el codigo para guardar en la base de datos...
        var id = UUID.randomUUID().toString();
        return new PersonaInSystem(UUID.fromString(id), persona);
    }

    private Failure<String, String> recoverFrom(Throwable throwable) {
        return Match(throwable)
            .of(
                Case(
                    $(instanceOf(SQLException.class)),
                    this::handleSqlException
                ),
                Case(
                    $(instanceOf(RuntimeException.class)),
                    this::handleRuntimeException
                ),
                Case(
                    $(),
                    this::handleUnknownException
                )
            );
    }

    private Failure<String, String> handleUnknownException(Throwable e) {
        return createFailureInstance(
            "Error desconocido",
            e.getMessage(),
            e
        );
    }

    private Failure<String, String> handleRuntimeException(RuntimeException e) {
        return createFailureInstance(
            "Error de runtime",
            e.getMessage(),
            e
        );
    }


    private Failure<String, String> handleSqlException(SQLException e) {
        return createFailureInstance(
            "Error de SQL",
            e.getMessage(),
            e
        );
    }

    private static Failure<String, String> createFailureInstance(
        String message,
        String reason,
        Throwable cause
    ) {
        return new Failure<String, String>(
            message,
            Optional.of(reason),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.of(cause),
            Optional.empty(),
            Optional.empty()
        );
    }
}
