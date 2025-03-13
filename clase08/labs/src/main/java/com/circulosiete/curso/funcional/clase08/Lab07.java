package com.circulosiete.curso.funcional.clase08;

import java.util.function.Predicate;

public class Lab07 {
    public static void main(String[] args) {
        // Diferentes estrategias de validación usando lambdas:
        Predicate<String> validarLongitud = s -> s.length() > 5;
        Predicate<String> validarCaracteresEspeciales = s -> s.matches(".*[@#$%^&+=].*");

        // Podemos “inyectar” la estrategia de validación como un Predicate
        String texto = "Hola@";

        // false (longitud <= 5)
        System.out.println("Valida longitud: " + validarLongitud.test(texto));

        // true (contiene @)
        System.out.println("Valida caracteres especiales: " + validarCaracteresEspeciales.test(texto));

        // Aquí se ve cómo cada estrategia es simplemente un Predicate<String> distinto
        // que podemos intercambiar sin crear múltiples clases concretas.
    }
}
