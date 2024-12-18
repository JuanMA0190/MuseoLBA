package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.RolUsuario;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAOImpl extends PersistenceJpaController implements UsuarioDAO{
    @Override
    public long contarUsuariosPorRol(RolUsuario rolUsuario) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String queryStr = "SELECT COUNT(u) FROM Usuario u WHERE u.rolUsuario = :rolUsuario";
            Query query = em.createQuery(queryStr);
            query.setParameter("rolUsuario", rolUsuario);

            return (long) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
