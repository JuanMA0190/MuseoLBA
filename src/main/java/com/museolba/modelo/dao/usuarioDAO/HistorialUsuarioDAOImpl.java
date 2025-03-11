package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.RolUsuario;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class HistorialUsuarioDAOImpl extends PersistenceJpaController implements HistorialUsuarioDAO {
    
    @Override
    public void actualizarHistorial(HistorialUsuario historial) {
        EntityManager em = getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(historial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public HistorialUsuario obtenerHistorialPorUsuario(long nLegajo) {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT h FROM HistorialUsuario h WHERE h.usuario.nLegajo = :nLegajo", HistorialUsuario.class)
                    .setParameter("nLegajo", nLegajo)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
    

    @Override
    public List<Object[]> obtenerHistorialesConDetalles() {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT " +
                "hu.usuario.nLegajo, " +
                "hu.usuario.nombreUsuario, " +
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
                       "hu.usuario.nLegajo, hu.usuario.nombreUsuario, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE LOWER(hu.usuario.nombreUsuario) LIKE :termino";

            case "Rol" -> jpql = "SELECT " +
                       "hu.usuario.nLegajo, hu.usuario.nombreUsuario, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE hu.usuario.rolUsuario = :termino";

            case "Estado" -> jpql = "SELECT " +
                       "hu.usuario.nLegajo, hu.usuario.nombreUsuario, hu.usuario.rolUsuario, hu.estado, " +
                       "hu.fechaCreacion, hu.fechaModificacion, hu.fechaEliminacion, hu.fechaAlta, hu.fechaBaja, hu.razonInactividad " +
                       "FROM HistorialUsuario hu WHERE hu.estado = :termino";

            default -> throw new IllegalArgumentException("Filtro no válido: " + filtro);
        }

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        //TENES QUE ARREGLAR ESTO:
        if (filtro.equals("Estado")) {
            try {
                EstadoPersonal estado = EstadoPersonal.valueOf(termino.toUpperCase());
                query.setParameter("termino", estado);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("El estado ingresado no es válido: " + termino, e);
            }
        } else if (filtro.equals("Rol")) {
            try {
                RolUsuario rol = obtenerRolUsuarioDesdeDescripcion(termino);
                query.setParameter("termino", rol);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("El rol ingresado no es válido: " + termino, e);
            }
        } else {
            query.setParameter("termino", "%" + termino.toLowerCase() + "%");
        }

        return query.getResultList();
    }

    private RolUsuario obtenerRolUsuarioDesdeDescripcion(String descripcion) {
        for (RolUsuario rol : RolUsuario.values()) {
            if (rol.toString().equalsIgnoreCase(descripcion)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("No se encontró un RolUsuario con la descripción: " + descripcion);
    }

    
    
}
