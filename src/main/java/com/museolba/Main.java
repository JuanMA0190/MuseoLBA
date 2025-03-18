package com.museolba;

import com.museolba.config.DBInitializer;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import com.museolba.utils.DialogoUtils;
import com.museolba.vista.ventanaLogin.VentanaLogin;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.swing.UIManager;

public class Main {
    
    public static void main(String[] args) {
         // Configurar FlatLaf como Look and Feel
        try {
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "Component.arc", 999 );
          //  UIManager.put( "TextComponent.arc", 999 );
            UIManager.put( "ScrollBar.showButtons", true );
            UIManager.setLookAndFeel(new FlatDraculaIJTheme());
            
            //_----------------------Script----------------------------_
            EntityManagerFactory emf = PersistenceJpaController.getEmf();
            DBInitializer dbInitializer = new DBInitializer(emf);
            dbInitializer.initialize();
            //_--------------------------------------------------------_
            
            
            VentanaLogin vl = new VentanaLogin();
            vl.setVisible(true);
            
        }catch (PersistenceException e){
            DialogoUtils.mostrarMensaje("Error: No se encontro la base de datos", 1, "No se pudo iniciar!");
        }catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
            System.err.println(ex.getClass());
            System.out.println(ex.getMessage());
            DialogoUtils.mostrarMensaje(ex.getMessage(), 1, "No se pudo iniciar!");
        }
        
    }
}
