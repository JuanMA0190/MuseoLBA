package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.usuarioDAO.HistorialUsuarioDAOImpl;
import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.jpaController.HistorialUsuarioJpaController;
import com.museolba.utils.UtilsValidacion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JTable;


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
    
    public List<HistorialUsuario> obtenerTodosLosHistorialUsuarios() {
        return historialUsuarioJpaController.findAll();
    }
    
    public void cargarTablaHistorial(JTable tabla, String[] titulos) {
        List<Object[]> datos = historialUsuarioDAO.obtenerHistorialesConDetalles();

        // Modificar el mapper para formatear las fechas
        UtilsValidacion.cargarTabla(tabla, datos, titulos, fila -> {
            // Suponiendo que los índices de las fechas son los siguientes
            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Aquí se formatean las fechas (índices de las fechas en el resultado de la consulta)
            for (int i = 0; i < fila.length; i++) {
                if (fila[i] instanceof LocalDateTime) {
                    // Si es una fecha, se formatea
                    LocalDateTime fecha = (LocalDateTime) fila[i];
                    String fechaFormateada = fecha.format(formatterFecha);
                    String horaFormateada = fecha.format(formatterHora);
                    // Si la columna corresponde a una fecha, mostramos fecha y hora
                    fila[i] = fechaFormateada + " " + horaFormateada;
                }
            }
            return fila;
        });

        if (datos.isEmpty()) {
            UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
        }
    }
    
    public void buscarYMostrarResultados(String filtro, String termino, JTable tabla, String[] titulos) {
        if (termino.isEmpty()) {
            //UtilsValidacion.MsjAlert("Por favor, ingrese un término de búsqueda.", 2, "Búsqueda Vacía");
            return;
        }
        
        List<Object[]> datos = historialUsuarioDAO.buscarPorFiltro(filtro, termino);
        
        // Modificar el mapper para formatear las fechas
        UtilsValidacion.cargarTabla(tabla, datos, titulos, fila -> {
            // Suponiendo que los índices de las fechas son los siguientes
            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Aquí se formatean las fechas (índices de las fechas en el resultado de la consulta)
            for (int i = 0; i < fila.length; i++) {
                if (fila[i] instanceof LocalDateTime) {
                    // Si es una fecha, se formatea
                    LocalDateTime fecha = (LocalDateTime) fila[i];
                    String fechaFormateada = fecha.format(formatterFecha);
                    String horaFormateada = fecha.format(formatterHora);
                    // Si la columna corresponde a una fecha, mostramos fecha y hora
                    fila[i] = fechaFormateada + " " + horaFormateada;
                }
            }
            return fila;
        });
        if (datos.isEmpty()) {
            //UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
            throw new NullPointerException();
        }
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

