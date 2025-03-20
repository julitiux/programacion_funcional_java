package com.circulosiete.curso.funcional.clase09;

import io.vavr.collection.HashMap;

public class Lab06 {
    public static void main(String[] args) {
        final var edades = HashMap.of("Juan", 30, "Ana", 25);
        System.out.println(edades); // {Juan=30, Ana=25}


        HashMap<String, Integer> juan = HashMap.of("Juan", 30);
        HashMap<String, Integer> edades2 = juan.put("Ana", 25);

        System.out.println(edades2); // {Juan=30, Ana=25}
        System.out.println(juan); // {Juan=30} (No cambia)
    }
}
