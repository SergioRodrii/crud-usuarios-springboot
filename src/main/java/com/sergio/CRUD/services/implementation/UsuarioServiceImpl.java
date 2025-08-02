package com.sergio.CRUD.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sergio.CRUD.models.Usuario;
import com.sergio.CRUD.repository.UsuarioRepository;
import com.sergio.CRUD.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository =  usuarioRepository;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> saveUsuarios(List<Usuario> usuarios) {
        return usuarioRepository.saveAll(usuarios);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
    
        return usuarioRepository.findById(id)
            .map(existingUsuario -> {
                existingUsuario.setNombre(usuario.getNombre());
                existingUsuario.setApellidos(usuario.getApellidos());
                existingUsuario.setEdad(usuario.getEdad());
                existingUsuario.setTelefono(usuario.getTelefono());
                existingUsuario.setEmail(usuario.getEmail());
                existingUsuario.setDocumento(usuario.getDocumento());
                
                return usuarioRepository.save(existingUsuario);
            });
    }

    @Override
    public void deleteUsuarioById(Long id) {
        usuarioRepository.deleteById(id);
    }
}