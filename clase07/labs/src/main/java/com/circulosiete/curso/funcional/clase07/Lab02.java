package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Try;

public class Lab02 {
    public static void main(String[] args) {
        Lab02 lab02 = new Lab02();
        int resultado = lab02.calcula(10, 0, 2);

        System.out.println("El resultado es: " + resultado);
    }

    private int calcula(int one, int two, int multiplicador) {
        return aplicaFunciones(one, two, multiplicador)
                .getOrElseGet(throwable -> 0);
    }

    private int multiplicar(int multiplicador, int x) {
        return x * multiplicador;
    }

    private int division(int one, int two) {
        return one / two;
    }

    private Try<Integer> aplicaFunciones(int one, int two, int multiplicador) {
        return Try.of(() -> division(one, two))
                .onFailure(throwable -> System.out.println(throwable.getMessage()))
                .flatMap(x -> Try.of(() -> multiplicar(multiplicador, x)));
    }


}
