package com.circulosiete.curso.funcional.clase09;

import io.vavr.collection.HashSet;

public class Lab05 {
    public static void main(String[] args) {
        final var numeros = HashSet.of(1, 2, 3, 3);
        System.out.println(numeros); // [1, 2, 3] (sin duplicados)
        // Se mantiene la inmutabilidad y se eliminan duplicados automáticamente.

        // Agregar elementos sin modificar el Set original
        HashSet<Integer> numeros2 = HashSet.of(1, 2, 3);
        HashSet<Integer> nuevoSet = numeros.add(4);

        System.out.println(nuevoSet); // [1, 2, 3, 4]
        System.out.println(numeros2); // [1, 2, 3] (No cambia)
        // Ventaja: add() devuelve un nuevo Set sin modificar el original.
    }
}
