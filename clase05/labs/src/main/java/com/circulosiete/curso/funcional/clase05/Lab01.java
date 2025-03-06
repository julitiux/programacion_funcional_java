package com.circulosiete.curso.funcional.clase05;

import io.vavr.collection.List;

public class Lab01 {
    public static void main(String[] args) {
        List<String> lista = List.of("A", "B", "C");
        List<String> nuevaLista = lista.append("D");

        System.out.println("vavr List: " + nuevaLista); // [A, B, C, D]

        // interoperabilidad con Java Standard Library
        // Convertir del tipo de vavr a SDK
        final var javaList = nuevaLista.toJavaList();
        System.out.println("Java List: " + nuevaLista); // [A, B, C, D]

        // Crear una List de vavr a partir de una List de SDK
        final var vavrList = List.ofAll(javaList);
        System.out.println("vavr List: " + vavrList); // [A, B, C, D]
    }
}
