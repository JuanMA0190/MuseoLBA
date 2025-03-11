package com.museolba.modelo.dao.personalDAO;

import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonalDAOImpl extends PersistenceJpaController implements PersonalDAO  {
    
    @Override
    public boolean existeLegajo(long nLegajo) {
        EntityManager em = getEmf().createEntityManager();
        try{
            String queryStr = "SELECT COUNT(p) FROM Personal p WHERE p.nLegajo = :n_legajo";
            Query query = em.createQuery(queryStr);
            query.setParameter("n_legajo", nLegajo);
        
            long count = (long) query.getSingleResult();
            return count > 0;
        }finally{
            em.close();
        }
    }
    
    @Override
    public List<Object[]> obtenerPersonalConDetalles() {
        EntityManager em = getEmf().createEntityManager();
        String jpql = "SELECT " +
                "p.nLegajo, " +
                "p.nombre, " +
                "p.apellido, " +
                "p.dni, " +
                "p.nTelefono, " +
                "p.estado " +
                "FROM Personal p";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
    
    @Override
    public List<Object[]> buscarPorFiltro(String filtro, String termino) {
        String jpql;
        EntityManager em = getEmf().createEntityManager();
        switch (filtro) {
            case "Nombre" -> jpql = "SELECT " +
                       "p.nLegajo, p.nombre, p.apellido, p.dni, p.nTelefono, p.estado " +
                       "FROM Personal p WHERE LOWER(p.nombre) LIKE :termino";

            case "Estado" -> jpql = "SELECT " +
                   "p.nLegajo, p.nombre, p.apellido, p.dni, p.nTelefono, p.estado " +
                   "FROM Personal p WHERE p.estado = :termino";

            case "Num Legajo" -> jpql = "SELECT " +
                       "p.nLegajo, p.nombre, p.apellido, p.dni, p.nTelefono, p.estado " +
                       "FROM Personal p WHERE LOWER(p.nLegajo) LIKE :termino";

            default -> throw new IllegalArgumentException("Filtro no válido: " + filtro);
        }
        
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

        if (filtro.equals("Estado")) {
            try {
               EstadoPersonal estado = EstadoPersonal.valueOf(termino.toUpperCase());
                query.setParameter("termino", estado);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("El estado ingresado no es válido: " + termino, e);
            }
        } else {
            query.setParameter("termino", "%" + termino.toLowerCase() + "%");
        }

        return query.getResultList();
    }

}

