package com.museolba.vista.ventanaArtista;

import com.museolba.controlador.controladorArtista.ControladorArtista;
import com.museolba.modelo.entidades.artista.Artista;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.reportes.obra.ArtistaPDFGenerador;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import javax.swing.SwingUtilities;


public class VentanaArtista extends javax.swing.JPanel {
    private ControladorArtista controladorArtista = null;
    private final String[] titulos = {"ID", "Nombre", "Correo", "N° Telefono"};
    
    public VentanaArtista() {
        initComponents();
        controladorArtista = new ControladorArtista();
        cargarTabla();
        btnCargarDatosNuevamente.setVisible(false);
    }
    
    private void cargarTabla(){
        try {
            List<Artista> listaObra = controladorArtista.traerTodosLosArtistas();

            // Cargar la tabla usando el método utilitario
            ComponentesUtils.cargarTabla(tblArtista, listaObra, titulos, artista -> new Object[]{
                    artista.getId(),       
                    artista.getNombre(),      
                    artista.getCorreo(),        
                    artista.getnTelefono() 
            
            }, true);
            
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
        tblArtista = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnCargarDatosNuevamente = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Artista");

        tblArtista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblArtista);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Buscar");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-agregar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(90, 38));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setPreferredSize(new java.awt.Dimension(90, 38));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reportes.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setPreferredSize(new java.awt.Dimension(90, 38));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnCargarDatosNuevamente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/recargar.png"))); // NOI18N
        btnCargarDatosNuevamente.setText("Cargar Todos Los Datos");
        btnCargarDatosNuevamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosNuevamenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarDatosNuevamente, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnCargarDatosNuevamente, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
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
            FormArtista formArtista = new FormArtista(vP, true, false, null);
            formArtista.setLocationRelativeTo(vP);
            formArtista.setVisible(true);
            
            cargarTabla();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
            VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
            if(tblArtista.getRowCount()> 0){
                if(tblArtista.getSelectedRow()!=-1){
                    int filaSeleccionada = tblArtista.getSelectedRow();
                    long idArtista = (long) tblArtista.getValueAt(filaSeleccionada, 0);
                    Optional<Artista> artistaOptional = controladorArtista.buscarArtistaPorId(idArtista);
                    Artista artista = artistaOptional.orElse(null); 

                    if (artistaOptional.isPresent() && artista != null && vP != null){
                        FormArtista formArtista = new FormArtista(vP, true, true, artista);
                        
                        formArtista.setLocationRelativeTo(vP);
                        formArtista.setVisible(true);
                        cargarTabla();
                        
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
                    }
                }else{
                    DialogoUtils.mostrarMensaje("Debe seleccionar un artista para Modificar!", 1, "Atención");
                }
            }
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
        }
                
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            String terminoBusqueda = txtBuscar.getText();
            if (terminoBusqueda == null || terminoBusqueda.trim().isEmpty()) {
                DialogoUtils.mostrarMensaje("Por favor, ingrese un término de búsqueda.", 1, "Atención!");
                return; // Detiene la ejecución si el término está vacío o es nulo
            }

            List<Artista> listaObra = controladorArtista.buscarArtistaPorNombre(terminoBusqueda);

            if (listaObra.isEmpty()) {
                DialogoUtils.mostrarMensaje("No se encontraron artistas con el término: " + terminoBusqueda, 1, "Atención!");
                return;
            }

            ComponentesUtils.TableDataMapper<Artista> artistaMapper = artista -> {
                return new Object[]{
                    artista.getId(),       
                    artista.getNombre(),      
                    artista.getCorreo(),        
                    artista.getnTelefono() 
                };
            };

            // Cargar la tabla usando el método utilitario
            ComponentesUtils.cargarTabla(tblArtista, listaObra, titulos, artistaMapper, true);

            btnCargarDatosNuevamente.setVisible(true);
        } catch (Exception ex) {
            DialogoUtils.mostrarMensaje("Error al buscar artistas: " + ex.getMessage(), 2, "Error");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
         try{
        
            if(tblArtista.getRowCount()> 0){
                if(tblArtista.getSelectedRow()!=-1){
                    int filaSeleccionada = tblArtista.getSelectedRow();
                    long idArtista = (long) tblArtista.getValueAt(filaSeleccionada, 0);
                    Optional<Artista> artistaOptional = controladorArtista.buscarArtistaPorId(idArtista);
                    Artista artista = artistaOptional.orElse(null); 

                    if (artistaOptional.isPresent() && artista != null){
                        
                        try{
                            String url = "reportes/Obras/Obras_Por_Artista/ReporteObras.pdf";
                            ArtistaPDFGenerador.generarReporte(artista, artista.getObras(), url);
                            DialogoUtils.mostrarMensaje("Reporte generado correctamente en: "+url, 1, "Atención!");
                        }catch(Exception e){
                            DialogoUtils.mostrarMensaje("Error, no se pudo generar reporte: "+e.getMessage(), 2, "Error!");
                        }
                        
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
                    }
                }else{
                    DialogoUtils.mostrarMensaje("Debe seleccionar un artista para generar el reporte!", 1, "Atención");
                }
            }
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
        }
        
        
       
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnCargarDatosNuevamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosNuevamenteActionPerformed
        cargarTabla();
        btnCargarDatosNuevamente.setVisible(false);
    }//GEN-LAST:event_btnCargarDatosNuevamenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarDatosNuevamente;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTable tblArtista;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
