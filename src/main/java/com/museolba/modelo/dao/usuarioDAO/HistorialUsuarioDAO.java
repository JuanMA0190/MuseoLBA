package com.museolba.modelo.dao.usuarioDAO;

import java.util.List;


public interface HistorialUsuarioDAO {
    List<Object[]> obtenerHistorialesConDetalles();
    List<Object[]> buscarPorFiltro(String filtro, String termino);
}
