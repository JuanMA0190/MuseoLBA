package com.museolba.vista.ventanaAsistencia;

import com.museolba.config.TiposReporte;
import com.museolba.controlador.controladorAsistencia.ControladorAsistenciaUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.FechaUtils;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SwingUtilities;



public class VentanaAsistencia extends javax.swing.JPanel {
    
    private Usuario usuario = null;
    private ControladorAsistenciaUsuario controladorAsistencia = null;
    
    public VentanaAsistencia(Usuario usuario) {
 
        initComponents();
        this.usuario = usuario;
        this.controladorAsistencia = new ControladorAsistenciaUsuario();
        
        ComponentesUtils.cargarComboBox(cmbReporte, TiposReporte.class);

        if (usuario.getRolUsuario() == RolUsuario.PERSONAL) {
            panelReporte.setVisible(false);
        }
         
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        calendarioAsistencias = new com.toedter.calendar.JCalendar();
        lblTitulo = new javax.swing.JLabel();
        panelReporte = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        cmbReporte = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        panelPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        calendarioAsistencias.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioAsistenciasPropertyChange(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Asistencias");

        panelReporte.setBackground(new java.awt.Color(204, 204, 204));
        panelReporte.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reportes.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setPreferredSize(new java.awt.Dimension(90, 38));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReporteLayout = new javax.swing.GroupLayout(panelReporte);
        panelReporte.setLayout(panelReporteLayout);
        panelReporteLayout.setHorizontalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelReporteLayout.setVerticalGroup(
            panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(447, Short.MAX_VALUE))
            .addComponent(calendarioAsistencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(calendarioAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        
        Calendar calendario = calendarioAsistencias.getCalendar();
        int mes =  calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String url = "reportes/asistencia/ReporteAsistencia"+FechaUtils.obtenerMes(mes)+anio;
            if(cmbReporte.getSelectedItem() == TiposReporte.PDF){
                controladorAsistencia.generarReporteAsistencia(mes, anio, url+".pdf");
            }else if(cmbReporte.getSelectedItem() == TiposReporte.EXCEL){
                controladorAsistencia.generarReporteAsistencia(mes, anio, url+".xlsx");
            }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void calendarioAsistenciasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioAsistenciasPropertyChange
        if ("calendar".equals(evt.getPropertyName())) {
            // Obtener el calendario antiguo y nuevo del evento
                Calendar calendarioAntiguo = (Calendar) evt.getOldValue();
                Calendar calendarioNuevo = (Calendar) evt.getNewValue();

                // Verificar si el día cambió (solo se abre el diálogo si se seleccionó un día)
                if (calendarioAntiguo != null && calendarioNuevo != null) {
                    int diaAntiguo = calendarioAntiguo.get(Calendar.DAY_OF_MONTH);
                    int diaNuevo = calendarioNuevo.get(Calendar.DAY_OF_MONTH);

                    if (diaAntiguo != diaNuevo) {
                        // Solo se abre el diálogo si el día cambió
                        Date fechaSeleccionada = calendarioAsistencias.getDate();
                        LocalDate fecha = fechaSeleccionada.toInstant()
                                                          .atZone(ZoneId.systemDefault())
                                                          .toLocalDate();

                        VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(VentanaAsistencia.this);
                        FormDia dF = new FormDia(vP, true, usuario, fecha);
                        dF.setLocationRelativeTo(vP);
                        dF.setVisible(true);
                    }
                }
        }
    }//GEN-LAST:event_calendarioAsistenciasPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private com.toedter.calendar.JCalendar calendarioAsistencias;
    private javax.swing.JComboBox<String> cmbReporte;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelReporte;
    // End of variables declaration//GEN-END:variables
}
