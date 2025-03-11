package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Either;

public class Lab03 {
    public static void main(String[] args) {
        final var resultado = Either.right(10)
                .map(x -> Either.right(x * 2));
        System.out.println(resultado); // Right(Right(20))
        // notan algo raro en el tipo de la variable resultado?
    }
}
