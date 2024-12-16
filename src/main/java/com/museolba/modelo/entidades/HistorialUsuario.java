package com.museolba.modelo.entidades;

import java.time.LocalDateTime;

public class HistorialUsuario {
    private long id;
    private Usuario usuario; 
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaEliminacion;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaBaja;
    private String razonInactividad;
    private EstadoPersonal estado; 

    public HistorialUsuario() {
    }

    public HistorialUsuario(Usuario usuario, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, LocalDateTime fechaEliminacion, LocalDateTime fechaAlta, LocalDateTime fechaBaja, String razonInactividad, EstadoPersonal estado) {
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = null;
        this.fechaEliminacion = null;
        this.fechaAlta = null;
        this.fechaBaja = null;
        this.razonInactividad = "-";
        this.estado = estado;
    }
    
    public void registrarModificacion(LocalDateTime fecha) {
        this.fechaModificacion = fecha;
    }

    public void registrarEliminacion(LocalDateTime fecha) {
        this.fechaEliminacion = fecha;
    }

    public void registrarAlta(LocalDateTime fecha) {
        this.fechaAlta = fecha;
    }

    public void registrarBaja(LocalDateTime fecha) {
        this.fechaBaja = fecha;
    }
    
    public long getId() {
        return id;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
     public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public LocalDateTime getFechaEliminacion() {
        return fechaEliminacion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public String getRazonInactividad() {
        return razonInactividad;
    }

    public void setRazonInactividad(String razonInactividad) {
        this.razonInactividad = razonInactividad;
    }
    
    public EstadoPersonal getEstado() {
        return estado;
    }

    public void setEstado(EstadoPersonal estado) {
        this.estado = estado;
    }
}
