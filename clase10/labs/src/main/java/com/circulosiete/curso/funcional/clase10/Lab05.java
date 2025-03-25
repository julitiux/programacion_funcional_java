package com.circulosiete.curso.funcional.clase10;

import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.concurrent.Future;

public class Lab05 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        usandoZip();
        System.out.println("[ZIP] Tiempo total de ejecución: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        usandoSequence();
        System.out.println("[SEQ] Tiempo total de ejecución: " + (System.currentTimeMillis() - start));
        usandoFold();
    }


    /**
     * Ejecutar dos Future<T> en paralelo con zip()
     */
    private static void usandoZip() {
        final var futuro1 = Future.of(() -> {
            Thread.sleep(200);
            return 10;
        });
        final var futuro2 = Future.of(() -> {
            Thread.sleep(300);
            return 20;
        });

        final var resultado = futuro1.zip(futuro2)
            .map(tupla -> tupla._1 + tupla._2);

        System.out.printf("El resultado es: %d%n", resultado.get());
    }

    private static void usandoSequence() throws InterruptedException {
        final var futuros = List.of(
            Future.of(() -> 10),
            Future.of(() -> 20),
            Future.of(() -> 30)
        );

        Future<Seq<Integer>> resultados = Future.sequence(futuros);

        resultados.get();

        resultados.onSuccess(results -> {
            Integer i = results.get();
            results.forEach(System.out::println);
            System.out.println("Total: " + i);

        });
        Thread.sleep(100);
        Seq<Integer> integers = resultados.get();
        System.out.println("seq: " + integers);
    }

    private static void usandoFold() {
        List<Future<Integer>> futures = List.of(
            Future.of(() -> 10),
            Future.of(() -> 20),
            Future.of(() -> 30)
        );

        final var foldeados = Future
            .fold(futures, 0, Integer::sum)
            .map(i -> "Valor de la suma total: " + i);

        System.out.println(foldeados.get());
    }
}
