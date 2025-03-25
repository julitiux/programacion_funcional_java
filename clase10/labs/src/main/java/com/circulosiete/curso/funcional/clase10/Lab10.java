package com.circulosiete.curso.funcional.clase10;

import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import java.util.concurrent.Executors;

public class Lab10 {
    public static void main(String[] args) throws InterruptedException {
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        List<Future<Integer>> futuros = List.of(
            Future.of(executor, () -> {
                Thread.sleep(1000);
                return 10;
            }),
            Future.of(executor, () -> {
                Thread.sleep(2000);
                return 20;
            }),
            Future.of(executor, () -> {
                Thread.sleep(1500);
                return 30;
            })
        );

        var resultado = Future.sequence(futuros);
        resultado.onSuccess(System.out::println);

        Thread.sleep(3000);
    }
}
