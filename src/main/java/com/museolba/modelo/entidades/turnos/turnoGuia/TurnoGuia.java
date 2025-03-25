package com.museolba.modelo.entidades.turnos.turnoGuia;


import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turno_guia")
public class TurnoGuia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "entidad")
    private String entidad;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "horario")
    private String horario;

    public TurnoGuia() {
    }

    public TurnoGuia(Long id, String entidad, LocalDate fecha, String horario) {
        this.id = id;
        this.entidad = entidad;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
