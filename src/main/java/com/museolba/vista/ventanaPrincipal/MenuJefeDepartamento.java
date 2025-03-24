package com.museolba.vista.ventanaPrincipal;


import com.museolba.vista.ventanaArtista.VentanaArtista;
import com.museolba.vista.ventanaAsistencia.VentanaAsistencia;
import com.museolba.vista.ventanaCajaChica.VentanaCajaChica;
import com.museolba.vista.ventanaObra.VentanaObra;
import com.museolba.vista.ventanaPersonal.VentanaPersonal;
import com.museolba.vista.ventanaSalas.VentanaSalas;
import com.museolba.vista.ventanaUsuario.VentanaUsuario;


public class MenuJefeDepartamento extends javax.swing.JPanel {
    private VentanaPrincipal ventanaPrincipal;
    
    public MenuJefeDepartamento(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JScrollPane();
        panelMenu1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        btnPrincipal = new javax.swing.JButton();
        btnObras = new javax.swing.JButton();
        btnArtistas = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnSalas = new javax.swing.JButton();
        btnCajaChica = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        panelImagen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 102));

        panelMenu.setBackground(new java.awt.Color(102, 0, 102));
        panelMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelMenu.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelMenu1.setBackground(new java.awt.Color(102, 0, 102));
        panelMenu1.setPreferredSize(new java.awt.Dimension(290, 600));
        panelMenu1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelMenu1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 6, -1, 104));

        btnPrincipal.setText("Principal");
        btnPrincipal.setBorder(null);
        btnPrincipal.setBorderPainted(false);
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });
        panelMenu1.add(btnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 248, 47));

        btnObras.setText("Obras");
        btnObras.setBorder(null);
        btnObras.setBorderPainted(false);
        btnObras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrasActionPerformed(evt);
            }
        });
        panelMenu1.add(btnObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 248, 47));

        btnArtistas.setText("Artistas");
        btnArtistas.setBorder(null);
        btnArtistas.setBorderPainted(false);
        btnArtistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtistasActionPerformed(evt);
            }
        });
        panelMenu1.add(btnArtistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 248, 47));

        btnAsistencia.setText("Asistencia");
        btnAsistencia.setBorder(null);
        btnAsistencia.setBorderPainted(false);
        btnAsistencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });
        panelMenu1.add(btnAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 248, 47));

        btnSalas.setText("Salas");
        btnSalas.setBorder(null);
        btnSalas.setBorderPainted(false);
        btnSalas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalasActionPerformed(evt);
            }
        });
        panelMenu1.add(btnSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 248, 47));

        btnCajaChica.setText("Caja Chica");
        btnCajaChica.setBorder(null);
        btnCajaChica.setBorderPainted(false);
        btnCajaChica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCajaChica.setPreferredSize(new java.awt.Dimension(47, 17));
        btnCajaChica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaChicaActionPerformed(evt);
            }
        });
        panelMenu1.add(btnCajaChica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 248, 47));

        btnPersonal.setText("Personal");
        btnPersonal.setBorder(null);
        btnPersonal.setBorderPainted(false);
        btnPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
            }
        });
        panelMenu1.add(btnPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 248, 47));

        btnUsuario.setText("Usuarios");
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        panelMenu1.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, 50));

        panelMenu.setViewportView(panelMenu1);

        panelImagen.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imgPrinc.jpg"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo.setText("Museo Lucas Braulio Areco");

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImagenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImagenLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        //VentanaActividades va = new VentanaActividades();
        //ventanaPrincipal.abrirContenido(va, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrasActionPerformed
        VentanaObra vo = new VentanaObra(ventanaPrincipal.getUsuarioOnline());
        ventanaPrincipal.abrirContenido(vo, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnObrasActionPerformed

    private void btnArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtistasActionPerformed
        VentanaArtista vart = new VentanaArtista();
        ventanaPrincipal.abrirContenido(vart, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnArtistasActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        VentanaAsistencia va = new VentanaAsistencia(ventanaPrincipal.getUsuarioOnline());
        ventanaPrincipal.abrirContenido(va, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalasActionPerformed
        VentanaSalas vs = new VentanaSalas();
        ventanaPrincipal.abrirContenido(vs, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnSalasActionPerformed

    private void btnCajaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaChicaActionPerformed
        VentanaCajaChica vcc = new VentanaCajaChica(ventanaPrincipal.getUsuarioOnline());
        ventanaPrincipal.abrirContenido(vcc, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnCajaChicaActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        VentanaPersonal vp = new VentanaPersonal();
        ventanaPrincipal.abrirContenido(vp, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        VentanaUsuario vu = new VentanaUsuario();
        ventanaPrincipal.abrirContenido(vu, 738, 572, ventanaPrincipal.getPanelContenido());
    }//GEN-LAST:event_btnUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArtistas;
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnCajaChica;
    private javax.swing.JButton btnObras;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnSalas;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JScrollPane panelMenu;
    private javax.swing.JPanel panelMenu1;
    // End of variables declaration//GEN-END:variables
}
