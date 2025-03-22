package com.museolba.modelo.dao.loginDAO;

import com.museolba.modelo.entidades.usuario.Usuario;


public interface LoginDAO {
    Usuario verificarCredenciales(String txtUsuario, String txtPwd);
}
