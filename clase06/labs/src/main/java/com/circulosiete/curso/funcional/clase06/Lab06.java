package com.circulosiete.curso.funcional.clase06;

import io.vavr.control.Try;

/**
 * Try se utiliza para manejar operaciones que pueden lanzar excepciones.
 */
public class Lab06 {
    public static void main(String[] args) {
        // Ejecutar una operación que puede fallar
        Try<Integer> result = Try.of(() -> 10 / 0);

        // Manejar el resultado
        if (result.isSuccess()) {
            System.out.println("Resultado: " + result.get());
        } else {
            System.out.println("Error: " + result.getCause().getMessage()); // Error: / by zero
        }
    }
}
