package com.museolba.modelo.jpaController.cajaChicaJpaController;

import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.modelo.jpaController.BaseJpaController;
import javax.persistence.EntityManager;

public class CajaChicaJpaController extends BaseJpaController<CajaChica, Long> {
    
    public CajaChicaJpaController() {
        super(CajaChica.class);
    }
    
    // Método para guardar o editar el fondo inicial
    public void editarFondoInicial(Long idCajaChica, double fondoInicial) throws Exception {
        EntityManager em = null;
        
        try {
            em=getEntityManager();
            em.getTransaction().begin();
            
            // Intentamos encontrar la caja chica con el ID proporcionado
            CajaChica cajaChica = em.find(CajaChica.class, idCajaChica);
            
            // Establecemos el fondo inicial
            cajaChica.setFondoInicial(fondoInicial);

            // Si la caja chica ya existe, la editamos; si no, la creamos
            if (cajaChica.getId() != null && em.contains(cajaChica)) {
                // Editamos la caja chica existente
                em.merge(cajaChica);
            } else {
                // Guardamos una nueva caja chica
                em.persist(cajaChica);
            }

            // Confirmamos la transacción
            em.getTransaction().commit();
            System.out.println("Fondo inicial guardado o editado correctamente.");
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertimos si ocurre un error
            }
            e.printStackTrace();
            throw new RuntimeException("Error al guardar o editar el fondo inicial.");
        } finally {
            em.close();
        }
    }
}
