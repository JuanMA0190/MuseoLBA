package com.museolba.utils;


public class FechaUtils {
    private static final String[] MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    
    public static String obtenerMes(int numeroMes) {
        if (numeroMes < 1 || numeroMes > 12) {
            throw new IllegalArgumentException("El número de mes debe estar entre 1 y 12");
        }
        return MESES[numeroMes - 1];
    }
}
