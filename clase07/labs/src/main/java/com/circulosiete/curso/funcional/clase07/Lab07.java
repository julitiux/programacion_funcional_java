package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Try;

public class Lab07 {
    public static void main(String[] args) {
        System.out.println(division(1, 0).getOrElse(-1)); // -1
        System.out.println(division(1, 1).getOrElse(-1)); //  1
    }

    private static Try<Integer> division(int uno, int dos) {
        return Try.of(() -> uno / dos)
                .onFailure(e -> System.out.println("Error capturado: " + e.getMessage()))
                .onSuccess(valor -> System.out.println("Éxito con valor: " + valor));
    }
}
