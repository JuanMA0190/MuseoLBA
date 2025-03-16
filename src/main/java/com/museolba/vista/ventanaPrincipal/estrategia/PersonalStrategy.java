package com.museolba.vista.ventanaPrincipal.estrategia;

import com.museolba.vista.ventanaPrincipal.MenuPersonal;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;


public class PersonalStrategy implements RolStrategy {

    @Override
    public void mostrarMenu(VentanaPrincipal ventanaPrincipal1) {
        MenuPersonal menuPersonal = new MenuPersonal(ventanaPrincipal1);
        ventanaPrincipal1.abrirContenido(menuPersonal, 290, 720, ventanaPrincipal1.getPanelMenu());
    }
}
