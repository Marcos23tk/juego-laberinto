package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Clasificacion;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {
}