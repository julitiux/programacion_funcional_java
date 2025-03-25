package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Lab11 {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory factory = Thread
            .ofVirtual()
            .name("Mi factory")
            .uncaughtExceptionHandler((t, e) -> {
                System.out.println("Problemas en el hilo: " + t.getName() + " - " + e.getMessage());
            })
            .factory();

        var executor = Executors.newThreadPerTaskExecutor(factory);

        Future<Integer> futuro = Future.of(executor, () -> {
            Thread.sleep(1000);
            return 200;
        });

        futuro.onSuccess(System.out::println);

        Thread.sleep(2000);
    }
}
