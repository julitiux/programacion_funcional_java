package com.circulosiete.curso.funcional.clase05;

import io.vavr.control.Try;

public class Lab04 {
    public static void main(String[] args) {
        Try<Integer> resultado = Try.of(() -> 10 / 0)
                .onFailure(e -> System.out.println("Error manejado"));

        System.out.println(resultado.getOrElse(-1)); // -1

        Try<Integer> resultado2 = Try.of(() -> Integer.parseInt("123"))
                .map(n -> n * 2)
                .onFailure(e -> {
                    e.printStackTrace();
                    System.out.println("Error manejado.");
                });
        System.out.println(resultado2.getOrElse(-1)); // 246
    }
}
