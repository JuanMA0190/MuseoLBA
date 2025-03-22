package com.museolba.modelo.dao.reciboDAO;

import com.museolba.modelo.entidades.cajaChica.Producto;
import java.util.List;
import com.museolba.modelo.entidades.cajaChica.Recibo;

public interface ReciboDAO {
    
    List<Recibo> obtenerRecibosPorCajaChica(Long cajaChicaId);

    List<Recibo> obtenerRecibosPorMes(int mes);

    List<Recibo> obtenerRecibosConPrecioTotalMayorA(Double monto);

    Double obtenerTotalGastadoPorCajaChica(Long cajaChicaId);
    
    List<Producto> obtenerProductosPorRecibo(Long reciboId);
}
