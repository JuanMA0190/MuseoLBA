package com.museolba.modelo.dao.usuarioDAO;

import com.museolba.modelo.entidades.HistorialUsuario;
import java.util.List;


public interface HistorialUsuarioDAO {
    void actualizarHistorial (HistorialUsuario historial);
    HistorialUsuario obtenerHistorialPorUsuario(long nLegajo);
    List<Object[]> obtenerHistorialesConDetalles();
    List<Object[]> buscarPorFiltro(String filtro, String termino);
}
