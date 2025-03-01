package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Composición de Funciones con compose()
 * Convertir un número a su doble y luego restarle 5
 */
public class Lab10 {
    public static void main(String[] args) {
        Function<Integer, Integer> doblar = x -> x * 2;
        Function<Integer, Integer> restarCinco = x -> x - 5;

        // Composición con compose()
        final var operacion = restarCinco.compose(doblar);

        System.out.println(operacion.apply(6)); // (6 * 2) - 5 = 7
    }
}
