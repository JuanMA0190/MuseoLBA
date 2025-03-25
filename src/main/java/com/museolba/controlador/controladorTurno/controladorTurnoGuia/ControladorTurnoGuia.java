package com.museolba.controlador.controladorTurno.controladorTurnoGuia;

import com.museolba.modelo.dao.turnoDAO.turnoGuiaDAO.TurnoGuiaDAOImpl;
import com.museolba.modelo.entidades.turnos.turnoGuia.TurnoGuia;
import com.museolba.modelo.jpaController.turnoGuiaJpaController.TurnoGuiaJpaController;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class ControladorTurnoGuia {
    private final TurnoGuiaJpaController turnoGuiaJpaController;
    private final TurnoGuiaDAOImpl turnoGuiaDAO;
    
    public ControladorTurnoGuia(){
        this.turnoGuiaJpaController = new TurnoGuiaJpaController();
        this.turnoGuiaDAO = new TurnoGuiaDAOImpl();
    }
    
    public List<TurnoGuia> traerTodosLosTurnosGuia(){
        return turnoGuiaDAO.obtenerTodosLosTurnosGuia();
    }
    
    public Optional<TurnoGuia> obtenerTurnoGuiaPorId(Long id){
        return turnoGuiaDAO.buscarPorId(id);
    }
    
    
    public void agregarTurnoGuia(TurnoGuia turnoGuia) throws Exception {
        // Validar que la fecha y el horario no sean menores a la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        
        LocalTime horarioTurno = LocalTime.parse(turnoGuia.getHorario());
        LocalDateTime fechaHoraTurno = LocalDateTime.of(turnoGuia.getFecha(), horarioTurno);

        if (fechaHoraTurno.isBefore(fechaHoraActual)) {
            throw new Exception("La fecha y el horario del turno no pueden ser menores a la fecha y hora actual.");
        }

        // Obtener todos los turnos del día actual
        List<TurnoGuia> turnosDelDia = turnoGuiaDAO.obtenerTurnosPorFecha(turnoGuia.getFecha());

        if (turnosDelDia.size() >= 4) {
            throw new Exception("No se pueden agregar más turnos para el día " + turnoGuia.getFecha() + ". El límite es de 4 turnos por día.");
        }

        // Verificar si ya existe un turno en el mismo horario
        boolean horarioOcupado = turnosDelDia.stream()
                .anyMatch(turno -> turno.getHorario().equals(turnoGuia.getHorario()));

        if (horarioOcupado) {
            throw new Exception("Ya existe un turno en el horario " + turnoGuia.getHorario() + " para el día " + turnoGuia.getFecha() + ".");
        }

        // Si pasa las validaciones, agregar el turno
        turnoGuiaJpaController.agregarTurnoGuia(turnoGuia);
    }
    
    public void editarTurnoGuia(TurnoGuia turnoGuia) throws Exception {
        // Validar que la fecha y el horario no sean menores a la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        LocalTime horarioTurno = LocalTime.parse(turnoGuia.getHorario());
        LocalDateTime fechaHoraTurno = LocalDateTime.of(turnoGuia.getFecha(), horarioTurno);

        if (fechaHoraTurno.isBefore(fechaHoraActual)) {
            throw new Exception("La fecha y el horario del turno no pueden ser menores a la fecha y hora actual.");
        }

        // Obtener todos los turnos del día actual, excluyendo el turno que se está editando
        List<TurnoGuia> turnosDelDia = turnoGuiaDAO.obtenerTurnosPorFecha(turnoGuia.getFecha());
        turnosDelDia.removeIf(turno -> turno.getId().equals(turnoGuia.getId()));

        // Verificar si ya existe un turno en el mismo horario
        boolean horarioOcupado = turnosDelDia.stream()
                .anyMatch(turno -> turno.getHorario().equals(turnoGuia.getHorario()));

        if (horarioOcupado) {
            throw new Exception("Ya existe un turno en el horario " + turnoGuia.getHorario() + " para el día " + turnoGuia.getFecha() + ".");
        }

        // Si pasa las validaciones, editar el turno
        turnoGuiaJpaController.editarTurnoGuia(turnoGuia);
    }
    
    
    public void eliminarTurnoGuia(Long id) throws Exception {
        // Verificar si el turno existe antes de eliminarlo
        Optional<TurnoGuia> turnoGuiaOptional = obtenerTurnoGuiaPorId(id);

        if (turnoGuiaOptional.isPresent()) {
            // Si el turno existe, eliminarlo
            turnoGuiaJpaController.eliminarTurnoGuia(id);
        } else {
            throw new Exception("No se encontró el TurnoGuia con ID: " + id);
        }
    }
}
