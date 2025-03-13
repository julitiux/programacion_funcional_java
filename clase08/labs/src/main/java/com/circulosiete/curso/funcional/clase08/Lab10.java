package com.circulosiete.curso.funcional.clase08;

public class Lab10 {
    public static void main(String[] args) {
        // Creamos "hooks" como lambdas
        Runnable validarDatos = () -> System.out.println("Validando datos...");
        Runnable guardarEnBD = () -> System.out.println("Guardando en Base de Datos...");
        Runnable enviarEmail = () -> System.out.println("Enviando email de confirmación...");

        // Ejecutamos el flujo
        procesoRegistro(validarDatos, guardarEnBD, enviarEmail);

        // Si queremos omitir el email, pasamos un "hook" vacío
        procesoRegistro(validarDatos, guardarEnBD, () -> {
        });
    }

    // Método template: define el orden
    private static void procesoRegistro(
        Runnable pasoValidar,
        Runnable pasoGuardar,
        Runnable pasoAdicional
    ) {
        pasoValidar.run();
        pasoGuardar.run();
        // Hook
        pasoAdicional.run();
    }
}
