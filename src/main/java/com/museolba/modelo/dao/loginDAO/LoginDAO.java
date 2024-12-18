package com.museolba.modelo.dao.loginDAO;

import com.museolba.modelo.entidades.Usuario;


public interface LoginDAO {
    Usuario verificarCredenciales(String txtUsuario, String txtPwd);
}
