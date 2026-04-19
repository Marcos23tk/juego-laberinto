package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}