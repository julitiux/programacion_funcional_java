package com.circulosiete.curso.funcional.clase09;

import io.vavr.control.Option;
import io.vavr.control.Validation;

record MiUsuario(String nombre, int edad) {
    public MiUsuario crearUsuarioDeFormaImperativa(String nombre, int edad) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("Edad inválida");
        }
        // Problema: Solo captura el primer error,
        // no todos los errores de validación.

        return new MiUsuario(nombre, edad);
    }

    public static Validation<String, Integer> validarEdad(int edad) {
        return edad >= 18 ? Validation.valid(edad) : Validation.invalid("Edad inválida");
    }
}

public class Lab07 {


    public static void main(String[] args) {
        Validation<String, Integer> resultado = MiUsuario.validarEdad(15);

        System.out.println(resultado.isValid() ? "Usuario válido" : resultado.getError());
    }
}
