package com.museolba.utils.reportes.asistencias;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.museolba.controlador.controladorUsuario.ControladorHistorialUsuario;
import com.museolba.modelo.entidades.usuario.AsistenciaUsuario;
import com.museolba.modelo.entidades.usuario.HistorialUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.FechaUtils;
import java.io.File;
import java.io.FileOutputStream;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AsistenciaPDFGeneradorUtil {
    
    private ControladorHistorialUsuario controladorHU = new ControladorHistorialUsuario();
    
   /**
     * Genera el reporte de asistencia en PDF.
     *
     * @param filePath   Ruta donde se guardará el PDF.
     * @param asistencias Lista de asistencias.
     * @param mes        Mes correspondiente (número del mes, 1-12).
     * @param anio       Año correspondiente.
     */
    public void generarReporteAsistencia(String filePath, List<AsistenciaUsuario> asistencias, int mes, int anio) {
        try {
            // Crear directorio si no existe
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean dirCreated = parentDir.mkdirs();
                if (!dirCreated) {
                    DialogoUtils.mostrarMensaje("No se pudo crear el directorio: " + parentDir.getAbsolutePath(), 2, "Error!");
                    return;
                }
            }
            
            // Crear el documento en orientación horizontal
            Document document = new Document(PageSize.A4.rotate()); // Orientación horizontal
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Agregar el título
            String nombreMes = FechaUtils.obtenerMes(mes);
            Paragraph titulo = new Paragraph("Asistencia del mes " + nombreMes + " " + anio, 
                                            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n")); // Espacio después del título

            // Crear la tabla con las columnas necesarias
            int diasDelMes = obtenerDiasDelMes(mes, anio);
            PdfPTable table = new PdfPTable(4 + diasDelMes); // 4 columnas fijas + días del mes

            // Configurar el ancho de las columnas
            table.setWidthPercentage(100); // La tabla ocupa el 100% del ancho de la página
            table.setSpacingBefore(5f); // Espacio antes de la tabla
            table.setSpacingAfter(5f); // Espacio después de la tabla

            // Ajustar el ancho de las columnas
            float[] columnWidths = new float[4 + diasDelMes];
            columnWidths[0] = 5.8f; // Nombre y Apellido (más ancho)
            columnWidths[1] = 4.8f; // Número de Legajo
            columnWidths[2] = 5.5f; // DNI
            columnWidths[3] = 4.3f; // Horario (DISCONTINUO)
            for (int i = 4; i < columnWidths.length; i++) {
                columnWidths[i] = 1.6f; // Días del mes (más estrechos)
            }
            table.setWidths(columnWidths);

            // Agregar las cabeceras de la tabla
            agregarCabecerasTabla(table, mes, anio);

            // Agrupar asistencias por usuario
            Map<Usuario, List<AsistenciaUsuario>> asistenciasPorUsuario = asistencias.stream()
                    .collect(Collectors.groupingBy(AsistenciaUsuario::getUsuario));

            // Agregar los datos de asistencia a la tabla
            for (Map.Entry<Usuario, List<AsistenciaUsuario>> entry : asistenciasPorUsuario.entrySet()) {
                Usuario usuario = entry.getKey();
                List<AsistenciaUsuario> asistenciasUsuario = entry.getValue();
                agregarFilaTabla(table, usuario, asistenciasUsuario, mes, anio);
            }

            // Agregar la tabla al documento
            document.add(table);

            //Agregar referencias de Asistencia
            agregarReferencias(document);

            // Agregar las firmas al final del documento
            agregarFirmas(document);

            // Cerrar el documento
            document.close();

            DialogoUtils.mostrarMensaje("Reporte PDF generado exitosamente en: " + filePath,1,"Exito!");
              
        } catch (Exception e) {
            e.printStackTrace();
            DialogoUtils.mostrarMensaje("Error al generar el reporte PDF: " + e.getMessage(),2,"Error!");
        }
    }

    /**
     * Agrega las cabeceras de la tabla.
     *
     * @param table Tabla a la que se agregarán las cabeceras.
     * @param mes   Mes correspondiente (número del mes, 1-12).
     * @param anio  Año correspondiente.
     */
    private void agregarCabecerasTabla(PdfPTable table, int mes, int anio) {
        // Columnas fijas
        agregarCelda(table, "Nombre y Apellido", Element.ALIGN_CENTER);
        agregarCelda(table, "Número de Legajo", Element.ALIGN_CENTER);
        agregarCelda(table, "DNI", Element.ALIGN_CENTER);
        agregarCelda(table, "Horario", Element.ALIGN_CENTER);

        // Días del mes (simplificados: 1, 2, 3, ...)
        int diasDelMes = obtenerDiasDelMes(mes, anio);
        for (int i = 1; i <= diasDelMes; i++) {
            agregarCelda(table, String.valueOf(i), Element.ALIGN_CENTER); // Solo el número del día
        }
    }

    private void agregarFilaTabla(PdfPTable table, Usuario usuario, List<AsistenciaUsuario> asistenciasUsuario, int mes, int anio) {
        // Columnas fijas
        String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
        agregarCelda(table, nombreCompleto, Element.ALIGN_LEFT);
        agregarCelda(table, String.valueOf(usuario.getnLegajo()), Element.ALIGN_CENTER);
        agregarCelda(table, usuario.getDni(), Element.ALIGN_CENTER);
        agregarCelda(table, "Discontinuo", Element.ALIGN_CENTER);

        // Pre-cargar datos de inactividad
        HistorialUsuario hu = controladorHU.obtenerHistorialPorUsuario(usuario.getnLegajo());
        Map<String, String> codigosInasistencia = crearMapeoInasistencias();

        // Procesar cada día del mes
        int diasDelMes = obtenerDiasDelMes(mes, anio);
        for (int dia = 1; dia <= diasDelMes; dia++) {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            String presencia = determinarPresenciaDia(fecha, asistenciasUsuario, hu, codigosInasistencia);
            agregarCelda(table, presencia, Element.ALIGN_CENTER);
        }
    }

    private Map<String, String> crearMapeoInasistencias() {
        Map<String, String> codigos = new HashMap<>();
        codigos.put("Licencia Anual Reglamentaria", "LAR");
        codigos.put("ELIMINADO", "E");
        codigos.put("Licencia por Estudio", "L/E");
        codigos.put("Certificado Médico", "C/M");
        codigos.put("Franco Compensatorio", "F/C");
        return codigos;
    }

    private String determinarPresenciaDia(LocalDate fecha, List<AsistenciaUsuario> asistencias, HistorialUsuario hu, Map<String, String> codigos) {
        // Obtener todos los registros de asistencia para esta fecha
        List<AsistenciaUsuario> asistenciasDia = asistencias.stream()
                .filter(a -> a.getFecha().equals(fecha))
                .collect(Collectors.toList());

        if (!asistenciasDia.isEmpty()) {
            // Determinar tipo de presencia por horarios
            boolean maniana = false;
            boolean tarde = false;

            for (AsistenciaUsuario asistencia : asistenciasDia) {
                if (esHorarioManiana(asistencia.getHorario())) {
                    maniana = true;
                } else {
                    tarde = true;
                }
            }

            if (maniana && tarde) return "P";
            if (maniana) return "P.M";
            return "P.T";
        } 
        else {
            // Manejar inasistencias
            return codigos.entrySet().stream()
                    .filter(entry -> hu.getRazonInactividad().startsWith(entry.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse("A"); // Ausencia no clasificada
        }
    }

    private boolean esHorarioManiana(LocalTime horario) {
        return horario.isBefore(LocalTime.NOON); // Ajustar según criterio horario
    }

    /**
     * Agrega una celda a la tabla con alineación específica.
     *
     * @param table      Tabla a la que se agregará la celda.
     * @param texto      Texto de la celda.
     * @param alineacion Alineación del texto.
     */
    private void agregarCelda(PdfPTable table, String texto, int alineacion) {
        PdfPCell cell = new PdfPCell(new Phrase(texto));
        cell.setHorizontalAlignment(alineacion);
        cell.setPadding(3); // Espacio interno en la celda
        table.addCell(cell);
    }

    /**
     * Agrega las firmas al final del documento.
     *
     * @param document Documento PDF.
     * @throws DocumentException Si ocurre un error al agregar contenido al documento.
     */
    private void agregarFirmas(Document document) throws DocumentException {
        // Espacio antes de las firmas
        document.add(new Paragraph("\n\n"));

        // Crear una tabla para las firmas
        PdfPTable firmasTable = new PdfPTable(2);
        firmasTable.setWidthPercentage(100); // La tabla ocupa el 100% del ancho de la página

        // Agregar la firma del Jefe de Departamento de Museo (izquierda)
        PdfPCell firmaIzquierda = new PdfPCell(new Phrase("-----------------------------------------------------\nJefe de Departamento de Museo"));
        firmaIzquierda.setBorder(Rectangle.NO_BORDER);
        firmaIzquierda.setHorizontalAlignment(Element.ALIGN_LEFT);
        firmasTable.addCell(firmaIzquierda);

        // Agregar la firma del Jefe de Personal de Museo (derecha)
        PdfPCell firmaDerecha = new PdfPCell(new Phrase("-----------------------------------------------------\nJefe de Personal de Museo"));
        firmaDerecha.setBorder(Rectangle.NO_BORDER);
        firmaDerecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
        firmasTable.addCell(firmaDerecha);

        // Agregar la tabla de firmas al documento
        document.add(firmasTable);
    }
    
    private void agregarReferencias(Document document) throws DocumentException {
        // Crear tabla con 1 sola columna
        PdfPTable referenciaTable = new PdfPTable(1);
        referenciaTable.setWidthPercentage(100);
        referenciaTable.setSpacingBefore(15f); // Espacio antes de las referencias

        // Configurar texto
        String texto = "REFERENCIAS:\n"
                + "P: Presente (Dos turnos); "
                + "P.M: Presente horario de mañana; "
                + "P.T: Presente horario de tarde; "
                + "A: Ausente; "
                + "F/C: Franco compensatorio; "
                + "LAR: Licencia Anual Reglamentaria; "
                + "C/M: Certificado Médico; "
                + "L/E: Licencia por Estudio;";

        // Crear celda con formato
        PdfPCell cell = new PdfPCell(new Phrase(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
        //cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        referenciaTable.addCell(cell);

        document.add(referenciaTable);
    }
    
    
    /**
     * Obtiene el número de días del mes.
     *
     * @param mes  Mes correspondiente (número del mes, 1-12).
     * @param anio Año correspondiente.
     * @return Número de días del mes.
     */
    private int obtenerDiasDelMes(int mes, int anio) {
        YearMonth yearMonth = YearMonth.of(anio, mes);
        return yearMonth.lengthOfMonth();
    }
}
