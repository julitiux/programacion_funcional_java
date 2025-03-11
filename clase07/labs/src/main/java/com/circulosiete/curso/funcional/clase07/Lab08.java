package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Either;
import io.vavr.control.Try;

public class Lab08 {
    public static void main(String[] args) {
        Try<Integer> resultado = Try.of(() -> 10 / 0);
        Either<String, Integer> either = resultado
                .toEither()
                .mapLeft(Throwable::getMessage);

        // con if's....
        System.out.println(either.isLeft() ? "Error: " + either.getLeft() : "Éxito: " + either.get());

        //Mas idiomatico y funcional
        String resultadoFinal = either.fold(
                error -> "Error: %s".formatted(error),
                result -> "Exito: %d".formatted(result)
        );

        //Con mas estilo aun
        String resultadoFinal2 = either.fold(
                "Error: %s"::formatted,
                "Exito: %d"::formatted
        );
        System.out.println(resultadoFinal);
        System.out.println(resultadoFinal2);
    }
}
