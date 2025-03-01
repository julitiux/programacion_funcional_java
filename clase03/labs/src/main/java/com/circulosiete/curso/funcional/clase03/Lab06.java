package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Retornar una Función Personalizada
 */
public class Lab06 {
    // Función de orden superior que devuelve una función multiplicadora
    public static Function<Integer, Integer> crearMultiplicador(int factor) {
        return x -> x * factor;
    }

    public static void main(String[] args) {
        // Obtenemos una función multiplicadora
        final var porCinco = crearMultiplicador(5);

        // Aplicamos la función
        System.out.println(porCinco.apply(2)); // 10
        System.out.println(porCinco.apply(3)); // 15
    }
}
