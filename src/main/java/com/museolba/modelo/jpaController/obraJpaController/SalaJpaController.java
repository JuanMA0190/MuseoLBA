package com.museolba.modelo.jpaController.obraJpaController;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import com.museolba.modelo.jpaController.BaseJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;


public class SalaJpaController extends BaseJpaController<Sala, Long> {
    public SalaJpaController() {
        super(Sala.class);
    }

    // Método para buscar salas por nombre
    public List<Sala> findSalasByNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Sala s WHERE s.nombre LIKE :nombre", Sala.class)
                      .setParameter("nombre", "%" + nombre + "%")
                      .getResultList();
        } finally {
            em.close();
        }
    }

    // Método para obtener todas las obras en una sala
    public List<Obra> getObrasBySala(Long salaId) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT o FROM Obra o WHERE o.sala.id = :salaId", Obra.class)
                      .setParameter("salaId", salaId)
                      .getResultList();
        } finally {
            em.close();
        }
    }
    
    
    // Método para buscar una sala por nombre
    public Sala encontrarSalaByNombre(String nombre) {
         EntityManager em = getEntityManager();
        try {
            List<Sala> salas = em.createQuery("SELECT s FROM Sala s WHERE s.nombre = :nombre", Sala.class)
                                 .setParameter("nombre", nombre)
                                 .getResultList();

            if (salas.isEmpty()) {
                return null; // No se encontró ninguna sala
            } else if (salas.size() == 1) {
                return salas.get(0); // Devuelve la única sala encontrada
            } else {
                // Si hay más de una sala, lanza una excepción o maneja el caso
                throw new NonUniqueResultException("Se encontraron múltiples salas con el nombre: " + nombre);
            }
        } finally {
            em.close();
        }
    }
}
