package com.museolba.vista.ventanaUsuario;

import com.museolba.controlador.controladorUsuario.ControladorHistorialUsuario;
import com.museolba.controlador.controladorUsuario.ControladorUsuario;
import com.museolba.modelo.entidades.EstadoPersonal;
import com.museolba.modelo.entidades.HistorialUsuario;
import com.museolba.modelo.entidades.Personal;
import com.museolba.modelo.entidades.RolUsuario;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import java.time.LocalDateTime;


public class FormUsuario extends javax.swing.JDialog {
    private Personal personal;
    private Usuario usuario;
    ControladorUsuario controladorUsuario = null;
    ControladorHistorialUsuario controladorHistorialUsuario = null;
   
    public FormUsuario(java.awt.Frame parent, boolean modal, Personal personal, boolean editable, Usuario usuario) {
        super(parent, modal);
        initComponents();
        ComponentesUtils.cargarComboBox(cmbRol, RolUsuario.class);
        controladorHistorialUsuario = new ControladorHistorialUsuario();
        controladorUsuario = new ControladorUsuario();
        this.personal = personal;
        btnGuardar.setVisible(false);
        if(editable){
            cmbRol.setEditable(false);
            btnFinalizar.setVisible(false);
            btnGuardar.setVisible(true);
        }
    }
    
    public FormUsuario(java.awt.Frame parent, boolean modal,boolean editable, Usuario usuario) {
        super(parent, modal);
        initComponents();
        ComponentesUtils.cargarComboBox(cmbRol, RolUsuario.class);
        controladorHistorialUsuario = new ControladorHistorialUsuario();
        controladorUsuario = new ControladorUsuario();
        this.usuario = usuario;
        btnGuardar.setVisible(false);
        if (editable) {
            cmbRol.setEditable(false);
            btnFinalizar.setVisible(false);
            btnGuardar.setVisible(true);
        }
        
        if (usuario != null) {
            txtNombreUsuario.setText(usuario.getNombreUsuario());
            txtContrasenia.setText(usuario.getContrasenia());
            cmbRol.setSelectedItem(usuario.getRolUsuario()); 
        }
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo4 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        cmbRol = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        txtContrasenia = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 487));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Registro Usuario");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo4.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo4.setText("Nombre");

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Contraseña");

        lblTitulo6.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo6.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo6.setText("Rol");

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(204, 0, 0));

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(cmbRol, 0, 183, Short.MAX_VALUE)
                            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasenia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblError)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(446, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        String resultado = "";

        if (txtNombreUsuario.getText().trim().isEmpty() || txtContrasenia.getText().trim().isEmpty()) {
            DialogoUtils.mostrarMensaje("Rellene todos los campos para continuar!", 2, "Rellene todos los Campos");
            return;
        }

        if (cmbRol.getSelectedItem() == null) {
            DialogoUtils.mostrarMensaje("Seleccione un rol para continuar!", 2, "Rol no seleccionado");
            return;
        }

        Usuario usuario = new Usuario(
                personal.getnLegajo(),
                personal.getNombre(),
                personal.getApellido(),
                personal.getDni(),
                personal.getnTelefono(),
                txtNombreUsuario.getText().trim(),
                txtContrasenia.getText().trim(),
                (RolUsuario) cmbRol.getSelectedItem()
        );

        try {
            resultado = controladorUsuario.crearUsuario(usuario);

            if (resultado.equalsIgnoreCase("Usuario creado exitosamente.")) {
                HistorialUsuario historialUsuario = new HistorialUsuario(
                        usuario,
                        LocalDateTime.now(),
                        null,
                        null,
                        LocalDateTime.now(),
                        null,
                        "-",
                        EstadoPersonal.ACTIVO
                );
                
                controladorHistorialUsuario.crearHistorialUsuario(historialUsuario);
                
                DialogoUtils.mostrarMensaje(resultado, 1, "Éxito");
                this.dispose();
            } else {
                DialogoUtils.mostrarMensaje(resultado, 2, "Error");
            }
        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al crear usuario: " + e.getMessage(), 2, "Error");
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombreUsuario.getText().trim().isEmpty() || txtContrasenia.getText().trim().isEmpty()) {
            DialogoUtils.mostrarMensaje("Por favor, complete todos los campos.", 1, "Validación");
            return;
        }

        try {
            usuario.setNombreUsuario(txtNombreUsuario.getText());
            usuario.setContrasenia(txtContrasenia.getText());
            usuario.setRolUsuario((RolUsuario) cmbRol.getSelectedItem());

            // Llama al controlador para editar el usuario
            controladorUsuario.editarUsuario(usuario);
            DialogoUtils.mostrarMensaje("¡Usuario actualizado correctamente!", 0, "Éxito");
            this.dispose();
        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al actualizar el usuario: " + e.getMessage(), 2, "Error");
        }   
    }//GEN-LAST:event_btnGuardarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<RolUsuario> cmbRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
