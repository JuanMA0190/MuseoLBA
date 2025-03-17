package com.museolba.controlador.controladorLogin;

import com.museolba.modelo.dao.loginDAO.LoginDAOImpl;
import com.museolba.modelo.entidades.enums.EstadoPersonal;
import com.museolba.modelo.entidades.Usuario;


public class ControladorLogin {
    private final LoginDAOImpl loginDAO;
    
    public ControladorLogin(){
        this.loginDAO = new LoginDAOImpl();
    }
    
    public Usuario verificarLogin(String nombreUsuario, String contrasenia) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty() || 
            contrasenia == null || contrasenia.trim().isEmpty()) {
            return null;
        }

        Usuario usuario = loginDAO.verificarCredenciales(nombreUsuario, contrasenia);

        if (usuario != null && usuario.getEstado() != EstadoPersonal.ACTIVO) {
            return usuario; 
        }

        return usuario;
    }
}
