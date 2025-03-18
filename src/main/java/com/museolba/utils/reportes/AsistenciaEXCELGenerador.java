package com.museolba.utils.reportes;

import com.museolba.controlador.controladorUsuario.ControladorHistorialUsuario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.museolba.modelo.entidades.*;

import java.io.FileOutputStream;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import org.apache.poi.ss.util.CellRangeAddress;

public class AsistenciaEXCELGenerador {
    private static final Map<String, String> CODIGOS_INASISTENCIA = crearMapeoInasistencias();
     
    private ControladorHistorialUsuario controladorHU = new ControladorHistorialUsuario();
     
    private static final String[] REFERENCIAS = {
        "REFERENCIAS:", 
        "P: Presente (Dos turnos)", 
        "P.M: Presente horario de mañana",
        "P.T: Presente horario de tarde",
        "A: Ausente",
        "F/C: Franco compensatorio",
        "LAR: Licencia Anual Reglamentaria",
        "C/M: Certificado Médico",
        "L/E: Licencia por Estudio"
    };

    public void generarReporteExcel(String filePath, List<AsistenciaUsuario> asistencias, int mes, int anio) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Asistencia " + obtenerNombreMes(mes));

            // Configurar estilos
            CellStyle headerStyle = crearEstiloEncabezado(workbook);
            CellStyle dataStyle = crearEstiloDatos(workbook);
            CellStyle centeredStyle = crearEstiloCentrado(workbook);
            CellStyle titleStyle = crearEstiloTitulo(workbook);
            
            // Agregar título
            Row titleRow = sheet.createRow(0);
            crearTitulo(titleRow, sheet, mes, anio, titleStyle);
            
            // Crear encabezados
            int rowNum = 1;
            Row headerRow = sheet.createRow(rowNum++);
            crearEncabezados(headerRow, headerStyle, mes, anio);

            // Agrupar datos por usuario
            Map<Usuario, List<AsistenciaUsuario>> asistenciasPorUsuario = asistencias.stream()
                    .collect(Collectors.groupingBy(AsistenciaUsuario::getUsuario));

            // Llenar datos
            for (Map.Entry<Usuario, List<AsistenciaUsuario>> entry : asistenciasPorUsuario.entrySet()) {
                Row dataRow = sheet.createRow(rowNum++);
                agregarFilaUsuario(dataRow, entry.getKey(), entry.getValue(), dataStyle, mes, anio);
            }

            // Agregar referencias
            agregarReferencias(sheet, rowNum++, centeredStyle);
            
            // Agregar firmas
            agregarFirmas(sheet, rowNum, centeredStyle);

            // Ajustar anchos de columnas
            ajustarAnchosColumnas(sheet, mes, anio);

