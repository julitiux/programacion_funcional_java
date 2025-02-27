package com.circulosiete.curso.javafuncional.clase02;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lab01 {

    public static void main(String[] args) {
        // Lambda con Múltiples Parámetros
        BiFunction<Integer, Integer, Integer> suma = (a, b) -> a + b;
        System.out.println(suma.apply(10, 5)); // 15

        // Lambda con un Solo Parámetro (Sin Paréntesis)
        // Si hay un solo parámetro, los paréntesis () pueden omitirse
        Consumer<String> imprimir = mensaje -> System.out.println(mensaje);
        imprimir.accept("Hola, Java!"); // Hola, Java!

        // Lambda con Bloque de Código
        Function<Integer, Integer> factorial = n -> {
            int resultado = 1;
            for (int i = 1; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        };
        System.out.println(factorial.apply(5)); // 120

        // Lambda sin Parámetros
        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println(aleatorio.get()); // Un número aleatorio

        // Referencias a Métodos (::)
        // Si una lambda solo llama a un metodo existente, se puede usar una referencia a metodo (::)
        Function<String, Integer> longitud = String::length;
        System.out.println(longitud.apply("Lambda")); // 6
    }
}
