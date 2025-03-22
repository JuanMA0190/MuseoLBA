package com.museolba.modelo.dao.asistenciaDAO;

import com.museolba.modelo.entidades.usuario.AsistenciaUsuario;
import static com.museolba.modelo.jpaController.PersistenceJpaController.getEmf;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AsistenciaDAOImpl implements AsistenciaDAO {

    @Override
    public List<AsistenciaUsuario> obtenerAsistenciaConDetalles(LocalDate fecha) { 
        EntityManager em = getEmf().createEntityManager();
        try {
            // Consulta JPQL para obtener la entidad AsistenciaUsuario completa
            String jpql = "SELECT au " +  // Selecciona la entidad completa
                          "FROM AsistenciaUsuario au " +
                          "WHERE au.fecha = :fecha";

            TypedQuery<AsistenciaUsuario> query = em.createQuery(jpql, AsistenciaUsuario.class);
            query.setParameter("fecha", fecha);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AsistenciaUsuario> obtenerAsistenciasPorMesYAnio(int mes, int anio) {
            EntityManager em = getEmf().createEntityManager();
        try {
            YearMonth yearMonth = YearMonth.of(anio, mes);
            LocalDate startDate = yearMonth.atDay(1);
            LocalDate endDate = yearMonth.atEndOfMonth();

            String jpql = "SELECT au FROM AsistenciaUsuario au " +
                          "WHERE au.fecha BETWEEN :startDate AND :endDate";
            TypedQuery<AsistenciaUsuario> query = em.createQuery(jpql, AsistenciaUsuario.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    
}
