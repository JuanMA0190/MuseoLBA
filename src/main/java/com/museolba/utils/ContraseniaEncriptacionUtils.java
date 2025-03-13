package com.museolba.utils;

import org.mindrot.jbcrypt.BCrypt;

public class ContraseniaEncriptacionUtils {
    // Factor de costo para BCrypt
    private static final int ROUNDS = 12;
    
     /**
     * Encripta una contraseña usando BCrypt
     * @param plainPassword La contraseña en texto plano
     * @return La contraseña encriptada (hash)
     */
    public static String hashContrasenia(String contraseniaPlano) {
        return BCrypt.hashpw(contraseniaPlano, BCrypt.gensalt(ROUNDS));
    }
    
    /**
     * Verifica si una contraseña en texto plano coincide con un hash
     * @param plainPassword La contraseña en texto plano a verificar
     * @param hashedPassword El hash de la contraseña almacenada
     * @return true si coinciden, false en caso contrario
     */
    public static boolean checkContrasenia(String contraseniaPlano, String hashedContrasenia) {
        return BCrypt.checkpw(contraseniaPlano, hashedContrasenia);
    }
}
