package com.museolba.modelo.dao.cajachicaDAO;

import java.util.List;
import com.museolba.modelo.entidades.cajaChica.CajaChica;

public interface CajaChicaDAO {
    // Obtener caja chica por mes
    CajaChica obtenerCajaChicaPorMes(int mes, int anio);

    // Obtener el total gastado en un mes específico
    Double obtenerTotalGastadoEnMes(int mes);

    // Obtener cajas chicas que no tienen recibos asociados
    List<CajaChica> obtenerCajasChicasSinRecibos();
    
    boolean existeCajaChicaParaMes(int mes, int anio);
    
    boolean esFondoInicialCero(int mes, int anio);
    
}
