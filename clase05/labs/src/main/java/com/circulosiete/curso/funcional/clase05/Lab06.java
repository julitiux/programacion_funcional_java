package com.circulosiete.curso.funcional.clase05;

import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.function.Function;

public class Lab06 {
    public static Either<String, Integer> dividir(int a, int b) {
        return Try.of(() -> a / b)
                .toEither()
                .mapLeft(throwable -> "No se puede dividir por cero");
    }

    public static void main(String[] args) {
        dividir(10, 0)
                .peek(System.out::println)
                .peekLeft(System.out::println);

        final var resultado = dividir(10, 0)
                .fold(Function.identity(), Object::toString);

        System.out.printf("El resultado es: '%s'%n", resultado);
    }
}
