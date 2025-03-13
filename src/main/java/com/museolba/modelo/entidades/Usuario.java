package com.museolba.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends Personal implements Serializable {
    
    @Column(name = "nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;
    
    @Column(name = "contrasenia", nullable = false, length = 60)
    private String contrasenia;
    
    @Enumerated(EnumType.STRING) // Almacena el valor del Enum como String en la base de datos
    @Column(name = "rol_usuario", nullable = false)
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
