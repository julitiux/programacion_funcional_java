/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
    public String getGreeting() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

        numeros.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));

        var paresEImpares = numeros.stream()
                .distinct()
                .toList();

        System.out.println(paresEImpares);
// {false=[1, 3, 5], true=[2, 4, 6]}

        List<String> nombres = Arrays
                .asList("Ana", "Pedro", "Luis", "Andrea", "Pablo");

        List<String> resultado = nombres
                .stream()
                .filter(n -> n.startsWith("A")) // Filtrar nombres que inician con "A"
                .map(String::toUpperCase)       // Convertir a mayúsculas
                .sorted()                      // Ordenar alfabéticamente
                .toList();

        System.out.println(resultado); // [ANA, ANDREA]


        Function<Integer, Integer> doblar = x -> x * 2;
        Function<Integer, Integer> incrementar = x -> x + 1;

        Function<Integer, Integer> dobleYSumar = doblar.andThen(incrementar);

        System.out.println(dobleYSumar.apply(3)); // (3 * 2) + 1 = 7

        Function<Integer, Integer> compose = dobleYSumar.compose(doblar);

        System.out.println("Compose "+ compose.apply(6));


        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
