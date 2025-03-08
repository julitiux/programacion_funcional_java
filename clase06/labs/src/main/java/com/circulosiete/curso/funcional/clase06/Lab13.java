package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function2;
import io.vavr.Function3;

/**
 * Ejemplo de Aplicación Parcial
 */
public class Lab13 {
    public static void main(String[] args) {
        Function3<Integer, Integer, Integer, Integer> sumThree = (a, b, c) -> a + b + c;

        // Fijar el primer argumento
        Function2<Integer, Integer, Integer> addTen = sumThree.apply(10);

        System.out.println(addTen.apply(5, 3)); // 10 + 5 + 3 = 18
    }
}
