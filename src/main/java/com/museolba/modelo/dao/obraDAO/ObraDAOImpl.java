package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import javax.persistence.EntityManager;

public class ObraDAOImpl extends PersistenceJpaController implements ObraDAO{

    // Método para buscar obras por sala
    @Override
    public List<Obra> findObrasBySala(Long salaId) {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.sala.id = :salaId", Obra.class)
                      .setParameter("salaId", salaId)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar todas las obras
    @Override
    public List<Obra> findAllObras() {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o", Obra.class)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar obras por nombre (opcional)
    @Override
    public List<Obra> findObrasByNombre(String nombre) {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.nombre LIKE :nombre", Obra.class)
                      .setParameter("nombre", "%" + nombre + "%")
                      .getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Obra> findObrasByTerminoArtista(String termino) {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery(
                "SELECT o FROM Obra o WHERE LOWER(o.artista) LIKE LOWER(:termino)", Obra.class)
                .setParameter("termino", "%" + termino + "%")
                .getResultList();
        } finally {
            em.close();
        }
    }
    
    
}
