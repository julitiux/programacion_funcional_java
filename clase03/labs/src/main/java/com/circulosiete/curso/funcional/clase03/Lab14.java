package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Tipos de Streams en Java
 */
public class Lab14 {
    public static void main(String[] args) {
        // Streams de Colecciones
        final var lista = Arrays.asList("A", "B", "C");
        lista.stream().forEach(System.out::println);
        // alternativa
        lista.forEach(System.out::println);

        // Streams de Arrays
        int[] numeros = {1, 2, 3, 4, 5};
        Arrays.stream(numeros).forEach(System.out::println);

        // Streams con Stream.of()
        final var stream = Stream.of("Java", "Python", "Go");
        stream.forEach(System.out::println);

        // Streams Infinitos (generate() y iterate())
        final var aleatorios = Stream
                .generate(Math::random)
                .peek(System.out::println)
                .limit(5);
        aleatorios.forEach(System.out::println);

        final var secuencia = Stream
                .iterate(1, n -> n + 2)
                .limit(5);
        secuencia.forEach(System.out::println); // 1, 3, 5, 7, 9
    }
}
