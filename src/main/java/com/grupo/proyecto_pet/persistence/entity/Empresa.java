package com.grupo.proyecto_pet.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@Entity(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(length = 300)
    private String descripcion;
    private String ruc;
    private String razonSocial;
    private String direccion;

    @Column(name = "empresa_local", nullable = false)
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Local> locales = new ArrayList<>();

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "empresa_usuario_creador_id_fk"))
    private Usuario usuarioCreacion;

    @Column(name = "fecha_edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicion;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "empresa_usuario_editor_id_fk"))
    private Usuario usuarioEdicion;

    public Empresa() {
    }

    public Empresa(Long empresaId) {
        this.id = empresaId;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Usuario getUsuarioEdicion() {
        return usuarioEdicion;
    }

    public void setUsuarioEdicion(Usuario usuarioEdicion) {
        this.usuarioEdicion = usuarioEdicion;
    }

    public List<Local> getLocales() {
        return locales;
    }

    public void setLocales(List<Local> locales) {
        this.locales = locales;
    }
}
