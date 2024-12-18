package com.museolba.utils;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UtilsValidacion {
    
    //devuelve si es un digito o no
    public static boolean esDigito(String text) {
        return text != null && text.matches("\\d*");
    }
    
    //valida que se ingresen solo digitos
    public static void validacionDigito(JTextField txt, JLabel lbl){
        if(!UtilsValidacion.esDigito(txt.getText())){
            lbl.setText("Solo se permiten numeros en este campo.");
            txt.setText("");
        }else{
            lbl.setText("");
        }
    }

    //devuelve si es un caracter o no
    public static boolean esCaracter(String text) {
        return text != null && text.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ´]+$");
    }
    
    //valida que se ingresen solo caracteres
    public static void validacionCaracter(JTextField txt, JLabel lbl){
        if(!UtilsValidacion.esCaracter(txt.getText())){
            lbl.setText("Solo se permiten letras en este campo.");
            txt.setText("");
        }else{
            lbl.setText("");
        }
    }
    
    //da la notificacion de error o information para avisar al usuario
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
    
    //carga cualquier comboBox que reciba una clase enum
    public static <E extends Enum<E>> void cargarComboBox(JComboBox<E> comboBox, Class<E> enumClass) {
        comboBox.removeAllItems(); 
        for (E valor : enumClass.getEnumConstants()) {
            comboBox.addItem(valor);
        }
    }
    
    //Valida que el Dni tenga 8 caracteres
    public static boolean validarDNI(JTextField campoDNI) {
        String dni = campoDNI.getText().trim();
        if (dni.length() == 8 && dni.matches("\\d{8}")) {
            return true;
        } else {
            MsjAlert("El DNI debe tener exactamente 8 dígitos numéricos.", 2, "Validación DNI");
            campoDNI.requestFocus();
            return false;
        }
    }
    
    //Valida que el telefono tenga 10 caracteres
    public static boolean validarTelefono(JTextField campoTelefono) {
        String telefono = campoTelefono.getText().trim();
        if (telefono.length() == 10 && telefono.matches("\\d{10}")) {
            return true;
        } else {
            MsjAlert("El número de teléfono debe tener exactamente 10 dígitos numéricos.", 2, "Validación Teléfono");
            campoTelefono.requestFocus();
            return false;
        }    
    }
    
    public static <T> void cargarTabla(JTable tabla, List<T> lista, String[] titulos, TableDataMapper<T> mapper) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Establecer los nombres de las columnas
        modeloTabla.setColumnIdentifiers(titulos);

        // Verificar y llenar la tabla
        if (lista != null) {
            for (T elemento : lista) {
                Object[] fila = mapper.map(elemento);
                modeloTabla.addRow(fila);
            }
        }

        tabla.setModel(modeloTabla);
    }
    
    @FunctionalInterface
    public interface TableDataMapper<T> {
        Object[] map(T elemento);
    }
}
