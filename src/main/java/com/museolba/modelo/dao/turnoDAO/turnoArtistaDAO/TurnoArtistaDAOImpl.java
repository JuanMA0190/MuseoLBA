package com.museolba.modelo.dao.turnoDAO.turnoArtistaDAO;

import com.museolba.modelo.entidades.turnos.turnoArtista.TurnoArtista;
import com.museolba.modelo.jpaController.PersistenceJpaController;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

public class TurnoArtistaDAOImpl extends PersistenceJpaController implements TurnoArtistaDAO {

    @Override
    public List<TurnoArtista> obtenerTodosLosTurnosArtista() {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery(
                "SELECT ta FROM TurnoArtista ta ORDER BY ta.id", 
                TurnoArtista.class)
                .getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public Optional<TurnoArtista> buscarPorId(Long id) {
        EntityManager em = getEmf().createEntityManager();
        try {
            TurnoArtista turnoArtista = em.find(TurnoArtista.class, id);
            return Optional.ofNullable(turnoArtista);
        } finally {
            em.close();
        }
    }
    
}
