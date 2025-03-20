package com.circulosiete.curso.funcional.clase09;

import io.vavr.collection.List;

public class Lab04 {
    public static void main(String[] args) {
        final var lista = List.of("A", "B", "C");

        System.out.println(lista); // [A, B, C]

        // Agregar elementos sin modificar la lista original (append())
        final var listaOriginal = List.of("A", "B", "C");
        final var nuevaLista = listaOriginal.append("D");

        System.out.println(nuevaLista); // [A, B, C, D]
        System.out.println(listaOriginal); // [A, B, C] (No se modificó)

        // Eliminar elementos sin modificar la lista original (remove())
        final var numeros = List.of(1, 2, 3, 4, 5);
        final var numerosNuevaLista = numeros.remove(2);

        System.out.println(numerosNuevaLista); // [1, 3, 4, 5]
        System.out.println(numeros); // [1, 2, 3, 4, 5] (No cambia)
        // Evita efectos colaterales y errores de concurrencia.
    }
}
