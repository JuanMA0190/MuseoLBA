package com.museolba.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personal")
public class Personal implements Serializable {
    
    @Id
    @Column(name = "n_legajo", unique = true, nullable = false)
    private long nLegajo;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido;
    
    @Column(nullable = false, unique = true, length = 8)
    private String dni;
    
    @Column(name = "n_telefono")
    private String nTelefono;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPersonal estado;
    

    public Personal() {
    }

    public Personal(long nLegajo, String nombre, String apellido, String dni, String nTelefono) {
        this.nLegajo = nLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nTelefono = nTelefono;
        this.estado = EstadoPersonal.ACTIVO;
    }

    public long getnLegajo() {
        return nLegajo;
    }

    public void setnLegajo(long nLegajo) {
        this.nLegajo = nLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    public EstadoPersonal getEstado() {
        return estado;
    }

    public void setEstado(EstadoPersonal estado) {
        this.estado = estado;
    }
}
