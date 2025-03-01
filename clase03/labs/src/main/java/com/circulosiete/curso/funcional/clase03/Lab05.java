package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Usamos Predicate<T> para recibir una función que evalúa una condición.
 */
public class Lab05 {
    // Función de orden superior que filtra una lista según una condición
    public static List<Integer> filtrar(
            List<Integer> numeros,
            Predicate<Integer> condicion
    ) {
        return numeros.stream()
                .filter(condicion)
                .toList();
    }

    public static void main(String[] args) {
        final var numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Pasamos diferentes funciones como parámetros
        System.out.println(filtrar(numeros, n -> n % 2 == 0));  // [2, 4, 6, 8]
        System.out.println(filtrar(numeros, n -> n > 5));       // [6, 7, 8, 9]
    }
}
