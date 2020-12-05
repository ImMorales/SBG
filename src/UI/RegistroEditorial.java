package UI;

import Logic.Libro;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class RegistroEditorial extends javax.swing.JFrame {

    private DefaultTableModel modelEditorial;
    private int idLibro;
    private String nombreLibro;
    private String desc;
    private String tipo;
    private String subgenero;
    private int cantidad;
    private Libro libroAIngresar;

    public RegistroEditorial() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarPlaceHolders();
        mostrarEditoriales();
        actualizarBusqueda();
        elegirOEliminar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        elegirOption = new javax.swing.JMenuItem();
        eliminarOption = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEditoriales = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0) return false;
                if(column == 1) return false;
                return true;
            }
        };
        btnAceptar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        elegirOption.setText("jMenuItem1");
        jPopupMenu1.add(elegirOption);

        eliminarOption.setText("jMenuItem2");
        jPopupMenu1.add(eliminarOption);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editorial");
        setMinimumSize(new java.awt.Dimension(634, 363));
        setResizable(false);
        setSize(new java.awt.Dimension(634, 363));

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 320));

        txtBusqueda.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusqueda.setPreferredSize(new java.awt.Dimension(320, 30));
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        tblEditoriales.setAutoCreateRowSorter(true);
        tblEditoriales.setModel(new javax.swing.table.DefaultTableModel());
        tblEditoriales.setShowVerticalLines(false);
        tblEditoriales.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEditoriales);

        btnAceptar.setBackground(new java.awt.Color(102, 102, 255));
        btnAceptar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 0, 51));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nombre:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Registrar Nueva Editorial");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        System.out.println(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        String input = txtBusqueda.getText();
        if (input.equals("Filtrar")) {
            txtBusqueda.setForeground(new java.awt.Color(0, 0, 0));
            txtBusqueda.setText(null);
            txtBusqueda.setCaretPosition(0);
        }
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        RegistroLibro volver = new RegistroLibro();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registrarEditorialABD();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        registrarEditorialABD();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEditorial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JMenuItem elegirOption;
    private javax.swing.JMenuItem eliminarOption;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
    private void mostrarEditoriales() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM editorial order by id_editorial";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelEditorial = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelEditorial.setColumnIdentifiers(new Object[]{"ID", "Nombre"});
            tblEditoriales.setModel(modelEditorial);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    private void mostrarPlaceHolders() {
        new TextPrompt("Buscar Editorial", txtBusqueda);
        new TextPrompt("Nombre (s)", txtNombre);
    }

    private void actualizarBusqueda() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                filterTable();
            }

            public void filterTable() {
                String search = txtBusqueda.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sorter
                        = new TableRowSorter<>(modelEditorial);
                tblEditoriales.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
            }
        }
        );
    }

    private void elegirOEliminar() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemElegir = new JMenuItem("Elegir");
        JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
        popupMenu.setPopupSize(100, 60);

        popupMenu.add(menuItemElegir);
        popupMenu.add(menuItemEliminar);

        tblEditoriales.setComponentPopupMenu(popupMenu);

        menuItemElegir.addActionListener((ActionEvent ae) -> {
            elegirEditorial();

        });

        menuItemEliminar.addActionListener((ActionEvent ae) -> {
            elegirEditorial();
            eliminarEditoriales();
        });
    }

    private void elegirEditorial() {

    }

    private void eliminarEditoriales() {
        int decision = JOptionPane.showConfirmDialog(null, "¿Eliminar elemento (s)"
                + " seleccionados (s)?", "Eliminar", 0);
        if (decision == JOptionPane.OK_OPTION) {

        }
    }

    private void setEditorialALibro() {

    }

    private void eliminarDeBD(int id) {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "DELETE FROM editorial WHERE id_editorial = " + id + ";";
            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();
            mostrarEditoriales();

        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
        System.out.println("Eliminado: " + id);
    }

    public void recibirCampos(Libro libro) {
        nombreLibro = libro.getNombre();
        this.desc = libro.getDesc();
        this.tipo = libro.getTipo();
        this.subgenero = libro.getSubgenero();
        this.cantidad = libro.getCantidad();

    }

    private void registrarEditorialABD() {
        if (!txtNombre.getText().equals("")) {
            String nombre = txtNombre.getText();
            Logic.conexion con = new Logic.conexion();
            con.ConectarBasedeDatos();
            Statement statement = con.sentencia;

            try {
                statement.executeUpdate(
                        "INSERT INTO editorial (nombre)"
                        + "VALUES ("
                        + "'" + nombre + "')"
                );
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEditorial.class.getName()).log(Level.SEVERE, null, ex);
            }
            mostrarEditoriales();
            con.DesconectarBasedeDatos();
            txtNombre.setText("");
        }
    }

}
