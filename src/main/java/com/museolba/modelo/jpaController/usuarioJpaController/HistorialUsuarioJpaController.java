package com.museolba.modelo.jpaController.usuarioJpaController;

import com.museolba.modelo.entidades.usuario.HistorialUsuario;
import com.museolba.modelo.jpaController.BaseJpaController;


public class HistorialUsuarioJpaController extends BaseJpaController<HistorialUsuario, Long> {

    public HistorialUsuarioJpaController() {
        super(HistorialUsuario.class);
    }

    public HistorialUsuario findHistorialUsuario(long id) {
        return find(id);
    }
    
}
