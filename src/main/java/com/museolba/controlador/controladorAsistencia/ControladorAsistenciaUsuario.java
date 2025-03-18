package com.museolba.controlador.controladorAsistencia;

import com.museolba.config.TiposReporte;
import com.museolba.modelo.dao.asistenciaDAO.AsistenciaDAOImpl;
import com.museolba.modelo.entidades.AsistenciaUsuario;
import com.museolba.utils.reportes.AsistenciaEXCELGenerador;
import com.museolba.utils.reportes.AsistenciaPDFGeneradorUtil;
import java.time.LocalDate;
import java.util.List;

public class ControladorAsistenciaUsuario {
    private final AsistenciaDAOImpl asistenciaDAO;
    
    public ControladorAsistenciaUsuario(){
        this.asistenciaDAO = new AsistenciaDAOImpl();
    }
    
    public List<AsistenciaUsuario> obtenerAsistenciasDetalladas( LocalDate fecha) {
        return asistenciaDAO.obtenerAsistenciaConDetalles(fecha);
    }
    
   /**
     * Genera un reporte de asistencia en PDF.
     *
     * @param numLegajo Número de legajo del usuario (puede ser null para todos los usuarios).
     * @param mes       Mes del reporte.
     * @param anio      Año del reporte.
     * @param filePath  Ruta donde se guardará el PDF.
     */
    public void generarReporteAsistencia(int mes, int anio, String filePath) {
        // Obtener las asistencias del mes y año especificados
        List<AsistenciaUsuario> asistencias = asistenciaDAO.obtenerAsistenciasPorMesYAnio(mes, anio);
      
        if(filePath.contains(".pdf")){
            // Generar el PDF
            AsistenciaPDFGeneradorUtil pdfGenerator = new AsistenciaPDFGeneradorUtil();
            pdfGenerator.generarReporteAsistencia(filePath, asistencias, mes, anio);
        }else if(filePath.endsWith(".xlsx")){
            //Generar el excel
            AsistenciaEXCELGenerador excelGenerator = new AsistenciaEXCELGenerador();
            excelGenerator.generarReporteExcel(filePath, asistencias, mes, anio);
        }
        
    }

}
