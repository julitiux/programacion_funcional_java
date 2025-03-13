package com.circulosiete.curso.funcional.clase08;

import io.vavr.control.Either;
import java.util.function.Function;

public class Lab03 {
    public static Either<String, Integer> dividir(int a, int b) {
        return b == 0 ? Either.left("No se puede dividir por cero") : Either.right(a / b);
    }

    public static void main(String[] args) {
        Either<String, Integer> resultado = dividir(10, 1);

        // one-liners del mal...
        System.out.println(resultado.isLeft() ? "Error con one-liner: %s".formatted(resultado.getLeft()) : "Éxito con one-liner: %d".formatted(resultado.get()));

        // uso de Either imperativo
        if (resultado.isRight()) {
            System.out.printf("Éxito con Java imperativo: %d%n", resultado.get());
        } else {
            System.out.printf("Error con Java imperativo: %s%n", resultado.getLeft());
        }

        // Estilo preferido, más funcional e idiomático
        final var result = resultado
            .map("Éxito con vavr idiomático: %d"::formatted)
            .mapLeft("Error con vavr idiomático: %s"::formatted)
            .fold(Function.identity(), Function.identity());

        System.out.println(result);
    }
}
