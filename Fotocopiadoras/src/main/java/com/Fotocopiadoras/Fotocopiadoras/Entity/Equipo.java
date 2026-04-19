package com.Fotocopiadoras.Fotocopiadoras.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_patrimonial", nullable = false, unique = true)
    private String codigoPatrimonial;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "clasificacion_id", nullable = false)
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "estado_equipo_id", nullable = false)
    private EstadoEquipo estadoEquipo;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCodigoPatrimonial() { return codigoPatrimonial; }
    public void setCodigoPatrimonial(String codigoPatrimonial) { this.codigoPatrimonial = codigoPatrimonial; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Clasificacion getClasificacion() { return clasificacion; }
    public void setClasificacion(Clasificacion clasificacion) { this.clasificacion = clasificacion; }

    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }

    public EstadoEquipo getEstadoEquipo() { return estadoEquipo; }
    public void setEstadoEquipo(EstadoEquipo estadoEquipo) { this.estadoEquipo = estadoEquipo; }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }
}