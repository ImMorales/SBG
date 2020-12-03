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
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class RegistroLibro extends JFrame {

    private final Libro libro;

    public RegistroLibro() {
        initComponents();
        setLocationRelativeTo(null);
        setupTableMenus();
        mostrarPlaceHolders();
        libro = new Libro();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrarEditorial = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtBusquedaEditorial = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEditoriales = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0) return false;
                if(column == 1) return false;
                return true;
            }
        };
        jPanel8 = new javax.swing.JPanel();
        txtNombreEditorial = new javax.swing.JTextField();
        btnIngresarEditorial = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tituloEditorial = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnAceptarEditorial = new javax.swing.JButton();
        btnCancelarEditorial = new javax.swing.JButton();
        registrarAutor = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtBusquedaAutor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0) return false;
                if(column == 1) return false;
                if(column == 2) return false;
                if(column == 3) return false;
                return true;
            }
        };
        jPanel11 = new javax.swing.JPanel();
        txtNombreAutor = new javax.swing.JTextField();
        txtPaternoAutor = new javax.swing.JTextField();
        txtMaternoAutor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnAceptarAutor = new javax.swing.JButton();
        btnCancelarAutor = new javax.swing.JButton();
        editorialOptionsMenu = new javax.swing.JPopupMenu();
        aceptarEditorial = new javax.swing.JMenuItem();
        editarEditorial = new javax.swing.JMenuItem();
        eliminarEditorial = new javax.swing.JMenuItem();
        autorOptionsMenu = new javax.swing.JPopupMenu();
        aceptarAutor = new javax.swing.JMenuItem();
        editarAutor = new javax.swing.JMenuItem();
        eliminarAutor = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel13 = new javax.swing.JLabel();
        btnRegistrarAutor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblAutores = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnRegistrarLibro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        registrarEditorial.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        registrarEditorial.setTitle("Editorial");
        registrarEditorial.setAlwaysOnTop(true);
        registrarEditorial.setMinimumSize(new java.awt.Dimension(584, 244));
        registrarEditorial.setResizable(false);
        registrarEditorial.setSize(new java.awt.Dimension(584, 244));
        registrarEditorial.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                registrarEditorialWindowOpened(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());
        registrarEditorial.getContentPane().add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setPreferredSize(new java.awt.Dimension(320, 320));

        txtBusquedaEditorial.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusquedaEditorial.setPreferredSize(new java.awt.Dimension(320, 30));

        tblEditoriales.setAutoCreateRowSorter(true);
        tblEditoriales.setModel(new javax.swing.table.DefaultTableModel());
        tblEditoriales.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tblEditoriales.setShowVerticalLines(false);
        tblEditoriales.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEditoriales);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        txtNombreEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEditorialActionPerformed(evt);
            }
        });

        btnIngresarEditorial.setBackground(new java.awt.Color(0, 102, 255));
        btnIngresarEditorial.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnIngresarEditorial.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresarEditorial.setText("Registrar");
        btnIngresarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEditorialActionPerformed(evt);
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
                    .addComponent(txtNombreEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(btnIngresarEditorial)
                .addGap(79, 79, 79))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresarEditorial)
                .addContainerGap())
        );

        tituloEditorial.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tituloEditorial.setForeground(new java.awt.Color(51, 51, 51));
        tituloEditorial.setText("Registrar nueva editorial");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        btnAceptarEditorial.setBackground(new java.awt.Color(0, 102, 255));
        btnAceptarEditorial.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAceptarEditorial.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarEditorial.setText("Aceptar");
        btnAceptarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEditorialActionPerformed(evt);
            }
        });
        jPanel13.add(btnAceptarEditorial);

        btnCancelarEditorial.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarEditorial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelarEditorial.setText("cancelar");
        btnCancelarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEditorialActionPerformed(evt);
            }
        });
        jPanel13.add(btnCancelarEditorial);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtBusquedaEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloEditorial)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusquedaEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        registrarEditorial.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

        registrarAutor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        registrarAutor.setTitle("Autor (es)");
        registrarAutor.setAlwaysOnTop(true);
        registrarAutor.setMinimumSize(new java.awt.Dimension(697, 402));
        registrarAutor.setResizable(false);
        registrarAutor.setSize(new java.awt.Dimension(697, 402));
        registrarAutor.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                registrarAutorWindowOpened(evt);
            }
        });

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

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
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

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 255));
        btnRegistrar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(72, 72, 72))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Registrar nuevo autor");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        btnAceptarAutor.setBackground(new java.awt.Color(0, 102, 255));
        btnAceptarAutor.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnAceptarAutor.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarAutor.setText("Aceptar");
        btnAceptarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarAutorActionPerformed(evt);
            }
        });
        jPanel12.add(btnAceptarAutor);

        btnCancelarAutor.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarAutor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCancelarAutor.setText("cancelar");
        btnCancelarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAutorActionPerformed(evt);
            }
        });
        jPanel12.add(btnCancelarAutor);

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
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtBusquedaAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        registrarAutor.getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        editorialOptionsMenu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                editorialOptionsMenuPopupMenuWillBecomeVisible(evt);
            }
        });

        aceptarEditorial.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        aceptarEditorial.setText("Aceptar");
        aceptarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarEditorialActionPerformed(evt);
            }
        });
        editorialOptionsMenu.add(aceptarEditorial);

        editarEditorial.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        editarEditorial.setText("Editar");
        editarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEditorialActionPerformed(evt);
            }
        });
        editorialOptionsMenu.add(editarEditorial);

        eliminarEditorial.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        eliminarEditorial.setText("Eliminar");
        eliminarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEditorialActionPerformed(evt);
            }
        });
        editorialOptionsMenu.add(eliminarEditorial);

        autorOptionsMenu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                autorOptionsMenuPopupMenuWillBecomeVisible(evt);
            }
        });

        aceptarAutor.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        aceptarAutor.setText("Aceptar");
        autorOptionsMenu.add(aceptarAutor);

        editarAutor.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        editarAutor.setText("Editar");
        autorOptionsMenu.add(editarAutor);

        eliminarAutor.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        eliminarAutor.setText("Eliminar");
        eliminarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAutorActionPerformed(evt);
            }
        });
        autorOptionsMenu.add(eliminarAutor);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar libro");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(680, 356));
        setResizable(false);
        setSize(new java.awt.Dimension(680, 356));
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nombre:");

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
        jLabel7.setText("Descripción:");

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        spnPaginas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Número de páginas:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Subgenero:");

        boxSubgenero.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxSubgenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Al Sol Solito", "Astrolabio", "Cometas Convidados", "Pasos de Luna", "Espejo de Urania" }));
        boxSubgenero.setPreferredSize(new java.awt.Dimension(183, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tipo:");

        boxTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Informativo", "Literarios" }));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Cantidad:");

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        btnRegistrarEditorial.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarEditorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/editorial.png"))); // NOI18N
        btnRegistrarEditorial.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRegistrarEditorial.setMaximumSize(new java.awt.Dimension(75, 52));
        btnRegistrarEditorial.setMinimumSize(new java.awt.Dimension(75, 52));
        btnRegistrarEditorial.setPreferredSize(new java.awt.Dimension(75, 52));
        btnRegistrarEditorial.setRolloverEnabled(true);
        btnRegistrarEditorial.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/editorial_black.png"))); // NOI18N
        btnRegistrarEditorial.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/editorial_black.png"))); // NOI18N
        btnRegistrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEditorialActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Editorial:");

        btnRegistrarAutor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fancy.png"))); // NOI18N
        btnRegistrarAutor.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRegistrarAutor.setMaximumSize(new java.awt.Dimension(75, 52));
        btnRegistrarAutor.setMinimumSize(new java.awt.Dimension(75, 52));
        btnRegistrarAutor.setPreferredSize(new java.awt.Dimension(75, 52));
        btnRegistrarAutor.setRolloverEnabled(true);
        btnRegistrarAutor.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fancy_black.png"))); // NOI18N
        btnRegistrarAutor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/fancy_black.png"))); // NOI18N
        btnRegistrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAutorActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Autor(es):");

        lblAutores.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblAutores.setForeground(new java.awt.Color(51, 51, 51));
        lblAutores.setText("0");

        lblEditorial.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblEditorial.setForeground(new java.awt.Color(51, 51, 51));
        lblEditorial.setText("...");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAutores))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRegistrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEditorial)))
                .addGap(48, 48, 48))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(lblAutores)
                    .addComponent(lblEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarLibro.setBackground(new java.awt.Color(0, 102, 255));
        btnRegistrarLibro.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRegistrarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarLibro.setText("Registrar");
        btnRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLibroActionPerformed(evt);
            }
        });
        jPanel14.add(btnRegistrarLibro);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        setupInformacionDelLibro();
        if (libro.areDatosCorrectos()) {
            ingresarLibroEnBD();
            enlazarLibroConAutor();
            if (Libros.btnRegitro != null) {
                Libros.btnRegitro.setEnabled(true);
            }
  
            this.dispose();
            
        } else {
            mostrarMensajeConElementosFaltantes();
        }

    }//GEN-LAST:event_btnRegistrarLibroActionPerformed

    private void btnAceptarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEditorialActionPerformed
        aceptarEditorialSeleccionada();
    }//GEN-LAST:event_btnAceptarEditorialActionPerformed

    private void txtNombreEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEditorialActionPerformed
        if (btnIngresarEditorial.getText().equals("Registrar")) {
            registrarNuevaEditorial();
        } else {
            actualizarEditorial();
            JOptionPane.showMessageDialog(null, "Elemento actualizado", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtNombreEditorialActionPerformed

    private void btnIngresarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEditorialActionPerformed
        if (btnIngresarEditorial.getText().equals("Registrar")) {
            registrarNuevaEditorial();
        } else {
            registrarEditorial.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Elemento actualizado", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
            registrarEditorial.setAlwaysOnTop(true);
            tituloEditorial.setText("Registrar nueva editorial");
            txtNombreEditorial.setText("");
            btnIngresarEditorial.setText("Registrar");
        }

    }//GEN-LAST:event_btnIngresarEditorialActionPerformed

    private void btnRegistrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAutorActionPerformed
        registrarAutor.setLocationRelativeTo(null);
        mostrarPlaceHolderEnAutor();
        mostrarTablaAutores();
        registrarAutor.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarAutorActionPerformed

    private void btnRegistrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEditorialActionPerformed
        registrarEditorial.setLocationRelativeTo(null);
        tblEditoriales.setComponentPopupMenu(editorialOptionsMenu);
        mostrarEditoriales();
        registrarEditorial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarEditorialActionPerformed

    private void txtMaternoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaternoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaternoAutorActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String nombreAutor = txtNombreAutor.getText().trim();
        String paternoAutor = txtPaternoAutor.getText().trim();
        String maternoAutor = txtMaternoAutor.getText().trim();
        Autor a;
        if (maternoAutor.equals("")) {
            a = Autor.getAutorInstance(nombreAutor, paternoAutor);
        } else {
            a = Autor.getAutorInstance(nombreAutor, paternoAutor, maternoAutor);
        }
        if (!areCamposParaRegistrarAutorEmpty()) {
            registrarAutor(a);
        } else {
            registrarAutor.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Ingresa valores en los campos de autor", "Error", 0);
            registrarAutor.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnAceptarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarAutorActionPerformed
        List<Autor> autores = new ArrayList<>();
        int N = tblAutores.getSelectedRowCount();
        int M = tblAutores.getColumnCount();
        if (N > 0) {
            Object[] datos = new Object[M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    datos[j] = tblAutores.getValueAt(tblAutores.getSelectedRows()[i], j);
                }
                String idAutor = String.valueOf(datos[0]);
                String nombreAutor = String.valueOf(datos[1]);
                String paternoAutor = String.valueOf(datos[2]);
                String maternoAutor = String.valueOf(datos[3]);
                Autor a;
                if (maternoAutor.equals("")) {
                    a = Autor.getAutorInstanceWithId(idAutor, nombreAutor, paternoAutor);
                } else {
                    a = Autor.getAutorInstanceWithId(idAutor, nombreAutor, paternoAutor, maternoAutor);
                }
                autores.add(a);
            }
            libro.setAutor(autores);
            registrarAutor.dispose();
            lblAutores.setText("" + libro.getAutor().size());
            this.setVisible(true);
        } else {
            registrarAutor.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Seleccione al menos un(a) autor(a)", "Error", JOptionPane.ERROR_MESSAGE);
            registrarAutor.setAlwaysOnTop(false);
        }

    }//GEN-LAST:event_btnAceptarAutorActionPerformed

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

    private void registrarEditorialWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_registrarEditorialWindowOpened

    }//GEN-LAST:event_registrarEditorialWindowOpened

    private void editorialOptionsMenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_editorialOptionsMenuPopupMenuWillBecomeVisible
        int editorialesSeleccionadas = tblEditoriales.getSelectedRowCount();
        boolean areMultiplesEditorialesSeleccionadas = editorialesSeleccionadas > 1;
        aceptarEditorial.setEnabled(!areMultiplesEditorialesSeleccionadas);
        editarEditorial.setEnabled(!areMultiplesEditorialesSeleccionadas);
    }//GEN-LAST:event_editorialOptionsMenuPopupMenuWillBecomeVisible

    private void registrarAutorWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_registrarAutorWindowOpened

    }//GEN-LAST:event_registrarAutorWindowOpened

    private void autorOptionsMenuPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_autorOptionsMenuPopupMenuWillBecomeVisible
        int autoresSeleccionados = tblAutores.getSelectedRowCount();
        boolean areMultiplesAuotresSeleccionados = autoresSeleccionados > 1;
        editarAutor.setEnabled(!areMultiplesAuotresSeleccionados);
    }//GEN-LAST:event_autorOptionsMenuPopupMenuWillBecomeVisible

    private void aceptarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarEditorialActionPerformed
        aceptarEditorialSeleccionada();
    }//GEN-LAST:event_aceptarEditorialActionPerformed

    private void editarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEditorialActionPerformed
        int selectedRow = tblEditoriales.getSelectedRow();
        String nombreEditorial = (String) tblEditoriales.getValueAt(selectedRow, 1);
        int idEditorial = (int) tblEditoriales.getValueAt(selectedRow, 0);
        Editorial e = new Editorial(idEditorial, nombreEditorial);
        System.out.println(e);
        tituloEditorial.setText("Editar editorial");
        btnIngresarEditorial.setText("Guardar");
        txtNombreEditorial.setText(e.getNombre());
    }//GEN-LAST:event_editarEditorialActionPerformed

    private void eliminarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEditorialActionPerformed
        int N = tblEditoriales.getSelectedRowCount();
        int[] selectedRow = tblEditoriales.getSelectedRows();
        for (int i = 0; i < N; i++) {
            int idEditorial = (int) tblEditoriales.getValueAt(selectedRow[i], 0);
            eliminarEditorialDeLaBD(idEditorial);
        }
        mostrarEditoriales();
    }//GEN-LAST:event_eliminarEditorialActionPerformed

    private void eliminarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAutorActionPerformed
        int N = tblAutores.getSelectedRowCount();
        int[] selectedRow = tblAutores.getSelectedRows();
        for (int i = 0; i < N; i++) {
            int idAutor = (int) tblAutores.getValueAt(selectedRow[i], 0);
            eliminarAutorDeLaBD(idAutor);
        }
        mostrarTablaAutores();
    }//GEN-LAST:event_eliminarAutorActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aceptarAutor;
    private javax.swing.JMenuItem aceptarEditorial;
    private javax.swing.JPopupMenu autorOptionsMenu;
    private javax.swing.JComboBox<String> boxSubgenero;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnAceptarAutor;
    private javax.swing.JButton btnAceptarEditorial;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAutor;
    private javax.swing.JButton btnCancelarEditorial;
    private javax.swing.JButton btnIngresarEditorial;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarAutor;
    private javax.swing.JButton btnRegistrarEditorial;
    private javax.swing.JButton btnRegistrarLibro;
    private javax.swing.JMenuItem editarAutor;
    private javax.swing.JMenuItem editarEditorial;
    private javax.swing.JPopupMenu editorialOptionsMenu;
    private javax.swing.JMenuItem eliminarAutor;
    private javax.swing.JMenuItem eliminarEditorial;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JLabel lblAutores;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JFrame registrarAutor;
    private javax.swing.JFrame registrarEditorial;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JSpinner spnPaginas;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JLabel tituloEditorial;
    private javax.swing.JTextField txtBusquedaAutor;
    private javax.swing.JTextField txtBusquedaEditorial;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtMaternoAutor;
    private javax.swing.JTextField txtNombreAutor;
    private javax.swing.JTextField txtNombreEditorial;
    private javax.swing.JTextField txtNombreLibro;
    private javax.swing.JTextField txtPaternoAutor;
    // End of variables declaration//GEN-END:variables

    private void mostrarPlaceHolders() {

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

    private boolean areCamposParaRegistrarAutorEmpty() {
        return txtNombreAutor.getText().trim().equals("")
                && txtPaternoAutor.getText().trim().equals("")
                && txtMaternoAutor.getText().trim().equals("");
    }

    private void mostrarPlaceHolderEnAutor() {
        new TextPrompt("Buscar autor", txtBusquedaAutor);
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

    private void registrarAutor(Autor a) {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        Statement s = con.sentencia;

        boolean hasMaterno = !(a.getMaterno() == null);
        String query = "INSERT INTO autor(nombre, apellido_paterno"
                .concat(hasMaterno ? ", apellido_materno)" : ")")
                .concat("VALUES(")
                .concat("\"" + a.getNombre()).concat("\" ,")
                .concat("\"" + a.getPaterno() + "\"")
                .concat(hasMaterno ? ", \"" + a.getMaterno() + "\")" : ");");

        try {
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mostrarTablaAutores();
        }
        con.DesconectarBasedeDatos();
    }

    private void registrarNuevaEditorial() {
        String nombreEditorial = txtNombreEditorial.getText().trim();
        libro.getEditorial().setNombre(nombreEditorial);
        if (!libro.getEditorial().isNombreEmpty()) {
            ingresarEditorialEnBD(nombreEditorial);
            mostrarEditoriales();

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        txtNombreEditorial.setText("");
    }

    private void ingresarEditorialEnBD(String nombreEditorial) {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        Statement statement = con.sentencia;
        String query = "INSERT INTO editorial (nombre)"
                .concat("VALUES (")
                .concat("'" + nombreEditorial + "')");
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void ingresarLibroEnBD() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        Statement statement = con.sentencia;
        String query = "INSERT INTO libro (nombre, descripcion, tipo, sub_genero, cantidad, editorial, num_paginas)"
                + "VALUES ("
                + "'" + libro.getNombre() + "',"
                + "'" + libro.getDesc() + "',"
                + "'" + libro.getTipo() + "',"
                + "'" + libro.getSubgenero() + "',"
                + "" + libro.getCantidad() + ","
                + "'" + libro.getEditorial().getNombre() + "',"
                + "" + libro.getNumDePaginas() + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void enlazarLibroConAutor() {
        libro.setId(getIdDelLibroRecienIngresado());
        for (int i = 0; i < libro.getAutor().size(); i++) {
            enlazarEsteAutorConLibroEnBD(libro.getAutor().get(i));
        }
    }

    private int getIdDelLibroRecienIngresado() {
        int id = 0;
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        String query = "SELECT * FROM libro WHERE ";
        query += "nombre = \"" + libro.getNombre() + "\" AND "
                + "descripcion = \"" + libro.getDesc() + "\" AND "
                + "tipo = \"" + libro.getTipo() + "\" AND "
                + "sub_genero = \"" + libro.getSubgenero() + "\" AND "
                + "cantidad = " + libro.getCantidad() + " AND "
                + "editorial = \"" + libro.getEditorial().getNombre() + "\" AND "
                + "num_paginas = " + libro.getNumDePaginas();
        try {
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_libro");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }

    private void enlazarEsteAutorConLibroEnBD(Autor a) {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        Statement statement = con.sentencia;
        String query = "INSERT INTO libro_has_autor VALUES("
                + libro.getId() + ", " + a.getIdentificador() + ")";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void mostrarMensajeConElementosFaltantes() {
        List<String> faltantes = libro.elementosFaltantes();
        int numFaltantes = faltantes.size();
        String message = "Falta ingresar ";
        StringBuilder hints = new StringBuilder();
        String singular = "el siguiente dato:\n";
        String plural = "los siguientes datos:\n";
        message += numFaltantes > 1 ? plural : singular;

        faltantes.forEach((faltante) -> {
            hints.append("  • ").append(faltante).append(".\n");
        });

        message += hints.toString();

        this.setAlwaysOnTop(false);
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
        this.setAlwaysOnTop(true);
    }

    private void setupInformacionDelLibro() {
        libro.setNombre(txtNombreLibro.getText().trim());
        libro.setDesc(txtDesc.getText().trim());
        libro.setSubgenero(String.valueOf(boxSubgenero.getSelectedItem()));
        libro.setTipo(String.valueOf(boxTipo.getSelectedItem()));
        libro.setCantidad((int) spnCantidad.getValue());
        libro.setNumDePaginas((int) spnPaginas.getValue());
    }

    private void setupTableMenus() {
        tblEditoriales.setComponentPopupMenu(editorialOptionsMenu);
        tblAutores.setComponentPopupMenu(autorOptionsMenu);
    }

    private void aceptarEditorialSeleccionada() {
        int N = tblEditoriales.getColumnCount();
        int M = tblEditoriales.getSelectedRowCount();
        if (M > 0) {
            Object[] datos = new Object[N];
            for (int i = 0; i < N; i++) {
                datos[i] = tblEditoriales.getValueAt(tblEditoriales.getSelectedRow(), i);
            }
            int idEditorial = (int) datos[0];
            String nombreEditorial = String.valueOf(datos[1]);
            Editorial editorial = new Editorial(idEditorial, nombreEditorial);
            libro.setEditorial(editorial);
            registrarEditorial.dispose();
            lblEditorial.setText("√");
            this.setVisible(true);
        } else {
            registrarEditorial.setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Seleccione una editorial", "Error", JOptionPane.WARNING_MESSAGE);
            registrarEditorial.setAlwaysOnTop(true);
        }
    }

    private void eliminarEditorialDeLaBD(int idEditorial) {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "DELETE FROM editorial WHERE id_editorial = " + idEditorial;
            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
    }

    private void eliminarAutorDeLaBD(int idAutor) {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "DELETE FROM autor WHERE id_autor = " + idAutor;
            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
    }

    private void actualizarEditorial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
