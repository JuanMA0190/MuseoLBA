package com.museolba.modelo.dao.asistenciaDAO;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaDAO {
    //TraerPorDiaNumeroLegajoHorarios
    List<Object[]> obtenerAsistenciaConDetalles(Long numLegajo, LocalDate fecha);
}
