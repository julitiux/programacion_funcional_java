package com.circulosiete.curso.funcional.clase06;

import io.vavr.control.Try;
import java.util.Optional;

public class Lab21 {
    public static void main(String[] args) {
        // Usar Try para manejar una operación que puede fallar
        Try<Integer> result = Try.of(() -> 10 / 0);

        // Convertir a Optional
        Optional<Integer> optionalResult = result.toJavaOptional();

        System.out.println("Optional: " + optionalResult); // Optional.empty
    }
}
