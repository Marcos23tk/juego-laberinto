package com.Fotocopiadoras.Fotocopiadoras.Service;

import java.util.List;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Rol;

public interface RolService {
    Rol registrar(Rol obj);
    List<Rol> listar();
    Rol buscarPorId(Integer id);
    Rol actualizar(Rol obj);
    void eliminar(Integer id);
}