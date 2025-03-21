package com.museolba.vista.ventanaPrincipal;

import com.museolba.vista.ventanaActividades.VentanaActividades;
import com.museolba.vista.ventanaAsistencia.VentanaAsistencia;
import com.museolba.vista.ventanaCajaChica.VentanaCajaChica;
import com.museolba.vista.ventanaObra.VentanaObra;


public class MenuPersonal extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    
    public MenuPersonal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnPrincipal = new javax.swing.JButton();
        btnObras = new javax.swing.JButton();
        btnTurVisitas = new javax.swing.JButton();
        btnSalas = new javax.swing.JButton();
        btnCajaChica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAsistencia = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(270, 431));

        panelMenu.setBackground(new java.awt.Color(102, 0, 102));
        panelMenu.setPreferredSize(new java.awt.Dimension(270, 431));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo.setText("Museo Lucas Braulio Areco");

        btnPrincipal.setText("Principal");
        btnPrincipal.setBorder(null);
        btnPrincipal.setBorderPainted(false);
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        btnObras.setText("Obras");
        btnObras.setBorder(null);
        btnObras.setBorderPainted(false);
        btnObras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrasActionPerformed(evt);
            }
        });

        btnTurVisitas.setText("Turnos Visitas");
        btnTurVisitas.setBorder(null);
        btnTurVisitas.setBorderPainted(false);
        btnTurVisitas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTurVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurVisitasActionPerformed(evt);
            }
        });

        btnSalas.setText("Salas");
        btnSalas.setBorder(null);
        btnSalas.setBorderPainted(false);
        btnSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalasActionPerformed(evt);
            }
        });

        btnCajaChica.setText("Caja Chica");
        btnCajaChica.setBorder(null);
        btnCajaChica.setBorderPainted(false);
        btnCajaChica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCajaChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaChicaActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgPrinc.jpg"))); // NOI18N

        btnAsistencia.setText("Asistencia");
        btnAsistencia.setBorder(null);
        btnAsistencia.setBorderPainted(false);
        btnAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblImagen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTitulo))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnTurVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnObras, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCajaChica, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTurVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCajaChica, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        //VentanaActividades va = new VentanaActividades();
        //ventanaPrincipal.abrirContenido(va, 738, 572, ventanaPrincipal.getPanelContenido());//MODIFIQUEAQUI
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrasActionPerformed
        VentanaObra vo = new VentanaObra();
        ventanaPrincipal.abrirContenido(vo, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnObrasActionPerformed

    private void btnTurVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurVisitasActionPerformed
        // VentanaTurnoVisita vtv = new VentanaTurnoVisita();
        // abrirContenido(vtv);
    }//GEN-LAST:event_btnTurVisitasActionPerformed

    private void btnSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalasActionPerformed
        // VentanaSalas vs = new VentanaSalas();
        // abrirContenido(vs);
    }//GEN-LAST:event_btnSalasActionPerformed

    private void btnCajaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaChicaActionPerformed
        VentanaCajaChica vcc = new VentanaCajaChica(ventanaPrincipal.getUsuarioOnline());
        ventanaPrincipal.abrirContenido(vcc, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnCajaChicaActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        VentanaAsistencia va = new VentanaAsistencia(ventanaPrincipal.getUsuarioOnline());
        ventanaPrincipal.abrirContenido(va, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnAsistenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnCajaChica;
    private javax.swing.JButton btnObras;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnSalas;
    private javax.swing.JButton btnTurVisitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
