package com.museolba.utils.reportes.asistencias;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.museolba.modelo.entidades.CajaChica;
import com.museolba.modelo.entidades.Recibo;
import com.museolba.utils.DialogoUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CajaChicaPDFGenerador {
     /**
     * Genera el reporte de caja chica en PDF.
     *
     * @param filePath   Ruta donde se guardará el PDF.
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

            // Crear el documento en orientación vertical
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Agregar el título
            String nombreMes = obtenerNombreMes(cajaChica.getMes().getMonthValue());
            Paragraph titulo = new Paragraph("Gastos Caja Chica " + nombreMes + " " + cajaChica.getMes().getYear(),
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph("\n")); // Espacio después del título

            // Agregar el fondo inicial
            Paragraph fondoInicialParagraph = new Paragraph("Fondo Inicial: $" + cajaChica.getFondoInicial(),
                    FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK));
            document.add(fondoInicialParagraph);
            document.add(new Paragraph("\n")); // Espacio después del fondo inicial

            // Crear la tabla para los gastos
            PdfPTable table = new PdfPTable(5); // 4 columnas: Recibo, Nombre, Fecha, Responsable, Precio
            table.setWidthPercentage(100); // La tabla ocupa el 100% del ancho de la página
            table.setSpacingBefore(5f); // Espacio antes de la tabla
            table.setSpacingAfter(5f); // Espacio después de la tabla

            // Configurar el ancho de las columnas
            float[] columnWidths = {1.5f, 4f, 3f, 2f, 4f};
            table.setWidths(columnWidths);

            // Agregar las cabeceras de la tabla
            agregarCabecerasTabla(table);

            // Agregar los gastos a la tabla
            double totalGastos = 0;
            for (Recibo recibo : cajaChica.getRecibos()) {
                agregarFilaRecibo(table, recibo);
                totalGastos += recibo.getPrecioTotal();
            }

            // Agregar la tabla al documento
            document.add(table);

            // Agregar el total de gastos y el saldo sobrante
            Paragraph totalGastosParagraph = new Paragraph("Total Gastos: $" + totalGastos,
                    FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK));
            document.add(totalGastosParagraph);

            double saldoSobrante = cajaChica.getFondoInicial() - totalGastos;
            Paragraph saldoSobranteParagraph = new Paragraph("Saldo Sobrante: $" + saldoSobrante,
                    FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK));
            document.add(saldoSobranteParagraph);

            // Agregar las firmas al final del documento
            agregarFirmas(document);

            // Cerrar el documento
            document.close();
            
            DialogoUtils.mostrarMensaje("Reporte PDF generado exitosamente en: " + filePath, 1, "Exito");
           

        } catch (Exception e) {
            e.printStackTrace();
            DialogoUtils.mostrarMensaje("Error al generar el reporte PDF: " + e.getMessage(), 2, "Error");
        }
    }

    /**
     * Agrega las cabeceras de la tabla.
     *
     * @param table Tabla a la que se agregarán las cabeceras.
     */
    private void agregarCabecerasTabla(PdfPTable table) {
        agregarCelda(table, "Recibo", Element.ALIGN_CENTER);
        agregarCelda(table, "Nombre", Element.ALIGN_CENTER);
        agregarCelda(table, "Fecha", Element.ALIGN_CENTER);
        agregarCelda(table, "Responsable", Element.ALIGN_CENTER);
        agregarCelda(table, "Precio", Element.ALIGN_CENTER);
    }

    /**
     * Agrega una fila con los datos de un recibo a la tabla.
     *
     * @param table  Tabla a la que se agregará la fila.
     * @param recibo Recibo a agregar.
     */
    private void agregarFilaRecibo(PdfPTable table, Recibo recibo) {
        agregarCelda(table, recibo.getId().toString(), Element.ALIGN_CENTER);
        agregarCelda(table, recibo.getNombre(), Element.ALIGN_LEFT);
        agregarCelda(table, recibo.getFechaRegistro().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), Element.ALIGN_CENTER);
        agregarCelda(table, recibo.getResponsable().toString(), Element.ALIGN_CENTER);
        agregarCelda(table, "$" + recibo.getPrecioTotal(), Element.ALIGN_RIGHT);
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
        cell.setPadding(5); // Espacio interno en la celda
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
        PdfPCell firmaIzquierda = new PdfPCell(new Phrase("_________________________\nJefe de Departamento de Museo"));
        firmaIzquierda.setBorder(Rectangle.NO_BORDER);
        firmaIzquierda.setHorizontalAlignment(Element.ALIGN_LEFT);
        firmasTable.addCell(firmaIzquierda);

        // Agregar la firma del Jefe de Personal de Museo (derecha)
        PdfPCell firmaDerecha = new PdfPCell(new Phrase("_________________________\nJefe de Personal de Museo"));
        firmaDerecha.setBorder(Rectangle.NO_BORDER);
        firmaDerecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
        firmasTable.addCell(firmaDerecha);

        // Agregar la tabla de firmas al documento
        document.add(firmasTable);
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
