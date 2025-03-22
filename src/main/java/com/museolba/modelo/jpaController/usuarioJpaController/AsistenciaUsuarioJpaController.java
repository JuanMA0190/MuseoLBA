package com.museolba.modelo.jpaController.usuarioJpaController;

import com.museolba.modelo.entidades.usuario.AsistenciaUsuario;
import com.museolba.modelo.jpaController.BaseJpaController;


public class AsistenciaUsuarioJpaController extends BaseJpaController<AsistenciaUsuario, Long> {
    
    public AsistenciaUsuarioJpaController() {
        super(AsistenciaUsuario.class);
    }
    
}
