package com.museolba.vista.ventanaObra;

import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.ComponentesUtils.TableDataMapper;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.reportes.obra.TodasObraPDFGenerador;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.swing.SwingUtilities;


public class VentanaObra extends javax.swing.JPanel {
   ControladorObra controladorObra = null;
   String[] titulos = {"Num. Inv.", "Titulo", "Artista", "Tipo", "Fecha", "Sala", "Exposicion"};
   
    public VentanaObra() {
        initComponents();
        controladorObra = new ControladorObra();
        
        cargarTabla(); 
    }
        
    private void cargarTabla(){
        try {
            // Obtener la lista de obras desde el controlador
            List<Obra> listaObra = controladorObra.obtenerTodasLasObras();

            // Formateador de fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            // Mapper para convertir Obra a fila de la tabla
            TableDataMapper<Obra> obraMapper = obra -> {
                String fechaFormateada = obra.getFechaEntrada().format(formatter); // Formatear la fecha
                return new Object[]{
                    obra.getNumInv(),
                    obra.getTitulo(),       
                    obra.getArtista().getNombre(),      
                    obra.getTipoObra(),
                    fechaFormateada,        
                    obra.getSala().getNombre(),
                    obra.getEstadoExpo()
                };
            };

            // Cargar la tabla usando el método utilitario
            ComponentesUtils.cargarTabla(tblObra, listaObra, titulos, obraMapper, true);
        } catch (NoResultException e) {
            DialogoUtils.mostrarMensaje("Error al cargar la tabla: " + e.getMessage(), 2, "Error");
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObra = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Obra");

        tblObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblObra);

        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(90, 38));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
       VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
       if(vP != null){
            FormObra formObra = new FormObra(vP, true, false, null);
            
            formObra.setLocationRelativeTo(vP);
            formObra.setVisible(true);
            
            cargarTabla();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
            VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
            
            if(tblObra.getRowCount()> 0){
                if(tblObra.getSelectedRow()!=-1){
                    int filaSeleccionada = tblObra.getSelectedRow();
                    long idObra = (long) tblObra.getValueAt(filaSeleccionada, 0);
                    
                    
                    Optional<Obra> obraOptional = controladorObra.obtenerObraPorIdConRelaciones(idObra);
                    Obra obra = obraOptional.orElse(null);

                    if (obraOptional.isPresent() && obra != null && vP != null){
                        FormObra formObra = new FormObra(vP, true, true, obra);

                        formObra.setVisible(true);
                        formObra.setLocationRelativeTo(vP);

                        cargarTabla();
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
                    }
                }else{
                    DialogoUtils.mostrarMensaje("Debe seleccionar una obra para Modificar!", 1, "Atención");
                }
            }  
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("No se encontró la obra seleccionada", 1, "Atención!");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try{
            List<Obra> listaObra = controladorObra.obtenerTodasLasObras();
            String url = "reportes/Obras/Todas_Las_Obras/ReporteObras.pdf";
            TodasObraPDFGenerador.generarReporte(listaObra,url );
            DialogoUtils.mostrarMensaje("Reporte generado correctamente en: "+url, 1, "Atención!");
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("Error, no se pudo generar reporte: "+e.getMessage(), 2, "Error!");
        }
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblObra;
    // End of variables declaration//GEN-END:variables
}
