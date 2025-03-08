package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.List;

/**
 * De Vavr a Java
 */
public class Lab16 {
    public static void main(String[] args) {
        // Crear una lista de Vavr
        List<Integer> vavrList = List.of(1, 2, 3, 4, 5);

        // Convertir a una lista de Java
        java.util.List<Integer> javaList = vavrList.toJavaList();

        System.out.println("Vavr List: " + vavrList); // List(1, 2, 3, 4, 5)
        System.out.println("Java List: " + javaList); // [1, 2, 3, 4, 5]
    }
}
