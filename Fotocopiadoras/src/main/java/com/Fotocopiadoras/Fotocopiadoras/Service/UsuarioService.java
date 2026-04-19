package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import java.util.Optional;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Usuario;

public interface UsuarioService {
    Usuario registrar(Usuario obj);
    List<Usuario> listar();
    Usuario buscarPorId(Integer id);
    Optional<Usuario> buscarPorUsername(String username);
    Usuario actualizar(Usuario obj);
    void eliminar(Integer id);
}