package com.circulosiete.curso.funcional.clase07;

import java.util.List;
import java.util.stream.Stream;

public class Lab04 {
    public static void main(String[] args) {
        List<List<Integer>> resultado = Stream.of(1, 2, 3)
                .map(n -> List.of(n, n * 2))
                .toList();

        System.out.println("Sin flatMap: " + resultado); // [[1, 2], [2, 4], [3, 6]]

        // Pero con flatMap
        List<Integer> resultado2 = Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n * 2))
                .toList();

        System.out.println("con flatMap: " + resultado2); // [1, 2, 2, 4, 3, 6]
    }
}
