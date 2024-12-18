package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.usuarioDAO.UsuarioDAOImpl;
import com.museolba.modelo.entidades.RolUsuario;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.modelo.jpaController.UsuarioJpaController;
import java.util.List;



public class ControladorUsuario {
    private final UsuarioJpaController usuarioJpaController;
    private final UsuarioDAOImpl usuarioDAO;
    
    public ControladorUsuario(){
        this.usuarioJpaController = new UsuarioJpaController();
        this.usuarioDAO = new UsuarioDAOImpl();
    }
    
    public String crearUsuario(Usuario usuario) throws Exception {
        try{
            if (!puedeAgregarUsuarioConRol(usuario.getRolUsuario())) { 
                return "Error: Ya existe un usuario con el rol " + usuario.getRolUsuario();
            }
            usuarioJpaController.create(usuario);
            return "Usuario creado exitosamente.";
        }catch(Exception e){
            e.printStackTrace();
            return "Error al crear el usuario: " + e.getMessage();
        }
        
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
    
    public boolean puedeAgregarUsuarioConRol(RolUsuario rolUsuario) {
        if (rolUsuario == RolUsuario.JEFEDEDEPARTAMENTO || rolUsuario == RolUsuario.JEFEDEPERSONAL) {
            long cantidad = usuarioDAO.contarUsuariosPorRol(rolUsuario);
            return cantidad == 0;
        }
        return true;
    }

}
