package com.museolba.controlador.controladorCajaChica;

import com.museolba.modelo.dao.cajachicaDAO.CajaChicaDAOImpl;
import com.museolba.modelo.jpaController.CajaChicaJpaController;
import com.museolba.modelo.entidades.CajaChica;
import java.util.List;

public class ControladorCajaChica {
    private final CajaChicaJpaController cajachicaJpaController;
    private final CajaChicaDAOImpl cajachicaDAO;
    
    public ControladorCajaChica(){
        this.cajachicaJpaController = new CajaChicaJpaController();
        this.cajachicaDAO = new CajaChicaDAOImpl();
    }
    
    public void crearCajaChica(CajaChica cajaChica) throws Exception {
        cajachicaJpaController.create(cajaChica);
    }

    public CajaChica obtenerCajaChica(Long id) {
        return cajachicaJpaController.find(id);
    }

    
    public List<CajaChica> obtenerTodosLosCajaChica() {
        return cajachicaJpaController.findAll();
    }
    
    public void editarFondoInicial(Long idCajaChica, double fondoInicial)throws Exception {
        cajachicaJpaController.editarFondoInicial(idCajaChica, fondoInicial);
    }
    
    // Métodos de consultas específicas (usando DAO)
    public CajaChica obtenerCajaChicaPorMes(int mes, int anio) {
        return cajachicaDAO.obtenerCajaChicaPorMes(mes, anio);
    }

    public Double obtenerTotalGastadoEnMes(int mes) {
        return cajachicaDAO.obtenerTotalGastadoEnMes(mes);
    }

    public List<CajaChica> obtenerCajasChicasSinRecibos() {
        return cajachicaDAO.obtenerCajasChicasSinRecibos();
    }
    
    public boolean existeCajaChicaParaMes(int mes, int anio){
        return cajachicaDAO.existeCajaChicaParaMes(mes, anio);
    }
    
    public boolean esFondoInicialCero(int mes, int anio){
        return cajachicaDAO.esFondoInicialCero(mes, anio);
    }
}
