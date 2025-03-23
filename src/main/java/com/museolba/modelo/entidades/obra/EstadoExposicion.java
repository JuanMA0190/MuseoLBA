package com.museolba.modelo.entidades.obra;


public enum EstadoExposicion {
    EXPUESTO("Expuesto"),
    FINALIZADO("Finalizado"),
    GUARDADO("Guardado");
    
    private final String descripcion;

    EstadoExposicion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
