package com.circulosiete.curso.funcional.clase06;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

import static io.vavr.API.*;

/**
 * Vavr introduce un sistema de pattern matching
 * que permite manejar diferentes casos de manera más clara.
 */
public class Lab09 {
    public static void main(String[] args) {
        int number = read();

        String result = Match(number).of(
                Case($(1), "Uno"),
                Case($(2), supplierForDos(number)),
                Case($(3), functionForTres()),
                Case($(), "No soportado")
        );

        System.out.println(result);
    }

    private static Supplier<String> supplierForDos(int number) {
        System.out.println("Este es el caso del numero " + number);
        return () -> "Dos";
    }

    private static Function<Integer, String> functionForTres() {
        return (number) -> {
            System.out.println("Este es el caso del numero " + number);
            return "Tres";
        };
    }

    private static int read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número entero: ");
        int numero = scanner.nextInt();

        scanner.close();
        return numero;
    }
}
