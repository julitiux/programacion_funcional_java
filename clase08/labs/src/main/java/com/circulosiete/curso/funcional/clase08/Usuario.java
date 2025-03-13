package com.circulosiete.curso.funcional.clase08;

import io.vavr.control.Either;
import io.vavr.control.Option;

public record Usuario(
    int id,
    String nombre,
    int edad,
    boolean usarImperativo
) {

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public Either<String, Usuario> validarEdad() {
        // con código imperativo
        if (usarImperativo) {
            if (!esMayorDeEdad()) {
                return Either.left(
                    obtenerMensajeErrorPorSerMenorDeEdad()
                );
            }
            return Either.right(this);
        }

        // de forma declarativa,
        // a elección siempre...
        return Option.of(this)
            .filter(Usuario::esMayorDeEdad)
            .toEither(
                this::obtenerMensajeErrorPorSerMenorDeEdad
            );
    }

    private String obtenerMensajeErrorPorSerMenorDeEdad() {
        return "Querido '%s', lo siento, eres menor de edad. No permitido entrar."
            .formatted(nombre);
    }
}
