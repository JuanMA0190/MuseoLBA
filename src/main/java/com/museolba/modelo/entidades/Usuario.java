package com.museolba.modelo.entidades;

public class Usuario extends Personal {

    private String nombreUsuario;
    private String contrasenia;
    private RolUsuario rolUsuario;

    public Usuario() {
    }

    public Usuario(long nLegajo, String nombre, String apellido, String dni, String nTelefono, String nombreUsuario, String contrasenia, RolUsuario rolUsuario) {
        super(nLegajo, nombre, apellido, dni, nTelefono);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rolUsuario = rolUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
}
