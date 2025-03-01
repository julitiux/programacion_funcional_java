package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Pasar una Función como Parámetro
 */
public class Lab04 {
    // Función de orden superior que recibe otra función como parámetro
    public static int aplicarOperacion(int numero, Function<Integer, Integer> operacion) {
        return operacion.apply(numero);
    }

    public static void main(String[] args) {
        // Definir funciones lambda
        Function<Integer, Integer> cuadrado = x -> x * x;
        Function<Integer, Integer> triple = x -> x * 3;

        // Pasar funciones como parámetros
        System.out.println(aplicarOperacion(5, cuadrado)); // 25
        System.out.println(aplicarOperacion(4, triple));   // 12
    }
}
