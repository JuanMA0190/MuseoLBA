package com.museolba.modelo.jpaController.turnoArtistaJpaController;

import com.museolba.modelo.jpaController.BaseJpaController;
import com.museolba.modelo.entidades.turnos.turnoArtista.TurnoArtista;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TurnoArtistaJpaController extends BaseJpaController<TurnoArtista, Long> {
    
    public TurnoArtistaJpaController() {
        super(TurnoArtista.class);
    }
    
     
    public void crearTurnoArtista(TurnoArtista turnoArtista) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            // Persistir el TurnoArtista
            em.persist(turnoArtista);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al crear el TurnoArtista: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }


    public List<TurnoArtista> obtenerTurnosSolapados(LocalDate fechaInicio, LocalDate fechaFin) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT t FROM TurnoArtista t WHERE t.fechaInicio <= :fechaFin AND t.fechaFin >= :fechaInicio",
                    TurnoArtista.class)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
     public void modificarTurnoArtista(TurnoArtista turnoArtista) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            // Actualizar el TurnoArtista
            em.merge(turnoArtista);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al modificar el TurnoArtista: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    
    public List<TurnoArtista> obtenerTurnosSolapadosExcluyendo(LocalDate fechaInicio, LocalDate fechaFin, Long idExcluido) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT t FROM TurnoArtista t WHERE t.id != :idExcluido AND t.fechaInicio <= :fechaFin AND t.fechaFin >= :fechaInicio",
                    TurnoArtista.class)
                    .setParameter("idExcluido", idExcluido)
                    .setParameter("fechaInicio", fechaInicio)
                    .setParameter("fechaFin", fechaFin)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
    public void eliminarTurnoArtista(Long id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            // Buscar el TurnoArtista por ID
            TurnoArtista turnoArtista = em.find(TurnoArtista.class, id);
            if (turnoArtista != null) {
                em.remove(turnoArtista); // Eliminar el TurnoArtista
            } else {
                throw new Exception("No se encontró el TurnoArtista con ID: " + id);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al eliminar el TurnoArtista: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
     public Optional<TurnoArtista> findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            TurnoArtista turnoArtista = em.find(TurnoArtista.class, id);
            return Optional.ofNullable(turnoArtista);
        } finally {
            em.close();
        }
    }
    
}
