package com.circulosiete.curso.funcional.clase10;

import io.vavr.API;
import io.vavr.concurrent.Future;
import io.vavr.control.Option;
import io.vavr.control.Try;

public class Lab01 {
    public static void main(String[] args) throws InterruptedException {
        introFuture();
        introFuture2();
        // necesario para esperar a que
        // termine la ejecucion de los futuros
        Thread.sleep(2500);
    }

    private static void introFuture() {
        Future<Integer> futuro = Future.of(() -> {
            Thread.sleep(1000);
            return 42;
        });

        System.out.println("Operación en background...");
        futuro.onSuccess(resultado -> System.out.println("Resultado: " + resultado));

        // La ejecución es asíncrona y no bloqueante.
    }

    private static void introFuture2() {
        final var f = Future.of(() -> {
            Thread.sleep(1000);
            return 42;
        });

        for (int i = 0; i < 2_000_000_000; ++i) {
            // intentamos obtener el valor del futuro
            // de forma no bloqueante
            Option<Try<Integer>> value = f.getValue();

            if (value.isDefined()) {
                API.println(i + " - El futuro ha terminado");
                value.peek(attempt -> {
                    API.println("\tExito: " + attempt.isSuccess());
                    API.println("\tValor: " + attempt.getOrElse(0));
                });
                break;
            } else {
                if (i % 200_000_000 == 0) {
                    API.println(i + " - Esperando el resultado");
                }
            }
        }
    }
}
