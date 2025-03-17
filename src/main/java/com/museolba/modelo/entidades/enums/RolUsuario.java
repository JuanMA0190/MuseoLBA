package com.museolba.modelo.entidades.enums;


public enum RolUsuario {
    PERSONAL("Personal"),
    JEFEDEDEPARTAMENTO("Jefe de Departamento"),
    JEFEDEPERSONAL("Jefe de Personal");
    
    
    private final String descripcion;

    RolUsuario(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
