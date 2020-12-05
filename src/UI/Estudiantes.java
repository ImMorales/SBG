package UI;

import Logic.Estudiante;
import java.awt.Color;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Estudiantes extends javax.swing.JFrame {

    public static int numeroDeEstudiantes;
    private int grado;
    private String matricula, nombre, paterno, materno, grupos, grados;
    private final List<String> gradosParaFiltro = new ArrayList<>();
    private final List<String> gruposParaFiltro = new ArrayList<>();

    public static DefaultTableModel model;

    public Estudiantes() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        mostrarTablaAlumnosYNumeroDeEstudiantes();
        placeHolder();
        mostrarMenuDeOpciones();
        actualizarBusqueda();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsMenu = new javax.swing.JPopupMenu();
        eliminarOption = new javax.swing.JMenuItem();
        editarOption = new javax.swing.JMenuItem();
        registroEstudiante = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnGrado = new javax.swing.JSpinner();
        filtroEstudiante = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        gdoSegundo = new javax.swing.JCheckBox();
        gdoCuarto = new javax.swing.JCheckBox();
        gdoSexto = new javax.swing.JCheckBox();
        gdoQuinto = new javax.swing.JCheckBox();
        gdoPrimero = new javax.swing.JCheckBox();
        gdoTercero = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        gpoA = new javax.swing.JCheckBox();
        gpoC = new javax.swing.JCheckBox();
        gpoB = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        btnBorrarFiltro = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblEstudiantes = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblVolver = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable(){
            @Override
            public boolean isCellEditable(int row,int column){
                if(column == 0) return false;
                if(column == 1) return false;
                if(column == 2) return false;
                if(column == 3) return false;
                if(column == 4) return false;
                if(column == 5) return false;
                return true;
            }
        };

        optionsMenu.setInvoker(tblAlumnos);
        optionsMenu.setMaximumSize(new java.awt.Dimension(135, 65));
        optionsMenu.setMinimumSize(new java.awt.Dimension(100, 60));

        eliminarOption.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        eliminarOption.setText("Eliminar");
        eliminarOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarOptionMouseExited(evt);
            }
        });
        eliminarOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(eliminarOption);

        editarOption.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        editarOption.setText("Editar");
        editarOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editarOptionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editarOptionMouseExited(evt);
            }
        });
        editarOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(editarOption);

        registroEstudiante.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        registroEstudiante.setTitle("Registrar estudiante");
        registroEstudiante.setMinimumSize(new java.awt.Dimension(536, 265));
        registroEstudiante.setResizable(false);
        registroEstudiante.setSize(new java.awt.Dimension(536, 265));
        registroEstudiante.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                registroEstudianteWindowClosed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(0, 102, 255));
        jPanel10.setLayout(new java.awt.GridBagLayout());
        registroEstudiante.getContentPane().add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(254, 254, 254));
        jPanel11.setPreferredSize(new java.awt.Dimension(320, 320));

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(102, 102, 255));
        btnRegistrar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(0, 0, 51));
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(218, 218, 218));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel7.setText("Apellido paterno:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel8.setText("Apellido materno:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(218, 218, 218));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel3.setText("Matricula:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel9.setText("Edad:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spnGrado)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(52, 52, 52)
                        .addComponent(btnRegistrar)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnRegistrar))))
                .addGap(10, 10, 10))
        );

        registroEstudiante.getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        filtroEstudiante.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        filtroEstudiante.setTitle("Filtrar");
        filtroEstudiante.setMinimumSize(new java.awt.Dimension(179, 232));
        filtroEstudiante.setResizable(false);
        filtroEstudiante.setSize(new java.awt.Dimension(179, 232));
        filtroEstudiante.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                filtroEstudianteWindowClosed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setInheritsPopupMenu(true);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel4.setText("Grado");

        gdoSegundo.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoSegundo.setText("2do");
        gdoSegundo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        gdoCuarto.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoCuarto.setText("4to");
        gdoCuarto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        gdoSexto.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoSexto.setText("6to");
        gdoSexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        gdoQuinto.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoQuinto.setText("5to");
        gdoQuinto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        gdoPrimero.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoPrimero.setText("1ro");
        gdoPrimero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        gdoTercero.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gdoTercero.setText("3ro");
        gdoTercero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gdoTercero)
                    .addComponent(gdoSegundo)
                    .addComponent(gdoPrimero))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gdoCuarto)
                    .addComponent(gdoQuinto)
                    .addComponent(gdoSexto))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gdoPrimero)
                    .addComponent(gdoCuarto))
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gdoSegundo)
                    .addComponent(gdoQuinto))
                .addGap(6, 6, 6)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gdoTercero)
                    .addComponent(gdoSexto))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel6.setText("Grupo");

        gpoA.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gpoA.setText("A");
        gpoA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grupoMouseClicked(evt);
            }
        });

        gpoC.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gpoC.setText("C");
        gpoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grupoMouseClicked(evt);
            }
        });

        gpoB.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        gpoB.setText("B");
        gpoB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grupoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(gpoA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gpoB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gpoC))
                    .addComponent(jLabel6))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gpoA)
                    .addComponent(gpoB)
                    .addComponent(gpoC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filtroEstudiante.getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        btnBorrarFiltro.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnBorrarFiltro.setText("Borrar Filtro");
        btnBorrarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnBorrarFiltro)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBorrarFiltro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        filtroEstudiante.getContentPane().add(jPanel17, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SiBi");
        setBackground(java.awt.SystemColor.controlLtHighlight);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        header.setBackground(new java.awt.Color(0, 102, 255));
        header.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        header.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 110));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 110));
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 110));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 110));

        lblEstudiantes.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblEstudiantes.setText("<html><center><h1>#</h1><h3>Clientes</h3></center>");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        lblEstudiantes.getAccessibleContext().setAccessibleDescription("");

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));
        jPanel7.setMinimumSize(new java.awt.Dimension(100, 30));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel11);

        txtBusqueda.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.setMaximumSize(new java.awt.Dimension(320, 30));
        txtBusqueda.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusqueda.setPreferredSize(new java.awt.Dimension(320, 30));
        jPanel16.add(txtBusqueda);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clear.png"))); // NOI18N
        jLabel12.setToolTipText("");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel16.add(jLabel12);

        jPanel7.add(jPanel16, new java.awt.GridBagConstraints());

        jPanel4.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(254, 254, 254));

        btnRegistro.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        btnRegistro.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(102, 102, 102));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_black.png"))); // NOI18N
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        btnActualizar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(1, 1, 1));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_black.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(4, 4, 4)
                .addComponent(btnRegistro)
                .addGap(50, 50, 50))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        header.add(jPanel4, java.awt.BorderLayout.SOUTH);

        lblHeader.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(254, 254, 254));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("<html><h1>Clientes</h1>");
        lblHeader.setPreferredSize(new java.awt.Dimension(200, 50));
        lblHeader.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        header.add(lblHeader, java.awt.BorderLayout.CENTER);

        lblVolver.setFont(new java.awt.Font("Gargi-1.2b", 1, 12)); // NOI18N
        lblVolver.setForeground(new java.awt.Color(255, 255, 255));
        lblVolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/baseline_keyboard_backspace_white_18dp.png"))); // NOI18N
        lblVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolverMouseClicked(evt);
            }
        });
        header.add(lblVolver, java.awt.BorderLayout.LINE_START);

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
            .addGap(0, 421, Short.MAX_VALUE)
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
            .addGap(0, 421, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        tblAlumnos.setAutoCreateRowSorter(true);
        tblAlumnos.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAlumnos.setGridColor(new java.awt.Color(172, 172, 172));
        tblAlumnos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAlumnos.setRowHeight(28);
        tblAlumnos.setShowVerticalLines(false);
        tblAlumnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAlumnos);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        txtBusqueda.setFocusable(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       txtBusqueda.setText("");
    }//GEN-LAST:event_jLabel12MouseClicked

    public static void mostrarTablaAlumnosYNumeroDeEstudiantes() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        try {
            String query = "SELECT matricula, nombre, apellido_paterno, apellido_materno, grado FROM alumno";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
        model.setColumnIdentifiers(
                new String[]{"Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad"});
        numeroDeEstudiantes = model.getRowCount();
        tblAlumnos.setModel(model);
        mostrarNumeroDeEstudiatnes();
    }

    private void actualizarBusqueda() {
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                System.out.println("inserting");
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                System.out.println("removing");
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                System.out.println("changing");
                filterTable();
            }

            public void filterTable() {
                String search = txtBusqueda.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tblAlumnos.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
            }
        });
    }

    private void placeHolder() {
        new TextPrompt("Buscar", txtBusqueda);
    }

    private void mostrarMenuDeOpciones() {
        tblAlumnos.setComponentPopupMenu(optionsMenu);
    }

    private void eliminarElementoDeLaTabla(String id) {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "DELETE FROM alumno WHERE matricula = '"
                    + id + "';";
            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();
            mostrarTablaAlumnosYNumeroDeEstudiantes();

        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
    }

    private void eliminarOptionActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarOption.setForeground(new Color(51, 51, 51));
        int N = tblAlumnos.getSelectedRowCount();
        int dialogResult = 0;
        if (N > 1) {
            dialogResult = JOptionPane.showConfirmDialog(null,
                    "¿Eliminar " + N + " elementos seleccionados?", "Eliminar", 2,
                    JOptionPane.WARNING_MESSAGE);
        } else {
            dialogResult = JOptionPane.showConfirmDialog(null,
                    "¿Eliminar elemento seleccionado?", "Eliminar", 2,
                    JOptionPane.WARNING_MESSAGE);
        }
        if (dialogResult == JOptionPane.OK_OPTION) {
            deleteEstudiantesSeleccionados(getIdsDeEstudiantesSeleccionados());
        }
        mostrarTablaAlumnosYNumeroDeEstudiantes();

    }

    private void eliminarOptionMouseEntered(java.awt.event.MouseEvent evt) {
        eliminarOption.setForeground(new Color(255, 255, 255));
    }

    private void eliminarOptionMouseExited(java.awt.event.MouseEvent evt) {
        eliminarOption.setForeground(new Color(51, 51, 51));
    }

    private void editarOptionMouseEntered(java.awt.event.MouseEvent evt) {
        editarOption.setForeground(new Color(255, 255, 255));
    }

    private void editarOptionMouseExited(java.awt.event.MouseEvent evt) {
        editarOption.setForeground(new Color(51, 51, 51));
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        registroEstudiante.dispose();
    }

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        if (!areCamposEmpty()) {
            matricula = txtMatricula.getText();
            nombre = txtNombre.getText();
            paterno = txtPaterno.getText();
            materno = txtMaterno.getText();
            grado = (int) spnGrado.getValue();
            String grupo = "A";
            Logic.conexion con = new Logic.conexion();
            con.ConectarBasedeDatos();
            Statement statement = con.sentencia;
            try {
                statement.executeUpdate("INSERT INTO alumno " + "(matricula, nombre, apellido_paterno,"
                        + "apellido_materno, grado, grupo)" + " VALUES ('" + matricula + "','" + nombre + "','"
                        + paterno + "','" + materno + "', " + grado + ", '" + grupo + "');");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            btnRegistro.setEnabled(true);
            mostrarTablaAlumnosYNumeroDeEstudiantes();
            registroEstudiante.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Complete los campos necesarios.", "Error", 0);
        }
        txtMatricula.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        spnGrado.setValue(0);
    }

    private boolean areCamposEmpty() {
        return txtNombre.getText().equals("") || txtPaterno.getText().equals("") || txtMatricula.getText().equals("");
    }

    private void registroEstudianteWindowClosed(java.awt.event.WindowEvent evt) {
        btnRegistro.setEnabled(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Seguro de que quieres cerrar el programa?");
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void filtroEstudianteWindowClosed(java.awt.event.WindowEvent evt) {
        filtroEstudiante.dispose();
    }

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarTablaAlumnosYNumeroDeEstudiantes();
    }

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        registroEstudiante.setVisible(true);
        registroEstudiante.setLocationRelativeTo(null);
        btnRegistro.setEnabled(false);
    }

    private void lblVolverMouseClicked(java.awt.event.MouseEvent evt) {
        Menu regresar = new Menu();
        regresar.setVisible(true);
        this.dispose();
    }

    private void btnFiltroMouseEntered(java.awt.event.MouseEvent evt) {

    }

    private void btnFiltroMouseExited(java.awt.event.MouseEvent evt) {

    }

    private void editarOptionActionPerformed(java.awt.event.ActionEvent evt) {
        editarOption.setForeground(new Color(51, 51, 51));
        Estudiante[] estudiantesAEditar = crearArregloDeEstudiantesSeleccionados();
        EditarEstudiante editarEstudiante = new EditarEstudiante(estudiantesAEditar);
        editarEstudiante.setVisible(true);
    }

    private Estudiante[] crearArregloDeEstudiantesSeleccionados() {
        int N = tblAlumnos.getSelectedRowCount();
        Estudiante[] estudiantesSeleccionados = new Estudiante[N];
        Object[] datos = new Object[6];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < tblAlumnos.getColumnCount(); j++) {
                datos[j] = tblAlumnos.getValueAt(tblAlumnos.getSelectedRows()[i], j);
            }
            String id = (String) datos[0];
            String nombreSeleccionado = (String) datos[1];
            String paternoSeleccionado = (String) datos[2];
            String maternoSeleccionado = (String) datos[3];
            int gradoSeleccionado = (int) datos[4];
            String grupoSeleccionado = (String) datos[5];
            Estudiante e = crearInstanceDeEstudiante(id, nombreSeleccionado,
                    paternoSeleccionado, maternoSeleccionado, gradoSeleccionado,
                    grupoSeleccionado);
            estudiantesSeleccionados[i] = e;
        }
        return estudiantesSeleccionados;

    }

    private Estudiante crearInstanceDeEstudiante(String id, String nombre, String paterno, String materno,
            int grado, String grupo) {
        Estudiante estudiante = new Estudiante();
        estudiante.setIdentificador(id);
        estudiante.setNombre(nombre);
        estudiante.setPaterno(paterno);
        estudiante.setMaterno(materno);
        estudiante.setGrado(grado);
        estudiante.setGrupo(grupo);
        return estudiante;
    }

    private void btnBorrarFiltroActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarElementosSeleccionadosParaFiltro();
        gradosParaFiltro.clear();
        gruposParaFiltro.clear();
        setEnableBtnBorrarFiltro();
        grados = "";
        grupos = "";
        mostrarTablaAlumnosYNumeroDeEstudiantes();
        mostrarNumeroDeEstudiatnes();
    }

    private void grupoMouseClicked(java.awt.event.MouseEvent evt) {
        setEnableBtnBorrarFiltro();
        if (!areCamposSeleccionadosParaFiltro()) {
            mostrarTablaAlumnosYNumeroDeEstudiantes();
        }
        if (gpoA.isSelected()) {
            gruposParaFiltro.add("A");
        }
        if (gpoB.isSelected()) {
            gruposParaFiltro.add("B");
        }
        if (gpoC.isSelected()) {
            gruposParaFiltro.add("C");
        }
        grupos = generarStatementParaFiltro(gruposParaFiltro, "grupo");
        unirStatementsYMostrarTabla();
        gruposParaFiltro.clear();
    }

    private void gradoMouseClicked(java.awt.event.MouseEvent evt) {
        setEnableBtnBorrarFiltro();
        if (!areCamposSeleccionadosParaFiltro()) {
            mostrarTablaAlumnosYNumeroDeEstudiantes();
        }
        if (gdoPrimero.isSelected()) {
            gradosParaFiltro.add(1 + "");
        }
        if (gdoSegundo.isSelected()) {
            gradosParaFiltro.add(2 + "");
        }
        if (gdoTercero.isSelected()) {
            gradosParaFiltro.add(3 + "");
        }
        if (gdoCuarto.isSelected()) {
            gradosParaFiltro.add(4 + "");
        }
        if (gdoQuinto.isSelected()) {
            gradosParaFiltro.add(5 + "");
        }
        if (gdoSexto.isSelected()) {
            gradosParaFiltro.add(6 + "");
        }
        grados = generarStatementParaFiltro(gradosParaFiltro, "grado");
        unirStatementsYMostrarTabla();
        gradosParaFiltro.clear();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estudiantes().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrarFiltro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    public static javax.swing.JButton btnRegistro;
    private javax.swing.JMenuItem editarOption;
    private javax.swing.JMenuItem eliminarOption;
    private javax.swing.JFrame filtroEstudiante;
    private javax.swing.JCheckBox gdoCuarto;
    private javax.swing.JCheckBox gdoPrimero;
    private javax.swing.JCheckBox gdoQuinto;
    private javax.swing.JCheckBox gdoSegundo;
    private javax.swing.JCheckBox gdoSexto;
    private javax.swing.JCheckBox gdoTercero;
    private javax.swing.JCheckBox gpoA;
    private javax.swing.JCheckBox gpoB;
    private javax.swing.JCheckBox gpoC;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblEstudiantes;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JPopupMenu optionsMenu;
    private javax.swing.JFrame registroEstudiante;
    private javax.swing.JSpinner spnGrado;
    public static javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    // End of variables declaration//GEN-END:variables

    public static void mostrarNumeroDeEstudiatnes() {
        StringBuilder formattedNumLibros = new StringBuilder();
        formattedNumLibros.append("<html><center><h1>");
        formattedNumLibros.append(numeroDeEstudiantes);
        formattedNumLibros.append("</h1><h3>Estudiantes</h3></center>");
        lblEstudiantes.setText(formattedNumLibros.toString());
    }

    private void limpiarElementosSeleccionadosParaFiltro() {
        gdoPrimero.setSelected(false);
        gdoSegundo.setSelected(false);
        gdoTercero.setSelected(false);
        gdoCuarto.setSelected(false);
        gdoQuinto.setSelected(false);
        gdoSexto.setSelected(false);
        gpoA.setSelected(false);
        gpoB.setSelected(false);
        gpoC.setSelected(false);

    }

    private boolean areCamposSeleccionadosParaFiltro() {
        return gdoPrimero.isSelected() || gdoSegundo.isSelected()
                || gdoTercero.isSelected() || gdoCuarto.isSelected()
                || gdoQuinto.isSelected() || gdoSexto.isSelected()
                || gpoA.isSelected() || gpoB.isSelected()
                || gpoC.isSelected();
    }

    private String generarStatementParaFiltro(List<String> options, String type) {
        String statementParaFiltro = "";
        if (options.size() >= 1) {
            for (int i = 0; i < options.size(); i++) {
                if (i == options.size() - 1) {
                    if (type.equals("grupo")) {
                        statementParaFiltro += type + " = '" + options.get(i) + "'";
                    } else {
                        statementParaFiltro += type + " = " + options.get(i);
                    }
                    break;
                }
                if (type.equals("grupo")) {
                    statementParaFiltro += type + " = '" + options.get(i) + "' or ";
                } else {
                    statementParaFiltro += type + " = " + options.get(i) + " or ";
                }
            }
        }
        return statementParaFiltro;
    }

    private void setEnableBtnBorrarFiltro() {
        boolean enable = false;
        if (areCamposSeleccionadosParaFiltro()) {
            enable = true;
        }
        btnBorrarFiltro.setEnabled(enable);
    }

    private void unirStatementsYMostrarTabla() {
        String whereClause = " ";
        if (grados == null || grados.equals("") && grupos != null) {
            whereClause = grupos;
        } else if (grupos == null || grupos.equals("") && grados != null) {
            whereClause = grados;
        } else {
            whereClause = grados + " and " + grupos;
        }
        if (!whereClause.equals("")) {
            mostrarTablaAlumnos(whereClause);
        }

    }

    private void mostrarTablaAlumnos(String statement) {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM alumno where " + statement;
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
        model.setColumnIdentifiers(
                new String[]{"Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Grado", "Grupo"});
        numeroDeEstudiantes = model.getRowCount();
        tblAlumnos.setModel(model);
        mostrarNumeroDeEstudiatnes();
    }

    private String[] getIdsDeEstudiantesSeleccionados() {
        int N = tblAlumnos.getSelectedRowCount();
        String[] listOfEstudiantesIds = new String[N];
        for (int i = 0; i < N; i++) {
            String id = (String) tblAlumnos.getValueAt(tblAlumnos.getSelectedRows()[i], 0);
            listOfEstudiantesIds[i] = id;
        }
        return listOfEstudiantesIds;
    }

    private void deleteEstudiantesSeleccionados(String[] ids) {
        for (String id : ids) {
            eliminarElementoDeLaTabla(id);
        }
    }

}
