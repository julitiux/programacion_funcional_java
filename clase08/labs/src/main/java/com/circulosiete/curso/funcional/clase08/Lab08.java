package com.circulosiete.curso.funcional.clase08;

/**
 * La interfaz Runnable (o Supplier/Consumer/Function según el caso) actúa
 * como una forma de encapsular el comportamiento que se desea ejecutar.
 */
public class Lab08 {
    public static void main(String[] args) {
        // Un "comando" que imprime un mensaje:
        Runnable comandoImprimir = () -> System.out.println("Ejecutando comando de impresión...");

        // Otro "comando" que hace un cálculo:
        Runnable comandoCalcular = () -> {
            int resultado = 2 + 2;
            System.out.println("Resultado del cálculo: " + resultado);
        };

        // Ejecución diferida o condicional:
        ejecutarComando(comandoImprimir);
        ejecutarComando(comandoCalcular);
    }

    private static void ejecutarComando(Runnable comando) {
        // Lógica antes, logging, etc.
        comando.run();
        // Lógica después, validaciones, etc.
    }
}
