package com.circulosiete.curso.funcional.clase08.service;

import com.circulosiete.curso.funcional.clase08.Usuario;
import com.circulosiete.curso.funcional.clase08.repository.UsuarioRepository;
import io.vavr.control.Either;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    /**
     * Busca un usuario por su identificador y realiza una validación de su edad.
     * Si el usuario no es encontrado, devuelve un mensaje de error.
     * Si el usuario es menor de edad, devuelve otro mensaje de error.
     * Si todo es correcto, devuelve el objeto Usuario.
     *
     * @param id El identificador único del usuario que se desea buscar.
     * @return Un Either que puede contener un String con el mensaje de error o un Usuario si la validación fue exitosa.
     */
    public Either<String, Usuario> bienvenida(int id) {
        return usuarioRepository.buscarUsuario(id)
            .toEither("Usuario no encontrado con el id: '%d'".formatted(id))
            .flatMap(Usuario::validarEdad);
    }
}
