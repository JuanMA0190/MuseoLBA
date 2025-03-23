package com.museolba.modelo.dao.obraDAO;

import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import com.museolba.modelo.entidades.obra.Artista;
import static com.museolba.modelo.jpaController.PersistenceJpaController.getEmf;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ArtistaDAOImpl extends PersistenceJpaController implements ArtistaDAO {
    @Override 
    public List<Artista> obtenerTodosLosArtistas() {
        EntityManager em = getEmf().createEntityManager();
        List<Artista> artistas = null;

        try {
            // Crea una consulta para obtener todos los artistas
            TypedQuery<Artista> query = em.createQuery("SELECT a FROM Artista a", Artista.class);
            artistas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return artistas;
    }
    
    @Override 
    public List<Artista> buscarArtistasPorNombre(String termino) {
       EntityManager em = getEmf().createEntityManager();
        List<Artista> artistas = null;

        try {
            // Crea una consulta para buscar artistas cuyo nombre contenga el término proporcionado
            TypedQuery<Artista> query = em.createQuery(
                "SELECT a FROM Artista a WHERE LOWER(a.nombre) LIKE LOWER(:termino)", Artista.class);
            query.setParameter("termino", "%" + termino + "%"); // Usamos % para buscar coincidencias parciales
            artistas = query.getResultList();
            System.out.println("Resultados encontrados: " + artistas.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return artistas;
    }
}
