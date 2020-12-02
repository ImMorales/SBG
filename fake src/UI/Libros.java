package UI;

import Logic.Libro;
import static UI.RegistroAutor.numDeAutores;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Libros extends javax.swing.JFrame {

    private int numeroDeLibros = 0;

    private DefaultTableModel modelLibros;

    public Libros() {
        initComponents();
        mostrarTablaLibros();
        mostrarNumeroDeLibros();
        mostrarNumeroDeAutores();
        crearPopMenuATabla();
        placeHolder();
        actualizarBusqueda();
        setExtendedState(MAXIMIZED_BOTH);

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
        filtrarLibros = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lblLibros = new javax.swing.JLabel();
        lblAutores = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnFiltro = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegitro = new javax.swing.JButton();
        lblVolver = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0) return false;
                if(column == 1) return false;
                if(column == 2) return false;
                if(column == 3) return false;
                if(column == 4) return false;
                return true;
            }
        };

        filtrarLibros.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        filtrarLibros.setTitle("Filtrar");
        filtrarLibros.setBackground(new java.awt.Color(204, 204, 204));
        filtrarLibros.setMinimumSize(new java.awt.Dimension(366, 306));
        filtrarLibros.setResizable(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox6.setText("Espejo de Urania");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Subgenero");

        jCheckBox1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox1.setText("Al Sol Solito");

        jCheckBox2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox2.setText("Astrolabio");

        jCheckBox5.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox5.setText("Pasos de Luna");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox7.setText("Cometas Convidados");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(67, 67, 67)
                        .addComponent(jCheckBox5))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(80, 80, 80)
                        .addComponent(jCheckBox6))
                    .addComponent(jCheckBox7)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox5))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox6))
                .addGap(6, 6, 6)
                .addComponent(jCheckBox7))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Tipo");

        jCheckBox3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox3.setText("Informativo");

        jCheckBox4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox4.setText("Literario");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filtrarLibros.getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jPanel12.setLayout(new java.awt.BorderLayout());
        filtrarLibros.getContentPane().add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        filtrarLibros.getContentPane().add(jPanel13, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SiBi");
        setSize(new java.awt.Dimension(1280, 681));

        header.setBackground(new java.awt.Color(0, 102, 255));
        header.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        header.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 110));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setMaximumSize(new java.awt.Dimension(320, 30));
        jPanel7.setMinimumSize(new java.awt.Dimension(320, 30));
        jPanel7.setPreferredSize(new java.awt.Dimension(320, 90));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        txtBusqueda.setMaximumSize(new java.awt.Dimension(320, 30));
        txtBusqueda.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusqueda.setPreferredSize(new java.awt.Dimension(320, 30));
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        jPanel7.add(txtBusqueda, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 110));
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 110));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 110));

        lblLibros.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblLibros.setForeground(new java.awt.Color(51, 51, 51));
        lblLibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLibros.setText("<html><center><h1>#</h1><h3>Libros</h3></center>");
        lblLibros.setPreferredSize(new java.awt.Dimension(100, 100));

        lblAutores.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblAutores.setForeground(new java.awt.Color(51, 51, 51));
        lblAutores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutores.setText("<html><center><h1>#</h1><h3>Autores</h3></center>");
        lblAutores.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.LINE_START);

        jPanel8.setBackground(new java.awt.Color(254, 254, 254));

        btnFiltro.setBackground(new java.awt.Color(255, 255, 255));
        btnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filter.png"))); // NOI18N
        btnFiltro.setComponentPopupMenu(jPopupMenu1);
        btnFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFiltro.setRolloverEnabled(true);
        btnFiltro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filter_black.png"))); // NOI18N
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setRolloverEnabled(true);
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_black.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegitro.setBackground(new java.awt.Color(255, 255, 255));
        btnRegitro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnRegitro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegitro.setRolloverEnabled(true);
        btnRegitro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_black.png"))); // NOI18N
        btnRegitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegitroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegitro)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFiltro)
                    .addComponent(btnActualizar)
                    .addComponent(btnRegitro))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8, java.awt.BorderLayout.EAST);

        header.add(jPanel4, java.awt.BorderLayout.SOUTH);

        lblVolver.setFont(new java.awt.Font("Gargi-1.2b", 1, 12)); // NOI18N
        lblVolver.setForeground(new java.awt.Color(255, 255, 255));
        lblVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/baseline_keyboard_backspace_white_18dp.png"))); // NOI18N
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolverMouseClicked(evt);
            }
        });
        header.add(lblVolver, java.awt.BorderLayout.LINE_START);

        lblHeader.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(254, 254, 254));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("<html><h1>Libros</h1>");
        lblHeader.setPreferredSize(new java.awt.Dimension(200, 50));
        lblHeader.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        header.add(lblHeader, java.awt.BorderLayout.CENTER);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setMinimumSize(new java.awt.Dimension(50, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 471));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));
        jPanel5.setPreferredSize(new java.awt.Dimension(50, 471));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        tblLibros.setAutoCreateRowSorter(true);
        tblLibros.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblLibros.setRowHeight(20);
        tblLibros.setShowVerticalLines(false);
        tblLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblLibros);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                String search = txtBusqueda.getText();
                TableRowSorter<DefaultTableModel> sorter
                        = new TableRowSorter<>(modelLibros);
                tblLibros.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
            }
        }
        );
    }

    private void lblVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolverMouseClicked
        Menu regresar = new Menu();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblVolverMouseClicked

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        System.out.println(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        Point fromFiltroButtonPosition = btnFiltro.getLocationOnScreen();
        int x = (int) fromFiltroButtonPosition.getX();
        int y = (int) fromFiltroButtonPosition.getY() + 50;
        Point pointForFiltroFrame = new Point(x, y);
        filtrarLibros.setLocation(pointForFiltroFrame);
        filtrarLibros.setVisible(true);
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void btnRegitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegitroActionPerformed
        RegistroLibro nuevoRegistroDeLibro = new RegistroLibro();
        nuevoRegistroDeLibro.setVisible(true);
        btnRegitro.setEnabled(false);
    }//GEN-LAST:event_btnRegitroActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        mostrarTablaLibros();
        mostrarNumeroDeLibros();
        mostrarNumeroDeAutores();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        filtrarLibros.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostrarTablaLibros() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT id_libro, nombre,tipo, sub_genero, editorial FROM libro";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelLibros = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelLibros.setColumnIdentifiers(new Object[]{"ID", "Libro", "Tipo", "Sub Genero", "Editorial"});
            numeroDeLibros = modelLibros.getRowCount();
            tblLibros.setModel(modelLibros);
        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
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
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    public static javax.swing.JButton btnFiltro;
    public static javax.swing.JButton btnRegitro;
    private javax.swing.JFrame filtrarLibros;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutores;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLibros;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    private void placeHolder() {
        TextPrompt ph = new TextPrompt("Buscar", txtBusqueda);

    }

    private void mostrarNumeroDeLibros() {
        StringBuilder formattedNumLibros = new StringBuilder();
        formattedNumLibros.append("<html><center><h1>");
        formattedNumLibros.append(numeroDeLibros);
        formattedNumLibros.append("</h1><h3>Libros</h3></center>");
        lblLibros.setText(formattedNumLibros + "");
    }

    private void mostrarNumeroDeAutores() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        try {
            String query = "SELECT * FROM autor";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel modelAutor = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            numDeAutores = modelAutor.getRowCount();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
        StringBuilder formattedNumLibros = new StringBuilder();
        formattedNumLibros.append("<html><center><h1>");
        formattedNumLibros.append(numDeAutores);
        formattedNumLibros.append("</h1><h3>Autores</h3></center>");
        lblAutores.setText(formattedNumLibros + "");
    }

    private void crearPopMenuATabla() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemElegir = new JMenuItem("Editar");
        JMenuItem menuItemEliminar = new JMenuItem("Eliminar");
        popupMenu.setPopupSize(100, 60);

        popupMenu.add(menuItemElegir);
        popupMenu.add(menuItemEliminar);

        tblLibros.setComponentPopupMenu(popupMenu);

        menuItemElegir.addActionListener((ActionEvent ae) -> {
            Libro libroAEditar = new Libro();
            EditarLibro editar = new EditarLibro();
            editar.setVisible(true);
        });

        menuItemEliminar.addActionListener((ActionEvent ae) -> {

        });

    }

}
