package com.circulosiete.curso.funcional.clase05;

import io.vavr.control.Either;

public class Lab05 {
    public static Either<String, Integer> dividir(int a, int b) {
        return b == 0 ? Either.left("No se puede dividir por cero") : Either.right(a / b);
    }

    public static void main(String[] args) {
        final var resultado = dividir(10, 0);
        System.out.println(resultado.isLeft() ? resultado.getLeft() : resultado.get());
    }
}
