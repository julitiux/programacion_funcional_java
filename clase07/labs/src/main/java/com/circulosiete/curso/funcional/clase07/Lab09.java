package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Try;

public class Lab09 {
    public static void main(String[] args) {
        Try<Integer> resultado = Try.of(() -> 5)
                .filter(x -> x > 10)
                .recover(e -> -1);

        System.out.println(resultado.get()); // -1
    }
}
