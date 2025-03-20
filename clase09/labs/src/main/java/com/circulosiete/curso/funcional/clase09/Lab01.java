package com.circulosiete.curso.funcional.clase09;

import io.vavr.Tuple;

class PersonaClase {
    private final String nombre;
    private final int edad;

    PersonaClase(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

record PersonaRecord(String nombre, int edad) {
}

public class Lab01 {
    public static void main(String[] args) {

        final var juanConClase = new PersonaClase("Juan", 25);
        System.out.println(juanConClase.getNombre());

        final var juanConRecord = new PersonaRecord("Juan", 25);
        System.out.println(juanConRecord.nombre());

        final var juan = Tuple.of("Juan", 25);
        System.out.println(juan._1());
    }
}
