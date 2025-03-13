package com.circulosiete.curso.funcional.clase08;

import java.util.function.Function;

public class Lab09 {
    public static void main(String[] args) {
        // "Manejador" 1: convierte a mayúsculas
        Function<String, String> handlerMayusculas = String::toUpperCase;

        // "Manejador" 2: si el string es muy corto, añade un sufijo
        Function<String, String> handlerSufijoSiCorto = s -> {
            if (s.length() < 8) {
                return s + " - (Short)";
            }
            return s; // No hace nada si no cumple condición
        };

        // Encadenamos los manejadores:
        Function<String, String> pipeline = handlerMayusculas.andThen(handlerSufijoSiCorto);

        // Ejecutamos la "cadena" sobre un String
        String resultado = pipeline.apply("Hola");
        System.out.println(resultado);
        // HOLA - (Short)
    }
}
