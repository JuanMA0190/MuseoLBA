package com.museolba.modelo.entidades.usuario;


public enum RazonInactividad {
    NOVALID("----------------"),
    VACACIONES("Licencia Anual Reglamentaria"),
    LICENCIA_ESTUDIO("Licencia por Estudio"),
    CERTIFICADO_MEDICO("Certificado Médico"),
    FRANCO_COMPESATORIO("Franco Compesatorio");
    
    private final String descripcion;

    RazonInactividad(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
