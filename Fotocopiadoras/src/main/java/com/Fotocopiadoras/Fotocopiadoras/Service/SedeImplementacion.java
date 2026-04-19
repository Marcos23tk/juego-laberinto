package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Sede;
import com.Fotocopiadoras.Fotocopiadoras.Repository.SedeRepository;

// @Service le indica a Spring que esta clase es un "Servicio".
@Service
public class SedeImplementacion implements SedeService {

    // Aquí definimos una variable para nuestro "Repositorio".
    private final SedeRepository repo;

    // Este es el constructor de la clase.
    public SedeImplementacion(SedeRepository repo) {
        this.repo = repo;
    }

    // @Override indica que este método está sobrescribiendo/implementando
    @Override
    public Sede registrar(Sede obj) {
        // repo.save(obj) toma nuestro objeto Sede y genera automáticamente
        return repo.save(obj);
    }

    @Override
    public List<Sede> listar() {
        // repo.findAll() busca todas los registros en la tabla y los devuelve como una
        // lista.
        return repo.findAll();
    }

    @Override
    public Sede buscarPorId(Integer id) {
        // repo.findById(id) busca un registro por su clave primaria (ID).
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Sede no encontrada con ID: " + id));
    }

    @Override
    public Sede actualizar(Sede obj) {
        // En Spring Data JPA (la tecnología debajo de 'repo'),
        return repo.save(obj);
    }

    @Override
    public void eliminar(Integer id) {
        // Elimina el registro de la tabla en base de datos usando el ID proporcionado.
        repo.deleteById(id);
    }
}
