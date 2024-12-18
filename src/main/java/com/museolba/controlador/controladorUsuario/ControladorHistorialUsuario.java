package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.dao.usuarioDAO.HistorialUsuarioDAOImpl;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.jpaController.HistorialUsuarioJpaController;
import com.museolba.utils.UtilsValidacion;
import java.util.List;
import javax.swing.JTable;


public class ControladorHistorialUsuario {
    private final HistorialUsuarioJpaController historialUsuarioJpaController;
    private final HistorialUsuarioDAOImpl historialUsuarioDAO;
    
    public ControladorHistorialUsuario(){
        this.historialUsuarioJpaController = new HistorialUsuarioJpaController();
        this.historialUsuarioDAO = new HistorialUsuarioDAOImpl();
    }
    
    public void crearHistorialUsuario(HistorialUsuario historialUsuario) throws Exception {
        historialUsuarioJpaController.create(historialUsuario);
    }
    public void editarHistorialUsuario(HistorialUsuario historialUsuario) throws Exception {
        historialUsuarioJpaController.edit(historialUsuario, historialUsuario.getId());
    }

    
    public void eliminarHistorialUsuario(long id) throws Exception {
        historialUsuarioJpaController.destroy(id);
    }

    
    public HistorialUsuario obtenerHistorialUsuario(long id) {
        return historialUsuarioJpaController.findHistorialUsuario(id);
    }

    
    public List<HistorialUsuario> obtenerTodosLosHistorialUsuarios() {
        return historialUsuarioJpaController.findAll();
    }
    
    public void cargarTablaHistorial(JTable tabla, String[] titulos) {
        List<Object[]> datos = historialUsuarioDAO.obtenerHistorialesConDetalles();

        UtilsValidacion.cargarTabla(tabla, datos, titulos, fila -> fila);
        if (datos.isEmpty()) {
            UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
        }
    }
    
    public void buscarYMostrarResultados(String filtro, String termino, JTable tabla, String[] titulos) {
        if (termino.isEmpty()) {
            UtilsValidacion.MsjAlert("Por favor, ingrese un término de búsqueda.", 2, "Búsqueda Vacía");
            return;
        }
        List<Object[]> resultados = historialUsuarioDAO.buscarPorFiltro(filtro, termino);
        UtilsValidacion.cargarTabla(tabla, resultados, titulos, fila -> fila);
        if (resultados.isEmpty()) {
            UtilsValidacion.MsjAlert("No se encontraron resultados para el filtro y término proporcionados.", 1, "Sin Resultados");
        }
    }
}
