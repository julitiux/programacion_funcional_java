package com.circulosiete.curso.funcional.clase08.repository;

import com.circulosiete.curso.funcional.clase08.Usuario;
import io.vavr.control.Option;
import java.util.Map;

public class UsuarioRepository {
    private Map<Integer, Usuario> usuarios = Map.of(
        1, new Usuario(1, "Juan", 17, true),
        2, new Usuario(2, "Laura", 18, false),
        3, new Usuario(3, "Maria", 23, true)
    );

    public Option<Usuario> buscarUsuario(int id) {
        // Lógica para buscar usuario de alguna forma.
        return Option.of(usuarios.get(id));
    }
}
