package com.museolba.vista.ventanaCajaChica;

import com.museolba.controlador.controladorCajaChica.ControladorRecibo;
import com.museolba.modelo.entidades.cajaChica.CajaChica;
import com.museolba.modelo.entidades.cajaChica.Producto;
import com.museolba.modelo.entidades.cajaChica.Recibo;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.CopiarTextoURLUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.utils.cloudinary.CloudinaryService;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.NoResultException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class FormGestionRecibo extends javax.swing.JDialog {
    
    String urlImage = "";
    String[] titulos = {"Nombre", "Precio Unitario", "cantidad"};
    ControladorRecibo controladorRecibo= null;
    List<Producto> productosNR = null;
    CloudinaryService cloud = new CloudinaryService();
    Long numbLegajo = 0l;
    CajaChica cajaChica = null;
    
    
    public FormGestionRecibo(java.awt.Frame parent, boolean modal, Long numLegajo, CajaChica cajaChica) {
        super(parent, modal);
        initComponents();
        controladorRecibo = new ControladorRecibo();
        productosNR = new ArrayList<>();
        this.numbLegajo = numLegajo;
        this.cajaChica = cajaChica;
        
        panelInfo.setVisible(false);
        
        
        SwingUtilities.invokeLater(() -> {
          cargarTablaSinRecibo();
        });
   
    }
    
     public FormGestionRecibo(java.awt.Frame parent, boolean modal, Recibo recibo) {
        super(parent, modal);
        initComponents();
        
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        
        controladorRecibo = new ControladorRecibo();
        
        txtNombre.setText(recibo.getNombre());
        txtResponsable.setText(String.valueOf(recibo.getResponsable()));
        
        txtFecha.setText(String.valueOf(recibo.getFechaRegistro().format(formatterFecha)+" "+recibo.getFechaRegistro().format(formatterHora)));
        txtPrecioTotal.setText(String.valueOf(recibo.getPrecioTotal()));

        lblUrl.setText(recibo.getImagenUrl());
        
         SwingUtilities.invokeLater(() -> {
           cargarTablaConRecibo(recibo.getId());
         });
         
         btnImagenRecibo.setEnabled(false);
         btnEliminarProducto.setEnabled(false);
         btnAgregarProducto.setEnabled(false);
         btnGuardar.setEnabled(false);
         
         try{
             URL url = new URL(recibo.getImagenUrl());
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
   
    }
    
    private void cargarTablaConRecibo(Long idRecibo){
        List<Producto> productos = controladorRecibo.obtenerProductosPorRecibo(idRecibo);
        
        
        ComponentesUtils.TableDataMapper<Producto> productoMapper = producto -> new Object[]{
            producto.getNombre(),
            producto.getPrecioUnitario(),
            producto.getCantidad()
        };
        
        // Cargar la tabla con los productos
        try {
            ComponentesUtils.cargarTabla(tblProductos, productos, titulos, productoMapper, true);
        } catch (NoResultException e) {
            DialogoUtils.mostrarMensaje("No se encontraron productos en este recibo!", 1, "Atención");
        }
    }
    
    private void cargarTablaSinRecibo(){
        
         // Verificar si la lista de productos está inicializada
        if (productosNR == null) {
            productosNR = new ArrayList<>(); // Inicializar como lista vacía si es null
        }
        
        // Mapper para convertir un Producto en una fila de la tabla
        ComponentesUtils.TableDataMapper<Producto> productoMapper = producto -> new Object[]{
            producto.getNombre(),
            producto.getPrecioUnitario(),
            producto.getCantidad()
        };
        
        ComponentesUtils.cargarTabla(tblProductos, productosNR, titulos, productoMapper, false);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        panelProducto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        lblTitulo5 = new javax.swing.JLabel();
        btnImagenRecibo = new javax.swing.JButton();
        lblUrl = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        panelInfo = new javax.swing.JPanel();
        lblTitulo4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblTitulo6 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        lblTitulo8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblTitulo7 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 487));

        lblTitulo1.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo1.setText("Gestión Recibo");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        btnCerrar.setText("Cerrar");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        panelProducto.setBackground(new java.awt.Color(204, 204, 204));
        panelProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 102), 1, true));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        lblTitulo5.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo5.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo5.setText("Producto");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(lblTitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnImagenRecibo.setText("Agregar Imagen");
        btnImagenRecibo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImagenRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenReciboActionPerformed(evt);
            }
        });

        lblUrl.setForeground(new java.awt.Color(0, 0, 153));
        lblUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUrlMouseClicked(evt);
            }
        });

        lblImage.setForeground(new java.awt.Color(102, 102, 102));

        panelInfo.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo4.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo4.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo4.setText("Nombre");

        txtNombre.setEditable(false);

        lblTitulo6.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo6.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo6.setText("Responsable");

        txtResponsable.setEditable(false);

        lblTitulo8.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo8.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo8.setText("Fecha");

        txtFecha.setEditable(false);

        lblTitulo7.setFont(new java.awt.Font("DejaVu Serif", 0, 18)); // NOI18N
        lblTitulo7.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo7.setText("Precio Total");

        txtPrecioTotal.setEditable(false);

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                        .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPrecioTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblTitulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUrl)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImagenRecibo)
                                .addGap(18, 18, 18)
                                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addComponent(panelProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnImagenRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUrl)
                .addGap(6, 6, 6)
                .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if(tblProductos.getRowCount()> 0){
            if(tblProductos.getSelectedRow()!=-1){
                int filaSeleccionada = tblProductos.getSelectedRow();
                
                productosNR.remove(filaSeleccionada);
                cargarTablaSinRecibo();
            }else{
                DialogoUtils.mostrarMensaje("Debe seleccionar un producto para eliminar!", 1, "Atención");
            }
        }   
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    public double calcularPrecioTotal(List<Producto> productos) {
        double precioTotal = 0.0;

        for (Producto producto : productos) {
            precioTotal += producto.getPrecioUnitario() * producto.getCantidad();
        }

        return precioTotal;
    }
    
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
       VentanaPrincipal vP = (VentanaPrincipal) SwingUtilities.getWindowAncestor(this);
       if(vP != null){
            FormGestionProducto formProducto = new FormGestionProducto(vP, true);
            formProducto.setLocationRelativeTo(vP);
            formProducto.setVisible(true);
            
           Producto nuevoProducto = formProducto.getProducto(); // Obtener el producto
           
            if (nuevoProducto != null) { // Verificar que no sea null
                 
                productosNR.add(nuevoProducto);
        
                cargarTablaSinRecibo();
            } else {
                DialogoUtils.mostrarMensaje("No se agregó ningún producto.", 1, "Atención");
            }
       }
      
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnImagenReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenReciboActionPerformed

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
    }//GEN-LAST:event_btnImagenReciboActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Validaciones iniciales
            if (productosNR == null || productosNR.isEmpty()) {
                DialogoUtils.mostrarMensaje("Lista de productos vacía!", 2, "ERROR");
                return;
            }

            if (urlImage == null || urlImage.isEmpty()) {
                DialogoUtils.mostrarMensaje("Debe seleccionar una imagen!", 2, "ERROR");
                return;
            }

            if (numbLegajo == null || cajaChica == null) {
                DialogoUtils.mostrarMensaje("Datos inválidos, verifique la información!", 2, "ERROR");
                return;
            }

            int opcion = JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro de que desea GUARDAR el RECIBO con los datos ingresado ?\nRECUERDE ESTA ACCIÓN NO SE PUEDE MODIFICAR", 
                "ATENCIÓN!", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {

                 Recibo recibo = new Recibo();

                // Subir imagen a la nube
                String urlCloud;
                try {
                    urlCloud = cloud.subirImagen(urlImage);
                    recibo.setImagenUrl(urlCloud);
                } catch (Exception ex) {
                    DialogoUtils.mostrarMensaje("Error al subir la imagen: " + ex.getMessage(), 2, "ERROR");
                    return;
                }

                // Calcular precio total
                Double precioTotal = calcularPrecioTotal(productosNR);
                LocalDateTime fecha = LocalDateTime.now();

                // Setear valores al recibo
                recibo.setResponsable(numbLegajo);
                recibo.setProductos(productosNR);
                recibo.setFechaRegistro(fecha);
                recibo.setPrecioTotal(precioTotal);
                recibo.setCajaChica(cajaChica);

                // Agregar recibo a caja chica
                cajaChica.agregarRecibo(recibo);

                try {
                    controladorRecibo.crearRecibo(recibo);
                    DialogoUtils.mostrarMensaje("Se agregó correctamente el recibo!", 1, "ÉXITO");
                    this.dispose();
                } catch (Exception ex) {
                    DialogoUtils.mostrarMensaje("Error al guardar el recibo: " + ex.getMessage(), 2, "ERROR");
                }

            } else {
                DialogoUtils.mostrarMensaje("Se cancelo el guardado del RECIBO", 1, "Atencion!");
            }
        
        } catch (Exception e) {
            DialogoUtils.mostrarMensaje("Error inesperado: " + e.getMessage(), 2, "ERROR");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void lblUrlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUrlMouseClicked
        String url = lblUrl.getText();
        CopiarTextoURLUtils.copiarTexto(url);
    }//GEN-LAST:event_lblUrlMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagenRecibo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioTotal;
    private javax.swing.JTextField txtResponsable;
    // End of variables declaration//GEN-END:variables
}
