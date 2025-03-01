package com.circulosiete.curso.funcional.clase03;

import java.util.function.Function;

/**
 * Ejemplo de Función de Orden Superior en Java
 */
public class Lab01 {
    // Función de orden superior que aplica otra función sobre un número
    public static int operar(int numero, Function<Integer, Integer> operacion) {
        return operacion.apply(numero);
    }

    public static void main(String[] args) {
        // Expresión lambda para duplicar un número
        Function<Integer, Integer> duplicar = x -> x * 2;

        // Usamos la función de orden superior
        System.out.println(operar(5, duplicar)); // 10
    }
}

