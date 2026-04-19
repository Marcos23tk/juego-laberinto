package com.Fotocopiadoras.Fotocopiadoras.Service;
import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Personal;

public interface PersonalService {
    Personal registrar(Personal obj);
    List<Personal> listar();
    Personal buscarPorId(Integer id);
    Personal actualizar(Personal obj);
    void eliminar(Integer id);
}
