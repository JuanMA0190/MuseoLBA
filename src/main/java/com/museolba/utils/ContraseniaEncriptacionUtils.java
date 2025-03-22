package com.museolba.utils;

import org.mindrot.jbcrypt.BCrypt;

public class ContraseniaEncriptacionUtils {
    // Factor de costo para BCrypt
    private static final int ROUNDS = 12;
    
     /**
     * Encripta una contraseña usando BCrypt
     * @return La contraseña encriptada (hash)
     */
    public static String hashContrasenia(String contraseniaPlano) {
        return BCrypt.hashpw(contraseniaPlano, BCrypt.gensalt(ROUNDS));
    }
    
    /**
     * Verifica si una contraseña en texto plano coincide con un hash
     * @return true si coinciden, false en caso contrario
     */
    public static boolean checkContrasenia(String contraseniaPlano, String hashedContrasenia) {
        return BCrypt.checkpw(contraseniaPlano, hashedContrasenia);
    }
}
