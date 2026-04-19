package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Equipo;

public interface EquipoService {
    Equipo registrar(Equipo obj);
    List<Equipo> listar();
    Equipo buscarPorId(Integer id);
    Equipo actualizar(Equipo obj);
    void eliminar(Integer id);
}
