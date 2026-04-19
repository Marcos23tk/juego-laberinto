package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Usuario;
import com.Fotocopiadoras.Fotocopiadoras.Repository.UsuarioRepository;
import com.Fotocopiadoras.Fotocopiadoras.Exception.ResourceNotFoundException;
import com.Fotocopiadoras.Fotocopiadoras.Exception.ValidationException;

@Service
public class UsuarioImplementacion implements UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioImplementacion(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Usuario registrar(Usuario obj) {
        if (obj == null || obj.getNombre() == null || obj.getNombre().isBlank()) {
            throw new ValidationException("El nombre de usuario es obligatorio");
        }
        if (obj.getUsername() == null || obj.getUsername().isBlank()) {
            throw new ValidationException("El username es obligatorio");
        }
        if (obj.getPassword() == null || obj.getPassword().isBlank()) {
            throw new ValidationException("La contraseña es obligatoria");
        }
        if (obj.getRol() == null || obj.getRol().getId() == null) {
            throw new ValidationException("El rol es obligatorio");
        }
        
        // Verificar si el username ya existe
        if (repo.findByUsername(obj.getUsername()).isPresent()) {
            throw new ValidationException("El username ya está en uso");
        }
        
        // Guardar contraseña tal cual (sin cifrado)
        return repo.save(obj);
    }

    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new ValidationException("El ID debe ser un número válido");
        }
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", id));
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new ValidationException("El username no puede estar vacío");
        }
        return repo.findByUsername(username);
    }

    @Override
    public Usuario actualizar(Usuario obj) {
        if (obj == null || obj.getId() == null) {
            throw new ValidationException("El ID del usuario es obligatorio para actualizar");
        }
        if (obj.getNombre() == null || obj.getNombre().isBlank()) {
            throw new ValidationException("El nombre de usuario es obligatorio");
        }
        if (obj.getUsername() == null || obj.getUsername().isBlank()) {
            throw new ValidationException("El username es obligatorio");
        }
        if (obj.getRol() == null || obj.getRol().getId() == null) {
            throw new ValidationException("El rol es obligatorio");
        }
        
        // Verificar que el usuario existe
        buscarPorId(obj.getId());
        
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        if (id == null || id <= 0) {
            throw new ValidationException("El ID debe ser un número válido");
        }
        buscarPorId(id); // Verifica que exista antes de eliminar
        repo.deleteById(id);
    }
}