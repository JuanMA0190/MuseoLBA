package com.museolba.modelo.dao.asistenciaDAO;

import static com.museolba.modelo.jpaController.PersistenceJpaController.getEmf;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AsistenciaDAOImpl implements AsistenciaDAO {

    @Override
    public List<Object[]> obtenerAsistenciaConDetalles(Long numLegajo, LocalDate fecha) {
        EntityManager em = getEmf().createEntityManager();
        try {
            // Consulta JPQL para obtener fecha y horario por número de legajo y fecha
            String jpql = "SELECT au.fecha, au.horario " +
                          "FROM AsistenciaUsuario au " +
                          "WHERE au.usuario.nLegajo = :numLegajo " +
                          "AND au.fecha = :fecha";

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            query.setParameter("numLegajo", numLegajo);
            query.setParameter("fecha", fecha);

            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
}
