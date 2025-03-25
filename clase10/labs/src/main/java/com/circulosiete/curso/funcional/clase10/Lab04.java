package com.circulosiete.curso.funcional.clase10;

import io.vavr.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Lab04 {
    public static void main(String[] args) {
        usandoGet();
        usandoAwait();
    }

    /**
     * await puede ser util cuando no podemos
     * esperar mas de cierto tiempo.
     */
    private static void usandoAwait() {
        final var futuro = Future.of(() -> {
            Thread.sleep(2000);
            return 100;
        });

        final var resultadoDelFuturo = futuro
            // espera en este caso 100 milisegundos.
            // Si no se resuelve el valor del futuro,
            // lo cancela
            .await(100, TimeUnit.MILLISECONDS)
            // En caso de resolverse el futuro,
            // Resolverse:
            //    1. Terminar con exito o excepcion
            //    2. Futuro cancelado por alguna razon.
            //
            // obtiene el valor del futuro o el valor default
            .getOrElse(-1);

        System.out.println(resultadoDelFuturo);
    }

    /**
     * .get() bloquea el hilo actual,
     * no tan recomendable ya que se pierde
     * la idea del Futuro
     */
    private static void usandoGet() {
        Future<Integer> futuro = Future.of(() -> {
            Thread.sleep(1000);
            return 100;
        });

        // Espera hasta obtener el resultado
        // Si hubo alguna exception,
        // aqui se lanza un Throwable
        System.out.println(futuro.get());
    }
}
