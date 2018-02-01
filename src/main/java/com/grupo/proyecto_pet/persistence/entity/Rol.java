package com.grupo.proyecto_pet.persistence.entity;

import javax.persistence.*;

/**
 * @author Franco on 5/21/2017.
 */
@Entity(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = true)
    private String descripcion;

    public Rol() {
    }

    public Rol(String rol) {
        this.nombre = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
