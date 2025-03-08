package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function1;
import io.vavr.Function2;

/**
 * El currying permite dividir una función
 * en múltiples funciones más pequeñas.
 */
public class Lab08 {
    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = Integer::sum;

        // Aplicar currying
        Function1<Integer, Integer> addFive = sum
                .curried()
                .apply(5);

        System.out.println(addFive.apply(10)); // 15
    }
}
