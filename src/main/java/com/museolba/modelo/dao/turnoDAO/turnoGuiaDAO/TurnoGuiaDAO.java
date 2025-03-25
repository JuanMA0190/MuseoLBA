package com.museolba.modelo.dao.turnoDAO.turnoGuiaDAO;

import com.museolba.modelo.entidades.turnos.turnoGuia.TurnoGuia;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TurnoGuiaDAO {
    public List<TurnoGuia> obtenerTurnosPorFecha(LocalDate fecha);
    
    public List<TurnoGuia> obtenerTodosLosTurnosGuia();
    
    public Optional<TurnoGuia> buscarPorId(Long id);
}
