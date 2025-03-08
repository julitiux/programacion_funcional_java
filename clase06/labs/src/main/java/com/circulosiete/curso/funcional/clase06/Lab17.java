package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.List;
import java.util.Arrays;

/**
 * De Java a Vavr
 */
public class Lab17 {
    public static void main(String[] args) {
        // Crear una lista de Java
        java.util.List<Integer> javaList = Arrays.asList(1, 2, 3, 4, 5);

        // Convertir a una lista de Vavr
        List<Integer> vavrList = List.ofAll(javaList);

        System.out.println("Java List: " + javaList); // [1, 2, 3, 4, 5]
        System.out.println("Vavr List: " + vavrList); // List(1, 2, 3, 4, 5)
    }
}
