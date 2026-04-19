package com.Fotocopiadoras.Fotocopiadoras.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "distrito_fiscal_id", nullable = false)
    private DistritoFiscal distritoFiscal;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public DistritoFiscal getDistritoFiscal() { return distritoFiscal; }
    public void setDistritoFiscal(DistritoFiscal distritoFiscal) { this.distritoFiscal = distritoFiscal; }
}