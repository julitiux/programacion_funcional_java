package com.circulosiete.curso.javafuncional.clase02.lab03;

// Definición de una interfaz funcional
interface Operacion {
    int ejecutar(int a, int b);
}

// Implementación usando una clase anónima
public class Lab03 {
    public static void main(String[] args) {
        Operacion suma = new Operacion() {
            @Override
            public int ejecutar(int a, int b) {
                return a + b;
            }
        };

        System.out.println(suma.ejecutar(5, 3)); // 8
    }
}