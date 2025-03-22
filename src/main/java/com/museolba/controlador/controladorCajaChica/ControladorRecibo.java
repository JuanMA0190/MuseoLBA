package com.museolba.controlador.controladorCajaChica;

import com.museolba.modelo.dao.reciboDAO.ReciboDAOImpl;
import com.museolba.modelo.entidades.cajaChica.Recibo;
import com.museolba.modelo.jpaController.cajaChicaJpaController.ReciboJpaController;
import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.modelo.entidades.cajaChica.Producto;
import com.museolba.modelo.jpaController.cajaChicaJpaController.CajaChicaJpaController;

import java.util.List;

public class ControladorRecibo {
    private final ReciboJpaController reciboJpaController;
    private final ReciboDAOImpl reciboDAO;
    private final CajaChicaJpaController cajaChicaJpaController;
    
    public ControladorRecibo(){
        this.reciboJpaController = new ReciboJpaController();
        this.reciboDAO = new ReciboDAOImpl();
        this.cajaChicaJpaController = new CajaChicaJpaController();
    }
    
      // Métodos ABM (usando JpaController)
    public void crearRecibo(Recibo recibo) throws Exception {
        reciboJpaController.crearRecibo(recibo);
        actualizarTotalGastoCajaChica(recibo.getCajaChica().getId());
    }

    public void editarRecibo(Recibo recibo) throws Exception {
        reciboJpaController.edit(recibo, recibo.getId());
        actualizarTotalGastoCajaChica(recibo.getCajaChica().getId());
    }

    public void eliminarRecibo(Long id) throws Exception {
        Recibo recibo = reciboJpaController.find(id);
        if (recibo != null) {
            Long cajaChicaId = recibo.getCajaChica().getId();
            reciboJpaController.destroy(id);
            actualizarTotalGastoCajaChica(cajaChicaId);
        }
    }

    public Recibo obtenerRecibo(Long id) {
        return reciboJpaController.find(id);
    }

    public List<Recibo> obtenerTodosLosRecibo() {
        return reciboJpaController.findAll();
    }

    // Métodos de consultas específicas (usando DAO)
    public List<Recibo> obtenerRecibosPorCajaChica(Long cajaChicaId) {
        return reciboDAO.obtenerRecibosPorCajaChica(cajaChicaId);
    }

    public List<Recibo> obtenerRecibosPorMes(int mes) {
        return reciboDAO.obtenerRecibosPorMes(mes);
    }

    public List<Recibo> obtenerRecibosConPrecioTotalMayorA(Double monto) {
        return reciboDAO.obtenerRecibosConPrecioTotalMayorA(monto);
    }

    public Double obtenerTotalGastadoPorCajaChica(Long cajaChicaId) {
        return reciboDAO.obtenerTotalGastadoPorCajaChica(cajaChicaId);
    }

    public List<Producto> obtenerProductosPorRecibo(Long reciboId){
        return reciboDAO.obtenerProductosPorRecibo(reciboId);
    }
    
    // Método auxiliar para actualizar el totalGasto de CajaChica
    private void actualizarTotalGastoCajaChica(Long cajaChicaId) {
        Double totalGasto = reciboDAO.obtenerTotalGastadoPorCajaChica(cajaChicaId);
        CajaChica cajaChica = cajaChicaJpaController.find(cajaChicaId);
        if (cajaChica != null) {
            cajaChica.setTotalGasto(totalGasto);
            try {
                cajaChicaJpaController.edit(cajaChica, cajaChicaId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
