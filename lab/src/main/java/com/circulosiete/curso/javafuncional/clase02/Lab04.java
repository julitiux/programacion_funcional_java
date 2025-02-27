package com.circulosiete.curso.javafuncional.clase02;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class Lab04 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(suma); // 15

        // Alternativa declarativa a un for acumulador.
        int suma2 = numeros.stream().reduce(0, Integer::sum);
        System.out.println(MessageFormat.format("Suma: {0}", suma2));
    }
}
