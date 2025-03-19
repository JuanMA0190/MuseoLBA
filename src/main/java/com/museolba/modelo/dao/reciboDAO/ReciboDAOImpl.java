package com.museolba.modelo.dao.reciboDAO;

import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import com.museolba.modelo.entidades.Recibo;
import javax.persistence.TypedQuery;

public class ReciboDAOImpl extends PersistenceJpaController implements ReciboDAO {
    @Override
    public List<Recibo> obtenerRecibosPorCajaChica(Long cajaChicaId) {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT r FROM Recibo r WHERE r.cajaChica.id = :cajaChicaId";
        TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
        query.setParameter("cajaChicaId", cajaChicaId);
        return query.getResultList();
    }

    @Override
    public List<Recibo> obtenerRecibosPorMes(int mes) {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT r FROM Recibo r WHERE MONTH(r.fechaRegistro) = :mes";
        TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
        query.setParameter("mes", mes);
        return query.getResultList();
    }

    @Override
    public List<Recibo> obtenerRecibosConPrecioTotalMayorA(Double monto) {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT r FROM Recibo r WHERE r.precioTotal > :monto";
        TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
        query.setParameter("monto", monto);
        return query.getResultList();
    }

    @Override
    public Double obtenerTotalGastadoPorCajaChica(Long cajaChicaId) {
        EntityManager em = getEmf().createEntityManager();
        try{
            String jpql = "SELECT SUM(r.precioTotal) FROM Recibo r WHERE r.cajaChica.id = :cajaChicaId";
            TypedQuery<Double> query = em.createQuery(jpql, Double.class);
            query.setParameter("cajaChicaId", cajaChicaId);
            return query.getSingleResult();
        }finally{
            em.close();
        }
    }

    @Override
    public List<Recibo> obtenerRecibosConProducto(String nombreProducto) {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT r FROM Recibo r JOIN r.productos p WHERE p.nombre = :nombreProducto";
        TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
        query.setParameter("nombreProducto", nombreProducto);
        return query.getResultList();
    }
    
}
