package com.circulosiete.curso.funcional.clase06;

/**
 * Use los nombres de las clases completamente
 * calificadas para hacer más claro cuál tipo estoy usando.
 */
public class Lab01 {
    public static void main(String[] args) {
        lab01VavrWay();
        lab01JavaWay();
    }

    private static void lab01VavrWay() {
        System.out.println("Vavr");
        // Crear una lista inmutable
        final var numbers = io.vavr.collection.List.of(1, 2, 3, 4, 5);

        // Definir una función que suma 10 a un número
        io.vavr.Function1<Integer, Integer> addTen = x -> x + 10;

        // Aplicar la función a cada elemento de la lista
        final var incrementedNumbers = numbers.map(addTen);

        // Imprimir la lista resultante
        System.out.println(incrementedNumbers); // [11, 12, 13, 14, 15]
    }

    private static void lab01JavaWay() {
        System.out.println("Java");
        // Crear una lista inmutable
        final var numbers = java.util.List.of(1, 2, 3, 4, 5);

        // Definir una función que suma 10 a un número
        java.util.function.Function<Integer, Integer> addTen = x -> x + 10;

        // Aplicar la función a cada elemento de la lista
        final var incrementedNumbers = numbers
                .stream()
                .map(addTen)
                .toList();

        // Imprimir la lista resultante
        System.out.println(incrementedNumbers); // [11, 12, 13, 14, 15]
    }
}
