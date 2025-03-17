package com.museolba.config;


public enum TiposReporte {
    PDF("PDF"),
    EXCEL("Excel");
    
    
    private final String descripcion;

    TiposReporte(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
