package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function1;

public class Lab07 {
    public static void main(String[] args) {
        Function1<Integer, Integer> addTen = x -> x + 10;
        Function1<Integer, Integer> multiplyByTwo = x -> x * 2;

        // Componer funciones
        Function1<Integer, Integer> composed = addTen.andThen(multiplyByTwo);

        System.out.println(composed.apply(5)); // (5 + 10) * 2 = 30
    }
}
