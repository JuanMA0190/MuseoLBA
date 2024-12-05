package com.museolba.vista.ventanaPrincipal;

import com.museolba.vista.ventanaActividades.VentanaActividades;
import com.museolba.vista.ventanaArtista.VentanaArtista;
import com.museolba.vista.ventanaCajaChica.VentanaCajaChica;
import com.museolba.vista.ventanaLogin.VentanaLogin;
import com.museolba.vista.ventanaObra.VentanaObra;
import com.museolba.vista.ventanaPersonal.VentanaPersonal;
import com.museolba.vista.ventanaSalas.VentanaSalas;
import com.museolba.vista.ventanaTurnoExposicion.VentanaTurnoExposicion;
import com.museolba.vista.ventanaTurnoVisita.VentanaTurnoVisita;
import com.museolba.vista.ventanaUsuario.VentanaUsuario;
import java.awt.BorderLayout;
import javax.swing.JPanel;


public class VentanaPrincipal extends javax.swing.JFrame {

    
    public VentanaPrincipal() {
        initComponents();
        initContent();
    }
    
    private void initContent(){
        VentanaActividades va = new VentanaActividades();
        abrirContenido(va);
    }
    
    private void abrirContenido(JPanel nuevaVentana){
        nuevaVentana.setSize(738, 572);
        nuevaVentana.setLocation(0,0);
        
        panelContenido.removeAll();
        panelContenido.add(nuevaVentana, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnPrincipal = new javax.swing.JButton();
        btnObras = new javax.swing.JButton();
        btnArtistas = new javax.swing.JButton();
        btnTurVisitas = new javax.swing.JButton();
        btnTurExpo = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnPersonal = new javax.swing.JButton();
        btnSalas = new javax.swing.JButton();
        btnCajaChica = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 733));

        background.setBackground(new java.awt.Color(204, 204, 204));

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

        btnArtistas.setText("Artistas");
        btnArtistas.setBorder(null);
        btnArtistas.setBorderPainted(false);
        btnArtistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtistasActionPerformed(evt);
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

        btnTurExpo.setText("Turnos Exposición");
        btnTurExpo.setBorder(null);
        btnTurExpo.setBorderPainted(false);
        btnTurExpo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTurExpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurExpoActionPerformed(evt);
            }
        });

        btnUsuario.setText("Usuarios");
        btnUsuario.setBorder(null);
        btnUsuario.setBorderPainted(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnPersonal.setText("Personal");
        btnPersonal.setBorder(null);
        btnPersonal.setBorderPainted(false);
        btnPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalActionPerformed(evt);
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
                                .addComponent(lblTitulo)))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnArtistas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCajaChica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTurVisitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTurExpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(btnObras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTurVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTurExpo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCajaChica, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panelInfo.setBackground(new java.awt.Color(102, 102, 102));
        panelInfo.setPreferredSize(new java.awt.Dimension(744, 140));

        lblFecha.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblFecha.setText("Martes 10 de Julio de 2024");

        lblBienvenida.setFont(new java.awt.Font("DejaVu Serif", 0, 36)); // NOI18N
        lblBienvenida.setText("¡Bienvenido, Juan Acosta !");

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelContenido.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        VentanaLogin vl = new VentanaLogin();
        vl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrasActionPerformed
        VentanaObra vo = new VentanaObra();
        abrirContenido(vo);
    }//GEN-LAST:event_btnObrasActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        VentanaActividades va = new VentanaActividades();
        abrirContenido(va);
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtistasActionPerformed
        VentanaArtista vart = new VentanaArtista();
        abrirContenido(vart);
    }//GEN-LAST:event_btnArtistasActionPerformed

    private void btnTurVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurVisitasActionPerformed
        VentanaTurnoVisita vtv = new VentanaTurnoVisita();
        abrirContenido(vtv);
    }//GEN-LAST:event_btnTurVisitasActionPerformed

    private void btnTurExpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurExpoActionPerformed
        VentanaTurnoExposicion vte = new VentanaTurnoExposicion();
        abrirContenido(vte);
    }//GEN-LAST:event_btnTurExpoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        VentanaUsuario vu = new VentanaUsuario();
        abrirContenido(vu);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalActionPerformed
        VentanaPersonal vp = new VentanaPersonal();
        abrirContenido(vp);
    }//GEN-LAST:event_btnPersonalActionPerformed

    private void btnSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalasActionPerformed
        VentanaSalas vs = new VentanaSalas();
        abrirContenido(vs);
    }//GEN-LAST:event_btnSalasActionPerformed

    private void btnCajaChicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaChicaActionPerformed
        VentanaCajaChica vcc = new VentanaCajaChica();
        abrirContenido(vcc);
    }//GEN-LAST:event_btnCajaChicaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnArtistas;
    private javax.swing.JButton btnCajaChica;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnObras;
    private javax.swing.JButton btnPersonal;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JButton btnSalas;
    private javax.swing.JButton btnTurExpo;
    private javax.swing.JButton btnTurVisitas;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
