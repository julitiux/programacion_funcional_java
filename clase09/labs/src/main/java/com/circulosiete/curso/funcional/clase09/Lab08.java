package com.circulosiete.curso.funcional.clase09;

import io.vavr.Tuple;
import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import java.util.Optional;
import java.util.function.Function;

public class Lab08 {
    public static void main(String[] args) {
        final var juan = Usuario.crear("Juan", 18);
        // de forma imperativa
        if (juan.isValid()) {
            System.out.println(juan);
        } else {
            System.out.println("Error: " + juan.getError());
        }

        var resultado = juan
            .mapError(errores -> errores.mkString(", "))
            .fold(Function.identity(), Usuario::toString);

        System.out.println("Resultado con Validation: " + resultado);

        String valorDobladoConEither = juan
            .toEither()
            .mapLeft(errores -> errores.mkString(", "))
            .map(Usuario::toString)
            .fold(Function.identity(), Function.identity());

        System.out.println("Resultado con Either: " + valorDobladoConEither);

        Usuario ana = juan.getOrElse(new Usuario("Ana", 25));
        System.out.println(ana);

        Usuario orNull = juan.getOrNull();
        Option<Usuario> option = juan.toOption();
        Optional<Usuario> javaOptional = juan.toJavaOptional();

        juan.getOrElseThrow(() -> new RuntimeException("Usuario invalido"));

        validacionMasiva();

    }

    private static void validacionMasiva() {
        final var usuarios = List.of(
            Tuple.of("Ana", 20),
            Tuple.of("", 15),
            Tuple.of("Luis", 17)
        );

        final var validaciones = usuarios
            .map(u -> Usuario.crear(u._1(), u._2()));

        int validacionesExitosas = validaciones.count(Validation::isValid);
        int validacionesConError = validaciones.count(Validation::isInvalid);
        System.out.println("Validaciones exitosas: " + validacionesExitosas);
        System.out.println("Validaciones con error: " + validacionesConError);


        final var partitions = validaciones.partition(Validation::isValid);

        System.out.println("Validas: " + partitions._1);
        System.out.println("Invalidas: " + partitions._2);

        final var errores = validaciones
            .filter(Validation::isInvalid)
            .map(Validation::getError)
            .flatMap(List::ofAll); // Aplanar lista de errores

        System.out.println("Errores encontrados: " + errores);
    }
}
