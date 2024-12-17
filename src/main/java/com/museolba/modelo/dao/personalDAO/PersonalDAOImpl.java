package com.museolba.modelo.dao.personalDAO;

import com.museolba.modelo.jpaController.PersistenceJpaController;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
}

