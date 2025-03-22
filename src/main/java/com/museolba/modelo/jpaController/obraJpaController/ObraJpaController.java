package com.museolba.modelo.jpaController.obraJpaController;

import com.museolba.modelo.jpaController.BaseJpaController;
import com.museolba.modelo.entidades.obra.Obra;
import java.util.List;
import javax.persistence.EntityManager;

public class ObraJpaController extends BaseJpaController<Obra, Long> {
    
     public ObraJpaController() {
        super(Obra.class);
    }
    
    
    // Método para buscar obras por artista (ahora por nombre de artista)
    public List<Obra> findObrasByArtista(String nombreArtista) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.artista = :nombreArtista", Obra.class)
                      .setParameter("nombreArtista", nombreArtista)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar obras por sala
    public List<Obra> findObrasBySala(Long salaId) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.sala.id = :salaId", Obra.class)
                      .setParameter("salaId", salaId)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar todas las obras
    public List<Obra> findAllObras() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o", Obra.class)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar obras por nombre (opcional)
    public List<Obra> findObrasByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.nombre LIKE :nombre", Obra.class)
                      .setParameter("nombre", "%" + nombre + "%")
                      .getResultList();
        } finally {
            em.close();
        }
    }
    
    
    public List<Obra> findObrasByTerminoArtista(String termino) {
        EntityManager em = getEntityManager();
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
