package UI;

import Logic.Estudiante;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.List;

public class EditarEstudiante extends javax.swing.JFrame {

    String oldMatricula;
    Estudiante editarEstudiante;
    Estudiante[] estudiantes;
    String matricula, nombre, paterno, grupo, materno;
    final String DIF_VAL = "<Diferentes valores>";
    int grado;

    public EditarEstudiante(Estudiante[] estudiantes) {
        initComponents();
        setLocationRelativeTo(null);
        this.estudiantes = estudiantes;
        if (estudiantes.length > 1) {
            txtIdentificador.setEnabled(false);
            txtIdentificador.setText(DIF_VAL);
            txtNombre.setEnabled(false);
            txtPaterno.setEnabled(false);
            txtMaterno.setEnabled(false);
            checkCamposDeEstudiantes(estudiantes);

        } else {
            editarEstudiante = estudiantes[0];
            oldMatricula = editarEstudiante.getIdentificador();
            iniciarCampos();
        }
        //showEstudiantes(estudiantes);

    }

    private void showEstudiantes(List<Estudiante> estudiantes) {
        System.out.println("Total a editar: " + estudiantes.size());
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    private EditarEstudiante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        txtIdentificador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        boxGrado = new javax.swing.JSpinner();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Estudiante");
        setMinimumSize(new java.awt.Dimension(536, 239));
        setResizable(false);
        setSize(new java.awt.Dimension(536, 239));

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        btnCancelar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 204, 102));
        btnRegistrar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(6, 13, 5));
        btnRegistrar.setText("Guardar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(218, 218, 218));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtIdentificador.setDisabledTextColor(new java.awt.Color(55, 55, 55));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Matricula");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Edad:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(boxGrado)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(boxGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(218, 218, 218));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre");

        txtNombre.setActionCommand("<Not Set>");
        txtNombre.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtPaterno.setActionCommand("<Not Set>");
        txtPaterno.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Paterno");

        txtMaterno.setActionCommand("<Not Set>");
        txtMaterno.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Materno");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtPaterno)
                    .addComponent(txtMaterno))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (estudiantes.length > 1) {
            actualizarEstudiantes(estudiantes);
        } else {
            actualizarEstudiante();
        }
        Estudiantes.mostrarTablaAlumnosYNumeroDeEstudiantes();
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void iniciarCampos() {
        txtIdentificador.setText("" + editarEstudiante.getIdentificador());
        txtNombre.setText("" + editarEstudiante.getNombre());
        txtPaterno.setText("" + editarEstudiante.getPaterno());
        txtMaterno.setText("" + editarEstudiante.getMaterno());
        boxGrado.setValue(editarEstudiante.getGrado());

    }

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
            java.util.logging.Logger.getLogger(EditarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner boxGrado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables

    private void checkCamposDeEstudiantes(Estudiante[] estudiantes) {
        int N = estudiantes.length;
        boolean nombreWasEqual = true;
        boolean paternoWasEqual = true;
        boolean maternoWasEqual = true;
        boolean gradoWasEqual = true;
        boolean grupoWasEqual = true;
        String nombreEnComun = "";
        String paternoEnComun = "";
        String maternoEnComun = "";
        String gradoEnComun = "";
        String grupoEnComun = "";

        for (int i = 1; i < N; i++) {
            String nombreActual = estudiantes[i].getNombre();
            String nombrePrevio = estudiantes[i - 1].getNombre();
            String paternoActual = estudiantes[i].getPaterno();
            String paternoPrevio = estudiantes[i - 1].getPaterno();
            String maternoActual = estudiantes[i].getMaterno();
            String maternoPrevio = estudiantes[i - 1].getMaterno();
            int gradoActual = estudiantes[i].getGrado();
            int gradoPrevio = estudiantes[i - 1].getGrado();
            String grupoActual = estudiantes[i].getGrupo();
            String grupoPrevio = estudiantes[i - 1].getGrupo();

            if (nombreActual.equals(nombrePrevio) && nombreWasEqual) {
                nombreEnComun = nombreActual;
            } else {
                nombreWasEqual = false;
            }

            if (paternoActual.equals(paternoPrevio) && paternoWasEqual) {
                paternoEnComun = paternoActual;
            } else {
                paternoWasEqual = false;
            }

            if (maternoActual.equals(maternoPrevio) && maternoWasEqual) {
                maternoEnComun = maternoActual;
            } else {
                maternoWasEqual = false;
            }

            if (gradoActual == gradoPrevio && gradoWasEqual) {
                gradoEnComun = gradoActual + "";
            } else {
                gradoWasEqual = false;
            }

            if (grupoActual.equals(grupoPrevio) && grupoWasEqual) {
                grupoEnComun = grupoActual;
            } else {
                grupoWasEqual = false;
            }
        }

        if (nombreWasEqual) {
            txtNombre.setText(nombreEnComun);
        } else {
            txtNombre.setText(DIF_VAL);
        }

        if (paternoWasEqual) {
            txtPaterno.setText(paternoEnComun);
        } else {
            txtPaterno.setText(DIF_VAL);
        }

        if (maternoWasEqual) {
            txtMaterno.setText(maternoEnComun);
        } else {
            txtMaterno.setText(DIF_VAL);
        }
    }

    private void actualizarEstudiantes(Estudiante[] estudiantes) {
        for (Estudiante e : estudiantes) {
            actualizarEstudiante(e.getIdentificador());
        }
    }

    private void actualizarEstudiante(String id) {
        getValueFromCampos();
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        Statement statement = (Statement) con.sentencia;
        try {
            statement.executeUpdate(
                    "UPDATE alumno SET "
                    + "matricula = '" + id + "',"
                    + "grado =" + grado + ", "
                    + "grupo = '" + grupo + "'"
                    + "WHERE matricula = '" + id + "';");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void getValueFromCampos() {
        matricula = txtIdentificador.getText();
        nombre = txtNombre.getText();
        paterno = txtPaterno.getText();
        materno = txtMaterno.getText();
        grado = (int) boxGrado.getValue();
        grupo = "A";
    }

    private void actualizarEstudiante() {
        getValueFromCampos();
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        Statement statement = (Statement) con.sentencia;
        try {
            statement.executeUpdate(
                    "UPDATE alumno SET "
                    + "matricula = '" + matricula + "',"
                    + "nombre = '" + nombre + "',"
                    + "apellido_paterno = '" + paterno + "',"
                    + "apellido_materno = '" + materno + "', "
                    + "grado =" + grado + ", "
                    + "grupo = '" + grupo + "'"
                    + "WHERE matricula = '" + oldMatricula + "';");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
