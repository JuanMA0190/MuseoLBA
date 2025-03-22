package com.museolba.modelo.entidades.obra;


public enum TipoObra {
    CUADRO("Cuadro"),
    ESCULTURA("Escultura"),
    POEMA("Poema"),
    FOTOGRAFIA("Fotografia"),
    TALLA("Talla"),
    MATE("Mate");
    
    private final String descripcion;

    TipoObra(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
