package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function2;

/**
 * Function2 representa una función que
 * toma dos argumentos y devuelve un valor.
 */
public class Lab12 {
    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum.apply(3, 5)); // 8
    }
}
