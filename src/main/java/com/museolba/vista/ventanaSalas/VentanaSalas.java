package com.museolba.vista.ventanaSalas;

import com.museolba.controlador.controladorObra.ControladorObra;
import com.museolba.controlador.controladorObra.ControladorSala;
import com.museolba.modelo.entidades.obra.Obra;
import com.museolba.modelo.entidades.obra.Sala;
import com.museolba.utils.ComponentesUtils;
import com.museolba.utils.DialogoUtils;
import com.museolba.vista.ventanaObra.FormObra;
import com.museolba.vista.ventanaPrincipal.VentanaPrincipal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.NoResultException;
import javax.swing.SwingUtilities;



public class VentanaSalas extends javax.swing.JPanel {
    ControladorSala controladorSala = null;
    
    public VentanaSalas() {
        initComponents();
        controladorSala = new ControladorSala();
        cargarTabla();
    }
    
    private void cargarTabla(){
       
       try {
            List<Sala> salas = controladorSala.obtenerTodasLasSalas();

            // Filtrar las salas para excluir "Entregado al artista"
            List<Sala> salasFiltradas = salas.stream()
                    .filter(sala -> !"Entregado al artista".equalsIgnoreCase(sala.getNombre()))
                    .collect(Collectors.toList());

            // Crear los títulos de las columnas (nombres de las salas)
          String[] titulos = salasFiltradas.stream().map(Sala::getNombre).toArray(String[]::new);

          // Crear el mapeador para transformar las obras en filas
          ComponentesUtils.TableDataMapper<Integer> mapper = (filaIndex) -> {
              Object[] fila = new Object[salasFiltradas.size()];
              for (int colIndex = 0; colIndex < salasFiltradas.size(); colIndex++) {
                  List<Obra> obras = salasFiltradas.get(colIndex).getObras();
                  fila[colIndex] = (filaIndex < obras.size()) ? obras.get(filaIndex).getTitulo() : ""; // Si no hay obra, dejar vacío
              }
              return fila;
          };

          // Determinar el número máximo de obras en cualquier sala
          int maxObras = salasFiltradas.stream().mapToInt(sala -> sala.getObras().size()).max().orElse(0);

          // Crear una lista de índices para representar las filas
          List<Integer> indices = new ArrayList<>();
          for (int i = 0; i < maxObras; i++) {
              indices.add(i);
          }

          // Cargar los datos en la tabla usando ComponentesUtils
          ComponentesUtils.cargarTabla(tblSala, indices, titulos, mapper, true);

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
        tblSala = new javax.swing.JTable();

        setMinimumSize(new java.awt.Dimension(738, 572));
        setPreferredSize(new java.awt.Dimension(738, 572));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("DejaVu Serif", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 0, 102));
        lblTitulo.setText("Muestra Obras");

        tblSala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSala);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(549, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblSala;
    // End of variables declaration//GEN-END:variables
}
