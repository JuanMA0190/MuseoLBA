package com.museolba.controlador.controladorUsuario;

import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.jpaController.HistorialUsuarioJpaController;
import java.util.List;


public class ControladorHistorialUsuario {
    private final HistorialUsuarioJpaController historialUsuarioJpaController;
    
    public ControladorHistorialUsuario(){
        this.historialUsuarioJpaController = new HistorialUsuarioJpaController();
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
}
