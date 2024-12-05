package com.museolba.modelo.entidades;


public class Personal {
    private long nLegajo;
    private String nombre;
    private String apellido;
    private long dni;
    private String nTelefono;

    public Personal() {
    }

    public Personal(long nLegajo, String nombre, String apellido, long dni, String nTelefono) {
        this.nLegajo = nLegajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nTelefono = nTelefono;
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

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }
    
    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }
    
}
