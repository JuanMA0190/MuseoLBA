package com.museolba.utils;

public class ValidacionUtils {

    // Validaciones de tipos de datos
    public static boolean esDigito(String text) {
        return text != null && text.matches("\\d*");
    }
    
    public static boolean esCaracter(String text) {
        return text != null && text.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ´]+$");
    }
    
    // Validaciones específicas
    public static boolean validarDNI(String dni) {
        return dni.length() == 8 && dni.matches("\\d{8}");
    }
    
    public static boolean validarTelefono(String telefono) {
        return telefono.length() == 10 && telefono.matches("\\d{10}");
    }

}
