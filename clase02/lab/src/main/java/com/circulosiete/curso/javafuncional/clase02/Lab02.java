package com.circulosiete.curso.javafuncional.clase02;

@FunctionalInterface
interface Operacion {
    int ejecutar(int a, int b);
}

public class Lab02 {
    public static void main(String[] args) {
        Operacion multiplicacion = (x, y) -> x * y;
        System.out.println(multiplicacion.ejecutar(3, 4)); // 12
    }
}
