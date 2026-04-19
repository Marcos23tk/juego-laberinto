package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Sede;

public interface SedeService {
    Sede registrar(Sede obj);
    List<Sede> listar();
    Sede buscarPorId(Integer id);
    Sede actualizar(Sede obj);
    void eliminar(Integer id);
}
