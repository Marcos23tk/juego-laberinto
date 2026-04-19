package com.Fotocopiadoras.Fotocopiadoras.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Fotocopiadoras.Fotocopiadoras.Entity.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}