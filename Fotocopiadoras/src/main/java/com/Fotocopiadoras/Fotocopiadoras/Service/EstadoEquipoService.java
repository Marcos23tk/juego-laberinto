package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.EstadoEquipo;

public interface EstadoEquipoService {
    EstadoEquipo registrar(EstadoEquipo obj);
    List<EstadoEquipo> listar();
    EstadoEquipo buscarPorId(Integer id);
    EstadoEquipo actualizar(EstadoEquipo obj);
    void eliminar(Integer id);
}
