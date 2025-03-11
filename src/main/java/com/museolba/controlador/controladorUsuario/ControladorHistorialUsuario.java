package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.usuarioDAO.HistorialUsuarioDAOImpl;
import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.jpaController.HistorialUsuarioJpaController;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.NoResultException;


public class ControladorHistorialUsuario{
    private final HistorialUsuarioJpaController historialUsuarioJpaController;
    private final HistorialUsuarioDAOImpl historialUsuarioDAO;
 
    public ControladorHistorialUsuario(){
        this.historialUsuarioJpaController = new HistorialUsuarioJpaController();
        this.historialUsuarioDAO = new HistorialUsuarioDAOImpl();

    }
    
    public void crearHistorialUsuario(HistorialUsuario historialUsuario) throws Exception {
        historialUsuarioJpaController.create(historialUsuario);
    }
    
    public HistorialUsuario obtenerHistorialUsuario(long id) {
        return historialUsuarioJpaController.findHistorialUsuario(id);
    }
    
    public List<Object[]> obtenerTodosLosHistorialUsuarios() {
        return historialUsuarioDAO.obtenerHistorialesConDetalles();
    }
    
    public List<Object[]> buscarYMostrarResultados(String filtro, String termino) {
        if (termino.isEmpty()) {
            //UtilsValidacion.MsjAlert("Por favor, ingrese un término de búsqueda.", 2, "Búsqueda Vacía");
            throw new NoResultException("Por favor, ingrese un término de búsqueda.");
        }
        
        List<Object[]> datos = historialUsuarioDAO.buscarPorFiltro(filtro, termino);
        
        
        if (datos.isEmpty()) {
            //UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
            throw new NoResultException("No se encontraron resultados para el filtro y término proporcionados.");
        }
        
        return datos;
    }
    
    public String actualizarHistorial(long nLegajo, LocalDateTime fecha, EstadoPersonal estado, String razon){
        try {
            HistorialUsuario historial = historialUsuarioDAO.obtenerHistorialPorUsuario(nLegajo);

            if (historial == null) {
                return "No se encontró un historial para el usuario especificado.";
            }
            
            switch (estado) {
                case ACTIVO -> {
                    historial.registrarModificacion(fecha);
                    historial.registrarAlta(fecha);
                    historial.setEstado(estado);
                    historial.getUsuario().setEstado(estado);
                    historial.setRazonInactividad("-");
                }
                case INACTIVO -> {
                    if(razon.equals("ELIMINADO: Usuario eliminado permanentemente.")){
                        historial.registrarEliminacion(fecha);
                        historial.registrarBaja(fecha);
                        historial.setEstado(estado);
                        historial.getUsuario().setEstado(estado);
                        historial.setRazonInactividad("ELIMINADO: Usuario eliminado permanentemente.");
                    }else{
                        historial.registrarModificacion(fecha);
                        historial.registrarBaja(fecha);
                        historial.setEstado(estado);
                        historial.getUsuario().setEstado(estado);
                        historial.setRazonInactividad(razon);
                    }
                }
                default -> throw new AssertionError();
            }
          

            historialUsuarioDAO.actualizarHistorial(historial);

            return "Historial actualizado correctamente.";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar el historial: " + e.getMessage();
        }
    }
       
    public HistorialUsuario obtenerHistorialPorUsuario(long nLegajo) {
        HistorialUsuario historial = historialUsuarioDAO.obtenerHistorialPorUsuario(nLegajo);
        return historial;
    }
}

