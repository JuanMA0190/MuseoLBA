package com.museolba.utils;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class DialogoUtils {
    public static final int TIPO_INFO = 1;
    public static final int TIPO_ERROR = 2;
    
    public static void mostrarMensaje(String mensaje, int tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo == TIPO_INFO) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo == TIPO_ERROR) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    } 
}
