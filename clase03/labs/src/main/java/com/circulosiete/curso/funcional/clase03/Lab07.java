package com.circulosiete.curso.funcional.clase03;

import java.util.function.Predicate;

/**
 * Retornar una Función con Parámetro Personalizado.
 * Generamos funciones que comparan números de forma flexible.
 */
public class Lab07 {
    // Función que devuelve una función que compara con un umbral
    public static Predicate<Integer> mayorQue(int umbral) {
        return n -> n > umbral;
    }

    public static void main(String[] args) {
        final var mayorQueDiez = mayorQue(10);

        System.out.println(mayorQueDiez.test(5));  // false
        System.out.println(mayorQueDiez.test(15)); // true
    }
}
