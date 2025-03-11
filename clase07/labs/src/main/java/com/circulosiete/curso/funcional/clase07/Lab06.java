package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Try;

public class Lab06 {
    public static void main(String[] args) {
        Try<Integer> resultado = Try.of(() -> 10 / 0)
                .recover(ArithmeticException.class, -1);

        System.out.println(resultado.get()); // -1

        Try<Integer> resultado2 = Try.of(() -> 10 / 0)
                .recoverWith(ArithmeticException.class, e -> Try.of(() -> 1));

        System.out.println(resultado2.get()); // 1
    }
}
