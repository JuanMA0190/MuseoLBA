package com.museolba.modelo.entidades.obra;


public enum EstadoObra {
    EXCELENTE("Excelente"),
    BUENO("Bueno"),
    DETERIORADO("Deteriorado");
    
    private final String descripcion;

    EstadoObra(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
