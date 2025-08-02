package com.sergio.CRUD.services;

import java.util.List;
import java.util.Optional;

import com.sergio.CRUD.models.Usuario;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();

    Optional<Usuario> findUsuarioById(Long id);

    List<Usuario> saveUsuarios(List<Usuario> usuarios);

    Usuario saveUsuario(Usuario usuario);

    Optional<Usuario> updateUsuario(Long id, Usuario usuario);

    void deleteUsuarioById(Long id);

}
