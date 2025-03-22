package com.museolba.vista.ventanaPrincipal.estrategia;

import com.museolba.modelo.entidades.usuario.RolUsuario;


public class RolStrategyFactory {
    public static RolStrategy getStrategy(RolUsuario rolUsuario) {
        switch (rolUsuario) {
            case JEFEDEDEPARTAMENTO:
                return new JefeDepartamentoStrategy();
            case JEFEDEPERSONAL:
                return new JefePersonalStrategy();
            case PERSONAL:
                return new PersonalStrategy();
            default:
                throw new IllegalArgumentException("Rol no conocido: " + rolUsuario);
        }
    }
}
