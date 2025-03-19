package com.museolba.modelo.dao.cajachicaDAO;

import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import com.museolba.modelo.entidades.CajaChica;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.persistence.TypedQuery;


public class CajaChicaDAOImpl extends PersistenceJpaController implements CajaChicaDAO {
 
    @Override
    public CajaChica obtenerCajaChicaPorMes(int mes, int anio) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String jpql = "SELECT c FROM CajaChica c WHERE c.mes BETWEEN :inicioMes AND :finMes";
            TypedQuery<CajaChica> query = em.createQuery(jpql, CajaChica.class);

            // Obtener el primer y último día del mes
            LocalDate inicioMes = LocalDate.of(anio, mes, 1);
            LocalDate finMes = YearMonth.of(anio, mes).atEndOfMonth(); // Último día del mes

            query.setParameter("inicioMes", inicioMes);
            query.setParameter("finMes", finMes);

            return query.getSingleResult();
        } finally {
            em.close();
        }
    }


    @Override
    public Double obtenerTotalGastadoEnMes(int mes) {
        EntityManager em = getEmf().createEntityManager();
        try{
            String jpql = "SELECT SUM(c.totalGasto) FROM CajaChica c WHERE MONTH(c.mes) = :mes";
            TypedQuery<Double> query = em.createQuery(jpql, Double.class);
            query.setParameter("mes", mes);
            return query.getSingleResult();
        }finally{
            em.close();
        }
        
    }

    @Override
    public List<CajaChica> obtenerCajasChicasSinRecibos() {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT c FROM CajaChica c WHERE c.recibos IS EMPTY";
        TypedQuery<CajaChica> query = em.createQuery(jpql, CajaChica.class);
        return query.getResultList();
    }

    @Override
    public boolean existeCajaChicaParaMes(int mes, int anio) {
        EntityManager em = getEmf().createEntityManager();
        try {
            
            String jpql = "SELECT COUNT(c) FROM CajaChica c WHERE FUNCTION('MONTH', c.mes) = :mes AND FUNCTION('YEAR', c.mes) = :anio";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("mes", mes);
            query.setParameter("anio", anio);
            Long count = query.getSingleResult();
            return count > 0; // Si count > 0, ya existe una CajaChica para el mes y año
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean esFondoInicialCero(int mes, int anio) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String jpql = "SELECT COUNT(c) FROM CajaChica c WHERE FUNCTION('MONTH', c.mes) = :mes AND FUNCTION('YEAR', c.mes) = :anio AND c.fondoInicial = 0";
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            query.setParameter("mes", mes);
            query.setParameter("anio", anio);
            Long count = query.getSingleResult();
            return count > 0; // Si hay al menos una CajaChica con fondoInicial = 0, devuelve true
        } finally {
            em.close();
        }
    }

    
}
