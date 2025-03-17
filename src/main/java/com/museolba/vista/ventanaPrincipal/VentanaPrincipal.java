package com.museolba.vista.ventanaPrincipal;

import com.museolba.vista.ventanaPrincipal.estrategia.RolStrategy;
import com.museolba.vista.ventanaPrincipal.estrategia.RolStrategyFactory;
import com.museolba.modelo.entidades.enums.RolUsuario;
import com.museolba.modelo.entidades.Usuario;
import com.museolba.vista.ventanaActividades.VentanaActividades;
import com.museolba.vista.ventanaLogin.VentanaLogin;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.Timer;


public class VentanaPrincipal extends javax.swing.JFrame {
    private Usuario usuarioOnline=null;
    
    public VentanaPrincipal(Usuario usuario){
        initComponents();
        initContent();
        this.usuarioOnline = usuario;
        mostrarMenuSegunRol();
        mostrarBienvenida(usuarioOnline);
        iniciarReloj();
        
    }
    
    private void mostrarMenuSegunRol() {
        RolStrategy estrategia = RolStrategyFactory.getStrategy(usuarioOnline.getRolUsuario());
        estrategia.mostrarMenu(this);
    }
    
    private void mostrarBienvenida(Usuario usuario) {
        lblBienvenida.setText("¡Bienvenido, " + usuario.getNombre() + " " + usuario.getApellido() + "!");
    }
    
    private void iniciarReloj() {
        Timer timer = new Timer(1000, e -> actualizarFechaHora());
        timer.start();
    }
    
    private void actualizarFechaHora() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM yyyy", new Locale("es", "ES"));
        DateTimeFormatter formatterClock = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblFecha.setText(ahora.format(formatterDate));
        lblHora.setText(ahora.format(formatterClock));
    }
    
    public Usuario getUsuarioOnline(){
        return usuarioOnline;
    }
    
    public JPanel getPanelMenu() {
        return panelMenu;
    }
    
     public static void abrirContenido(JPanel nuevaVentana, int x, int y, JPanel panelPrincipal) {
        nuevaVentana.setSize(x, y);
        nuevaVentana.setLocation(0, 0);
        panelPrincipal.removeAll();
        panelPrincipal.add(nuevaVentana, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    public JPanel getPanelContenido() {
        return panelContenido;
    }
   
     private void initContent(){
        VentanaActividades va = new VentanaActividades();
        abrirContenido(va, 738, 572, panelContenido);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        panelContenidoPrincipal = new javax.swing.JPanel();
        panelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 733));

        background.setBackground(new java.awt.Color(204, 204, 204));

        panelMenu.setBackground(new java.awt.Color(102, 0, 102));
        panelMenu.setPreferredSize(new java.awt.Dimension(275, 431));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblImagen)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(670, Short.MAX_VALUE))
        );

        panelInfo.setBackground(new java.awt.Color(102, 102, 102));
        panelInfo.setPreferredSize(new java.awt.Dimension(744, 140));

        lblFecha.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N

        lblBienvenida.setFont(new java.awt.Font("DejaVu Serif", 0, 36)); // NOI18N

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHora)
                        .addGap(75, 75, 75)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInfoLayout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelContenidoPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        panelContenido.setBackground(new java.awt.Color(204, 204, 204));
        panelContenido.setPreferredSize(new java.awt.Dimension(738, 572));

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

        javax.swing.GroupLayout panelContenidoPrincipalLayout = new javax.swing.GroupLayout(panelContenidoPrincipal);
        panelContenidoPrincipal.setLayout(panelContenidoPrincipalLayout);
        panelContenidoPrincipalLayout.setHorizontalGroup(
            panelContenidoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoPrincipalLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        panelContenidoPrincipalLayout.setVerticalGroup(
            panelContenidoPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoPrincipalLayout.createSequentialGroup()
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(panelContenidoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenidoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelContenidoPrincipal;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
