package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;


public class SalaDAOImpl extends PersistenceJpaController implements SalaDAO{
   
    /**
     * Obtiene todas las salas registradas en la base de datos.
     *
     * @return Una lista de todas las salas.
     */
    @Override
    public List<Sala> obtenerTodasLasSalas() {
        EntityManager em = getEmf().createEntityManager();
        List<Sala> salas = null;

        try {
            // Crea una consulta para obtener todas las salas
            TypedQuery<Sala> query = em.createQuery("SELECT s FROM Sala s", Sala.class);
            salas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            em.close(); 
        }

        return salas;
    }
    
    /**
     * Busca una sala por su nombre en la base de datos.
     *
     * @param nombre El nombre de la sala a buscar.
     * @return Un Optional que contiene la sala si se encuentra, o vacío si no.
     */
    public Optional<Sala> buscarSalaPorNombre(String nombre) {
        EntityManager em = getEmf().createEntityManager();
        Optional<Sala> sala = Optional.empty();

        try {
            // Crea una consulta para buscar la sala por su nombre
            TypedQuery<Sala> query = em.createQuery(
                "SELECT s FROM Sala s WHERE s.nombre = :nombre", Sala.class);
            query.setParameter("nombre", nombre);
            sala = Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            em.close();
        }

        return sala;
    }
    
    @Override
    public List<Sala> obtenerTodasLasSalasConObras() {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Sala s LEFT JOIN FETCH s.obras", Sala.class).getResultList();
        } finally {
            em.close();
        }
    }

}
