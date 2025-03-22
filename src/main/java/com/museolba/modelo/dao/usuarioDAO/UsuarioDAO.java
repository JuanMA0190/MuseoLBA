package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.personal.EstadoPersonal;
import com.museolba.modelo.entidades.usuario.RolUsuario;


public interface UsuarioDAO {
    long contarUsuariosPorRol(RolUsuario rolUsuario);
    long contarUsuarioPorRolYEstado(RolUsuario rolUsuario, EstadoPersonal estado);
}
