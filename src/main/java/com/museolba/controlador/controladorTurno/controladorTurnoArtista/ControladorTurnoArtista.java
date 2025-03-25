package com.museolba.controlador.controladorTurno.controladorTurnoArtista;

import com.museolba.modelo.dao.turnoDAO.turnoArtistaDAO.TurnoArtistaDAOImpl;
import com.museolba.modelo.jpaController.turnoArtistaJpaController.TurnoArtistaJpaController;
import com.museolba.modelo.entidades.turnos.turnoArtista.TurnoArtista;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ControladorTurnoArtista {
    private final TurnoArtistaJpaController turnoArtistaJpaController;
    private final TurnoArtistaDAOImpl turnoArtistaDAO;
    
    public ControladorTurnoArtista(){
        this.turnoArtistaJpaController = new TurnoArtistaJpaController();
        this.turnoArtistaDAO = new TurnoArtistaDAOImpl();
    }
    
    public List<TurnoArtista> traerTodosLosTurnosArtista(){
        return turnoArtistaDAO.obtenerTodosLosTurnosArtista();
    }
    
    public Optional<TurnoArtista> obtenerTurnoArtistaPorId(Long id) {
        return turnoArtistaDAO.buscarPorId(id);
    }
    
    
    
    public void crearTurnoArtista(TurnoArtista turnoArtista) throws Exception {
        // Validar que la fecha de inicio no sea anterior a la fecha actual
        LocalDate fechaActual = LocalDate.now();
        if (turnoArtista.getFechaInicio().isBefore(fechaActual)) {
            throw new Exception("La fecha de inicio no puede ser anterior a la fecha actual.");
        }

        // Validar que la fecha de fin sea mayor o igual a la fecha de inicio
        if (turnoArtista.getFechaFin().isBefore(turnoArtista.getFechaInicio())) {
            throw new Exception("La fecha de fin debe ser mayor o igual a la fecha de inicio.");
        }

        // Verificar si hay solapamiento con otros turnos
        List<TurnoArtista> turnosSolapados = turnoArtistaJpaController.obtenerTurnosSolapados(
                turnoArtista.getFechaInicio(), turnoArtista.getFechaFin());

        if (!turnosSolapados.isEmpty()) {
            throw new Exception("El rango de fechas se solapa con otro turno existente.");
        }

        turnoArtistaJpaController.crearTurnoArtista(turnoArtista);
    }
     
    public void modificarTurnoArtista(TurnoArtista turnoArtista) throws Exception {
        // Validar que la fecha de inicio no sea anterior a la fecha actual
        LocalDate fechaActual = LocalDate.now();
        if (turnoArtista.getFechaInicio().isBefore(fechaActual)) {
            throw new Exception("La fecha de inicio no puede ser anterior a la fecha actual.");
        }

        // Validar que la fecha de fin sea mayor o igual a la fecha de inicio
        if (turnoArtista.getFechaFin().isBefore(turnoArtista.getFechaInicio())) {
            throw new Exception("La fecha de fin debe ser mayor o igual a la fecha de inicio.");
        }

        // Verificar si hay solapamiento con otros turnos, excluyendo el turno actual
        List<TurnoArtista> turnosSolapados = turnoArtistaJpaController.obtenerTurnosSolapadosExcluyendo(
                turnoArtista.getFechaInicio(), turnoArtista.getFechaFin(), turnoArtista.getId());

        if (!turnosSolapados.isEmpty()) {
            throw new Exception("El rango de fechas se solapa con otro turno existente.");
        }

        turnoArtistaJpaController.modificarTurnoArtista(turnoArtista);
    }
    
    public void eliminarTurnoArtista(Long id) throws Exception {
        // Verificar si el turno existe antes de eliminarlo
        if (turnoArtistaJpaController.findById(id).isPresent()) {
            turnoArtistaJpaController.eliminarTurnoArtista(id);
        } else {
            throw new Exception("No se encontró el TurnoArtista con ID: " + id);
        }
    }
}
