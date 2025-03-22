package com.museolba.modelo.jpaController.cajaChicaJpaController;

import com.museolba.modelo.entidades.cajaChica.Recibo;
import com.museolba.modelo.jpaController.BaseJpaController;
import javax.persistence.EntityManager;

public class ReciboJpaController extends BaseJpaController<Recibo, Long> {
    
    public ReciboJpaController() {
        super(Recibo.class);
    }
    
    public void crearRecibo(Recibo recibo){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            // 1. Asignar un nombre temporal antes de persistir
            recibo.setNombre("Generando...");

            // 2. Persistir el recibo
            em.persist(recibo);
            em.flush(); // Fuerza la sincronización con la base de datos

            // 3. Ahora que el ID está generado, actualizar el nombre real
            String nombreRecibo = "Recibo CC N" + recibo.getId();
            recibo.setNombre(nombreRecibo);

            // 4. Merge para actualizar el nombre
            em.merge(recibo);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
