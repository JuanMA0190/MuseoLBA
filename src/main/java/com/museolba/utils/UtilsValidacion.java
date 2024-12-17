package com.museolba.utils;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class UtilsValidacion {
    
    public static boolean esDigito(String text) {
        return text != null && text.matches("\\d*");
    }
    
    public static void validacionDigito(JTextField txt, JLabel lbl){
        if(!UtilsValidacion.esDigito(txt.getText())){
            lbl.setText("Solo se permiten numeros en este campo.");
            txt.setText("");
        }else{
            lbl.setText("");
        }
    }

    public static boolean esCaracter(String text) {
        return text != null && text.matches("[a-zA-Z]*");
    }
    
    public static void validacionCaracter(JTextField txt, JLabel lbl){
        if(!UtilsValidacion.esCaracter(txt.getText())){
            lbl.setText("Solo se permiten letras en este campo.");
            txt.setText("");
        }else{
            lbl.setText("");
        }
    }
    
    public static void MsjAlert(String mesj, int tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mesj);
        if (tipo == 1) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo == 2) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    
    public static <E extends Enum<E>> void cargarComboBox(JComboBox<E> comboBox, Class<E> enumClass) {
        comboBox.removeAllItems(); 
        for (E valor : enumClass.getEnumConstants()) {
            comboBox.addItem(valor);
        }
    }
}
