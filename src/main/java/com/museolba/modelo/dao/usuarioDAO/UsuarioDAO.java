package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.enums.EstadoPersonal;
import com.museolba.modelo.entidades.enums.RolUsuario;


public interface UsuarioDAO {
    long contarUsuariosPorRol(RolUsuario rolUsuario);
    long contarUsuarioPorRolYEstado(RolUsuario rolUsuario, EstadoPersonal estado);
}
