package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Clasificacion;

public interface ClasificacionService {
    Clasificacion registrar(Clasificacion obj);
    List<Clasificacion> listar();
    Clasificacion buscarPorId(Integer id);
    Clasificacion actualizar(Clasificacion obj);
    void eliminar(Integer id);
}
