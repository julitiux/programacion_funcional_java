package com.circulosiete.curso.funcional.clase06;

import io.vavr.control.Option;

import java.util.Optional;

public class Lab18 {
    public static void main(String[] args) {
        vavrToJava();
        javaToVavr();
    }

    private static void javaToVavr() {
        Optional<String> javaOptional = Optional.of("Hello");

        // Convertir a Option de Vavr
        Option<String> vavrOption = Option.ofOptional(javaOptional);

        System.out.println("Java Optional: " + javaOptional); // Optional[Hello]
        System.out.println("Vavr Option: " + vavrOption); // Some(Hello)
    }

    private static void vavrToJava() {
        Option<String> vavrOption = Option.of("Hello");

        // Convertir a Optional de Java
        Optional<String> javaOptional = vavrOption.toJavaOptional();

        System.out.println("Vavr Option: " + vavrOption); // Some(Hello)
        System.out.println("Java Optional: " + javaOptional); // Optional[Hello]
    }
}
