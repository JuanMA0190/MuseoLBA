package com.museolba.modelo.dao.personalDAO;

import java.util.List;


public interface PersonalDAO {
    boolean existeLegajo(long nLegajo);
    List<Object[]> obtenerPersonalConDetalles();
    List<Object[]> buscarPorFiltro(String filtro, String termino);
}
