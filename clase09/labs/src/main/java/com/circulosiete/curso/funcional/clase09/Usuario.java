package com.circulosiete.curso.funcional.clase09;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Validation;

public record Usuario(String nombre, int edad) {


    @Override
    public String toString() {
        return "Usuario{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            '}';
    }

    public static Validation<Seq<String>, Usuario> crear(String nombre, int edad) {
        return Validation
            .combine(
                validarNombre(nombre),
                validarEdad(edad)
            )
            .ap(Usuario::new);
    }

    public static Validation<String, Integer> validarEdad(int edad) {
        return Option.of(edad)
            .filter(age -> age >= 18)
            .toValidation(() -> "Edad inválida: %d".formatted(edad));
    }

    private static boolean esNombreValido(String nombre) {
        return !nombre.isEmpty();
    }

    public static Validation<String, String> validarNombre(String nombre) {
        return Option.of(nombre)
            .filter(Usuario::esNombreValido)
            .toValidation(() -> "Nombre inválido: '%s'".formatted(nombre));
    }
}
