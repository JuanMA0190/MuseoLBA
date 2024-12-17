package com.museolba.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_usuarios")
public class HistorialUsuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id", referencedColumnName = "n_legajo", nullable = false)
    private Usuario usuario;
    
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    
    @Column(name = "fecha_eliminacion")
    private LocalDateTime fechaEliminacion;
    
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    
    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;
    
    @Column(name = "razon_inactividad", length = 255)
    private String razonInactividad;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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
