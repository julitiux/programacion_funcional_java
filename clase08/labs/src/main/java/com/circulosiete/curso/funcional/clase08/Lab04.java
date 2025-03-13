package com.circulosiete.curso.funcional.clase08;

import io.vavr.control.Either;

public class Lab04 {
    public static void main(String[] args) {
        // map
        Either<String, Integer> resultado = Either
            .<String, Integer>right(10) // auch! generic types! domix aquí elaborará algo...
            .map(x -> x * 2);
        System.out.println(resultado.get()); // 20

        // flatMap
        resultado
            .flatMap(x -> Either.right(x * 2));

        System.out.println(resultado.get()); // 20

        // el uso de get() arriba es desaconsejado.
        // Ya que antes de usarlo,
        // debemos validar que es right el Either.
        // Si no es Right, lanzará NoSuchElementException

        // getOrElse
        System.out.println(resultado.getOrElse(-1)); // -1

        // fold
        String mensaje = resultado.fold(
            error -> "Error con fold: " + error,
            exito -> "Resultado con fold: " + exito
        );
        System.out.println(mensaje); // "Resultado: 20"
    }
}
