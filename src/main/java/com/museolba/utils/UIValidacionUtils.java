package com.museolba.utils;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class UIValidacionUtils {
    public static void validacionDigito(JTextField txt, JLabel lbl) {
        if(!ValidacionUtils.esDigito(txt.getText())) {
            lbl.setText("Solo se permiten numeros en este campo.");
            txt.setText("");
        } else {
            lbl.setText("");
        }
    }
    
    public static void validacionCaracter(JTextField txt, JLabel lbl) {
        if(!ValidacionUtils.esCaracter(txt.getText())) {
            lbl.setText("Solo se permiten letras en este campo.");
            txt.setText("");
        } else {
            lbl.setText("");
        }
    }
    
    public static boolean validarCampoDNI(JTextField campoDNI) {
        String dni = campoDNI.getText().trim();
        if (ValidacionUtils.validarDNI(dni)) {
            return true;
        } else {
            DialogoUtils.mostrarMensaje("El DNI debe tener exactamente 8 dígitos numéricos.", 
                                     DialogoUtils.TIPO_ERROR, "Validación DNI");
            campoDNI.requestFocus();
            return false;
        }
    }
    
    public static boolean validarCampoTelefono(JTextField campoTelefono) {
        String telefono = campoTelefono.getText().trim();
        if (ValidacionUtils.validarTelefono(telefono)) {
            return true;
        } else {
            DialogoUtils.mostrarMensaje("El número de teléfono debe tener exactamente 10 dígitos numéricos.", 
                                     DialogoUtils.TIPO_ERROR, "Validación Teléfono");
            campoTelefono.requestFocus();
            return false;
        }
    }   
    
    /**
     * Método para validar un campo de correo electrónico.
     *
     * @param campoEmail El campo de texto que contiene el correo electrónico.
     * @return true si el correo es válido, false si no lo es.
     */
    public static boolean validarCampoEmail(JTextField campoEmail) {
        String email = campoEmail.getText().trim();
        if (ValidacionUtils.validarEmail(email)) {
            return true;
        } else {
            DialogoUtils.mostrarMensaje("El correo electrónico no tiene un formato válido.",
                    DialogoUtils.TIPO_ERROR, "Validación Correo Electrónico");
            campoEmail.requestFocus();
            return false;
        }
    }
}
