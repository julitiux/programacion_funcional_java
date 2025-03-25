package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;
import java.util.concurrent.Executors;

public class Lab08 {
    public static void main(String[] args) throws InterruptedException {
        creandoElExecutorService();

        // esperamos a que termine el hilo
        Thread.sleep(1000);
    }

    private static void creandoElExecutorService() throws InterruptedException {
        // Crear un Executor
        var executor = Executors.newFixedThreadPool(2);
        // Crear un Future
        var future = Future.of(executor, () -> {
            Thread.sleep(1000); // Simular una tarea que tarda 1 segundo
            return 42;
        });

        // Obtener el resultado
        future.onSuccess(result -> System.out.println("Result: " + result)); // Result: 42

        future.get();

        // esperamos a que termine el hilo
        Thread.sleep(100);

        // Cerrar el Executor
        executor.shutdown();
    }
}
