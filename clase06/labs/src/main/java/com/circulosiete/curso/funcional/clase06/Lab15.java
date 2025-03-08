package com.circulosiete.curso.funcional.clase06;

import io.vavr.CheckedFunction1;
import io.vavr.control.Try;

/**
 * CheckedFunction
 */
public class Lab15 {
    public static void main(String[] args) {
        CheckedFunction1<Integer, Integer> divideByZero = x -> 10 / x;

        // Usar Try para manejar excepciones
        Try<Integer> result = Try.of(() -> divideByZero.apply(0));

        if (result.isSuccess()) {
            System.out.println("Resultado: " + result.get());
        } else {
            System.out.println("Error: " + result.getCause().getMessage());
        }
    }
}
