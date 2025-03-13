package com.museolba;

import com.museolba.config.DBInitializer;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import com.museolba.vista.ventanaLogin.VentanaLogin;
import javax.persistence.EntityManagerFactory;
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
            
            EntityManagerFactory emf = PersistenceJpaController.getEmf();
            DBInitializer dbInitializer = new DBInitializer(emf);
            dbInitializer.initialize();
            
            VentanaLogin vl = new VentanaLogin();
            vl.setVisible(true);
        } catch (Exception ex) {
            //System.err.println("Failed to initialize LaF");
            System.err.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
        /*
        VentanaPrincipal vl = new VentanaPrincipal();
        vl.setVisible(true);*/
        

        
    }
}
