package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.Usuario;


public class UsuarioJpaController extends BaseJpaController<Usuario, Long> {

    public UsuarioJpaController() {
        super(Usuario.class);
    }

    public Usuario findUsuario(long id) {
        return find(id);
    }
    
}
