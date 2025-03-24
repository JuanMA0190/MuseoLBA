package com.museolba.vista.ventanaObra;

import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.modelo.entidades.obra.EstadoExposicion;
import com.museolba.modelo.entidades.obra.EstadoObra;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.TipoObra;
import com.museolba.modelo.entidades.usuario.RolUsuario;
import com.museolba.modelo.entidades.usuario.Usuario;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.ComponentesUtils.TableDataMapper;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.reportes.obra.TodasObraPDFGenerador;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.NoResultException;
import javax.swing.SwingUtilities;


public class VentanaObra extends javax.swing.JPanel {
   ControladorObra controladorObra = null;
   String[] titulos = {"Num. Inv.", "Titulo", "Artista", "Tipo", "Fecha", "Sala", "Estado", "Exposicion"};
   
    public VentanaObra(Usuario usuario) {
        initComponents();
        controladorObra = new ControladorObra();
        cargarComboBoxFiltro();
        cargarTabla(); 
        btnCargarDatosIniciales.setVisible(false);
        cmbOpcion.setEnabled(false);
        
        if(usuario.getRolUsuario()==RolUsuario.PERSONAL){
            btnRegistrar.setVisible(false);
            btnModificar.setVisible(false);
            btnReporte.setVisible(false);
        }
    }
    
    private void cargarComboBoxFiltro() {
        // Cargar las opciones de filtro en el comboBoxFiltro
        cmbFilto.addItem("Titulo");
        cmbFilto.addItem("TipoObra");
        cmbFilto.addItem("EstadoExposicion");
        cmbFilto.addItem("EstadoObra");

        // Agregar un listener para actualizar el comboBoxOpcion o txtBuscar según el filtro seleccionado
        cmbFilto.addActionListener(e -> actualizarOpcionesFiltro());
    }
   
    private void actualizarOpcionesFiltro() {
        String filtroSeleccionado = (String) cmbFilto.getSelectedItem();

        // Limpiar el comboBoxOpcion y el campo de texto
        cmbOpcion.removeAllItems();
        txtBuscar.setText("");

        if ("Titulo".equals(filtroSeleccionado)) {
            // Mostrar el campo de texto para buscar por título
            txtBuscar.setEnabled(true);
            cmbOpcion.setEnabled(false);
        } else {
            // Mostrar el comboBoxOpcion para los demás filtros
            txtBuscar.setEnabled(false);
            cmbOpcion.setEnabled(true);

            if ("TipoObra".equals(filtroSeleccionado)) {
                // Cargar las opciones de TipoObra
                for (TipoObra tipo : TipoObra.values()) {
                    cmbOpcion.addItem(tipo);
                }
            } else if ("EstadoExposicion".equals(filtroSeleccionado)) {
                // Cargar las opciones de EstadoExposicion
                for (EstadoExposicion estado : EstadoExposicion.values()) {
                    cmbOpcion.addItem(estado);
                }
            } else if ("EstadoObra".equals(filtroSeleccionado)) {
                // Cargar las opciones de EstadoObra
                for (EstadoObra estado : EstadoObra.values()) {
                    cmbOpcion.addItem(estado);
                }
            }
        }
    }

