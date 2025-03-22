package com.museolba.utils.reportes.cajaChica;

import com.museolba.modelo.entidades.cajaChica.Recibo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.utils.DialogoUtils;
import org.apache.poi.ss.util.CellRangeAddress;


public class CajaChicaExcelGenerador {
    /**
     * Genera el reporte de caja chica en Excel.
     *
     * @param filePath   Ruta donde se guardará el archivo Excel.
     * @param cajaChica  Objeto CajaChica con los datos del reporte.
     */
    public void generarReporteCajaChica(String filePath, CajaChica cajaChica) {
        try {
            // Crear directorio si no existe
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean dirCreated = parentDir.mkdirs();
                if (!dirCreated) {
                    System.out.println("No se pudo crear el directorio: " + parentDir.getAbsolutePath());
                    return;
                }
            }

            // Crear el libro de trabajo y la hoja
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Caja Chica " + obtenerNombreMes(cajaChica.getMes().getMonthValue()) + " " + cajaChica.getMes().getYear());

            // Configurar estilos
            CellStyle headerStyle = crearEstiloEncabezado(workbook);
            CellStyle dataStyle = crearEstiloDatos(workbook);
            CellStyle titleStyle = crearEstiloTitulo(workbook);

            // Agregar el título
            Row titleRow = sheet.createRow(0);
            crearTitulo(titleRow, sheet, cajaChica.getMes().getMonthValue(), cajaChica.getMes().getYear(), titleStyle);

            // Agregar el fondo inicial
            Row fondoInicialRow = sheet.createRow(1);
            crearFondoInicial(fondoInicialRow, sheet, cajaChica.getFondoInicial(), dataStyle);

            // Crear encabezados de la tabla
            Row headerRow = sheet.createRow(2);
            crearEncabezados(headerRow, headerStyle);

            // Agregar los recibos a la tabla
            int rowNum = 3;
            double totalGastos = 0;
            for (Recibo recibo : cajaChica.getRecibos()) {
                Row dataRow = sheet.createRow(rowNum++);
                agregarFilaRecibo(dataRow, recibo, dataStyle);
                totalGastos += recibo.getPrecioTotal();
            }

            // Agregar el total de gastos y el saldo sobrante
            Row totalGastosRow = sheet.createRow(rowNum++);
            crearTotalGastos(totalGastosRow, sheet, totalGastos, dataStyle);

            Row saldoSobranteRow = sheet.createRow(rowNum);
            crearSaldoSobrante(saldoSobranteRow, sheet, cajaChica.getFondoInicial() - totalGastos, dataStyle);

            // Ajustar anchos de columnas
            ajustarAnchosColumnas(sheet);

            // Escribir el archivo
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
            
            DialogoUtils.mostrarMensaje("Reporte Excel generado exitosamente en: " + filePath, 1, "Exito!");

        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al generar el reporte Excel: " + e.getMessage(), 2, "Error!");
        }
    }

    /**
     * Crea el título del reporte.
     *
     * @param titleRow  Fila donde se agregará el título.
     * @param sheet     Hoja de trabajo.
     * @param mes       Mes correspondiente.
     * @param anio      Año correspondiente.
     * @param style     Estilo del título.
     */
    private void crearTitulo(Row titleRow, Sheet sheet, int mes, int anio, CellStyle style) {
        Cell cell = titleRow.createCell(0);
        cell.setCellValue("Gastos Caja Chica " + obtenerNombreMes(mes) + " " + anio);
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4)); // Fusionar celdas para el título
    }

    /**
     * Crea la fila del fondo inicial.
     *
     * @param fondoInicialRow Fila donde se agregará el fondo inicial.
     * @param sheet           Hoja de trabajo.
     * @param fondoInicial    Fondo inicial de la caja chica.
     * @param style           Estilo de la celda.
     */
    private void crearFondoInicial(Row fondoInicialRow, Sheet sheet, double fondoInicial, CellStyle style) {
        Cell cell = fondoInicialRow.createCell(0);
        cell.setCellValue("Fondo Inicial: $" + fondoInicial);
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 4)); // Fusionar celdas para el fondo inicial
    }

    /**
     * Crea los encabezados de la tabla.
     *
     * @param headerRow Fila donde se agregarán los encabezados.
     * @param style     Estilo de los encabezados.
     */
    private void crearEncabezados(Row headerRow, CellStyle style) {
        String[] columnas = {"Recibo", "Nombre", "Fecha", "Responsable", "Precio"};
        for (int i = 0; i < columnas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnas[i]);
            cell.setCellStyle(style);
        }
    }

    /**
     * Agrega una fila con los datos de un recibo.
     *
     * @param dataRow Fila donde se agregarán los datos.
     * @param recibo  Recibo a agregar.
     * @param style   Estilo de las celdas.
     */
    private void agregarFilaRecibo(Row dataRow, Recibo recibo, CellStyle style) {
        dataRow.createCell(0).setCellValue(recibo.getId().toString());
        dataRow.createCell(1).setCellValue(recibo.getNombre());
        dataRow.createCell(2).setCellValue(recibo.getFechaRegistro().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dataRow.createCell(3).setCellValue(recibo.getResponsable().toString());
        Cell precioCell = dataRow.createCell(4);
        precioCell.setCellValue(recibo.getPrecioTotal());
        precioCell.setCellStyle(style);
    }

    /**
     * Crea la fila del total de gastos.
     *
     * @param totalGastosRow Fila donde se agregará el total de gastos.
     * @param sheet          Hoja de trabajo.
     * @param totalGastos    Total de gastos.
     * @param style          Estilo de la celda.
     */
    private void crearTotalGastos(Row totalGastosRow, Sheet sheet, double totalGastos, CellStyle style) {
        Cell cell = totalGastosRow.createCell(0);
        cell.setCellValue("Total Gastos: $" + totalGastos);
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(totalGastosRow.getRowNum(), totalGastosRow.getRowNum(), 0, 4)); // Fusionar celdas
    }

    /**
     * Crea la fila del saldo sobrante.
     *
     * @param saldoSobranteRow Fila donde se agregará el saldo sobrante.
     * @param sheet            Hoja de trabajo.
     * @param saldoSobrante    Saldo sobrante.
     * @param style            Estilo de la celda.
     */
    private void crearSaldoSobrante(Row saldoSobranteRow, Sheet sheet, double saldoSobrante, CellStyle style) {
        Cell cell = saldoSobranteRow.createCell(0);
        cell.setCellValue("Saldo Sobrante: $" + saldoSobrante);
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(saldoSobranteRow.getRowNum(), saldoSobranteRow.getRowNum(), 0, 4)); // Fusionar celdas
    }

    /**
     * Ajusta los anchos de las columnas.
     *
     * @param sheet Hoja de trabajo.
     */
    private void ajustarAnchosColumnas(Sheet sheet) {
        sheet.setColumnWidth(0, 15 * 256); // Recibo
        sheet.setColumnWidth(1, 30 * 256); // Nombre
        sheet.setColumnWidth(2, 15 * 256); // Fecha
        sheet.setColumnWidth(3, 20 * 256); // Responsable
        sheet.setColumnWidth(4, 15 * 256); // Precio
    }

    /**
     * Crea un estilo para el título.
     *
     * @param workbook Libro de trabajo.
     * @return Estilo del título.
     */
    private CellStyle crearEstiloTitulo(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    /**
     * Crea un estilo para los encabezados.
     *
     * @param workbook Libro de trabajo.
     * @return Estilo de los encabezados.
     */
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

    /**
     * Crea un estilo para los datos.
     *
     * @param workbook Libro de trabajo.
     * @return Estilo de los datos.
     */
    private CellStyle crearEstiloDatos(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    /**
     * Obtiene el nombre del mes a partir de su número.
     *
     * @param mes Número del mes (1-12).
     * @return Nombre del mes.
     */
    private String obtenerNombreMes(int mes) {
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return nombresMeses[mes - 1];
    }
}
