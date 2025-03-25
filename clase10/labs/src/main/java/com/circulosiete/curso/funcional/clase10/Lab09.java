package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;
import java.util.concurrent.Executors;

public class Lab09 {
    public static void main(String[] args) throws InterruptedException {
        usandoVirtualThreadsConControlDeCierreExecutor();
        usandoVirtualThreadsConExecutorReusable();
    }


    private static void usandoVirtualThreadsConControlDeCierreExecutor() throws InterruptedException {
        var futuro = Future.of(() -> {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                return executor.submit(() -> {
                    Thread.sleep(1000);
                    return 42;
                }).get();
            }
        });

        System.out.println("Operación en background...");
        futuro.onSuccess(resultado -> System.out.println("Resultado: " + resultado));

        Thread.sleep(1500);
    }

    private static void usandoVirtualThreadsConExecutorReusable() throws InterruptedException {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        var futuro = Future.of(executor, () -> {
            Thread.sleep(1000);
            return 100;
        });

        futuro.onSuccess(System.out::println);
        Thread.sleep(1500);
    }
}
