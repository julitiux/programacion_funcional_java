package com.circulosiete.curso.funcional.clase06;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

public class Lab03 {
    public static void main(String[] args) {
        // Crear un conjunto inmutable
        // Los duplicados se eliminan
        Set<Integer> numbers = HashSet.of(1, 2, 3, 3, 4);

        // Elevar al cuadrado
        Set<Integer> squared = numbers.map(x -> x * x);
        // Verificar si contiene el número 3
        boolean containsThree = numbers.contains(3);

        System.out.println("Original: " + numbers); // [1, 2, 3, 4]
        System.out.println("Squared: " + squared); // [1, 4, 9, 16]
        System.out.println("Contains 3: " + containsThree); // true
    }
    // HashSet: En la mayoría de los casos, es la opción por defecto.
    // TreeSet: Mantiene los elementos ordenados
    //          (requiere que los elementos implementen Comparable o
    //           que se proporcione un Comparator).
    // LinkedHashSet: Mantiene el orden de inserción de los elementos.
}
