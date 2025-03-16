package com.museolba.vista.ventanaPrincipal.estrategia;

import com.museolba.vista.ventanaPrincipal.MenuJefeDepartamento;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;

public class JefeDepartamentoStrategy implements RolStrategy {

    @Override
    public void mostrarMenu(VentanaPrincipal ventanaPrincipal1) {
        MenuJefeDepartamento menuJefeDepto = new MenuJefeDepartamento(ventanaPrincipal1);
        ventanaPrincipal1.abrirContenido(menuJefeDepto, 285, 720, ventanaPrincipal1.getPanelMenu());
    }
}
