package com.circulosiete.curso.funcional.clase06;

import io.vavr.Lazy;

/**
 * Vavr soporta evaluación perezosa,
 * lo que permite retrasar la evaluación
 * de expresiones hasta que sea necesario.
 */
public class Lab10 {
    public static void main(String[] args) {
        Lazy<Integer> lazyValue = Lazy.of(() -> {
            System.out.println("Calculando...");
            return 42;
        });

        System.out.println("Valor tardío aún no calculado");
        System.out.println(lazyValue.get()); // Calculando... 42
        System.out.println(lazyValue.get()); // 42 (no se vuelve a calcular)
    }
}
