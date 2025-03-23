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
    
     /**
     * Método para validar un correo electrónico.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo es válido, false si no lo es.
     */
    public static boolean validarEmail(String email) {
        if (email == null) {
            return false;
        }
        // Expresión regular para validar un correo electrónico
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }
}
