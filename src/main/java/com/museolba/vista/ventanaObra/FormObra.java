package com.museolba.vista.ventanaObra;


import com.museolba.controlador.controladorArtista.ControladorArtista;
import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.controlador.controladorSala.ControladorSala;
import com.museolba.modelo.entidades.artista.Artista;
import com.museolba.modelo.entidades.obra.EstadoExposicion;
import com.museolba.modelo.entidades.obra.EstadoObra;
import com.museolba.modelo.entidades.obra.TipoObra;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.sala.Sala;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.CopiarTextoURLUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.UIValidacionUtils;
import com.museolba.utils.cloudinary.CloudinaryService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;


public class FormObra extends javax.swing.JDialog {
    private String urlImage = "";
    private CloudinaryService cloud = new CloudinaryService();
    private ControladorSala controladorSala = null;
    private ControladorArtista controladorArtista = null;
    private ControladorObra controladorObra = null;
    private LocalDateTime fechaActual = LocalDateTime.now();
    private Obra obra = null;
   
    
    public FormObra(java.awt.Frame parent, boolean modal, boolean editable, Obra obra) {
        super(parent, modal);
        initComponents();
        
        this.controladorSala = new ControladorSala();
        this.controladorArtista = new ControladorArtista();
        this.controladorObra = new ControladorObra();
        this.obra = obra;
       
        cargarSalasEnComboBox();
        cargarArtistasEnComboBox();
        ComponentesUtils.cargarComboBox(cmbEstado, EstadoObra.class);
        ComponentesUtils.cargarComboBox(cmbTipoObra, TipoObra.class);
        
        if(editable && obra != null){            
            btnModificar.setEnabled(true);
            btnGuardar.setEnabled(false);
            
            cmbArtista.setSelectedItem(obra.getArtista());
            cmbTipoObra.setSelectedItem(obra.getTipoObra());
            txtTitulo.setText(obra.getTitulo());
            txtAncho.setText(String.valueOf(obra.getAncho()));
            txtLargo.setText(String.valueOf(obra.getAltura()));
            cmbSala.setSelectedItem(obra.getSala());
            cmbEstado.setSelectedItem(obra.getEstadoObra());
            txtDescripcion.setText(obra.getDescripcion());
            
            try{
                URL url = new URL(obra.getImagenUrl());
                BufferedImage image = ImageIO.read(url);

                ImageIcon icon = new ImageIcon(image);
                Image imagenRedimensionada = icon.getImage().getScaledInstance(
                   lblImage.getWidth(), // Ancho del label
                   lblImage.getHeight(), // Alto del label
                   Image.SCALE_SMOOTH // Algoritmo de escalado suave
               );

                ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

                lblImage.setIcon(iconoRedimensionado);

            }catch(Exception e){
                lblImage.setText("Error al cargar la imágen");
            }
            
            lblUrl.setText(obra.getImagenUrl());
            
        }
    }
   
    private void cargarSalasEnComboBox() {
        List<Sala> salas = controladorSala.obtenerTodasLasSalas();

        cmbSala.removeAllItems();

        for (Sala sala : salas) {
            cmbSala.addItem(sala);
        }
    }
    
    private void cargarArtistasEnComboBox() {
        List<Artista> artistas = controladorArtista.traerTodosLosArtistas();

        cmbArtista.removeAllItems();

        for (Artista artista : artistas) {
            cmbArtista.addItem(artista);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cmbSala = new javax.swing.JComboBox<>();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo7 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JButton();
        lblUrl = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        cmbArtista = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        txtAncho = new javax.swing.JTextField();
        lblTitulo8 = new javax.swing.JLabel();
        lblTitulo9 = new javax.swing.JLabel();
        txtLargo = new javax.swing.JTextField();
        lblTitulo10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblTitulo11 = new javax.swing.JLabel();
        cmbTipoObra = new javax.swing.JComboBox<>();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 487));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Gestión Obra");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo3.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo3.setText("Artista");

