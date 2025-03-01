package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Composición de Funciones con andThen()
 * Convertir un número a String y calcular su longitud
 */
public class Lab09 {
    public static void main(String[] args) {
        Function<Integer, String> convertirAString = "Número: %d"::formatted;
        Function<String, Integer> calcularLongitud = String::length;

        // Composición con andThen()
        final var longitudDelNumero = convertirAString.andThen(calcularLongitud);

        System.out.println(longitudDelNumero.apply(100)); // 11
    }
}
