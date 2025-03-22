package com.circulosiete.curso.funcional.clase11;

import com.circulosiete.curso.funcional.clase11.model.Persona;

public class Lab03 {
    public static void main(String[] args) {
        var validationResult = Lab02.validate(
            new Persona(
                "Domingo",
                "Suarez",
                "domingo@circulosiete.com",
                46
            )
        );

        validationResult
            // podemos provocar efectos colaterales...
            .peek(persona -> {
                System.out.println("Persona valida en el sistema");
                System.out.println("\t" + persona);
            })
            // intercambiamos el error por el valor válido,
            // porque se puede...
            .swap()
            // ahora el peek tiene los errores...
            .peek(
                error ->
                    error
                        .details()
                        .ifPresentOrElse(
                            failures -> {
                                System.out.println("Errores en la validación");
                                System.out.println("\t" + failures);
                            },
                            () -> System.out.println("Sin errores...")
                        )
            )
            // podemos regresar al
            .swap()
            .getOrNull();
    }
}
