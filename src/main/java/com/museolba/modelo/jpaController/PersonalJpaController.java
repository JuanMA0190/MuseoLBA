package com.museolba.modelo.jpaController;

import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.Personal;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class PersonalJpaController extends BaseJpaController<Personal, Long> {
    
    public PersonalJpaController() {
        super(Personal.class);
    }

    public Personal findPersonal(long id) {
        return find(id);
    }

    @Override
    public void edit(Personal personal, Long id) throws Exception {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin(); // Inicia la transacción
            Personal existingPersonal = em.find(Personal.class, personal.getnLegajo());
                    if (existingPersonal == null) {
                        throw new Exception("El personal con el legajo " + personal.getnLegajo() + " no existe.");
                    }
                    existingPersonal.setNombre(personal.getNombre());
                    existingPersonal.setApellido(personal.getApellido());
                    existingPersonal.setDni(personal.getDni());
                    existingPersonal.setnTelefono(personal.getnTelefono());
                    existingPersonal.setEstado(personal.getEstado());

                    em.merge(existingPersonal);

                    // Actualiza el historial del usuario asociado
                    Query query = em.createQuery("SELECT h FROM HistorialUsuario h WHERE h.usuario.nLegajo = :nLegajo");
                    query.setParameter("nLegajo", personal.getnLegajo());
                    HistorialUsuario historial = (HistorialUsuario) query.getSingleResult();

                    if (historial != null) {
                        historial.registrarModificacion(LocalDateTime.now()); // Establece la nueva fecha de modificación
                        em.merge(historial);
                    }

                    em.getTransaction().commit(); // Confirma la transacción
            } catch (Exception e) {
                if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback(); // Revertir si ocurre un error
                }
                throw e;
            } finally {
                if (em != null) {
                    em.close(); // Cierra el EntityManager
                }
            }
    }
    
    
    
}
