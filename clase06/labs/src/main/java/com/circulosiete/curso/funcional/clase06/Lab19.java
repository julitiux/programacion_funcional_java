package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.Stream;


public class Lab19 {
    public static void main(String[] args) {
        vavrToJava();
        javaToVavr();
    }

    private static void javaToVavr() {
        // Crear un Stream de Java
        final var javaStream = java.util.stream.Stream.of(1, 2, 3, 4, 5);

        // Convertir a un Stream de Vavr
        Stream<Integer> vavrStream = Stream.ofAll(javaStream);

        System.out.println("Vavr Stream: " + vavrStream); // Stream(1, 2, 3, 4, 5)
    }

    private static void vavrToJava() {
        // Crear un Stream de Vavr
        Stream<Integer> vavrStream = Stream.of(1, 2, 3, 4, 5);

        // Convertir a un Stream de Java
        java.util.stream.Stream<Integer> javaStream = vavrStream.toJavaStream();

        // Usar el Stream de Java
        java.util.List<Integer> javaList = javaStream.toList();

        System.out.println("Java List: " + javaList); // [1, 2, 3, 4, 5]
    }
}
