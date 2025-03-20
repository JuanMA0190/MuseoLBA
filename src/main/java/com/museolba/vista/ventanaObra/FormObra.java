package com.museolba.vista.ventanaObra;


import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.controlador.controladorObra.ControladorSala;
import com.museolba.modelo.entidades.enums.TipoObra;
import com.museolba.modelo.entidades.obras.Obra;
import com.museolba.modelo.entidades.obras.Sala;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.cloudinary.CloudinaryService;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class FormObra extends javax.swing.JDialog {
   String urlImage = "";
   ControladorObra controladorObra = null;
    ControladorSala controladorSala = null;
    CloudinaryService cloud = new CloudinaryService();
    Obra obra = null;
   
    
    
    public FormObra(java.awt.Frame parent, boolean modal, boolean editable, Obra obra) {
        super(parent, modal);
        initComponents();
        controladorObra = new ControladorObra();
        controladorSala = new ControladorSala();
        
        this.obra = obra;
        
        ComponentesUtils.cargarComboBox(cmbTipoObra, TipoObra.class);
        cargarSalasEnComboBox();
        if (obra != null){
            if(editable){
                txtArtista.setText(obra.getArtista());

                cmbSala.setSelectedItem(obra.getSala());

                cmbTipoObra.setSelectedItem(obra.getTipoObra());


                txtDescripcion.setText(obra.getDescripcion());
                txtMedida.setText(obra.getMedida());
                txtTitulo.setText(obra.getTitulo());
                lblUrl.setText(obra.getImagenUrl());
            
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

                btnGuardar.setEnabled(false);
                btnCargarImg.setEnabled(false);
                btnGuardar1.setEnabled(true);
            }
        }
        
        
        
        
        
    }
   
    private void cargarSalasEnComboBox() {
         // Obtener la lista de salas desde el controlador
        List<Sala> salas = controladorObra.obtenerTodasLasSalas();

        // Limpiar el JComboBox
        cmbSala.removeAllItems();

        // Agregar las salas al JComboBox
        for (Sala sala : salas) {
            cmbSala.addItem(sala);
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
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtArtista = new javax.swing.JTextField();
        txtMedida = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cmbTipoObra = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        cmbSala = new javax.swing.JComboBox<>();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo7 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnCargarImg = new javax.swing.JButton();
        lblUrl = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 487));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Gestión Obra");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        lblTitulo4.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo4.setText("Tipo Obra");

        lblTitulo2.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo2.setText("Medida");

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

        lblImage.setForeground(new java.awt.Color(0, 0, 0));

        btnCargarImg.setText("Cargar Img");
        btnCargarImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarImgActionPerformed(evt);
            }
        });

        lblUrl.setForeground(new java.awt.Color(0, 0, 255));
        lblUrl.setText("URL");

        btnGuardar1.setText("Modificar");
        btnGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar1.setEnabled(false);
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                                .addComponent(cmbSala, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(lblTitulo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtArtista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(lblTitulo4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTitulo5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUrl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Validar campos vacíos
        if (urlImage.isEmpty() || txtArtista.getText().isEmpty() || 
            txtDescripcion.getText().isEmpty() || txtMedida.getText().isEmpty() || 
            txtTitulo.getText().isEmpty()) {
            DialogoUtils.mostrarMensaje("No se permiten campos vacíos", 1, "Atención");
            return;
        }

        // Crear la obra
        Obra obra = new Obra();
        obra.setArtista(txtArtista.getText());
        obra.setDescripcion(txtDescripcion.getText());
        obra.setFechaEntrada(LocalDateTime.now());
        
        // Subir imagen a la nube
        String urlCloud;
        try {
            urlCloud = cloud.subirImagen(urlImage);
            obra.setImagenUrl(urlCloud);
        } catch (Exception ex) {
            DialogoUtils.mostrarMensaje("Error al subir la imagen: " + ex.getMessage(), 2, "ERROR");
            return;
        }
   
        obra.setMedida(txtMedida.getText());
        obra.setTitulo(txtTitulo.getText());

        // Obtener la sala seleccionada del JComboBox
        Sala salaSeleccionada = (Sala) cmbSala.getSelectedItem();

        // Asignar el tipo de obra
        obra.setTipoObra((TipoObra) cmbTipoObra.getSelectedItem());

        // Llamar al controlador para agregar la obra
        try {
            controladorObra.agregarObra(obra, salaSeleccionada);
            DialogoUtils.mostrarMensaje("Obra cargada correctamente", 1, "Éxito");
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
            DialogoUtils.mostrarMensaje("Error al guardar la obra: " + e.getMessage(), 2, "Error");
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

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
         // Validar campos vacíos
        if ( txtArtista.getText().isEmpty() || 
            txtDescripcion.getText().isEmpty() || txtMedida.getText().isEmpty() || 
            txtTitulo.getText().isEmpty()) {

            DialogoUtils.mostrarMensaje("No se permiten campos vacíos", 1, "Atención");
            return;
        }

        try {
            // Obtener la obra actual por su número de inventario (debe tener un campo visible para obtenerlo)
            Long idObra = Long.valueOf(obra.getNumInv());  // Asegúrate de tener un campo con el ID de la obra
            Obra obraExistente = controladorObra.buscarObraPorId(idObra);

            if (obraExistente == null) {
                DialogoUtils.mostrarMensaje("La obra no existe.", 2, "Error");
                return;
            }

            // Asignar nuevos valores a la obra
            obraExistente.setArtista(txtArtista.getText());
            obraExistente.setDescripcion(txtDescripcion.getText());
            obraExistente.setMedida(txtMedida.getText());
            obraExistente.setTitulo(txtTitulo.getText());

            // Obtener la sala seleccionada del JComboBox
            Sala salaSeleccionada = (Sala) cmbSala.getSelectedItem();
            obraExistente.setSala(salaSeleccionada);

            // Asignar el tipo de obra
            obraExistente.setTipoObra((TipoObra) cmbTipoObra.getSelectedItem());

            // Actualizar la obra
            controladorObra.actualizarObra(obraExistente);
            DialogoUtils.mostrarMensaje("¡Datos actualizados correctamente!", 1, "Éxito");
            this.dispose();  // Cerrar la ventana
        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Ocurrió un error al actualizar los datos: " + e.getMessage(), 2, "Error");
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargarImg;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JComboBox<Sala> cmbSala;
    private javax.swing.JComboBox<TipoObra> cmbTipoObra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JTextField txtArtista;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
