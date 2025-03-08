package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.List;

public class Lab02 {
    public static void main(String[] args) {
        // Crear una lista inmutable
        final var numbers = List.of(1, 2, 3, 4, 5);

        // Multiplicar cada elemento por 2
        final var doubled = numbers.map(x -> x * 2);
        // Filtrar elementos mayores a 3
        final var filtered = numbers.filter(x -> x > 3);
        // Sumar todos los elementos
        final var sum = numbers.reduce(Integer::sum);

        System.out.println("Original: " + numbers); // [1, 2, 3, 4, 5]
        System.out.println("Doubled: " + doubled); // [2, 4, 6, 8, 10]
        System.out.println("Filtered: " + filtered); // [4, 5]
        System.out.println("Sum: " + sum); // 15
    }
}
