package com.museolba.modelo.entidades;


public class Personal {
    private long nLegajo;
    private String nombre;
    private String apellido;
    private String dni;
    private String nTelefono;
    private EstadoPersonal estado;
    

    public Personal() {
    }

    public Personal(long nLegajo, String nombre, String apellido, String dni, String nTelefono) {
        this.nLegajo = nLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nTelefono = nTelefono;
        this.estado = estado.ACTIVO;
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
