package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.AsistenciaUsuario;


public class AsistenciaUsuarioJpaController extends BaseJpaController<AsistenciaUsuario, Long> {
    
    public AsistenciaUsuarioJpaController() {
        super(AsistenciaUsuario.class);
    }
    
}
