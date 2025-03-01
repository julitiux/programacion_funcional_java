package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Función que genera funciones matemáticas dinámicamente
 */
public class Lab02 {
    // Función de orden superior que devuelve otra función
    public static Function<Integer, Integer> crearMultiplicador(int factor) {
        return x -> x * factor;
    }

    public static void main(String[] args) {
        Function<Integer, Integer> porTres = crearMultiplicador(3);

        System.out.println(porTres.apply(4)); // 12
    }
}
