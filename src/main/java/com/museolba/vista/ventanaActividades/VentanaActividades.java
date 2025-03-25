package com.museolba.vista.ventanaActividades;

import com.museolba.controlador.controladorTurno.controladorTurnoArtista.ControladorTurnoArtista;
import com.museolba.controlador.controladorTurno.controladorTurnoGuia.ControladorTurnoGuia;
import com.museolba.modelo.entidades.turnos.turnoArtista.TurnoArtista;
import com.museolba.modelo.entidades.turnos.turnoGuia.TurnoGuia;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.utils.ComponentesUtils;
import java.util.List;
import com.museolba.utils.DialogoUtils;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import com.museolba.vista.ventanaTurnoArtista.FormTurnoArtista;
import com.museolba.vista.ventanaTurnoGuia.FormTurnoGuia;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class VentanaActividades extends javax.swing.JPanel {
    private ControladorTurnoGuia controladorTurnoGuia = null;
    private ControladorTurnoArtista controladorTurnoArtista = null;
    
    public VentanaActividades(Usuario usuario) {
        initComponents();
        
        this.controladorTurnoArtista = new ControladorTurnoArtista();
        this.controladorTurnoGuia = new ControladorTurnoGuia();
        
         if (usuario.getRolUsuario() == RolUsuario.PERSONAL) {
             btnAgregar.setVisible(false);
             btnEliminar.setVisible(false);
             btnModificar.setVisible(false);
         }
        
        cargarComboBoxTurnos();
        agregarListenerComboBox();
        
        cargarDatosTurnoArtista();
      
    }
    
    private void cargarComboBoxTurnos(){
        // Limpiar el comboBox
        cmbHorarios.removeAllItems();

        // Agregar las opciones "Turno Artista" y "Turno Guía"
        cmbHorarios.addItem("Turno Artista");
        cmbHorarios.addItem("Turno Guía");
    }
    
    private void agregarListenerComboBox() {
        cmbHorarios.addActionListener(e -> {
            String seleccion = (String) cmbHorarios.getSelectedItem();
            if ("Turno Artista".equals(seleccion)) {
                cargarDatosTurnoArtista();
            } else if ("Turno Guía".equals(seleccion)) {
                cargarDatosTurnoGuia();
            }
        });
    }

    private void cargarDatosTurnoArtista() {
        try {
            // Obtener los datos de Turno Artista desde el controlador
            List<TurnoArtista> turnosArtista = controladorTurnoArtista.traerTodosLosTurnosArtista();

            // Definir los títulos de las columnas
            String[] columnas = {"ID", "Artista", "Fecha Inicio", "Fecha Fin"};

            // Usar el método cargarTabla de ComponentesUtils
            ComponentesUtils.cargarTabla(tblDatosTurnos, turnosArtista, columnas, turno -> new Object[]{
                    turno.getId(),
                    turno.getArtista().getNombre(),
                    turno.getFechaInicio(),
                    turno.getFechaFin()
            }, false);

        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al cargar los datos de Turno Artista: " + e.getMessage(), 2, "Error!");
        }
    }

    private void cargarDatosTurnoGuia() {
        try {
            // Obtener los datos de Turno Guía desde el controlador
            List<TurnoGuia> turnosGuia = controladorTurnoGuia.traerTodosLosTurnosGuia();

            // Definir los títulos de las columnas
            String[] columnas = {"ID", "Entidad", "Fecha", "Horario"};

            // Usar el método cargarTabla de ComponentesUtils
            ComponentesUtils.cargarTabla(tblDatosTurnos, turnosGuia, columnas, turno -> new Object[]{
                    turno.getId(),
                    turno.getEntidad(),
                    turno.getFecha(),
                    turno.getHorario()
            }, false);

        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al cargar los datos de Turno Guía: " + e.getMessage(), 2, "Error!");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosTurnos = new javax.swing.JTable();
        lblTituloPrincipal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTituloPrincipal1 = new javax.swing.JLabel();
        cmbHorarios = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        panelContenido.setBackground(new java.awt.Color(204, 204, 204));

        tblDatosTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatosTurnos);

        lblTituloPrincipal.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTituloPrincipal.setForeground(new java.awt.Color(102, 0, 102));
        lblTituloPrincipal.setText("Actividades");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTituloPrincipal1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTituloPrincipal1.setForeground(new java.awt.Color(102, 0, 102));
        lblTituloPrincipal1.setText("Seleccionar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloPrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloPrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                    .addGroup(panelContenidoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(8, 8, 8)
                        .addComponent(btnModificar)
                        .addGap(7, 7, 7)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
        
        if(cmbHorarios.getSelectedItem().equals("Turno Artista")){
            
            FormTurnoArtista formTurnoArtista = new FormTurnoArtista(vP, true, false, null);
            formTurnoArtista.setLocationRelativeTo(vP);
            formTurnoArtista.setVisible(true);
            
            cargarDatosTurnoArtista();
            
        }else if(cmbHorarios.getSelectedItem().equals("Turno Guía")){
            FormTurnoGuia formTurnoGuia = new FormTurnoGuia(vP, true, false, null);
            formTurnoGuia.setLocationRelativeTo(vP);
            formTurnoGuia.setVisible(true);
            
            cargarDatosTurnoGuia();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
            VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
            
            if(tblDatosTurnos.getRowCount()> 0){
                if(tblDatosTurnos.getSelectedRow()!=-1){
                    int filaSeleccionada = tblDatosTurnos.getSelectedRow();
                    
                    if(cmbHorarios.getSelectedItem().equals("Turno Artista")){
                        long idTurnoArtista = (long) tblDatosTurnos.getValueAt(filaSeleccionada, 0);
                                            // Buscar el turno en el controlador
                        Optional<TurnoArtista> turnoArtistaOptional = controladorTurnoArtista.obtenerTurnoArtistaPorId(idTurnoArtista);
                        TurnoArtista turnoArtista = turnoArtistaOptional.orElse(null);

                        if (turnoArtistaOptional.isPresent() && turnoArtista != null && vP != null) {
                            // Abrir el formulario para editar el turno
                            FormTurnoArtista formTurnoArtista = new FormTurnoArtista(vP, true, true, turnoArtista);
                            formTurnoArtista.setLocationRelativeTo(vP);
                            formTurnoArtista.setVisible(true);

                            // Recargar los datos en la tabla después de editar
                            cargarDatosTurnoArtista();
                        }else{
                            DialogoUtils.mostrarMensaje("No se encontró el turno Artista seleccionado ", 1, "Atención!");
                        }   
                    }else if(cmbHorarios.getSelectedItem().equals("Turno Guía")){
                        long idTurnoGuia = (long) tblDatosTurnos.getValueAt(filaSeleccionada, 0);
                        
                        Optional<TurnoGuia> turnoGuiaOptional = controladorTurnoGuia.obtenerTurnoGuiaPorId(idTurnoGuia);
                        TurnoGuia turnoGuia = turnoGuiaOptional.orElse(null);

                        if (turnoGuiaOptional.isPresent() && turnoGuia != null && vP != null){
                            FormTurnoGuia formTurnoGuia = new FormTurnoGuia(vP, true, true, turnoGuia);

                            formTurnoGuia.setVisible(true);
                            formTurnoGuia.setLocationRelativeTo(vP);
                            
                            cargarDatosTurnoGuia();
                            
                        }else{
                            DialogoUtils.mostrarMensaje("No se encontró el turno Guía seleccionado ", 1, "Atención!");
                        }
                    }
                }else{
                    DialogoUtils.mostrarMensaje("Debe seleccionar un turno para Modificar!", 1, "Atención");
                }
            }  
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("No se encontró el turno seleccionado", 1, "Atención!");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
        // Verificar si hay filas en la tabla
        if (tblDatosTurnos.getRowCount() > 0) {
            // Verificar si hay una fila seleccionada
            if (tblDatosTurnos.getSelectedRow() != -1) {
                int filaSeleccionada = tblDatosTurnos.getSelectedRow();

                // Verificar si el turno seleccionado es "Turno Guía"
                if (cmbHorarios.getSelectedItem().equals("Turno Guía")) {
                    long idTurnoGuia = (long) tblDatosTurnos.getValueAt(filaSeleccionada, 0);

                    // Confirmar la eliminación
                    int opcion = JOptionPane.showConfirmDialog(
                        null, 
                        "¿Está seguro de que desea ELIMINAR el Turno ?\nRECUERDE ESTA ACCIÓN NO SE PUEDE MODIFICAR", 
                        "ATENCIÓN!", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE
                    );
                    if (opcion == JOptionPane.YES_OPTION) { 
                        controladorTurnoGuia.eliminarTurnoGuia(idTurnoGuia);
                        DialogoUtils.mostrarMensaje("El turno se eliminó correctamente.", 1, "Éxito!");

                        // Recargar los datos en la tabla
                        cargarDatosTurnoGuia();
                    }
                } else if (cmbHorarios.getSelectedItem().equals("Turno Artista")) {
                    long idTurnoArtista = (long) tblDatosTurnos.getValueAt(filaSeleccionada, 0);

                    // Confirmar la eliminación
                    int opcion = JOptionPane.showConfirmDialog(
                        null, 
                        "¿Está seguro de que desea ELIMINAR el Turno ?\nRECUERDE ESTA ACCIÓN NO SE PUEDE MODIFICAR", 
                        "ATENCIÓN!", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE
                    );
                    if (opcion == JOptionPane.YES_OPTION) { 
                       controladorTurnoArtista.eliminarTurnoArtista(idTurnoArtista);
                        DialogoUtils.mostrarMensaje("El turno se eliminó correctamente.", 1, "Éxito!");

                        // Recargar los datos en la tabla
                        cargarDatosTurnoArtista();
                    }
                }
            } else {
                DialogoUtils.mostrarMensaje("Debe seleccionar un turno para eliminar.", 1, "Atención");
            }
        } else {
            DialogoUtils.mostrarMensaje("No hay turnos disponibles para eliminar.", 1, "Atención");
        }
    } catch (Exception e) {
        DialogoUtils.mostrarMensaje("Error al eliminar el turno: " + e.getMessage(), 2, "Error");
    }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbHorarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloPrincipal;
    private javax.swing.JLabel lblTituloPrincipal1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JTable tblDatosTurnos;
    // End of variables declaration//GEN-END:variables
}
