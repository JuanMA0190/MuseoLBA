package com.museolba.modelo.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asistencia_usuario")
public class AsistenciaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia", unique = true, nullable = false)
    private Long id;

    // Relación muchos a uno: muchas asistencias para un usuario identificado por nLegajo
    @ManyToOne
    @JoinColumn(name = "n_legajo")  // Esta columna almacenará el nLegajo del usuario
    private Usuario usuario;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "horario")
    private LocalTime horario;

    public AsistenciaUsuario() {
    }

    public AsistenciaUsuario(Long id, Usuario usuario, LocalDate fecha, LocalTime horario) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horario = horario;
    }
    
    
     // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }
}
