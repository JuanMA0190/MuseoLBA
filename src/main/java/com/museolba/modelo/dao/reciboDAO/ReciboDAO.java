package com.museolba.modelo.dao.reciboDAO;

import com.museolba.modelo.entidades.Producto;
import java.util.List;
import com.museolba.modelo.entidades.Recibo;

public interface ReciboDAO {
    // Obtener recibos por caja chica
    List<Recibo> obtenerRecibosPorCajaChica(Long cajaChicaId);

    // Obtener recibos por mes
    List<Recibo> obtenerRecibosPorMes(int mes);

    // Obtener recibos con un precio total mayor a un monto específico
    List<Recibo> obtenerRecibosConPrecioTotalMayorA(Double monto);

    // Obtener el total gastado en recibos para una caja chica específica
    Double obtenerTotalGastadoPorCajaChica(Long cajaChicaId);

    
    List<Producto> obtenerProductosPorRecibo(Long reciboId);
}
