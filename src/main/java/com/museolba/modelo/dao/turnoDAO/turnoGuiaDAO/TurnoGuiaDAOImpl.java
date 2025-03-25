package com.museolba.modelo.dao.turnoDAO.turnoGuiaDAO;


import com.museolba.modelo.jpaController.PersistenceJpaController;
import com.museolba.modelo.entidades.turnos.turnoGuia.TurnoGuia;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

public class TurnoGuiaDAOImpl extends PersistenceJpaController implements TurnoGuiaDAO {
    
    @Override
    public List<TurnoGuia> obtenerTodosLosTurnosGuia(){
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery(
                "SELECT tg FROM TurnoGuia tg ORDER BY tg.id", 
                TurnoGuia.class)
                .getResultList();
        } finally {
            em.close();
        }

    }
   
    @Override
    public List<TurnoGuia> obtenerTurnosPorFecha(LocalDate fecha) {
        EntityManager em = getEmf().createEntityManager();
        try {
            return em.createQuery("SELECT t FROM TurnoGuia t WHERE t.fecha = :fecha", TurnoGuia.class)
                    .setParameter("fecha", fecha)
                    .getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public Optional<TurnoGuia> buscarPorId(Long id) {
        EntityManager em = getEmf().createEntityManager();
        try {
            TurnoGuia turnoGuia = em.find(TurnoGuia.class, id);
            return Optional.ofNullable(turnoGuia);
        } finally {
            em.close();
        }
    }
}
