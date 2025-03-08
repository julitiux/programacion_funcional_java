package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;

public class Lab04 {
    public static void main(String[] args) {
        // Crear un mapa inmutable
        Map<String, Integer> map = HashMap.of(
                "Alicia", 30,
                "Roberto", 25,
                "Carlos", 35
        );

        // Agregar un nuevo par clave-valor
        Map<String, Integer> updatedMap = map.put("David", 40);
        // Obtener la edad de Alicia
        Option<Integer> aliceAge = map.get("Alicia");

        System.out.println("Original: " + map); // {Alicia=30, Roberto=25, Carlos=35}
        System.out.println("Updated: " + updatedMap); // {Alicia=30, Roberto=25, Carlos=35, David=40}
        System.out.println("Edad de Alicia: " + aliceAge.getOrElse(0)); // 30
    }
    // LinkedHashMap, respeta el orden de inserción.
    // TreeMap, mantiene un orden natural (o el que definas con un Comparator).
}
