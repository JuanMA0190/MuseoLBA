package com.museolba.modelo.jpaController.turnoGuiaJpaController;

import com.museolba.modelo.entidades.turnos.turnoGuia.TurnoGuia;
import com.museolba.modelo.jpaController.BaseJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TurnoGuiaJpaController extends BaseJpaController<TurnoGuia, Long> {
    
    public TurnoGuiaJpaController() {
        super(TurnoGuia.class);
    }
    
    public void agregarTurnoGuia(TurnoGuia turnoGuia) throws Exception {
        EntityManager em = null;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // Persistir el TurnoGuia
            em.persist(turnoGuia);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al agregar el TurnoGuia: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    
    public void editarTurnoGuia(TurnoGuia turnoGuia) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            // Actualizar el TurnoGuia
            em.merge(turnoGuia);

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al editar el TurnoGuia: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
    
    
    public void eliminarTurnoGuia(Long id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            // Buscar el TurnoGuia por ID
            TurnoGuia turnoGuia = em.find(TurnoGuia.class, id);
            if (turnoGuia != null) {
                em.remove(turnoGuia); // Eliminar el TurnoGuia
            } else {
                throw new Exception("No se encontró el TurnoGuia con ID: " + id);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new Exception("Error al eliminar el TurnoGuia: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}
