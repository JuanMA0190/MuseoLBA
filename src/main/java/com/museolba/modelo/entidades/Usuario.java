package com.museolba.modelo.entidades;


public class Usuario {
    private long id;
    private String nombre;
    private String contrasenia;
    private RolUsuario rolUsuario;
    private Personal nLegajo;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasenia, RolUsuario rolUsuario, Personal nLegajo) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rolUsuario = rolUsuario;
        this.nLegajo = nLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Personal getnLegajo() {
        return nLegajo;
    }

    public void setnLegajo(Personal nLegajo) {
        this.nLegajo = nLegajo;
    }
}
