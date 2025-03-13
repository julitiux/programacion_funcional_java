package com.circulosiete.curso.funcional.clase08;


import com.circulosiete.curso.funcional.clase08.service.UsuarioService;
import com.circulosiete.curso.funcional.clase08.util.StandardInputUtils;
import io.vavr.control.Try;
import java.util.function.Function;

/**
 * Este ejemplo combina el Either con Try.
 */
public class Lab06 {
    public static void main(String[] args) throws Throwable {
        final var usuarioService = new UsuarioService();

        int userId = StandardInputUtils.readIntFromConsole("Cual es tu id: ");

        // podemos decorar con manejo de excepciones si es necesario,
        // pero se deja a elección del que invoca al método.
        final var tryable = Try.of(
                () -> usuarioService.bienvenida(userId)
            )
            .map(usuarios -> usuarios.fold(
                Function.identity(),
                usuario -> "Bienvenido: %s".formatted(usuario.nombre())
            ));

        final var resultado = tryable
            .onFailure(Throwable::printStackTrace);

        if (resultado.isFailure()) {
            // es seguro usar getCause(), porque se validó previamente

            // podemos lanzar la excepción que
            // se generó en alguna parte del flujo,
            // si es necesario...
            throw resultado.getCause();
        }

        // es seguro usar get(), porque se validó previamente
        System.out.println(resultado.get());
    }
}
