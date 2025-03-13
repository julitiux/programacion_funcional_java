package com.circulosiete.curso.funcional.clase08;

import io.vavr.control.Option;

public class Lab02 {
    public static void main(String[] args) {
        // map
        Option<String> nombre = Option.of("Juan");
        Option<Integer> longitud = nombre.map(String::length);
        System.out.println(longitud.getOrElse(0)); // 4

        // flatMap
        Option<Integer> resultado = nombre
            .flatMap(n -> Option.of(n.length()));
        System.out.println(resultado.getOrElse(0)); // 4

        // filter
        Option<Integer> edad = Option.of(25)
            .filter(e -> e >= 18);
        System.out.println(edad.isDefined()); // true

        // orElse
        System.out.println(nombre.getOrElse("Sin nombre")); // "Sin nombre"

    }
}
