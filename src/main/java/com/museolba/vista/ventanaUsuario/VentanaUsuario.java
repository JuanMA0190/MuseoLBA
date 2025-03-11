package com.museolba.vista.ventanaUsuario;

import com.museolba.controlador.controladorUsuario.ControladorHistorialUsuario;
import com.museolba.controlador.controladorUsuario.ControladorUsuario;
import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.utils.UtilsValidacion;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class VentanaUsuario extends javax.swing.JPanel {
    ControladorHistorialUsuario controladorHistorialUsuario = null;
    ControladorUsuario controladorUsuario = null;
    String[] titulos = {"Número Legajo", "Nombre", "Rol", "Estado", "Fecha Creación", "Fecha Modificación",
                "Fecha Eliminación", "Fecha Alta", "Fecha Baja", "Razon Inactividad"};
   
    public VentanaUsuario() {
        controladorHistorialUsuario = new ControladorHistorialUsuario();
        controladorUsuario = new ControladorUsuario();
        initComponents();
        cargarTablaUsuario();
        cargarOpcionesFiltro();
        btnCargarTodosDatos.setVisible(false);
    }
    
    private void cargarTablaUsuario(){
       controladorHistorialUsuario.cargarTablaHistorial(tblUsuario, titulos);
    }
    
    private void cargarOpcionesFiltro() {
        cmbFiltro.removeAllItems();
        cmbFiltro.addItem("Nombre");
        cmbFiltro.addItem("Rol");
        cmbFiltro.addItem("Estado");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        cmbFiltro = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnCargarTodosDatos = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActivo = new javax.swing.JButton();
        btnInactivo = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Usuario");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setPreferredSize(new java.awt.Dimension(90, 38));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Buscar");

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Seleccionar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCargarTodosDatos.setText("Volver a Cargar Todos los Datos");
        btnCargarTodosDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarTodosDatos.setPreferredSize(new java.awt.Dimension(90, 38));
        btnCargarTodosDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTodosDatosActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActivo.setText("Activo");
        btnActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivo.setPreferredSize(new java.awt.Dimension(90, 38));
        btnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivoActionPerformed(evt);
            }
        });

        btnInactivo.setText("Inactivo");
        btnInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInactivo.setPreferredSize(new java.awt.Dimension(90, 38));
        btnInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivoActionPerformed(evt);
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
                            .addComponent(btnCargarTodosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargarTodosDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        controladorHistorialUsuario.buscarYMostrarResultados((String) cmbFiltro.getSelectedItem(), txtBuscar.getText().trim(), tblUsuario, titulos);
        txtBuscar.setText("");
        btnCargarTodosDatos.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCargarTodosDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTodosDatosActionPerformed
        controladorHistorialUsuario.cargarTablaHistorial(tblUsuario, titulos);
        btnCargarTodosDatos.setVisible(false);
    }//GEN-LAST:event_btnCargarTodosDatosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblUsuario.getRowCount()> 0){
            if(tblUsuario.getSelectedRow()!=-1){
                // Mostrar el cuadro de diálogo de confirmación
                int opcion = JOptionPane.showConfirmDialog(
                    null, 
                    "¿Está seguro de que desea eliminar este usuario?", 
                    "Confirmación de eliminación", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    String mensaje = controladorUsuario.cambiarEstadoHistorialYUsuario( (long) tblUsuario.getValueAt(tblUsuario.getSelectedRow(), 0), "ELIMINADO: Usuario eliminado permanentemente.", 0);
                    JOptionPane.showMessageDialog(null, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                    cargarTablaUsuario();
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }else{
                UtilsValidacion.MsjAlert("Debe seleccionar un usuario para eliminar!", 2, "Error");
            }
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
        if(tblUsuario.getRowCount()> 0){
            if(tblUsuario.getSelectedRow()!=-1){
                if(vP != null){
                    int filaSeleccionada = tblUsuario.getSelectedRow();
                    long nLegajo = (long) tblUsuario.getValueAt(filaSeleccionada, 0);
                    
                    Usuario usuario = controladorUsuario.obtenerUsuario(nLegajo);
                    
                    if(usuario != null){
                        FormUsuario formUsuario = new FormUsuario(vP, true, true, usuario);
                        formUsuario.setVisible(true);
                        cargarTablaUsuario();
                    }else{
                        UtilsValidacion.MsjAlert("No se encontró el personal seleccionado.", 2, "Error");
                    }     
                }
            }else{
                UtilsValidacion.MsjAlert("Debe seleccionar un usuario para Modificar!", 2, "Error");
            }
        }   
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivoActionPerformed
        if(tblUsuario.getRowCount()> 0){
            if(tblUsuario.getSelectedRow()!=-1){
                int filaSeleccionada = tblUsuario.getSelectedRow();
                long nLegajo = (long) tblUsuario.getValueAt(filaSeleccionada, 0);
                Usuario usuario = controladorUsuario.obtenerUsuario(nLegajo);
                if(usuario != null){
                    UtilsValidacion.MsjAlert(controladorUsuario.cambiarEstadoHistorialYUsuario(nLegajo, "-", 1),1,"Atencion");
                    cargarTablaUsuario();
                }else{
                    UtilsValidacion.MsjAlert("No se encontró el personal seleccionado.", 2, "Error");
                } 
            }
        }    
    }//GEN-LAST:event_btnActivoActionPerformed

    private void btnInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivoActionPerformed
        VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
        if(tblUsuario.getRowCount()> 0){
            if(tblUsuario.getSelectedRow()!=-1){
                 if(vP != null){
                    int filaSeleccionada = tblUsuario.getSelectedRow();
                    long nLegajo = (long) tblUsuario.getValueAt(filaSeleccionada, 0);
                    
                    Usuario usuario = controladorUsuario.obtenerUsuario(nLegajo);
                    if(usuario != null){
                        FormBaja formBaja = new FormBaja(vP, true, nLegajo);
                        formBaja.setVisible(true);
                        cargarTablaUsuario();
                    }else{
                        UtilsValidacion.MsjAlert("No se encontró el personal seleccionado.", 2, "Error");
                    } 
                }    
            }
        }    
    }//GEN-LAST:event_btnInactivoActionPerformed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        int row = tblUsuario.rowAtPoint(evt.getPoint());
        if (row >= 0) {
            EstadoPersonal estado = (EstadoPersonal) tblUsuario.getValueAt(row, tblUsuario.getColumnModel().getColumnIndex("Estado"));
            actualizarBotones(estado);
        }
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void actualizarBotones(EstadoPersonal estado) {
        if (estado == estado.ACTIVO) {
            btnActivo.setEnabled(false);
            btnInactivo.setEnabled(true);
        } else if (estado == estado.INACTIVO) {
            btnActivo.setEnabled(true);
            btnInactivo.setEnabled(false);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarTodosDatos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInactivo;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
