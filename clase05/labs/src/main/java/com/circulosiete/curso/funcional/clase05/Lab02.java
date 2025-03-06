package com.circulosiete.curso.funcional.clase05;

import io.vavr.collection.HashMap;

/**
 * HashMaps en vavr, evitan errores en concurrencia sin necesidad de synchronized.
 */
public class Lab02 {
    public static void main(String[] args) {
        HashMap<String, Integer> edades = HashMap.of("Juan", 30, "Ana", 25);
        HashMap<String, Integer> nuevasEdades = edades.put("Luis", 40);

        System.out.println(nuevasEdades); // {Juan=30, Ana=25, Luis=40}
    }
}