        lblTitulo5.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo5.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo5.setText("Descripción");

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblTitulo6.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo6.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo6.setText("Sala");

        lblTitulo7.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo7.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo7.setText("Titulo");

        lblImage.setBackground(new java.awt.Color(255, 0, 51));
        lblImage.setForeground(new java.awt.Color(255, 0, 51));

        btnCargarImg.setText("Cargar Img");
        btnCargarImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });

        lblUrl.setForeground(new java.awt.Color(0, 0, 255));
        lblUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUrlMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Medida");

        txtAncho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnchoKeyReleased(evt);
            }
        });

        lblTitulo8.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo8.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo8.setText("Largo");

        lblTitulo9.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo9.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo9.setText("Ancho");

        txtLargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLargoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo10.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo10.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo10.setText("Estado");

        lblTitulo11.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo11.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo11.setText("Tipo Obra");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbArtista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(465, 465, 465))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTitulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(121, 121, 121)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitulo11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cmbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblTitulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUrl))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        lblError.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(lblError)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(txtTitulo.getText().isEmpty() || txtAncho.getText().isEmpty() || 
                    txtDescripcion.getText().isEmpty() || txtLargo.getText().isEmpty()){
                DialogoUtils.mostrarMensaje("Rellene todos los campos antes de guardar la obra", 1, "Atención!");
                return;
            }
            
            if(urlImage.equals("")){
                DialogoUtils.mostrarMensaje("Cargue la imagen de la obra antes de guardar", 1, "Atención!");
                return;
            }
            
            Obra obra = new Obra();
            obra.setTitulo(txtTitulo.getText());
            obra.setArtista((Artista) cmbArtista.getSelectedItem());
            obra.setTipoObra((TipoObra) cmbTipoObra.getSelectedItem());
            obra.setDescripcion(txtDescripcion.getText());
            
            obra.setAncho(Double.valueOf(txtAncho.getText()));
            obra.setAltura(Double.valueOf(txtLargo.getText()));
            
            obra.setSala((Sala) cmbSala.getSelectedItem());
            obra.setEstadoObra((EstadoObra) cmbEstado.getSelectedItem());
            
            // Subir imagen a la nube
            String urlCloud;
            try {
                urlCloud = cloud.subirImagen(urlImage);
                obra.setImagenUrl(urlCloud);
            } catch (Exception ex) {
                DialogoUtils.mostrarMensaje("Error al subir la imagen: " + ex.getMessage(), 2, "ERROR");
                return;
            }
            
            obra.setFechaEntrada(fechaActual);
            
            
            if(cmbSala.getSelectedItem().equals(compararSala("Pinacoteca"))){
                obra.setEstadoExpo(EstadoExposicion.GUARDADO);
            }else if(cmbSala.getSelectedItem().equals(compararSala("Entregado al Artista"))){
                DialogoUtils.mostrarMensaje("Seleccione una sala válida", 1, "Atención!");
                return;
            }else{
                obra.setEstadoExpo(EstadoExposicion.EXPUESTO);
            }
            
            
            controladorObra.crearObra(obra);
            DialogoUtils.mostrarMensaje("Se guardo correctamente la obra", 1, "Exito!");
            this.dispose();
            
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("Error: "+e.getMessage(), 2, "Error");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCargarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");

        // Filtrar solo imágenes (opcional)
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg", "gif"));

        // Mostrar el diálogo y obtener el resultado
        int seleccion = fileChooser.showOpenDialog(null);

        // Si el usuario seleccionó un archivo
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String ruta = archivoSeleccionado.getAbsolutePath();
            
            urlImage = ruta;//ruta de la imagen
            
            //Transofrmar en icono la imagen
            ImageIcon icono = new ImageIcon(urlImage);
           
            //Redimensionar Imagen
            Image imagenRedimensionada = icono.getImage().getScaledInstance(
                lblImage.getWidth(), // Ancho del label
                lblImage.getHeight(), // Alto del label
                Image.SCALE_SMOOTH // Algoritmo de escalado suave
            );
            ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
            
            //Actualizar label con la imagen
            lblImage.setIcon(iconoRedimensionado);
        } else {
            System.out.println("No se seleccionó ninguna imagen.");
        }
    }//GEN-LAST:event_btnCargarImgActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         try{
            if(txtTitulo.getText().isEmpty() || txtAncho.getText().isEmpty() || 
                    txtDescripcion.getText().isEmpty() || txtLargo.getText().isEmpty()){
                DialogoUtils.mostrarMensaje("Rellene todos los campos antes de guardar la obra", 1, "Atención!");
                return;
            }
            
            if(lblUrl.getText().equals("")){
                DialogoUtils.mostrarMensaje("Cargue la imagen de la obra antes de guardar", 1, "Atención!");
                return;
            }
            
            String titulo = txtTitulo.getText();
            Artista artista = (Artista) cmbArtista.getSelectedItem();
            TipoObra tipoObra = (TipoObra) cmbTipoObra.getSelectedItem();
            String descripcion = txtDescripcion.getText();
            Double ancho = Double.valueOf(txtAncho.getText());
            Double altura = Double.valueOf(txtLargo.getText());
            Sala sala = (Sala) cmbSala.getSelectedItem();
            EstadoObra estadoObra = (EstadoObra) cmbEstado.getSelectedItem();
            
            String urlSist = urlImage;
            
            String imgUrl;
            
            if(urlSist.equals("")){
                imgUrl = obra.getImagenUrl();
            }else{
                
                String urlCloud;
                try {
                    urlCloud = cloud.subirImagen(urlImage);
                    imgUrl = urlCloud;
                } catch (Exception ex) {
                    DialogoUtils.mostrarMensaje("Error al subir la imagen: " + ex.getMessage(), 2, "ERROR");
                    return;
                }
               
            }
            
            
            
            EstadoExposicion estadoExpo;
            
            if (!sala.equals(obra.getSala())) {
                if (sala.equals(compararSala("Entregado al Artista"))) {
                    estadoExpo = EstadoExposicion.FINALIZADO;
                } else if (sala.equals(compararSala("Pinacoteca"))) {
                    estadoExpo = EstadoExposicion.GUARDADO;
                } else {
                    estadoExpo = EstadoExposicion.EXPUESTO;
                }
            } else {
                estadoExpo = obra.getEstadoExpo();
            }

            
            Obra obraEditar = new Obra(obra.getNumInv(), titulo, artista, tipoObra, descripcion, ancho, altura, estadoObra, imgUrl, estadoExpo, sala);
            controladorObra.editarObra(obraEditar);
            DialogoUtils.mostrarMensaje("Se Guardo Artista con éxito!", 1, "Éxito!");
            this.dispose();
            
        }catch(Exception e){
            DialogoUtils.mostrarMensaje("Error: "+e.getMessage(), 2, "Error");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void lblUrlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUrlMouseClicked
      String text = lblUrl.getText();
      CopiarTextoURLUtils.copiarTexto(text);
    }//GEN-LAST:event_lblUrlMouseClicked

    private void txtAnchoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoKeyReleased
        UIValidacionUtils.validacionDigito(txtAncho, lblError);
    }//GEN-LAST:event_txtAnchoKeyReleased

    private void txtLargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoKeyReleased
        UIValidacionUtils.validacionDigito(txtLargo, lblError);
    }//GEN-LAST:event_txtLargoKeyReleased

    private Sala compararSala (String nombre){
        Optional<Sala> optionalSala = controladorSala.buscarSalaPorNombre(nombre);
        Sala sala = optionalSala.orElse(null);
        return sala;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarImg;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<Artista> cmbArtista;
    private javax.swing.JComboBox<Sala> cmbEstado;
    private javax.swing.JComboBox<Sala> cmbSala;
    private javax.swing.JComboBox<TipoObra> cmbTipoObra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JTextField txtAncho;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtLargo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
