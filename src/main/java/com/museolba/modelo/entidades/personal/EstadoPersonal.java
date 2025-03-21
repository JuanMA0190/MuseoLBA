package com.museolba.modelo.entidades.personal;


public enum EstadoPersonal {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");
    
    private final String descripcion;

    EstadoPersonal(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
