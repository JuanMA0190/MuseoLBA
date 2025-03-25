package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.personal.EstadoPersonal;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAOImpl extends PersistenceJpaController implements UsuarioDAO{
    @Override
    public long contarUsuariosPorRol(RolUsuario rolUsuario) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String queryStr = "SELECT COUNT(u) FROM Usuario u WHERE u.rolUsuario = :rolUsuario AND u.estado = :estado";
            Query query = em.createQuery(queryStr);
            query.setParameter("rolUsuario", rolUsuario);
            query.setParameter("estado", EstadoPersonal.ACTIVO); // Solo contar activos

            return (long) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public long contarUsuarioPorRolYEstado(RolUsuario rolUsuario, EstadoPersonal estado) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String queryStr = "SELECT COUNT(u) FROM Usuario u WHERE u.rolUsuario = :rolUsuario AND u.estado = :estado";
            Query query = em.createQuery(queryStr);
            query.setParameter("rolUsuario", rolUsuario);
            query.setParameter("estado",estado);

            return (long) query.getSingleResult();
        } finally {
            em.close();
        }
    }


}
