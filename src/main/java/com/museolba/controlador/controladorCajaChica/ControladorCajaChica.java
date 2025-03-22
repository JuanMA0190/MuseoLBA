package com.museolba.controlador.controladorCajaChica;

import com.museolba.modelo.dao.cajachicaDAO.CajaChicaDAOImpl;
import com.museolba.modelo.jpaController.cajaChicaJpaController.CajaChicaJpaController;
import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.utils.reportes.cajaChica.CajaChicaExcelGenerador;
import com.museolba.utils.reportes.cajaChica.CajaChicaPDFGenerador;
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
    
    
    /**
     * Genera un reporte de asistencia en PDF.
     *
     * @param mes       Mes del reporte.
     * @param anio      Año del reporte.
     * @param filePath  Ruta donde se guardará el PDF.
     */
    public void generarReporteCajaChica(int mes, int anio, String filePath) {
      // Obtener las asistencias del mes y año especificados
      CajaChica cajaChica = cajachicaDAO.obtenerCajaChicaPorMes(mes, anio);

      if(filePath.contains(".pdf")){
          // Generar el PDF
          CajaChicaPDFGenerador pdfGenerator = new CajaChicaPDFGenerador();
          pdfGenerator.generarReporteCajaChica(filePath, cajaChica);
      }else if(filePath.endsWith(".xlsx")){
          //Generar el excel
          CajaChicaExcelGenerador excelGenerator = new CajaChicaExcelGenerador();
          excelGenerator.generarReporteCajaChica(filePath, cajaChica);
      }

    }
}
