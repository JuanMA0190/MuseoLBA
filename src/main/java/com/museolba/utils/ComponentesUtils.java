package com.museolba.utils;


import java.awt.Image;
import java.awt.Window;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.NoResultException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComponentesUtils {
    // Para comboboxes
    public static <E extends Enum<E>> void cargarComboBox(JComboBox comboBox, Class<E> enumClass) {
        comboBox.removeAllItems(); 
        for (E valor : enumClass.getEnumConstants()) {
            comboBox.addItem(valor);
        }
    }
    
    
    // Para tablas
    @FunctionalInterface
    public interface TableDataMapper<T> {
        Object[] map(T elemento);
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
        
        if (lista == null || lista.isEmpty()) {
            throw new NoResultException("No se encontraron resultados para el filtro y término proporcionados.");
            /*DialogoUtils.mostrarMensaje("No se encontraron resultados para el filtro y término proporcionados.", 
                                     DialogoUtils.TIPO_INFO, "Sin Resultados");*/
        }
    }
    
    
    public static void cargarImagenIcono(Window ventana){
        try {
            Image icono = ImageIO.read(ComponentesUtils.class.getResource("/images/imageIcon.jpeg"));
            ventana.setIconImage(icono);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al cargar el ícono: " + e.getMessage());
        }
    }
    
}
