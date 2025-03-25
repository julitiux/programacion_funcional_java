package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;
import io.vavr.control.Try;

public class Lab07 {
    public static void main(String[] args) throws InterruptedException {
        var f = Future.fromTry(Try.of(() -> 10 / 0));
        f.onFailure(System.out::println);

        Thread.sleep(200);
    }
}
