package com.circulosiete.curso.funcional.clase08;

import io.vavr.control.Option;

import java.util.Optional;

public class Lab01 {
    public static void main(String[] args) {
        Option<String> nombre = Option.of(null); // Retorna None en lugar de null
        // Ventaja: No necesitamos verificar null manualmente con if-else.
        System.out.println(nombre.getOrElse("Valor por defecto")); // "Valor por defecto"

        Optional<String> optionalJava = Optional.of("Hola");
        // Ventaja: Permite interoperabilidad con el código estándar de Java.
        Option<String> optionVavr = Option.ofOptional(optionalJava);

        System.out.println(optionVavr.getOrElse("Sin valor")); // "Hola"
    }
}
