package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Clasificacion;
import com.Fotocopiadoras.Fotocopiadoras.Repository.ClasificacionRepository;
import com.Fotocopiadoras.Fotocopiadoras.Exception.ResourceNotFoundException;
import com.Fotocopiadoras.Fotocopiadoras.Exception.ValidationException;

@Service
public class ClasificacionImplementacion implements ClasificacionService {
    
    private final ClasificacionRepository repo;

    public ClasificacionImplementacion(ClasificacionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Clasificacion registrar(Clasificacion obj) {
        if (obj == null) {
            throw new ValidationException("La clasificación no puede ser nula");
        }
        if (obj.getNombre() == null || obj.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre de la clasificación es requerido");
        }
        return repo.save(obj);
    }

    @Override
    public List<Clasificacion> listar() {
        return repo.findAll();
    }

    @Override
    public Clasificacion buscarPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new ValidationException("El ID debe ser un número válido");
        }
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Clasificación", "ID", id));
    }

    @Override
    public Clasificacion actualizar(Clasificacion obj) {
        if (obj == null || obj.getId() == null) {
            throw new ValidationException("La clasificación y su ID son requeridos para actualizar");
        }
        buscarPorId(obj.getId()); // Verifica que exista
        if (obj.getNombre() == null || obj.getNombre().trim().isEmpty()) {
            throw new ValidationException("El nombre de la clasificación es requerido");
        }
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
