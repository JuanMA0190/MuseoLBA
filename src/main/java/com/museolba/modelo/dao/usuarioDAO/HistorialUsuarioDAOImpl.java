package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class HistorialUsuarioDAOImpl extends PersistenceJpaController implements HistorialUsuarioDAO {

    @Override
    public List<Object[]> obtenerHistorialesConDetalles() {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT " +
                "hu.usuario.nLegajo, " +
                "hu.usuario.nombre, " +
                "hu.usuario.rolUsuario, " +
                "hu.estado, " +
                "hu.fechaCreacion, " +
                "hu.fechaModificacion, " +
                "hu.fechaEliminacion, " +
                "hu.fechaAlta, " +
                "hu.fechaBaja, " +
                "hu.razonInactividad " +
                "FROM HistorialUsuario hu";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    @Override
    public List<Object[]> buscarPorFiltro(String filtro, String termino) {
        String jpql;
        EntityManager em = getEmf().createEntityManager();
        switch (filtro) {
            case "Nombre" -> jpql = "SELECT " +
                       "hu.usuario.nLegajo, hu.usuario.nombre, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE LOWER(hu.usuario.nombre) LIKE :termino";

            case "Rol" -> jpql = "SELECT " +
                       "hu.usuario.nLegajo, hu.usuario.nombre, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE LOWER(hu.usuario.rolUsuario) LIKE :termino";

            case "Estado" -> jpql = "SELECT " +
                       "hu.usuario.nLegajo, hu.usuario.nombre, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE LOWER(hu.estado) LIKE :termino";

            default -> throw new IllegalArgumentException("Filtro no válido: " + filtro);
        }

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("termino", "%" + termino.toLowerCase() + "%");

        return query.getResultList();
    }

    
    
}
