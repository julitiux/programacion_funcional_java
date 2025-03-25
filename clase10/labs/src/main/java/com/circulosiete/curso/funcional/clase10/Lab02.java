package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;

public class Lab02 {
    public static void main(String[] args) throws InterruptedException {
        futuroConMap();

        futuroConFlatMap();


        // necesario para esperar a los hilos
        // que no bloquean la ejecucion
        Thread.sleep(200);
    }

    private static void futuroConFlatMap() {
        // flatMap() para encadenar futuras ejecuciones
        Future<Integer> futuro = Future.of(() -> 10)
            .flatMap(x -> Future.of(() -> x * 2));

        futuro.onSuccess(resultado -> System.out.println("Doble: " + resultado));
    }

    private static void futuroConMap() {
        // map() transforma el resultado sin bloquear
        Future<Integer> futuro = Future.of(() -> 10)
            .map(x -> x * 2);

        futuro.onSuccess(resultado -> System.out.println("Doble: " + resultado));
    }
}
