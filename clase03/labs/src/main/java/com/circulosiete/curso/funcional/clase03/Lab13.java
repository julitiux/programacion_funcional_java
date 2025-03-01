package com.circulosiete.curso.funcional.clase03;

import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * Uso de BiFunction<T, U, R> en Composición
 * Función que suma dos números y luego los multiplica por un factor
 */
public class Lab13 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumar = Integer::sum;
        Function<Integer, Integer> multiplicarPorDos = x -> x * 2;

        // Composición con andThen()
        final var operacion = sumar.andThen(multiplicarPorDos);

        System.out.println(operacion.apply(3, 5)); // (3 + 5) * 2 = 16
    }
}
