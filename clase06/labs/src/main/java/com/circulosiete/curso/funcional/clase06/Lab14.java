package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function1;

/**
 * Ejemplo de Función de Orden Superior
 */
public class Lab14 {
    public static void main(String[] args) {
        // Función que toma una función como argumento
        Function1<
                Function1<Integer, Integer>,
                Integer
                > applyFunction = f -> f.apply(5);

        Function1<Integer, Integer> square = x -> x * x;

        System.out.println(applyFunction.apply(square)); // 25
    }
}
