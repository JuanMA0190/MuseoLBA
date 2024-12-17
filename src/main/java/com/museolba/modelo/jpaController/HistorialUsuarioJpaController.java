package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.HistorialUsuario;


public class HistorialUsuarioJpaController extends BaseJpaController<HistorialUsuario, Long> {

    public HistorialUsuarioJpaController() {
        super(HistorialUsuario.class);
    }

    public HistorialUsuario findHistorialUsuario(long id) {
        return find(id);
    }
    
}
