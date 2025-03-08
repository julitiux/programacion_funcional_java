package com.circulosiete.curso.funcional.clase06;

import io.vavr.Function0;

/**
 * Function0 representa una función que
 * no toma argumentos y devuelve un valor.
 */
public class Lab11 {
    public static void main(String[] args) {
        Function0<String> saluda = () -> "Hola mundo!";
        System.out.println(saluda.apply()); // Hola mundo!
    }
}
