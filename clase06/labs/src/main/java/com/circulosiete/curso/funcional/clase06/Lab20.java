package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function1;

import java.util.function.Function;

public class Lab20 {
    public static void main(String[] args) {
        javaToVavr();
        vavrToJava();
    }

    private static void vavrToJava() {
        // Crear una Function1 de Vavr
        Function1<Integer, Integer> vavrFunction = x -> x * 2;

        // Convertir a Function de Java
        Function<Integer, Integer> javaFunction = vavrFunction::apply;

        System.out.println("Result: " + javaFunction.apply(5)); // 10
    }

    private static void javaToVavr() {
        // Crear una Function de Java
        Function<Integer, Integer> javaFunction = x -> x * 2;

        // Convertir a Function1 de Vavr
        Function1<Integer, Integer> vavrFunction = javaFunction::apply;

        System.out.println("Result: " + vavrFunction.apply(5)); // 10
    }
}
