package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Composición de Predicados (Predicate<T>)
 * Filtrar números pares y mayores a 10
 */
public class Lab12 {
    public static void main(String[] args) {
        final var numeros = Arrays.asList(5, 8, 12, 15, 20);

        Predicate<Integer> esPar = x -> x % 2 == 0;
        Predicate<Integer> mayorQueDiez = x -> x > 10;

        // Composición con and()
        final var resultado = numeros.stream()
                .filter(esPar.and(mayorQueDiez))
                .toList();

        System.out.println(resultado); // [12, 20]
    }
}
