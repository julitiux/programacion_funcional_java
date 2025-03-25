package com.circulosiete.curso.funcional.clase10;

import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.Executors;

public class Lab12 {
    public static void main(String[] args) {
        new Lab12().create();
    }

    private void create() {
        long start = System.currentTimeMillis();
        var executor = Executors.newVirtualThreadPerTaskExecutor();

        var lista = List.range(0, 1000000)
            .map(
                numero -> Future.of(executor, () -> tareaPesada(numero))
                    .onComplete(System.out::println)
            );

        var resultados = Future.sequence(lista)
            .get();

        long totalTime = (System.currentTimeMillis() - start);
        var timeUnit="milisegundos";

        if (totalTime >= 1_000) {
            totalTime /= 1000;
            timeUnit="segundos";
        }

        System.out.printf(
            "Termine de procesar los resultados. Fueron '%s' tareas. Se procesaron en '%s' %s%n",
            formatear(resultados.size()),
            formatear(totalTime),
            timeUnit
        );
    }

    private String formatear(Number numero) {
        var formatter = NumberFormat.getInstance(Locale.US);
        return formatter.format(numero);
    }

    private String tareaPesada(int numero) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Tarea %d completada".formatted(numero);
    }
}
