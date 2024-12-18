package com.museolba;

import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.museolba.vista.ventanaLogin.VentanaLogin;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
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
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /*
        VentanaPrincipal vl = new VentanaPrincipal();
        vl.setVisible(true);*/
        
        VentanaLogin vl = new VentanaLogin();
        vl.setVisible(true);
        
    }
}
