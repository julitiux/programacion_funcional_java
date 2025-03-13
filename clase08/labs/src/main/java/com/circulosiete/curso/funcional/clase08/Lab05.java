package com.circulosiete.curso.funcional.clase08;

import com.circulosiete.curso.funcional.clase08.service.UsuarioService;
import com.circulosiete.curso.funcional.clase08.util.StandardInputUtils;
import java.util.function.Function;

public class Lab05 {

    public static void main(String[] args) {
        final var usuarioService = new UsuarioService();

        int userId = StandardInputUtils.readIntFromConsole("Cual es tu id: ");
        final var bienvenida = usuarioService.bienvenida(userId);

        final var resultado = bienvenida
            .fold(
                Function.identity(),
                usuario -> "Bienvenido: %s".formatted(usuario.nombre())
            );

        System.out.println(resultado);
    }
}