            // Escribir archivo
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Reporte Excel generado exitosamente en: " + filePath);

        } catch (Exception e) {
            System.err.println("Error al generar el reporte Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    private void crearTitulo(Row titleRow, Sheet sheet, int mes, int anio, CellStyle style) {
        Cell cell = titleRow.createCell(0);
        cell.setCellValue("Asistencia del mes " + obtenerNombreMes(mes) + " " + anio);
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3 + YearMonth.of(anio, mes).lengthOfMonth()));
    }
    
    private void agregarReferencias(Sheet sheet, int rowNum, CellStyle style) {
        Row refRow = sheet.createRow(rowNum);

        for (int i = 0; i < REFERENCIAS.length; i++) {
            Cell cell = refRow.createCell(i);
            cell.setCellValue(REFERENCIAS[i]);
            cell.setCellStyle(style);
        }
    }
    
    private void agregarFirmas(Sheet sheet, int rowNum, CellStyle style) {
        // Espacio antes de firmas
        Row espacioRow = sheet.createRow(rowNum++);
        
        // Fila de firmas
        Row firmaRow = sheet.createRow(rowNum++);
        crearCelda(firmaRow, 0, "_________________________", style);
        crearCelda(firmaRow, 3 + YearMonth.of(2024, 3).lengthOfMonth() - 2, "_________________________", style);

        // Texto firmas
        Row textoRow = sheet.createRow(rowNum);
        crearCelda(textoRow, 0, "Jefe de Departamento de Museo", style);
        crearCelda(textoRow, 3 + YearMonth.of(2024, 3).lengthOfMonth() - 2, "Jefe de Personal de Museo", style);
    }
    
    private CellStyle crearEstiloTitulo(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private void crearEncabezados(Row headerRow, CellStyle style, int mes, int anio) {
        String[] columnasFijas = {"Nombre y Apellido", "Número de Legajo", "DNI", "Horario"};
        int dia = 0;
        
        // Columnas fijas
        for (int i = 0; i < columnasFijas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnasFijas[i]);
            cell.setCellStyle(style);
        }

        // Días del mes
        int diasMes = YearMonth.of(anio, mes).lengthOfMonth();
        for (int i = 0; i < diasMes; i++) {
            Cell cell = headerRow.createCell(columnasFijas.length + i);
            cell.setCellValue((i + 1) + "");
            cell.setCellStyle(style);
        }
    }

    private void agregarFilaUsuario(Row row, Usuario usuario, List<AsistenciaUsuario> asistencias, CellStyle style, int mes, int anio) {
        // Datos fijos
        crearCelda(row, 0, usuario.getNombre() + " " + usuario.getApellido(), style);
        crearCelda(row, 1, String.valueOf(usuario.getnLegajo()), style);
        crearCelda(row, 2, usuario.getDni(), style);
        crearCelda(row, 3, "Discontinuo", style);

        // Procesar días
        HistorialUsuario hu = controladorHU.obtenerHistorialPorUsuario(usuario.getnLegajo());
        int diasMes = YearMonth.of(anio, mes).lengthOfMonth();
        
        for (int dia = 1; dia <= diasMes; dia++) {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            String valor = determinarPresenciaDia(fecha, asistencias, hu);
            crearCelda(row, 3 + dia, valor, style);
        }
    }

    private String determinarPresenciaDia(LocalDate fecha, List<AsistenciaUsuario> asistencias, HistorialUsuario hu) {
        List<AsistenciaUsuario> asistenciasDia = asistencias.stream()
                .filter(a -> a.getFecha().equals(fecha))
                .toList();

        if (!asistenciasDia.isEmpty()) {
            boolean maniana = false, tarde = false;
            for (AsistenciaUsuario a : asistenciasDia) {
                if (esHorarioManiana(a.getHorario())) maniana = true;
                else tarde = true;
            }
            if (maniana && tarde) return "P";
            if (maniana) return "P.M";
            return "P.T";
        }
        return CODIGOS_INASISTENCIA.entrySet().stream()
                .filter(e -> hu.getRazonInactividad().startsWith(e.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse("A");
    }

    private boolean esHorarioManiana(LocalTime horario) {
        return horario.isBefore(LocalTime.NOON);
    }

    private CellStyle crearEstiloEncabezado(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        return style;
    }

    private CellStyle crearEstiloDatos(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    private CellStyle crearEstiloCentrado(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        return style;
    }

    private void ajustarAnchosColumnas(Sheet sheet, int mes, int anio) {
        // Anchos fijos para las primeras columnas
        sheet.setColumnWidth(0, 25 * 256);   // Nombre
        sheet.setColumnWidth(1, 15 * 256);   // Legajo
        sheet.setColumnWidth(2, 15 * 256);   // DNI
        sheet.setColumnWidth(3, 12 * 256);   // Horario

        // Ancho para días
        int dias = YearMonth.of(anio, mes).lengthOfMonth();
        for (int i = 4; i < 4 + dias; i++) {
            sheet.setColumnWidth(i, 5 * 256);
        }
    }

    private static Map<String, String> crearMapeoInasistencias() {
        return Map.of(
            "Licencia Anual Reglamentaria", "LAR",
            "ELIMINADO", "E",
            "Licencia por Estudio", "L/E",
            "Certificado Médico", "C/M",
            "Franco Compensatorio", "F/C"
        );
    }

    private String obtenerNombreMes(int mes) {
        return new DateFormatSymbols(Locale.getDefault()).getMonths()[mes - 1];
    }

    private void crearCelda(Row row, int column, String value, CellStyle style) {
        Cell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
}
