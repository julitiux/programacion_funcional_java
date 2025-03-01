package com.circulosiete.curso.funcional.clase03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Composición de Funciones en Flujos de Datos con map()
 * Convertir nombres a mayúsculas y contar sus caracteres
 */
public class Lab11 {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("ana", "pedro", "luis");

        Function<String, String> aMayusculas = String::toUpperCase;
        Function<String, Integer> contarCaracteres = String::length;

        // Composición con Streams
        final var resultado = nombres.stream()
                .map(aMayusculas.andThen(contarCaracteres))
                .toList();

        System.out.println(resultado); // [3, 5, 4]
    }
}
