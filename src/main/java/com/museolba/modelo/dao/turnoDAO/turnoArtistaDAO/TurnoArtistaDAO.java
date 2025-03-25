package com.museolba.modelo.dao.turnoDAO.turnoArtistaDAO;

import java.util.List;
import com.museolba.modelo.entidades.turnos.turnoArtista.TurnoArtista;
import java.util.Optional;

public interface TurnoArtistaDAO {
    public List<TurnoArtista> obtenerTodosLosTurnosArtista();
    public Optional<TurnoArtista> buscarPorId(Long id);
}
