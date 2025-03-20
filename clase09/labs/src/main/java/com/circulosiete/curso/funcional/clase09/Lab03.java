package com.circulosiete.curso.funcional.clase09;

import io.vavr.Tuple;

public class Lab03 {
    public static void main(String[] args) {
        final var persona = Tuple.of("Juan", 30);
        System.out.println(persona);

        final var nuevaTupla = persona.map(
            nombre -> nombre.toUpperCase(),
            edad -> edad + 5
        );

        System.out.println(nuevaTupla); // (JUAN, 35)

        final var resultado = persona
            .map(
                (nombre, edad) -> Tuple.of(nombre, "Edad: " + edad)
            );
        System.out.println(resultado); // (Juan, Edad: 30)

    }
}
