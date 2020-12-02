package UI;

import Logic.Autor;
import Logic.Libro;
import Logic.Editorial;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class RegistroLibro extends javax.swing.JFrame {

    protected final Libro libro = new Libro();

    public RegistroLibro() {
        initComponents();
        setLocationRelativeTo(null);
        mostrarPlaceHolders();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrarEditorial = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
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
        btnAceptarEditorial = new javax.swing.JButton();
        btnEliminarEditorial = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtNombre1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCancelarEditorial = new javax.swing.JButton();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        registrarAutor = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtBusquedaAutor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        txtNombreAutor = new javax.swing.JTextField();
        txtPaternoAutor = new javax.swing.JTextField();
        txtMaternoAutor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptarAutor = new javax.swing.JButton();
        btnEliminarAutor = new javax.swing.JButton();
        btnCancelarAutor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrarLibro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreLibro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        spnPaginas = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxSubgenero = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        boxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        btnRegistrarEditorial = new javax.swing.JButton();
        btnRegistrarAutor = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        registrarEditorial.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        registrarEditorial.setTitle("Editorial");
        registrarEditorial.setMaximumSize(new java.awt.Dimension(631, 262));
        registrarEditorial.setMinimumSize(new java.awt.Dimension(631, 262));
        registrarEditorial.setPreferredSize(new java.awt.Dimension(631, 262));
        registrarEditorial.setResizable(false);
        registrarEditorial.setSize(new java.awt.Dimension(631, 262));

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());
        registrarEditorial.getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setPreferredSize(new java.awt.Dimension(320, 320));

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

        btnAceptarEditorial.setBackground(new java.awt.Color(102, 102, 255));
        btnAceptarEditorial.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAceptarEditorial.setForeground(new java.awt.Color(0, 0, 51));
        btnAceptarEditorial.setText("Aceptar");
        btnAceptarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEditorialActionPerformed(evt);
            }
        });

        btnEliminarEditorial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminarEditorial.setText("Eliminar");
        btnEliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEditorialActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(218, 218, 218));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre1ActionPerformed(evt);
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

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Nombre:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(89, 89, 89))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Registrar nueva editorial");

        btnCancelarEditorial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelarEditorial.setText("cancelar");
        btnCancelarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnCancelarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarEditorial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptarEditorial))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarEditorial)
                            .addComponent(btnAceptarEditorial)
                            .addComponent(btnCancelarEditorial)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        registrarEditorial.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        registrarAutor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        registrarAutor.setTitle("Autor (es)");
        registrarAutor.setMinimumSize(new java.awt.Dimension(697, 402));
        registrarAutor.setResizable(false);
        registrarAutor.setSize(new java.awt.Dimension(697, 402));

        jPanel9.setBackground(new java.awt.Color(0, 102, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());
        registrarAutor.getContentPane().add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(254, 254, 254));
        jPanel10.setPreferredSize(new java.awt.Dimension(320, 320));

        txtBusquedaAutor.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusquedaAutor.setPreferredSize(new java.awt.Dimension(320, 30));

        tblAutores.setAutoCreateRowSorter(true);
        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblAutores.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tblAutores);

        jPanel11.setBackground(new java.awt.Color(218, 218, 218));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtMaternoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaternoAutorActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Nombre (s):");

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Apellido paterno:");

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Apellido materno:");

        btnRegistrar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtNombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtPaternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(78, 78, 78))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(txtNombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(txtPaternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addComponent(txtMaternoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registrar nuevo autor");

        btnAceptarAutor.setBackground(new java.awt.Color(102, 102, 255));
        btnAceptarAutor.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAceptarAutor.setForeground(new java.awt.Color(0, 0, 51));
        btnAceptarAutor.setText("Aceptar");
        btnAceptarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAutorActionPerformed(evt);
            }
        });

        btnEliminarAutor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEliminarAutor.setText("Eliminar");
        btnEliminarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAutorActionPerformed(evt);
            }
        });

        btnCancelarAutor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelarAutor.setText("cancelar");
        btnCancelarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(txtBusquedaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(btnCancelarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarAutor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptarAutor)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBusquedaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarAutor)
                            .addComponent(btnAceptarAutor)
                            .addComponent(btnCancelarAutor)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        registrarAutor.getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar libro");
        setMaximumSize(new java.awt.Dimension(672, 400));
        setMinimumSize(new java.awt.Dimension(672, 400));
        setPreferredSize(new java.awt.Dimension(672, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(672, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 320));

        btnRegistrarLibro.setBackground(new java.awt.Color(102, 102, 255));
        btnRegistrarLibro.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRegistrarLibro.setForeground(new java.awt.Color(0, 0, 51));
        btnRegistrarLibro.setText("Registrar");
        btnRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLibroActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(218, 218, 218));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nombre");

        txtNombreLibro.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDesc.setLineWrap(true);
        txtDesc.setRows(1);
        txtDesc.setToolTipText("Descripción de la parte trasera o contraportada del libro");
        txtDesc.setWrapStyleWord(true);
        txtDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtDesc);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Descripción");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNombreLibro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(218, 218, 218));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        spnPaginas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Número de páginas");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Subgenero");

        boxSubgenero.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxSubgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Al Sol Solito", "Astrolabio", "Cometas Convidados", "Pasos de Luna", "Espejo de Urania" }));
        boxSubgenero.setPreferredSize(new java.awt.Dimension(183, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tipo");

        boxTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Informativo", "Literarios" }));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Cantidad");

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(spnPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(boxSubgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boxSubgenero, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(boxTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(218, 218, 218));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        btnRegistrarEditorial.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnRegistrarEditorial.setMaximumSize(new java.awt.Dimension(75, 52));
        btnRegistrarEditorial.setMinimumSize(new java.awt.Dimension(75, 52));
        btnRegistrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEditorialActionPerformed(evt);
            }
        });

        btnRegistrarAutor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnRegistrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAutorActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Editorial:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Autor (es):");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarAutor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnRegistrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar)
                            .addComponent(btnRegistrarLibro))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (Libros.btnRegitro != null) {
            Libros.btnRegitro.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarLibroActionPerformed
        libro.setNombre(txtNombreLibro.getText().trim());
        libro.setDesc(txtDesc.getText().trim());
        libro.setSubgenero(String.valueOf(boxSubgenero.getSelectedItem()));
        libro.setTipo(String.valueOf(boxTipo.getSelectedItem()));
        libro.setCantidad((int) spnCantidad.getValue());
        libro.setNumDePaginas((int) spnPaginas.getValue());
        System.out.println(libro);
        if (Libros.btnRegitro != null) {
            Libros.btnRegitro.setEnabled(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnRegistrarLibroActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed

    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed

    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnAceptarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEditorialActionPerformed
        int N = tblEditoriales.getColumnCount();
        Object[] datos = new Object[N];
        for (int i = 0; i < N; i++) {
            datos[i] = tblEditoriales.getValueAt(tblEditoriales.getSelectedRow(), i);
        }
        int idEditorial = (int) datos[0];
        String nombreEditorial = String.valueOf(datos[1]);
        Editorial editorial = new Editorial(idEditorial, nombreEditorial);
        libro.setEditorial(editorial);
        registrarEditorial.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_btnAceptarEditorialActionPerformed

    private void btnEliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEditorialActionPerformed
        int editorialId = (int) tblEditoriales.getValueAt(tblEditoriales.getSelectedRow(), 0);
        eliminarEditorialById(editorialId);
        this.setVisible(true);
        registrarEditorial.dispose();
    }//GEN-LAST:event_btnEliminarEditorialActionPerformed

    private void txtNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre1ActionPerformed

    }//GEN-LAST:event_txtNombre1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAutorActionPerformed
        registrarAutor.setLocationRelativeTo(null);
        mostrarPlaceHolderEnAutor();
        mostrarTablaAutores();
        registrarAutor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarAutorActionPerformed

    private void btnRegistrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEditorialActionPerformed
        registrarEditorial.setLocationRelativeTo(null);
        mostrarEditoriales();
        registrarEditorial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarEditorialActionPerformed

    private void txtMaternoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaternoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaternoAutorActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (areCamposParaRegistrarAutorCorrectos()) {

        } else {
            JOptionPane.showMessageDialog(null, "Ingresa valores en los campos de autor", "Error", 0);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAceptarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAutorActionPerformed
        List<Autor> autores = new ArrayList<>();
        int N = tblAutores.getSelectedRowCount();
        int M = tblAutores.getColumnCount();
        Object[] datos = new Object[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                datos[j] = tblAutores.getValueAt(tblAutores.getSelectedRows()[i], j);
            }
            String idAutor = String.valueOf(datos[0]);
            String nombreAutor = String.valueOf(datos[1]);
            String paternoAutor = String.valueOf(datos[2]);
            String maternoAutor = String.valueOf(datos[3]);
            Autor autor = crearAutor(idAutor, nombreAutor, paternoAutor, maternoAutor);
            autores.add(autor);
        }
        libro.setAutor(autores);
        registrarAutor.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_btnAceptarAutorActionPerformed

    private void btnEliminarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAutorActionPerformed

    private void btnCancelarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEditorialActionPerformed
        registrarEditorial.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_btnCancelarEditorialActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (Libros.btnRegitro != null) {
            Libros.btnRegitro.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCancelarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAutorActionPerformed
        registrarAutor.dispose();
        this.setVisible(true);
    }//GEN-LAST:event_btnCancelarAutorActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxSubgenero;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnAceptarAutor;
    private javax.swing.JButton btnAceptarEditorial;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAutor;
    private javax.swing.JButton btnCancelarEditorial;
    private javax.swing.JButton btnEliminarAutor;
    private javax.swing.JButton btnEliminarEditorial;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarAutor;
    private javax.swing.JButton btnRegistrarEditorial;
    private javax.swing.JButton btnRegistrarLibro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JFrame registrarAutor;
    private javax.swing.JFrame registrarEditorial;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPaginas;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtBusquedaAutor;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtMaternoAutor;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombreAutor;
    private javax.swing.JTextField txtNombreLibro;
    private javax.swing.JTextField txtPaternoAutor;
    // End of variables declaration//GEN-END:variables

    private void mostrarPlaceHolders() {
        new TextPrompt("Ingrese nombre del Libro", txtNombreLibro);
        new TextPrompt("Ingrese la descripción de la contraportada", txtDesc);
    }

    private void registrarLibro() {
        asignarValoresALibro();
//        Logic.conexion con = new Logic.conexion();
//        con.ConectarBasedeDatos();
//        Statement statement = con.sentencia;
//        try {
//            statement.executeUpdate("insert into libro"
//                    + "(nombre, descripcion, tipo, sub_genero, cantidad)"
//                    + "values("
//                    + ", \"" + nombre
//                    + "\", '" + desc
//                    + "', '" + tipo
//                    + "', '" + subgenero
//                    + "', " + cantidad
//                    + ")");
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
    }

    private void deleteAutorLibroRelationship() {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "DELETE FROM libro_has_autor WHERE libro_id_libro = " + ""
                    + ";";

            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
    }

    private boolean areCamposCorrectosParaRegistro() {
        return !(txtDesc.getText().equals("") || txtNombreLibro.getText().equals("")
                || boxSubgenero.getSelectedIndex() == 0
                || boxTipo.getSelectedIndex() == 0 || libro.getEditorial() == null);

    }

    private void asignarValoresALibro() {
        String nombre = txtNombreLibro.getText();
        String desc = txtDesc.getText();
        String subgenero = String.valueOf(boxSubgenero.getSelectedItem());
        String tipo = String.valueOf(boxTipo.getSelectedItem());
        int cantidad = (int) spnCantidad.getValue();
        int paginas = (int) spnPaginas.getValue();
        libro.setNombre(nombre);
        libro.setDesc(desc);
        libro.setSubgenero(subgenero);
        libro.setTipo(tipo);
        libro.setCantidad(cantidad);
        libro.setNumDePaginas(paginas);
    }

    private void mostrarEditoriales() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM editorial order by id_editorial";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel modelEditorial = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelEditorial.setColumnIdentifiers(new Object[]{"ID", "Nombre"});
            tblEditoriales.setModel(modelEditorial);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    private boolean areCamposParaRegistrarAutorCorrectos() {
        return !(txtNombreAutor.getText().equals("")
                || txtPaternoAutor.getText().equals(""));
    }

    private void mostrarPlaceHolderEnAutor() {
        new TextPrompt("Buscar autor", txtBusquedaAutor);
    }

    private void eliminarEditorialById(int editorialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarTablaAutores() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM autor";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel modelAutor = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelAutor.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellido Paterno", "Apellido Materno"});
            tblAutores.setModel(modelAutor);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    private Autor crearAutor(String idAutor, String nombreAutor, String paternoAutor, String maternoAutor) {
        Autor a = new Autor();
        a.setIdentificador(idAutor);
        a.setNombre(nombreAutor);
        a.setPaterno(paternoAutor);
        a.setMaterno(maternoAutor);
        return a;
    }

}
