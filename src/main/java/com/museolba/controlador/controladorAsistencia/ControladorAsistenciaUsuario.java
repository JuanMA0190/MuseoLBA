package com.museolba.controlador.controladorAsistencia;

import com.museolba.modelo.dao.asistenciaDAO.AsistenciaDAOImpl;
import com.museolba.modelo.jpaController.AsistenciaUsuarioJpaController;
import java.time.LocalDate;
import java.util.List;

public class ControladorAsistenciaUsuario {
    private final AsistenciaUsuarioJpaController asistenciaJpaController;
    private final AsistenciaDAOImpl asistenciaDAO;
    
    public ControladorAsistenciaUsuario(){
        this.asistenciaJpaController = new AsistenciaUsuarioJpaController();
        this.asistenciaDAO = new AsistenciaDAOImpl();
    }
    
    public List<Object[]> obtenerAsistenciasPorLegajo(Long numLegajo, LocalDate fecha) {
        return asistenciaDAO.obtenerAsistenciaConDetalles(numLegajo, fecha);
    }
}
