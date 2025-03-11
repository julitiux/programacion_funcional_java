package com.circulosiete.curso.funcional.clase07;

import io.vavr.control.Try;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab05 {
    public static void main(String[] args) {
        final var contenido = Try
                .of(() -> new String(
                                Files.readAllBytes(Paths.get("archivo.txt"))
                        )
                );

        System.out.println(contenido.getOrElse("Archivo no encontrado"));
    }
}
