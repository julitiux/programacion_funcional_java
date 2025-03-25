package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;

public class Lab03 {
    public static void main(String[] args) throws InterruptedException {
        Lab03 lab03 = new Lab03();

        lab03.capturaDeErroresConOnFailure();
        lab03.usandoRecoverConPatternMatching();

        // necesario para esperar a los hilos
        // que no bloquean la ejecucion
        Thread.sleep(200);
    }

    private void usandoRecoverConPatternMatching() {
        Future<Integer> futuro = Future.of(() -> 10 / 0)
            .recover(this::recoverFrom);

        futuro.onSuccess(System.out::println);
    }

    private Integer recoverFrom(Throwable throwable) {
        return Match(throwable)
            .of(
                Case(
                    $(instanceOf(IllegalArgumentException.class)),
                    this::handleIllegalArgumentException
                ),
                Case(
                    $(instanceOf(ArithmeticException.class)),
                    this::handleArithmeticException
                ),
                Case(
                    $(instanceOf(RuntimeException.class)),
                    this::handleRuntimeException
                ),
                Case(
                    $(),
                    this::handleUnknownException
                )
            );
    }

    private int handleUnknownException(Throwable e) {
        System.out.println("Error desconocido recuperado: " + e.getMessage());
        System.out.println(e.getClass().getName());
        return 0;
    }

    private int handleRuntimeException(RuntimeException e) {
        System.out.println("Error de runtime recuperado: " + e.getMessage());
        System.out.println(e.getClass().getName());
        return 200;
    }

    private int handleArithmeticException(ArithmeticException e) {
        System.out.println("Error Aritmetico: " + e.getMessage());
        return 0;
    }

    private int handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println("Error de argumento recuperado: " + e.getMessage());
        return 100;
    }

    private void capturaDeErroresConOnFailure() {
        Future<Integer> futuro = Future.of(() -> 10 / 0);

        futuro.onFailure(e -> System.out.println("Error: " + e.getMessage()));
    }
}
