package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lab03 {
    public static void main(String[] args) {
        final var numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Definir funciones de orden superior
        Function<Integer, Integer> doblar = x -> x * 2;
        Predicate<Integer> esPar = x -> x % 2 == 0;

        // Aplicar transformación con `map()` y filtrar con `filter()`
        final var resultado = numeros.stream()
                .map(doblar)       // Multiplicar cada número por 2
                .filter(esPar)     // Filtrar solo los pares
                .toList();

        System.out.println(resultado); // [4, 8, 12, 16, 20]
    }
}
