package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.entidades.Usuario;
import com.museolba.modelo.jpaController.UsuarioJpaController;
import java.util.List;



public class ControladorUsuario {
    private final UsuarioJpaController usuarioJpaController;
    
    public ControladorUsuario(){
        this.usuarioJpaController = new UsuarioJpaController();
    }
    
    public void crearUsuario(Usuario usuario) throws Exception {
        usuarioJpaController.create(usuario);
    }
    public void editarUsuario(Usuario usuario) throws Exception {
        usuarioJpaController.edit(usuario, usuario.getnLegajo());
    }

    
    public void eliminarUsuario(long id) throws Exception {
        usuarioJpaController.destroy(id);
    }

    
    public Usuario obtenerUsuario(long id) {
        return usuarioJpaController.findUsuario(id);
    }

    
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioJpaController.findAll();
    }

}
