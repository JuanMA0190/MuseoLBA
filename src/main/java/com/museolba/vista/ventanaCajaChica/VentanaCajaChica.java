package com.museolba.vista.ventanaCajaChica;

import com.museolba.config.TiposReporte;
import com.museolba.controlador.controladorCajaChica.ControladorCajaChica;
import com.museolba.controlador.controladorCajaChica.ControladorRecibo;
import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.modelo.entidades.cajaChica.Recibo;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.FechaUtils;
import com.museolba.utils.UIValidacionUtils;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VentanaCajaChica extends javax.swing.JPanel {
    ControladorCajaChica controladorCajaChica = null;
    ControladorRecibo controladorRecibo = null;
    Long usuarioNumLegajo = null;
    String[] titulos = {"Nombre", "Fecha"};
    LocalDate fechaActual = null;
    int mesActual = 0;
    int anioActual = 0;
    
    
    public VentanaCajaChica(Usuario usuario) {
        
        initComponents();
        controladorCajaChica = new ControladorCajaChica();
        controladorRecibo = new ControladorRecibo();
        this.usuarioNumLegajo = usuario.getnLegajo();
        
        fechaActual = LocalDate.now();
        
        mesActual = fechaActual.getMonthValue();
        anioActual = fechaActual.getYear();
        
        panelFondoInical.setVisible(false);
        
        ComponentesUtils.cargarComboBox(cmbReporte, TiposReporte.class);
        
        // Ejecutar después de que el JPanel esté completamente inicializado
        SwingUtilities.invokeLater(() -> {
          estadoInicial(usuario, mesActual, anioActual);
        });
        
        
    }
    
    public void estadoInicial(Usuario usuario, int mesActual, int anioActual){
       
        //Verificar si ya hay una caja chica el mes actual y si no la hay la crea
        verificarYCrearCajaChicaParaMesActual();
        
        //Cargar Tabla
        cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
        
        verificarFondoInicial(monthChooser.getMonth()+1, yearChooser.getYear());
        
        //Si el usuario es personal
        if (usuario.getRolUsuario() == RolUsuario.PERSONAL) {
            panelReporte.setVisible(false);
            panelFondoInical.setVisible(false);
            btnAgregarRecibo.setEnabled(false);
        }
        
        estamosEnElMesYAnioActual(monthChooser.getMonth()+1, yearChooser.getYear());
        
    }
    
    public void estamosEnElMesYAnioActual(int mes, int anio){
        if(mes != mesActual || anio != anioActual){
            btnAgregarRecibo.setVisible(false);
            panelFondoInical.setVisible(false);
            panelReporte.setVisible(false);
        }else{
            btnAgregarRecibo.setVisible(true);
            panelReporte.setVisible(true);
        }
        
    }
        
    public void verificarYCrearCajaChicaParaMesActual() {
        int mesActual = monthChooser.getMonth()+1;
        int anioActual = yearChooser.getYear();
        try{
           // Verificar si ya existe una CajaChica para el mes actual
            if (!controladorCajaChica.existeCajaChicaParaMes(mesActual, anioActual)) {
                // Crear una nueva CajaChica con valores iniciales
                CajaChica nuevaCajaChica = new CajaChica(0.0, 0.0, fechaActual.withDayOfMonth(1));

                // Guardar la nueva CajaChica en la base de datos
                controladorCajaChica.crearCajaChica(nuevaCajaChica);
            }
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("Error no se pudo crear la caja chica del mes actual"+e.getMessage(), 2, "Error!");
        }
        
    }
    
    private void verificarFondoInicial(int mes, int anio) {
    if (controladorCajaChica.esFondoInicialCero(mes, anio)) {
        DialogoUtils.mostrarMensaje("Ingrese el fondo inicial para empezar a gestionar la Caja Chica", 1, "Atención");
        btnReporte.setEnabled(false);
        btnAgregarRecibo.setEnabled(false);
        panelFondoInical.setVisible(true);
    } else {
        btnReporte.setEnabled(true);
        btnAgregarRecibo.setEnabled(true);
        panelFondoInical.setVisible(false);
    }
}
    
    private void cargarTablaCajaChica(int mesSeleccionado , int anioSeleccionado){
        try {
            // Obtener la caja chica para el mes y año seleccionados
            CajaChica cajaChica = controladorCajaChica.obtenerCajaChicaPorMes(mesSeleccionado, anioSeleccionado);
            List<Recibo> cajaChicaRecibo = controladorRecibo.obtenerRecibosPorCajaChica(cajaChica.getId());

            DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

            ComponentesUtils.TableDataMapper<Recibo> reciboMapper = recibo -> new Object[]{
                recibo.getNombre(),
                recibo.getFechaRegistro().format(formatterFecha) + " " + recibo.getFechaRegistro().format(formatterHora)
            };
            
            try {
                ComponentesUtils.cargarTabla(tblRecibo, cajaChicaRecibo, titulos, reciboMapper, true);
            } catch (NoResultException e) {
             // Mostrar un mensaje si no hay productos
             DialogoUtils.mostrarMensaje("La Caja Chica no tiene Recibos almacenados!", 1, "Atención!");
            }
           
        } catch (NoResultException e) {
            DialogoUtils.mostrarMensaje("La Caja Chica no tiene Recibos almacenados!", 1, "Atención!");
            DefaultTableModel modelo = (DefaultTableModel) tblRecibo.getModel();
            modelo.setRowCount(0);
        }

        // Verificar el fondo inicial
        verificarFondoInicial(mesSeleccionado, anioSeleccionado);

        // Verificar si estamos en el mes y año actual
        estamosEnElMesYAnioActual(mesSeleccionado, anioSeleccionado);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelReporte = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        cmbReporte = new javax.swing.JComboBox<>();
        panelRecibo = new javax.swing.JPanel();
        btnAgregarRecibo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecibo = new javax.swing.JTable();
        btnVerRecibo = new javax.swing.JButton();
        panelBusqueda = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        monthChooser = new com.toedter.calendar.JMonthChooser();
        panelFondoInical = new javax.swing.JPanel();
        btnAgregarFondoInical1 = new javax.swing.JButton();
        txtFondoInicial = new javax.swing.JTextField();
        lblTitulo2 = new javax.swing.JLabel();
        lblAtencion = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Caja Chica");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        panelRecibo.setBackground(new java.awt.Color(204, 204, 204));
        panelRecibo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        btnAgregarRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-agregar.png"))); // NOI18N
        btnAgregarRecibo.setText("Agregar Recibo");
        btnAgregarRecibo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarRecibo.setPreferredSize(new java.awt.Dimension(90, 38));
        btnAgregarRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarReciboActionPerformed(evt);
            }
        });

        tblRecibo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRecibo);

        btnVerRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/buscar.png"))); // NOI18N
        btnVerRecibo.setText("Ver Recibo");
        btnVerRecibo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerRecibo.setPreferredSize(new java.awt.Dimension(90, 38));
        btnVerRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelReciboLayout = new javax.swing.GroupLayout(panelRecibo);
        panelRecibo.setLayout(panelReciboLayout);
        panelReciboLayout.setHorizontalGroup(
            panelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerRecibo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelReciboLayout.setVerticalGroup(
            panelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReciboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReciboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReciboLayout.createSequentialGroup()
                        .addComponent(btnAgregarRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelBusqueda.setBackground(new java.awt.Color(204, 204, 204));
        panelBusqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Buscar por Mes y Año");

        yearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearChooserPropertyChange(evt);
            }
        });

        monthChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                monthChooserPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout panelBusquedaLayout = new javax.swing.GroupLayout(panelBusqueda);
        panelBusqueda.setLayout(panelBusquedaLayout);
        panelBusquedaLayout.setHorizontalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBusquedaLayout.createSequentialGroup()
                        .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitulo1))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        panelBusquedaLayout.setVerticalGroup(
            panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBusquedaLayout.createSequentialGroup()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFondoInical.setBackground(new java.awt.Color(204, 204, 204));
        panelFondoInical.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        btnAgregarFondoInical1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/boton-agregar.png"))); // NOI18N
        btnAgregarFondoInical1.setText("Agregar");
        btnAgregarFondoInical1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarFondoInical1.setPreferredSize(new java.awt.Dimension(90, 38));
        btnAgregarFondoInical1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFondoInical1ActionPerformed(evt);
            }
        });

        txtFondoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFondoInicialKeyReleased(evt);
            }
        });

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Fondo Inicial");

        javax.swing.GroupLayout panelFondoInicalLayout = new javax.swing.GroupLayout(panelFondoInical);
        panelFondoInical.setLayout(panelFondoInicalLayout);
        panelFondoInicalLayout.setHorizontalGroup(
            panelFondoInicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoInicalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoInicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoInicalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtFondoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnAgregarFondoInical1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoInicalLayout.createSequentialGroup()
                        .addComponent(lblTitulo2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelFondoInicalLayout.setVerticalGroup(
            panelFondoInicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoInicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFondoInicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFondoInicial)
                    .addComponent(btnAgregarFondoInical1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblAtencion.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelFondoInical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAtencion))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAtencion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFondoInical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(panelRecibo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAgregarReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarReciboActionPerformed
       CajaChica cajaChica = controladorCajaChica.obtenerCajaChicaPorMes(monthChooser.getMonth()+1, yearChooser.getYear());
        
        VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
       if(vP != null){
            FormGestionRecibo formRecibo = new FormGestionRecibo(vP, true, usuarioNumLegajo, cajaChica);
            
            formRecibo.setLocationRelativeTo(vP);
            formRecibo.setVisible(true);

            cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
        }
    }//GEN-LAST:event_btnAgregarReciboActionPerformed

          //  cajaChica.setRecibos(controladorRecibo.obtenerRecibosPorCajaChica(cajaChica.getId()));
    private void monthChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_monthChooserPropertyChange
        if ("month".equals(evt.getPropertyName())) {
            cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
        }
    }//GEN-LAST:event_monthChooserPropertyChange

    private void yearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearChooserPropertyChange
        if ("year".equals(evt.getPropertyName())) {
            cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
        }
    }//GEN-LAST:event_yearChooserPropertyChange

    private void btnAgregarFondoInical1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFondoInical1ActionPerformed
        try{
            CajaChica cajaChica = controladorCajaChica.obtenerCajaChicaPorMes(monthChooser.getMonth()+1, yearChooser.getYear());
       
            if(!txtFondoInicial.getText().equals("")){
                if(cajaChica != null){
                    int opcion = JOptionPane.showConfirmDialog(
                            null, 
                            "¿Está seguro de que desea agregar el Fondo Inicial con la suma de $"+txtFondoInicial.getText()+"?\nRECUERDE ESTA OPCIÓN NO SE PUEDE MODIFICAR", 
                            "Atención!", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE
                    );
                    if (opcion == JOptionPane.YES_OPTION) {

                            controladorCajaChica.editarFondoInicial(cajaChica.getId(), Double.valueOf(txtFondoInicial.getText()));

                            DialogoUtils.mostrarMensaje("Se guardo exitosamente", 1, "Exito");
                            cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
                    } else {
                        DialogoUtils.mostrarMensaje("Se cancelo el guardado del fondo inicial", 1, "Atencion!");
                    }


                }else{
                    DialogoUtils.mostrarMensaje("No se encontro caja chica", 2, "Error");
                }
            }else{
                DialogoUtils.mostrarMensaje("Ingrese un monto", 2, "Atención");
            }
        }catch (Exception e){
            DialogoUtils.mostrarMensaje("Error: "+e.getMessage(), 2, "Atención");
        }
        
        
        
        
    }//GEN-LAST:event_btnAgregarFondoInical1ActionPerformed

    private void txtFondoInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFondoInicialKeyReleased
        UIValidacionUtils.validacionDigito(txtFondoInicial, lblAtencion);
    }//GEN-LAST:event_txtFondoInicialKeyReleased

    private void btnVerReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReciboActionPerformed
        if(tblRecibo.getRowCount() > 0) {
          if(tblRecibo.getSelectedRow() != -1) {
              // Obtener el modelo de la tabla
              DefaultTableModel modelo = (DefaultTableModel) tblRecibo.getModel();

              // Obtener la fila seleccionada
              int filaSeleccionada = tblRecibo.getSelectedRow();

              // Obtener el nombre del recibo (que está en la primera columna según tu mapper)
              String nombreRecibo = (String) modelo.getValueAt(filaSeleccionada, 0);

              // Obtener el recibo por su nombre (o mejor, por su ID si lo tienes en la tabla)
              Recibo recibo = controladorRecibo.obtenerReciboPorNombre(nombreRecibo);

              if(recibo != null) {
                  VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
                  if(vP != null) {
                      FormGestionRecibo formRecibo = new FormGestionRecibo(vP, true, recibo);
                      formRecibo.setLocationRelativeTo(vP);
                      formRecibo.setVisible(true);
                      cargarTablaCajaChica(monthChooser.getMonth()+1, yearChooser.getYear());
                  }
              } else {
                  DialogoUtils.mostrarMensaje("No se encontró el recibo seleccionado", 2, "Error");
              }
          } else {
              DialogoUtils.mostrarMensaje("Debe seleccionar un recibo para ver!", 1, "Atención");
          }
      } else {
          DialogoUtils.mostrarMensaje("No hay recibos para mostrar", 1, "Atención");
      }        
    }//GEN-LAST:event_btnVerReciboActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
       
        int mes =  mesActual;
        int anio = anioActual;
        CajaChica cajaChica = controladorCajaChica.obtenerCajaChicaPorMesReporte(mes, anio);
        String url = "reportes/caja_chica/ReporteCajaChica"+FechaUtils.obtenerMes(mes)+anio;

        if(cmbReporte.getSelectedItem() == TiposReporte.PDF){
        controladorCajaChica.generarReporteCajaChica(mes, anio, url+".pdf",cajaChica);

        }else if(cmbReporte.getSelectedItem() == TiposReporte.EXCEL){
            controladorCajaChica.generarReporteCajaChica(mes, anio, url+".xlsx",cajaChica);
        }
       
        
    }//GEN-LAST:event_btnReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFondoInical1;
    private javax.swing.JButton btnAgregarRecibo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVerRecibo;
    private javax.swing.JComboBox<String> cmbReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtencion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private com.toedter.calendar.JMonthChooser monthChooser;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelFondoInical;
    private javax.swing.JPanel panelRecibo;
    private javax.swing.JPanel panelReporte;
    private javax.swing.JTable tblRecibo;
    private javax.swing.JTextField txtFondoInicial;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables
}
