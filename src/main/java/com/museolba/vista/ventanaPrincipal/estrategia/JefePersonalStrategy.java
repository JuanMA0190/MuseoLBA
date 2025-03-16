package com.museolba.vista.ventanaPrincipal.estrategia;

import com.museolba.vista.ventanaPrincipal.MenuJefePersonal;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;


public class JefePersonalStrategy implements RolStrategy{

    @Override
    public void mostrarMenu(VentanaPrincipal ventanaPrincipal1) {
        MenuJefePersonal menuJefePersonal = new MenuJefePersonal(ventanaPrincipal1);
        ventanaPrincipal1.abrirContenido(menuJefePersonal, 290, 720, ventanaPrincipal1.getPanelMenu());
    }
}
