/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sv.edu.udb.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sv.edu.udb.controller.MorasDAO;
import sv.edu.udb.model.Mora;

/**
 *
 * @author Mercadeo 1
 */
public class MorasFrame extends javax.swing.JFrame {

    private void listarMoras() {
    // Encabezados de la tabla
    String[] columnas = {"ID Mora", "ID Alumno", "ID Préstamo", "Monto", "Fecha Registro", "Estado"};
    
    // Modelo con celdas no editables
    DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // 🔒 Evita que se puedan editar las celdas
        }
    };

    MorasDAO dao = new MorasDAO();
    List<Mora> lista = dao.listarMoras();

    for (Mora m : lista) { //for-each
        Object[] fila = {
            m.getIdMora(),
            m.getIdAlumno(),
            m.getIdPrestamo(),
            m.getMonto(),
            m.getFechaRegistro(),
            m.getEstado()
        };
        modelo.addRow(fila);
    }

    tblMoras.setModel(modelo);
}
    
    
    
    // metodo limpia todos los campos txt
    private void limpiarCampos(){
            txtidMora.setText("");
            txtidPrestamo.setText("");
            txtidAlumno.setText("");
            txtMonto.setText("");
            txtFechaRegistro.setText("");
            txtEstado.setText("");
            cmbEstado.setSelectedIndex(0);
            
    }
    
    
    /**
     * Creates new form MorasFrame
     */
    public MorasFrame() {
        initComponents();
        listarMoras();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidPrestamo = new javax.swing.JTextField();
        txtidAlumno = new javax.swing.JTextField();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtidMora = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnTodas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMoras = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Calcular moras");

        jLabel2.setText("ID Prestamo:");

        jLabel3.setText("ID Alumno:");

        txtidAlumno.setEditable(false);

        lblMonto.setText("Monto:");

        txtMonto.setEditable(false);

        jLabel4.setText("Fecha Registro:");

        txtFechaRegistro.setEditable(false);

        jLabel5.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "...", "Pendiente", "Pagado" }));

        btnCalcular.setText("Calcular Mora");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar Mora");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtEstado.setEditable(false);

        btnMenu.setText("Volver al Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Estado");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar por ID");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtidMora.setEditable(false);

        jLabel6.setText("ID Mora:");

        btnTodas.setText("Limpiar Campos");
        btnTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtidPrestamo)
                    .addComponent(txtidAlumno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel6))
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMonto))
                    .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidMora, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtMonto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMenu)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCalcular)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar)
                                .addContainerGap(100, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnModificar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtidAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        tblMoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Mora", "ID Alumno", "ID Prestamo", "Monto", "Fecha Registro", "Estado"
            }
        ));
        tblMoras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMorasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMoras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
        int idPrestamo = Integer.parseInt(txtidPrestamo.getText());
        MorasDAO dao = new MorasDAO();
        Mora mora = dao.calcularMora(idPrestamo);

        if (mora != null) {
            txtidAlumno.setText(String.valueOf(mora.getIdAlumno()));
            txtMonto.setText(String.format("%.2f", mora.getMonto()));
            txtFechaRegistro.setText(mora.getFechaRegistro().toString());
            txtEstado.setText(mora.getEstado());
        } else {
            JOptionPane.showMessageDialog(this, "El préstamo no tiene mora o no existe.", "Sin mora", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
           
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Ingrese un ID de préstamo válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCalcularActionPerformed

    
    
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
        // Obtener valores de los campos
        int idPrestamo = Integer.parseInt(txtidPrestamo.getText());
        int idAlumno = Integer.parseInt(txtidAlumno.getText());
        double monto = Double.parseDouble(txtMonto.getText());
        java.sql.Date fechaRegistro = java.sql.Date.valueOf(txtFechaRegistro.getText()); // formato: yyyy-MM-dd
        String estado = txtEstado.getText();

        // Crear objeto Mora
        Mora mora = new Mora();
        mora.setIdPrestamo(idPrestamo);
        mora.setIdAlumno(idAlumno);
        mora.setMonto(monto);
        mora.setFechaRegistro(fechaRegistro);
        mora.setEstado(estado);

        // Registrar en la base de datos
        MorasDAO dao = new MorasDAO();
        boolean resultado = dao.registrarMora(mora);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Mora registrada exitosamente.");
            listarMoras(); 
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la mora.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error en el formato de número: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, "Error en la fecha. Asegúrate de que esté en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    
    
    
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new AdminFrame().setVisible(true);
            dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed

    
    
    private void tblMorasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMorasMouseClicked
        int fila = tblMoras.getSelectedRow();

    if (fila >= 0) {
        txtidMora.setText(tblMoras.getValueAt(fila, 0).toString()); // id_mora
        txtidAlumno.setText(tblMoras.getValueAt(fila,1).toString());
        txtidPrestamo.setText(tblMoras.getValueAt(fila,2).toString());
        txtMonto.setText(tblMoras.getValueAt(fila,3).toString());
        txtFechaRegistro.setText(tblMoras.getValueAt(fila,4).toString());
        txtEstado.setText(tblMoras.getValueAt(fila,5).toString());
        cmbEstado.setSelectedItem(tblMoras.getValueAt(fila, 5).toString()); // estado
        
        
    }
    }//GEN-LAST:event_tblMorasMouseClicked

    
    
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
         if (txtidMora.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione una mora para modificar.");
        return;
    }

    int idMora = Integer.parseInt(txtidMora.getText());
    String nuevoEstado = cmbEstado.getSelectedItem().toString();

    MorasDAO dao = new MorasDAO();
    boolean resultado = dao.actualizarEstadoMora(idMora, nuevoEstado);

    if (resultado) {
        JOptionPane.showMessageDialog(this, "Estado de mora actualizado con éxito.");
        listarMoras(); // Método que refresca tblMoras
        limpiarCampos();      // Si tienes un método para limpiar campos
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo actualizar el estado.");
            }
    }//GEN-LAST:event_btnModificarActionPerformed

    
    
    
    private void btnTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasActionPerformed
       limpiarCampos();
    }//GEN-LAST:event_btnTodasActionPerformed

    
    
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtidPrestamo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese el ID del préstamo para buscar.");
        return;
    }

    int idPrestamo = Integer.parseInt(txtidPrestamo.getText());
    MorasDAO dao = new MorasDAO();
    Mora m = dao.obtenerMoraPorIdPrestamo(idPrestamo);

    if (m != null) {
        txtidMora.setText(String.valueOf(m.getIdMora()));
        txtidAlumno.setText(String.valueOf(m.getIdAlumno()));
        txtMonto.setText(String.valueOf(m.getMonto()));
        txtFechaRegistro.setText(m.getFechaRegistro().toString());
        cmbEstado.setSelectedItem(m.getEstado());
        

        JOptionPane.showMessageDialog(this, "Mora encontrada.");
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró mora con ese ID de préstamo.");
        limpiarCampos(); 
         }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MorasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MorasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MorasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MorasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MorasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTodas;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JTable tblMoras;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtidAlumno;
    private javax.swing.JTextField txtidMora;
    private javax.swing.JTextField txtidPrestamo;
    // End of variables declaration//GEN-END:variables
}
