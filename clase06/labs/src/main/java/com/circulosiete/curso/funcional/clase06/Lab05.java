package com.circulosiete.curso.funcional.clase06;

import io.vavr.control.Option;

public class Lab05 {
    public static void main(String[] args) {
        // Crear un Option con valor
        Option<String> name = Option.of("Alicia");
        // Crear un Option vacío
        Option<String> emptyName = Option.none();

        System.out.println(name.getOrElse("Unknown")); // Alicia
        System.out.println(emptyName.getOrElse("Unknown")); // Unknown

        // Transformar el valor
        Option<String> upperCaseName = name.map(String::toUpperCase);
        System.out.println(upperCaseName.getOrElse("Unknown")); // ALICIA
    }
}
