package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.jpaController.AsistenciaUsuarioJpaController;

public class ControladorAsistenciaUsuario {
    private final AsistenciaUsuarioJpaController asistenciaJpaController;
    
    public ControladorAsistenciaUsuario(){
        this.asistenciaJpaController = new AsistenciaUsuarioJpaController();
    }
}
