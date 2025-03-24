package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ObraDAOImpl extends PersistenceJpaController implements ObraDAO{

    /**
     * Obtiene todas las obras registradas en la base de datos.
     *
     * @return Una lista de todas las obras.
     */
    @Override
    public List<Obra> obtenerTodasLasObras() {
        EntityManager em = getEmf().createEntityManager();
        List<Obra> obras = null;

        try {
            // Crea una consulta para obtener todas las salas
            TypedQuery<Obra> query = em.createQuery("SELECT o FROM Obra o", Obra.class);
            obras = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones (puedes personalizarlo)
        } finally {
            em.close(); // Cierra el EntityManager
        }

        return obras;
    }
    
    public Optional<Obra> obtenerObraPorIdConRelaciones(Long id) {
        EntityManager em = getEmf().createEntityManager();
        Optional<Obra> obra = Optional.empty();

        try {
            TypedQuery<Obra> query = em.createQuery(
                "SELECT o FROM Obra o " +
                "LEFT JOIN FETCH o.artista " +
                "LEFT JOIN FETCH o.sala " +
                "WHERE o.numInv = :id", Obra.class);
            query.setParameter("id", id);
            obra = Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    return obra;
}
    
}
