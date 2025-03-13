package com.circulosiete.curso.funcional.clase08.util;

import java.util.Scanner;

public class StandardInputUtils {
    public static int readIntFromConsole(String message) {
        final var scanner = new Scanner(System.in);
        System.out.print(message);
        final var numero = scanner.nextInt();

        scanner.close();
        return numero;
    }
}
