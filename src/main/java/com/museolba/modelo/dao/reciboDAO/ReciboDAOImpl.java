package com.museolba.modelo.dao.reciboDAO;

import com.museolba.modelo.entidades.cajaChica.Producto;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import com.museolba.modelo.entidades.cajaChica.Recibo;
import java.util.ArrayList;
import javax.persistence.NoResultException;
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
    
    public List<Producto> obtenerProductosPorRecibo(Long reciboId) {
        EntityManager em = getEmf().createEntityManager();
        try {
            // Obtener el recibo por ID
            Recibo recibo = em.find(Recibo.class, reciboId);
            if (recibo != null) {
                return recibo.getProductos(); // Devuelve los productos del recibo
            }
            return new ArrayList<>(); // Si no se encuentra el recibo, devolver una lista vacía
        } finally {
            em.close();
        }
    }
    
    /**
     * Obtiene un Recibo por su nombre exacto
     * @param nombre Nombre del recibo a buscar
     * @return El Recibo encontrado o null si no existe
     */
    @Override
    public Recibo obtenerPorNombre(String nombre) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String jpql = "SELECT r FROM Recibo r WHERE r.nombre = :nombre";
            TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
            query.setParameter("nombre", nombre);
            
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Obtiene un Recibo por su nombre (búsqueda insensible a mayúsculas/minúsculas)
     * @param nombre Nombre del recibo a buscar
     * @return El Recibo encontrado o null si no existe
     */
    @Override
    public Recibo obtenerPorNombreIgnoreCase(String nombre) {
        EntityManager em = getEmf().createEntityManager();
        try {
            String jpql = "SELECT r FROM Recibo r WHERE LOWER(r.nombre) = LOWER(:nombre)";
            TypedQuery<Recibo> query = em.createQuery(jpql, Recibo.class);
            query.setParameter("nombre", nombre);
            
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

