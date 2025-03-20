package com.museolba.vista.ventanaObra;

import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.modelo.entidades.obras.Obra;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.ComponentesUtils.TableDataMapper;
import com.museolba.utils.DialogoUtils;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.SwingUtilities;


public class VentanaObra extends javax.swing.JPanel {
    String titulos[] = {"Titulo", "Artista", "Tipo Obra", "Fecha Registro", "Sala"};
    ControladorObra controladorObra = null;
   
    public VentanaObra() {
        initComponents();
        this.controladorObra = new ControladorObra();
        cargarTabla();
        
        
    }
        
    private void cargarTabla(){
        try {
            // Obtener la lista de obras desde el controlador
            List<Obra> listaObra = controladorObra.todasObras();

            // Formateador de fecha
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            // Mapper para convertir Obra a fila de la tabla
            TableDataMapper<Obra> obraMapper = obra -> {
                String fechaFormateada = obra.getFechaEntrada().format(formatter); // Formatear la fecha
                return new Object[]{
                    obra.getTitulo(),       // Título de la obra
                    obra.getArtista(),      // Artista (String)
                    obra.getTipoObra(),
                    fechaFormateada,        // Fecha de registro formateada
                    obra.getSala().getNombre() // Nombre de la sala
                };
            };

            // Cargar la tabla usando el método utilitario
            ComponentesUtils.cargarTabla(tblObra, listaObra, titulos, obraMapper);
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
        btnModificar1 = new javax.swing.JButton();

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

        btnModificar1.setText("Eliminar");
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            FormObra formRecibo = new FormObra(vP, true, false, null);
            
            formRecibo.setVisible(true);
            formRecibo.setLocationRelativeTo(vP);
            
            cargarTabla();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tblObra.getRowCount()> 0){
            if(tblObra.getSelectedRow()!=-1){
                int filaSeleccionada = tblObra.getSelectedRow();
                Obra obra = controladorObra.buscarObraPorId((long)filaSeleccionada+1);
                VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
               if(vP != null){
                    FormObra formObra = new FormObra(vP, true, true, obra);
                    
                    
                    formObra.setVisible(true);
                    formObra.setLocationRelativeTo(vP);

                      


                    cargarTabla();
                }
            }
        }    
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        if(tblObra.getRowCount()> 0){
            if(tblObra.getSelectedRow()!=-1){
                int filaSeleccionada = tblObra.getSelectedRow();
                Obra obra = controladorObra.buscarObraPorId((long)filaSeleccionada+1);
                controladorObra.eliminarObra(obra.getNumInv());
                cargarTabla();
            }
        }    
    }//GEN-LAST:event_btnModificar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblObra;
    // End of variables declaration//GEN-END:variables
}
