package com.museolba.utils.reportes.obra;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.museolba.modelo.entidades.artista.Artista;
import com.museolba.modelo.entidades.obra.Obra;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

public class ArtistaPDFGenerador {
    

    public static void generarReporte(Artista artista, List<Obra> obras, String pdfPath) {
        try {
            // Crear directorio si no existe
            File file = new File(pdfPath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean dirCreated = parentDir.mkdirs();
                if (!dirCreated) {
                    System.out.println("No se pudo crear el directorio: " + parentDir.getAbsolutePath());
                    return;
                }
            }
            
            // Crear el PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            // Primera página: Título principal
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18); // Fuente grande y negrita
            Paragraph titulo = new Paragraph("Obras de " + artista.getNombre(), tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Salto de página
            document.newPage();

            // Segunda página: Información del artista
            Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12); // Fuente normal
            document.add(new Paragraph("Información del Artista:", tituloFont));
            document.add(new Paragraph("Nombre: " + artista.getNombre(), infoFont));
            document.add(new Paragraph("Número de Telefono: " + artista.getnTelefono(), infoFont));
            document.add(new Paragraph("Correo: " + artista.getCorreo(), infoFont));

            // Salto de página
            document.newPage();

            // Páginas siguientes: Lista de obras
            Font tituloObraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14); // Fuente mediana y negrita
            for (Obra obra : obras) {
                // Título de la obra
                Paragraph tituloObra = new Paragraph(obra.getTitulo(), tituloObraFont);
                tituloObra.setAlignment(Element.ALIGN_CENTER);
                document.add(tituloObra);

                // Descargar la imagen desde la URL
                if (obra.getImagenUrl() != null && !obra.getImagenUrl().isEmpty()) {
                    URL url = new URL(obra.getImagenUrl());
                    Image image = Image.getInstance(url);
                    image.scaleToFit(300, 300); // Redimensionar la imagen
                    image.setAlignment(Element.ALIGN_CENTER);
                    document.add(image);
                }

                // Información de la obra
                document.add(new Paragraph("Artista: " + obra.getArtista().getNombre()));
                document.add(new Paragraph("Tipo: " + obra.getTipoObra().toString()));
                document.add(new Paragraph("Altura: " + obra.getAltura()));
                document.add(new Paragraph("Ancho: " + obra.getAncho()));
                document.add(new Paragraph("Fecha de Entrada: " + obra.getFechaEntrada()));
                document.add(new Paragraph("Sala: " + obra.getSala().getNombre()));
                document.add(new Paragraph("Estado Obra: " + obra.getEstadoObra().toString()));
                document.add(new Paragraph("Estado Expo: " + obra.getEstadoExpo().toString()));
                document.add(new Paragraph("Descripción: " + obra.getDescripcion()));

                // Salto de página entre obras
                document.newPage();
            }

            // Cerrar el documento
            document.close();

            System.out.println("Reporte generado correctamente en: " + pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}

