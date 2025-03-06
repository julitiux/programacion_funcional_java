package com.circulosiete.curso.funcional.clase05;

import io.vavr.control.Option;

public class Lab03 {
    public static void main(String[] args) {
        Option<String> nombre = Option.of(null);
        System.out.println(nombre.getOrElse("Valor por defecto")); // "Valor por defecto"

        //Encadenar Option<T> con map()
        Option<String> nombre2 = Option.of("Juan");
        Option<Integer> longitud = nombre2.map(String::length);
        System.out.println(longitud.getOrElse(0)); // 4
    }
}
