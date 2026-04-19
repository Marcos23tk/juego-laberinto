package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Mantenimiento;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {
}