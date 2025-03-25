package com.circulosiete.curso.funcional.clase10;

import io.vavr.collection.List;
import io.vavr.concurrent.Future;

public class Lab06 {
    public static void main(String[] args) throws InterruptedException {
        usoDeReduce();
        filterConError();

        // esperamos un poquito a que se completen los hilos
        Thread.sleep(100);
    }

    private static void filterConError() {
        var f = Future.of(() -> "foo")
            .filter(valor -> valor.length() > 3);

        try {
            // al invocar get() aqui fallara
            // debido a que no hay evaluacion del futuro
            f.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (f.isFailure()) {
            System.out.println("Error en el futuro");
        }
    }

    private static void usoDeReduce() {
        var f1 = Future.of(() -> 10);
        var f2 = Future.of(() -> 10);
        var f3 = Future.of(() -> 10);

        var futures = List.of(f1, f2, f3);

        var reduccion = Future.reduce(futures, Integer::sum);

        reduccion.onSuccess(System.out::println);
    }
}
