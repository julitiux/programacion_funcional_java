package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Combinación de Funciones en un Flujo Completo
 */
public class Lab08 {
    public static void main(String[] args) {
        final var numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Definir funciones
        Function<Integer, Integer> doblar = x -> x * 2;
        Predicate<Integer> esMayorQueDiez = x -> x > 10;

        // Aplicar transformaciones con map() y filter()
        final var resultado = numeros.stream()
                .map(doblar)             // Multiplica por 2
                .filter(esMayorQueDiez)  // Filtra mayores a 10
                .toList();

        System.out.println(resultado); // [12, 14, 16, 18, 20]
    }
}