    private void buscarObras() {
        try {
            String filtroSeleccionado = (String) cmbFilto.getSelectedItem();
            List<Obra> listaObra = controladorObra.obtenerTodasLasObras();

            // Filtrar las obras según el filtro seleccionado
            List<Obra> obrasFiltradas = listaObra;

            if ("Titulo".equals(filtroSeleccionado)) {
                String textoBuscar = txtBuscar.getText().toLowerCase();
                obrasFiltradas = listaObra.stream()
                        .filter(obra -> obra.getTitulo().toLowerCase().contains(textoBuscar))
                        .collect(Collectors.toList());
            } else if ("TipoObra".equals(filtroSeleccionado)) {
                TipoObra tipoSeleccionado = (TipoObra) cmbOpcion.getSelectedItem();
                obrasFiltradas = listaObra.stream()
                        .filter(obra -> obra.getTipoObra().equals(tipoSeleccionado))
                        .collect(Collectors.toList());
            } else if ("EstadoExposicion".equals(filtroSeleccionado)) {
                EstadoExposicion estadoSeleccionado = (EstadoExposicion) cmbOpcion.getSelectedItem();
                obrasFiltradas = listaObra.stream()
                        .filter(obra -> obra.getEstadoExpo().equals(estadoSeleccionado))
                        .collect(Collectors.toList());
            } else if ("EstadoObra".equals(filtroSeleccionado)) {
                EstadoObra estadoSeleccionado = (EstadoObra) cmbOpcion.getSelectedItem();
                obrasFiltradas = listaObra.stream()
                        .filter(obra -> obra.getEstadoObra().equals(estadoSeleccionado))
                        .collect(Collectors.toList());
            }

            // Actualizar la tabla con las obras filtradas
            ComponentesUtils.cargarTabla(tblObra, obrasFiltradas, titulos, obra -> new Object[]{
                    obra.getNumInv(),
                    obra.getTitulo(),
                    obra.getArtista().getNombre(),
                    obra.getTipoObra(),
                    obra.getFechaEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                    obra.getSala().getNombre(),
                    obra.getEstadoObra(),
                    obra.getEstadoExpo()
            }, true);

        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error al buscar obras: " + e.getMessage(), 2, "Error");
        }
    }

    
    private void cargarTabla(){
        try {
            // Obtener la lista de obras desde el controlador
            List<Obra> listaObra = controladorObra.obtenerTodasLasObras();

            // Cargar la tabla usando el método utilitario
            ComponentesUtils.cargarTabla(tblObra, listaObra, titulos, obra -> new Object[]{
                    obra.getNumInv(),
                    obra.getTitulo(),
                    obra.getArtista().getNombre(),
                    obra.getTipoObra(),
                    obra.getFechaEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                    obra.getSala().getNombre(),
                    obra.getEstadoObra(),
                    obra.getEstadoExpo()
            }, true);
        } catch (NoResultException e) {
            DialogoUtils.mostrarMensaje("Error al cargar la tabla: " + e.getMessage(), 2, "Error");
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObra = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        cmbFilto = new javax.swing.JComboBox<>();
        cmbOpcion = new javax.swing.JComboBox<>();
        btnCargarDatosIniciales = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Gestión de Obra");

        tblObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblObra);

        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(90, 38));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Buscar");

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Seleccionar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo2)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbFilto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFilto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(cmbOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCargarDatosIniciales.setText("Cargar Datos Iniciales");
        btnCargarDatosIniciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosInicialesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarDatosIniciales, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargarDatosIniciales))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
       VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
       if(vP != null){
            FormObra formObra = new FormObra(vP, true, false, null);
            
            formObra.setLocationRelativeTo(vP);
            formObra.setVisible(true);
            
            cargarTabla();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try{
            VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
            
            if(tblObra.getRowCount()> 0){
                if(tblObra.getSelectedRow()!=-1){
                    int filaSeleccionada = tblObra.getSelectedRow();
                    long idObra = (long) tblObra.getValueAt(filaSeleccionada, 0);
                    
                    
                    Optional<Obra> obraOptional = controladorObra.obtenerObraPorIdConRelaciones(idObra);
                    Obra obra = obraOptional.orElse(null);

                    if (obraOptional.isPresent() && obra != null && vP != null){
                        FormObra formObra = new FormObra(vP, true, true, obra);

                        formObra.setVisible(true);
                        formObra.setLocationRelativeTo(vP);

                        cargarTabla();
                    }else{
                        DialogoUtils.mostrarMensaje("No se encontró el artista seleccionado ", 1, "Atención!");
                    }
                }else{
                    DialogoUtils.mostrarMensaje("Debe seleccionar una obra para Modificar!", 1, "Atención");
                }
            }  
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("No se encontró la obra seleccionada", 1, "Atención!");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        try{
            List<Obra> listaObra = controladorObra.obtenerTodasLasObras();
            String url = "reportes/Obras/Todas_Las_Obras/ReporteObras.pdf";
            TodasObraPDFGenerador.generarReporte(listaObra,url );
            DialogoUtils.mostrarMensaje("Reporte generado correctamente en: "+url, 1, "Atención!");
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("Error, no se pudo generar reporte: "+e.getMessage(), 2, "Error!");
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarObras(); 
        btnCargarDatosIniciales.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCargarDatosInicialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosInicialesActionPerformed
        cargarTabla();
        btnCargarDatosIniciales.setVisible(false);
    }//GEN-LAST:event_btnCargarDatosInicialesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarDatosIniciales;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JComboBox<String> cmbFilto;
    private javax.swing.JComboBox<Object> cmbOpcion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tblObra;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
