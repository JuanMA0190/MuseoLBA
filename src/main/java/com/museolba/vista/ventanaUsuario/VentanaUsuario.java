package com.museolba.vista.ventanaUsuario;

import com.museolba.controlador.controladorUsuario.ControladorHistorialUsuario;
import com.museolba.controlador.controladorUsuario.ControladorUsuario;
import com.museolba.modelo.entidades.personal.EstadoPersonal;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class VentanaUsuario extends javax.swing.JPanel {
    ControladorHistorialUsuario controladorHistorialUsuario = null;
    ControladorUsuario controladorUsuario = null;
    String[] titulos = {"Número Legajo", "Nombre", "Rol", "Estado", "Fecha Creación", "Fecha Modificación",
                "Fecha Eliminación", "Fecha Alta", "Fecha Baja", "Razon Inactividad"};
    boolean isSelectedAOption = false;
   
    public VentanaUsuario() {
        controladorHistorialUsuario = new ControladorHistorialUsuario();
        controladorUsuario = new ControladorUsuario();
        initComponents();
        cargarTodosLosDatosTabla();
        cargarOpcionesFiltro();
        btnCargarTodosDatos.setVisible(false);
        cmbOpcion.setVisible(false);
        
    }
    
    private void cargarTablaUsuario(List<Object[]> datos, String[] titulos){
       try{
           ComponentesUtils.cargarTabla(tblUsuario, datos, titulos, fila -> {
            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

                for (int i = 0; i < fila.length; i++) {
                    if (fila[i] instanceof LocalDateTime) {
                        LocalDateTime fecha = (LocalDateTime) fila[i];
                        String fechaFormateada = fecha.format(formatterFecha);
                        String horaFormateada = fecha.format(formatterHora);
                        fila[i] = fechaFormateada + " " + horaFormateada;
                    }
                }
                return fila;
            }, true);
       }catch(NoResultException e){
           DialogoUtils.mostrarMensaje(e.getMessage(), 2, "Error");
       }
        

        
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
        cmbOpcion = new javax.swing.JComboBox<>();
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

        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCargarTodosDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/recargar.png"))); // NOI18N
        btnCargarTodosDatos.setText("Volver a Cargar Todos los Datos");
        btnCargarTodosDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarTodosDatos.setPreferredSize(new java.awt.Dimension(90, 38));
        btnCargarTodosDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTodosDatosActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario-activo.png"))); // NOI18N
        btnActivo.setText("Activo");
        btnActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivo.setPreferredSize(new java.awt.Dimension(90, 38));
        btnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivoActionPerformed(evt);
            }
        });

        btnInactivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/quitar-usuario.png"))); // NOI18N
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
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addContainerGap(22, Short.MAX_VALUE)
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
        try{
            if(isSelectedAOption)
                txtBuscar.setText(cmbOpcion.getSelectedItem().toString());
            
            List<Object[]> datos = controladorHistorialUsuario.obtenerDatosUsuariosConTerminos((String) cmbFiltro.getSelectedItem(), txtBuscar.getText().trim());

            // Modificar el mapper para formatear las fechas
            ComponentesUtils.cargarTabla(tblUsuario, datos, titulos, fila -> {
                // Suponiendo que los índices de las fechas son los siguientes
                DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

                // Aquí se formatean las fechas (índices de las fechas en el resultado de la consulta)
                for (int i = 0; i < fila.length; i++) {
                    if (fila[i] instanceof LocalDateTime) {
                        // Si es una fecha, se formatea
                        LocalDateTime fecha = (LocalDateTime) fila[i];
                        String fechaFormateada = fecha.format(formatterFecha);
                        String horaFormateada = fecha.format(formatterHora);
                        // Si la columna corresponde a una fecha, mostramos fecha y hora
                        fila[i] = fechaFormateada + " " + horaFormateada;
                    }
                }
                return fila;
            }, true);
            txtBuscar.setText("");
            btnCargarTodosDatos.setVisible(true);
        }catch (NoResultException e){
            DialogoUtils.mostrarMensaje(e.getMessage(), 1, "No se pudo obtener resultados.");
        }catch (IllegalArgumentException e){
            DialogoUtils.mostrarMensaje(e.getMessage(), 1,"No se encontro el termino ingresado");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cargarTodosLosDatosTabla(){
        List<Object[]> datos = controladorHistorialUsuario.obtenerTodosLosHistorialUsuarios();
        cargarTablaUsuario(datos, titulos);
    }
    
    private void btnCargarTodosDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTodosDatosActionPerformed
        cargarTodosLosDatosTabla();
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
                    cargarTodosLosDatosTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }else{
                DialogoUtils.mostrarMensaje("Debe seleccionar un usuario para eliminar!", 1, "Error");
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
                        cargarTodosLosDatosTabla();
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el personal seleccionado.", 1, "Atención");
                    }     
                }
            }else{
                DialogoUtils.mostrarMensaje("Debe seleccionar un usuario para Modificar!", 1, "Atención");
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
                    DialogoUtils.mostrarMensaje(controladorUsuario.cambiarEstadoHistorialYUsuario(nLegajo, "-", 1),1,"Atencion");
                    cargarTodosLosDatosTabla();
                }else{
                    DialogoUtils.mostrarMensaje("No se encontró el personal seleccionado.", 1, "Atención");
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
                        cargarTodosLosDatosTabla();
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el personal seleccionado.", 1, "Atención");
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

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        String seleccion = (String) cmbFiltro.getSelectedItem();
        cmbOpcion.removeAllItems();
        switch (seleccion) {
            case "Nombre" -> {
                txtBuscar.setEditable(true);
                cmbOpcion.setVisible(false);
                cmbOpcion.removeAllItems();
                isSelectedAOption = false;
            }
            case "Rol" -> {
                txtBuscar.setEditable(false);
                ComponentesUtils.cargarComboBox(cmbOpcion, RolUsuario.class);
                cmbOpcion.setVisible(true);
                isSelectedAOption = true;
            }
            case "Estado" -> {
                txtBuscar.setEditable(false);
                ComponentesUtils.cargarComboBox(cmbOpcion, EstadoPersonal.class);
                cmbOpcion.setVisible(true);
                isSelectedAOption = true;
            }
            default -> DialogoUtils.mostrarMensaje("No se pudo encontrar lo seleccionado", 2, "ERROR");
        }
    }//GEN-LAST:event_cmbFiltroActionPerformed

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
    private javax.swing.JComboBox<String> cmbOpcion;
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
