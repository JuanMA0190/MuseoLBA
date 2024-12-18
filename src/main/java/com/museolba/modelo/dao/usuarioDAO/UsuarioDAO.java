package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.RolUsuario;


public interface UsuarioDAO {
    long contarUsuariosPorRol(RolUsuario rolUsuario);
}
