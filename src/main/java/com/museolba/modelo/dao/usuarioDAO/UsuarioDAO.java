package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.RolUsuario;


public interface UsuarioDAO {
    long contarUsuariosPorRol(RolUsuario rolUsuario);
    long contarUsuarioPorRolYEstado(RolUsuario rolUsuario, EstadoPersonal estado);
}
