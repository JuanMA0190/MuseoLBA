package com.museolba.modelo.dao.asistenciaDAO;

import com.museolba.modelo.entidades.usuario.AsistenciaUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import java.time.LocalDate;
import java.util.List;

public interface AsistenciaDAO {
    //TraerPorDiaNumeroLegajoHorarios
    List<AsistenciaUsuario> obtenerAsistenciaConDetalles(LocalDate fecha, Usuario numLegajo);

    // Obtener asistencias por mes y año
    List<AsistenciaUsuario> obtenerAsistenciasPorMesYAnio(int mes, int anio);
}
