package com.circulosiete.curso.funcional.clase09;

import io.vavr.Tuple;
import io.vavr.Tuple3;

/**
 * Ventaja: Permite almacenar datos heterogéneos
 * sin necesidad de definir una clase personalizada.
 */
public class Lab02 {
    public static void main(String[] args) {
        Tuple3<String, Integer, Boolean> datos = Tuple.of("Laptop", 1500, true);

        System.out.println(datos._1); // Laptop
        System.out.println(datos._2); // 1500
        System.out.println(datos._3); // true
    }
}
