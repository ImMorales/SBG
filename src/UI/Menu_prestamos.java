package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.MOVE_CURSOR;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Menu_prestamos extends javax.swing.JFrame {
//variables para la seleccion de libro

    public static int id_libro;
    public static String nombrelibro;
    public static String tipo;
    public static String subgenero;
    public static int num_paginas;
    public static int cantidad;

//variables para la seleccion de estudiante 
    public static String matriculaestudiante;
    public static String nombreestudiante;
    public static String apellidoPestudiante;
    public static String apellidoMestudiante;
    public static int gradoestudiante;
    public static String grupoestudiante;

    public static int NumeroPrestamosTotales;
    int x, y, xgx = 0, ygy = 0;
    DefaultTableModel model, modellibros, modelestudiante, modelAuxAlumnos, modelAuxLibros, modelAuxPrestamos;
    boolean auxVisibleFrom = false;

    Menu mpodn = new Menu();
    String info_libroDefault = "No se ha seleccionado un libro...";
    String info_lectorDefault = "No se ha seleccionado un lector...";
    public static String info_libro = "No se ha seleccionado un libro...", info_lector = "No se ha seleccionado un lector...";
    public static String prestamos_matricula;
    public static int prestamos_ld_libros;

    public static String FrameCheck = "...", matriculagv;
    public static int ideditar = 0;
    public static int id_librogv, rowPrestamos, rowLibro, rowAlumno;

    public Menu_prestamos() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/IMG/logobeta1.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        mostrarTablaPrestamos();
        placeHolder();
        setTitle("Registro de prestamo");
        mostrarMenuDeOpciones();
        actualizarBusqueda();

        // tblPrestamos.setRowSelectionInterval(3, 3);
        txtidlibro.setVisible(false);
        txtMatricula.setVisible(false);

        ta_info_libros.setText(info_libro);
        ta_info_lector.setText(info_lector);

        txtidlibro.setText("" + prestamos_ld_libros);
        txtMatricula.setText(prestamos_matricula);

    }

    private static void getValuesbas() {

        try {

            for (int Countbas = 0; Countbas <= tblAuxPrestamos.getRowCount() - 1; Countbas++) {
                int rdp = (int) tblAuxPrestamos.getValueAt(Countbas, 0);
                if (rdp == ideditar) {
                    rowPrestamos = Countbas;
                    id_librogv = (int) tblAuxPrestamos.getValueAt(rowPrestamos, 2);
                    matriculagv = (String) tblAuxPrestamos.getValueAt(rowPrestamos, 1);
                    getValoreslibroeditar();
                    getValoresalumnoditar();
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo getValuesbas " + e);
        }

    }

    private static void getValoreslibroeditar(){
        try{
            
            for (int Countbaslibro = 0; Countbaslibro <= tblAuxLibros.getRowCount() - 1; Countbaslibro++) {
                        int rdlibros = (int) tblAuxLibros.getValueAt(Countbaslibro, 0);
                        if (rdlibros == id_librogv) {
                            rowLibro = Countbaslibro;
                            String nombrelibroaux = (String) tblAuxLibros.getValueAt(rowLibro, 1);
                            String tipoaux = (String) tblAuxLibros.getValueAt(rowLibro, 2);
                            String subgeneroaux = (String) tblAuxLibros.getValueAt(rowLibro, 3);
                            int num_paginasaux = (int) tblAuxLibros.getValueAt(rowLibro, 4);
                            info_libro = "Informacion del libro:\nNombre: " + nombrelibroaux + " \nTipo: " + tipoaux + " \nSubgenero: " + subgeneroaux + " \nNumero de paginas: " + num_paginasaux;
                            prestamos_ld_libros = id_librogv;
                            break;
                        }
                    }
            
            
        }catch(Exception e){
            System.out.println("Error en el metodo getValueslibroeditar " + e);
            
        }
    }
    
     private static void getValoresalumnoditar(){
        try{
            for (int Countbasalumno = 0; Countbasalumno <= tblAuxAlumnos.getRowCount() - 1; Countbasalumno++) {
                        String rdalumno = (String) tblAuxAlumnos.getValueAt(Countbasalumno, 0);
                        if (rdalumno.equals(matriculagv) == true) {
                            rowAlumno = Countbasalumno;
                            String nombreestudianteaux = (String) tblAuxAlumnos.getValueAt(rowAlumno, 1);
                            String apellidoPestudianteaux = (String) tblAuxAlumnos.getValueAt(rowAlumno, 2);
                            String apellidoMestudianteaux = (String) tblAuxAlumnos.getValueAt(rowAlumno, 3);
                            int gradoestudianteaux = (int) tblAuxAlumnos.getValueAt(rowAlumno, 4);
                            String grupoestudianteaux = (String) tblAuxAlumnos.getValueAt(rowAlumno, 5);

                            info_lector = "Informacion del lector:\nNombre: " + nombreestudianteaux + "\nApellido paterno: " + apellidoPestudianteaux + " \nApellido materno: " + apellidoMestudianteaux + " \nGrado: " + gradoestudianteaux + " \nGrupo: " + grupoestudianteaux;
                            prestamos_matricula = matriculagv;
                            break;
                        }
                    }
            
        }catch(Exception e){
            System.out.println("Error en el metodo getValuesalumnoeditar " + e);
            
        }
    }
    public void mostrarPrestamosTotales() {
        StringBuilder VPT = new StringBuilder();
        VPT.append("<html><center><h1>");
        VPT.append(NumeroPrestamosTotales);
        VPT.append("</h1><h3>Prestamos</h3></center>");
        lblPrestamosTotales.setText("" + VPT);
    }

    private void limpiarRegistroPrestamo() {
        info_libro = "No se ha seleccionado un libro...";
        info_lector = "No se ha seleccionado un lector...";
        prestamos_ld_libros = 0;
        prestamos_matricula = "";
        ta_info_libros.setText(info_libro);
        ta_info_lector.setText(info_lector);

        txtidlibro.setText("" + prestamos_ld_libros);
        txtMatricula.setText(prestamos_matricula);

        jdt.setDate(null);
    }

    public static int getId_libro() {
        return id_libro;
    }

    public static void setId_libro(int id_libro) {
        Menu_prestamos.id_libro = id_libro;
    }

    public static String getNombrelibro() {
        return nombrelibro;
    }

    public static void setNombrelibro(String nombre) {
        Menu_prestamos.nombrelibro = nombrelibro;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Menu_prestamos.tipo = tipo;
    }

    public static String getSubgenero() {
        return subgenero;
    }

    public static void setSubgenero(String subgenero) {
        Menu_prestamos.subgenero = subgenero;
    }

    public static int getNum_paginas() {
        return num_paginas;
    }

    public static void setNum_paginas(int num_paginas) {
        Menu_prestamos.num_paginas = num_paginas;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        Menu_prestamos.cantidad = cantidad;
    }

    public static String getMatriculaestudiante() {
        return matriculaestudiante;
    }

    public static void setMatriculaestudiante(String matriculaestudiante) {
        matriculaestudiante = matriculaestudiante;
    }

    public static String getNombreestudiante() {
        return nombreestudiante;
    }

    public static void setNombreestudiante(String nombreestudiante) {
        nombreestudiante = nombreestudiante;
    }

    public static String getApellidoPestudiante() {
        return apellidoPestudiante;
    }

    public static void setApellidoPestudiante(String apellidoPestudiante) {
        apellidoPestudiante = apellidoPestudiante;
    }

    public static String getApellidoMestudiante() {
        return apellidoMestudiante;
    }

    public static void setApellidoMestudiante(String apellidoMestudiante) {
        apellidoMestudiante = apellidoMestudiante;
    }

    public static int getGradoestudiante() {
        return gradoestudiante;
    }

    public static void setGradoestudiante(int gradoestudiante) {
        gradoestudiante = gradoestudiante;
    }

    public static String getGrupoestudiante() {
        return grupoestudiante;
    }

    public static void setGrupoestudiante(String grupoestudiante) {
        grupoestudiante = grupoestudiante;
    }

    private static void RefreshNumStatus() {
        int NumeroPrestamosPendientes = 0, NumeroPrestamosude = 0, NumeroPrestamostex = 0;

        for (int PrestamosCount = 0; PrestamosCount <= tblPrestamos.getRowCount() - 1; PrestamosCount++) {
            String estado = (String) tblPrestamos.getValueAt(PrestamosCount, 8);
            switch (estado) {
                case "pendiente":
                    NumeroPrestamosPendientes = NumeroPrestamosPendientes + 1;
                    break;

                case "ultimo dia de entrega":
                    NumeroPrestamosude = NumeroPrestamosude + 1;
                    break;

                case "tiempo excedido":
                    NumeroPrestamostex = NumeroPrestamostex + 1;
                    break;

                default:
                    System.out.println("Menu_Prestamos/method/countstatus");
            }
        }
        lbl_numero_pendientes.setText("" + NumeroPrestamosPendientes);
        lbl_numero_ude.setText("" + NumeroPrestamosude);
        lbl_numero_tex.setText("" + NumeroPrestamostex);

    }

    public void mostrarTablaAuxPrestamos() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM prestamo";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelAuxPrestamos = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelAuxPrestamos.setColumnIdentifiers(new Object[]{"id_prestamo", "Matricula", "id_libro", "Docente", "FS", "FD", "E"});
            tblAuxPrestamos.setModel(modelAuxPrestamos);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    public void mostrarTablaAlumnosestudiante() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT matricula,nombre,apellido_paterno,apellido_materno,grado FROM alumno";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelestudiante = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelestudiante.setColumnIdentifiers(new Object[]{"Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad"});
            tblAlumnosestudiante.setModel(modelestudiante);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    public void mostrarTablaAuxAlumnos() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "SELECT * FROM alumno";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelAuxAlumnos = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelAuxAlumnos.setColumnIdentifiers(new Object[]{"Matricula", "Nombre", "Apellido Paterno", "Apellido Materno", "Grado", "Grupo"});
            tblAuxAlumnos.setModel(modelAuxAlumnos);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    public void mostrarTablaLibros() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "select id_libro, nombre, tipo, sub_genero, num_paginas from libro;";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modellibros = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modellibros.setColumnIdentifiers(new Object[]{"id_libro", "Nombre del libro", "tipo", "Subgenero", "numero de paginas"});
            tblLibros.setModel(modellibros);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    public void mostrarTablaAuxLibros() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query = "select id_libro, nombre, tipo, sub_genero, num_paginas from libro;";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            modelAuxLibros = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            modelAuxLibros.setColumnIdentifiers(new Object[]{"id_libro", "Nombre del libro", "tipo", "Subgenero", "numero de paginas"});
            tblAuxLibros.setModel(modelAuxLibros);

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FiltroPrestamos = new javax.swing.JFrame();
        Prestamo_filtro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbx_all = new javax.swing.JCheckBox();
        cbx_pendientes = new javax.swing.JCheckBox();
        cbx_tex = new javax.swing.JCheckBox();
        cbx_ude = new javax.swing.JCheckBox();
        btn_aceptar_fitroestado = new javax.swing.JButton();
        RegistroPrestamos = new javax.swing.JFrame();
        header1 = new javax.swing.JPanel();
        Panel_prestamos_principal = new javax.swing.JPanel();
        Panel_libro = new javax.swing.JPanel();
        LEFT_book = new javax.swing.JPanel();
        btnBuscarLibro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RIGHT_book = new javax.swing.JPanel();
        ta_info_librosscroll = new javax.swing.JScrollPane();
        ta_info_libros = new javax.swing.JTextArea();
        Panel_lector = new javax.swing.JPanel();
        LEFT_reader = new javax.swing.JPanel();
        btnBuscarAlumno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        RIGHT_reader = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_info_lector = new javax.swing.JTextArea();
        Panel_fecha = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jdt = new com.toedter.calendar.JDateChooser();
        AuxiliarPane = new javax.swing.JPanel();
        txtidlibro = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        bottom = new javax.swing.JPanel();
        btn_aceptar_prestamo = new javax.swing.JButton();
        btn_cancelar_prestamo = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        Seleccionar_libro = new javax.swing.JFrame();
        Panel_inferiorBL = new javax.swing.JPanel();
        OpcionesInferiorBL = new javax.swing.JPanel();
        Panel_searchBL = new javax.swing.JPanel();
        txtBusquedalibro = new javax.swing.JTextField();
        paneloptionsBL = new javax.swing.JPanel();
        btnRegistrolibro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        Seleccionar_estudiante = new javax.swing.JFrame();
        headerES = new javax.swing.JPanel();
        Panel_menumpES = new javax.swing.JPanel();
        Panel_minES = new javax.swing.JPanel();
        Panel_maxES = new javax.swing.JPanel();
        Panel_cerrarES = new javax.swing.JPanel();
        Panel_inferiorES = new javax.swing.JPanel();
        OpcionesInferiorBL1 = new javax.swing.JPanel();
        Panel_searchBL1 = new javax.swing.JPanel();
        txtBusquedaestudiante = new javax.swing.JTextField();
        paneloptionsBL1 = new javax.swing.JPanel();
        btnRegistroestudiante = new javax.swing.JButton();
        btnCancelarestudiante = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAlumnosestudiante = new javax.swing.JTable();
        FrameAuxiliar = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAuxAlumnos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAuxLibros = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAuxPrestamos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        Plus_informacion = new javax.swing.JFrame();
        header2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Panel_prestamos_principal1 = new javax.swing.JPanel();
        plusinfo1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        PlusInfo_ta1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        plusinfo2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        PlusInfo_ta2 = new javax.swing.JTextArea();
        plusinfo3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        PlusInfo_ta3 = new javax.swing.JTextArea();
        bottom1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        PanelPrestamosTOP = new javax.swing.JPanel();
        PanelPrestamosCenter = new javax.swing.JPanel();
        txtBusquedaPrestamos = new javax.swing.JTextField();
        lblerase = new javax.swing.JLabel();
        PanelPrestamosRight = new javax.swing.JPanel();
        btnRegistro = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_filtroprestamos = new javax.swing.JButton();
        PanelPrestamosLeft = new javax.swing.JPanel();
        lblPrestamosTotales = new javax.swing.JLabel();
        Panelnumerosstatus = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Statusall = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_numero_pendientes = new javax.swing.JLabel();
        lbl_numero_ude = new javax.swing.JLabel();
        lbl_numero_tex = new javax.swing.JLabel();
        lbl_encabezado_prestamos = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();
        PanelAuxBottomP = new javax.swing.JPanel();
        PanelAuxRightP = new javax.swing.JPanel();
        PanelAuxLeftP = new javax.swing.JPanel();
        PanelAuxCenterP = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();

        FiltroPrestamos.setMinimumSize(new java.awt.Dimension(162, 165));
        FiltroPrestamos.setUndecorated(true);

        Prestamo_filtro.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><h3>FIltro por estado</html></h3>");

        cbx_all.setBackground(new java.awt.Color(255, 255, 255));
        cbx_all.setSelected(true);
        cbx_all.setText("Mostrar todos");
        cbx_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_allMouseClicked(evt);
            }
        });

        cbx_pendientes.setText("Pendientes");
        cbx_pendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_pendientesMouseClicked(evt);
            }
        });

        cbx_tex.setText("Tiempo excedido");
        cbx_tex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_texMouseClicked(evt);
            }
        });

        cbx_ude.setText("Ultimo dia de entrega");
        cbx_ude.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_udeMouseClicked(evt);
            }
        });

        btn_aceptar_fitroestado.setBackground(new java.awt.Color(255, 255, 255));
        btn_aceptar_fitroestado.setText("Aceptar");
        btn_aceptar_fitroestado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar_fitroestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_fitroestadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Prestamo_filtroLayout = new javax.swing.GroupLayout(Prestamo_filtro);
        Prestamo_filtro.setLayout(Prestamo_filtroLayout);
        Prestamo_filtroLayout.setHorizontalGroup(
            Prestamo_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addGroup(Prestamo_filtroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Prestamo_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_ude)
                    .addComponent(cbx_all)
                    .addComponent(cbx_pendientes)
                    .addComponent(cbx_tex))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btn_aceptar_fitroestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prestamo_filtroLayout.setVerticalGroup(
            Prestamo_filtroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Prestamo_filtroLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx_all)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_pendientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_ude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_tex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btn_aceptar_fitroestado))
        );

        javax.swing.GroupLayout FiltroPrestamosLayout = new javax.swing.GroupLayout(FiltroPrestamos.getContentPane());
        FiltroPrestamos.getContentPane().setLayout(FiltroPrestamosLayout);
        FiltroPrestamosLayout.setHorizontalGroup(
            FiltroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Prestamo_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FiltroPrestamosLayout.setVerticalGroup(
            FiltroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Prestamo_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        RegistroPrestamos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        RegistroPrestamos.setTitle("SiBi [Registro de prestamo]");
        RegistroPrestamos.setAlwaysOnTop(true);
        RegistroPrestamos.setMinimumSize(new java.awt.Dimension(520, 600));
        RegistroPrestamos.setSize(new java.awt.Dimension(520, 600));

        header1.setBackground(new java.awt.Color(0, 102, 255));
        header1.setLayout(new java.awt.BorderLayout());
        RegistroPrestamos.getContentPane().add(header1, java.awt.BorderLayout.PAGE_START);

        Panel_prestamos_principal.setPreferredSize(new java.awt.Dimension(520, 600));
        Panel_prestamos_principal.setRequestFocusEnabled(false);
        Panel_prestamos_principal.setLayout(new javax.swing.BoxLayout(Panel_prestamos_principal, javax.swing.BoxLayout.Y_AXIS));

        Panel_libro.setBackground(new java.awt.Color(254, 254, 254));
        Panel_libro.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><h2>Libro</h2></html>"));
        Panel_libro.setPreferredSize(new java.awt.Dimension(491, 210));
        Panel_libro.setLayout(new java.awt.GridLayout(1, 0));

        LEFT_book.setBackground(new java.awt.Color(255, 255, 255));
        LEFT_book.setPreferredSize(new java.awt.Dimension(200, 151));

        btnBuscarLibro.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarLibro.setText("Seleccionar un libro");
        btnBuscarLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/squarebook.png"))); // NOI18N

        javax.swing.GroupLayout LEFT_bookLayout = new javax.swing.GroupLayout(LEFT_book);
        LEFT_book.setLayout(LEFT_bookLayout);
        LEFT_bookLayout.setHorizontalGroup(
            LEFT_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LEFT_bookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        LEFT_bookLayout.setVerticalGroup(
            LEFT_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEFT_bookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarLibro)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Panel_libro.add(LEFT_book);

        RIGHT_book.setBackground(new java.awt.Color(255, 255, 255));

        ta_info_libros.setEditable(false);
        ta_info_libros.setBackground(new java.awt.Color(245, 245, 245));
        ta_info_libros.setColumns(20);
        ta_info_libros.setRows(5);
        ta_info_librosscroll.setViewportView(ta_info_libros);

        javax.swing.GroupLayout RIGHT_bookLayout = new javax.swing.GroupLayout(RIGHT_book);
        RIGHT_book.setLayout(RIGHT_bookLayout);
        RIGHT_bookLayout.setHorizontalGroup(
            RIGHT_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ta_info_librosscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        RIGHT_bookLayout.setVerticalGroup(
            RIGHT_bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RIGHT_bookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ta_info_librosscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_libro.add(RIGHT_book);

        Panel_prestamos_principal.add(Panel_libro);

        Panel_lector.setBackground(new java.awt.Color(254, 254, 254));
        Panel_lector.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><h2>Cliente</h2></html>"));
        Panel_lector.setPreferredSize(new java.awt.Dimension(491, 210));
        Panel_lector.setLayout(new java.awt.GridLayout(1, 0));

        LEFT_reader.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarAlumno.setText("Seleccionar cliente");
        btnBuscarAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/squarechild.png"))); // NOI18N

        javax.swing.GroupLayout LEFT_readerLayout = new javax.swing.GroupLayout(LEFT_reader);
        LEFT_reader.setLayout(LEFT_readerLayout);
        LEFT_readerLayout.setHorizontalGroup(
            LEFT_readerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LEFT_readerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addContainerGap())
        );
        LEFT_readerLayout.setVerticalGroup(
            LEFT_readerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LEFT_readerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarAlumno)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        Panel_lector.add(LEFT_reader);

        RIGHT_reader.setBackground(new java.awt.Color(255, 255, 255));

        ta_info_lector.setEditable(false);
        ta_info_lector.setBackground(new java.awt.Color(245, 245, 245));
        ta_info_lector.setColumns(20);
        ta_info_lector.setRows(5);
        jScrollPane2.setViewportView(ta_info_lector);

        javax.swing.GroupLayout RIGHT_readerLayout = new javax.swing.GroupLayout(RIGHT_reader);
        RIGHT_reader.setLayout(RIGHT_readerLayout);
        RIGHT_readerLayout.setHorizontalGroup(
            RIGHT_readerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        RIGHT_readerLayout.setVerticalGroup(
            RIGHT_readerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RIGHT_readerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel_lector.add(RIGHT_reader);

        Panel_prestamos_principal.add(Panel_lector);

        Panel_fecha.setBackground(new java.awt.Color(254, 254, 254));
        Panel_fecha.setBorder(javax.swing.BorderFactory.createTitledBorder("<html><h2>Fecha</h2></html>"));
        Panel_fecha.setLayout(new java.awt.GridLayout(1, 0));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fecha de devolucion");
        Panel_fecha.add(jLabel14);
        Panel_fecha.add(jdt);

        Panel_prestamos_principal.add(Panel_fecha);

        AuxiliarPane.setBackground(new java.awt.Color(255, 255, 255));
        AuxiliarPane.setPreferredSize(new java.awt.Dimension(424, 10));
        AuxiliarPane.setLayout(new java.awt.GridLayout(1, 0));

        txtidlibro.setEnabled(false);
        txtidlibro.setMinimumSize(new java.awt.Dimension(4, 10));
        txtidlibro.setPreferredSize(new java.awt.Dimension(4, 10));
        AuxiliarPane.add(txtidlibro);

        txtMatricula.setMinimumSize(new java.awt.Dimension(4, 10));
        txtMatricula.setPreferredSize(new java.awt.Dimension(4, 10));
        AuxiliarPane.add(txtMatricula);

        Panel_prestamos_principal.add(AuxiliarPane);

        bottom.setBackground(new java.awt.Color(254, 254, 254));
        bottom.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        btn_aceptar_prestamo.setBackground(new java.awt.Color(255, 255, 255));
        btn_aceptar_prestamo.setForeground(new java.awt.Color(0, 0, 0));
        btn_aceptar_prestamo.setText("Aceptar");
        btn_aceptar_prestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_aceptar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptar_prestamoActionPerformed(evt);
            }
        });
        bottom.add(btn_aceptar_prestamo);

        btn_cancelar_prestamo.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar_prestamo.setForeground(new java.awt.Color(0, 0, 0));
        btn_cancelar_prestamo.setText("Cancelar");
        btn_cancelar_prestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar_prestamo.setPreferredSize(new java.awt.Dimension(84, 36));
        btn_cancelar_prestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar_prestamoActionPerformed(evt);
            }
        });
        bottom.add(btn_cancelar_prestamo);

        Panel_prestamos_principal.add(bottom);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(520, 10));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        Panel_prestamos_principal.add(jPanel9);

        RegistroPrestamos.getContentPane().add(Panel_prestamos_principal, java.awt.BorderLayout.CENTER);

        Seleccionar_libro.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Seleccionar_libro.setTitle("Busqueda de libro");
        Seleccionar_libro.setMinimumSize(new java.awt.Dimension(800, 530));

        Panel_inferiorBL.setBackground(new java.awt.Color(254, 254, 254));
        Panel_inferiorBL.setLayout(new java.awt.BorderLayout());

        OpcionesInferiorBL.setBackground(new java.awt.Color(255, 255, 255));
        OpcionesInferiorBL.setLayout(new java.awt.GridLayout(1, 2));

        Panel_searchBL.setBackground(new java.awt.Color(255, 255, 255));
        Panel_searchBL.setPreferredSize(new java.awt.Dimension(400, 70));

        txtBusquedalibro.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusquedalibro.setPreferredSize(new java.awt.Dimension(320, 30));
        txtBusquedalibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedalibroActionPerformed(evt);
            }
        });
        txtBusquedalibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedalibroKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedalibroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout Panel_searchBLLayout = new javax.swing.GroupLayout(Panel_searchBL);
        Panel_searchBL.setLayout(Panel_searchBLLayout);
        Panel_searchBLLayout.setHorizontalGroup(
            Panel_searchBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_searchBLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusquedalibro, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
        Panel_searchBLLayout.setVerticalGroup(
            Panel_searchBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_searchBLLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtBusquedalibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        OpcionesInferiorBL.add(Panel_searchBL);

        paneloptionsBL.setBackground(new java.awt.Color(255, 255, 255));
        paneloptionsBL.setPreferredSize(new java.awt.Dimension(200, 70));

        btnRegistrolibro.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrolibro.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnRegistrolibro.setForeground(new java.awt.Color(1, 1, 1));
        btnRegistrolibro.setText("<html><h3>Aceptar</h3>");
        btnRegistrolibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrolibro.setFocusPainted(false);
        btnRegistrolibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrolibroActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(1, 1, 1));
        jButton2.setText("<html><h3>Cancelar</h3>");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneloptionsBLLayout = new javax.swing.GroupLayout(paneloptionsBL);
        paneloptionsBL.setLayout(paneloptionsBLLayout);
        paneloptionsBLLayout.setHorizontalGroup(
            paneloptionsBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneloptionsBLLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(btnRegistrolibro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneloptionsBLLayout.setVerticalGroup(
            paneloptionsBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneloptionsBLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneloptionsBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrolibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OpcionesInferiorBL.add(paneloptionsBL);

        Panel_inferiorBL.add(OpcionesInferiorBL, java.awt.BorderLayout.PAGE_START);

        tblLibros.setAutoCreateRowSorter(true);
        tblLibros.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblLibros.setAutoscrolls(false);
        tblLibros.setFocusable(false);
        tblLibros.setGridColor(new java.awt.Color(172, 172, 172));
        tblLibros.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblLibros.setRowHeight(28);
        tblLibros.getTableHeader().setReorderingAllowed(false);
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        tblLibros.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblLibrosPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tblLibros);

        Panel_inferiorBL.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        Seleccionar_libro.getContentPane().add(Panel_inferiorBL, java.awt.BorderLayout.CENTER);

        Seleccionar_estudiante.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Seleccionar_estudiante.setTitle("Busqueda de cliente");
        Seleccionar_estudiante.setMinimumSize(new java.awt.Dimension(800, 530));

        headerES.setBackground(new java.awt.Color(0, 102, 255));
        headerES.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        headerES.setLayout(new java.awt.BorderLayout());

        Panel_menumpES.setBackground(new java.awt.Color(0, 102, 255));
        Panel_menumpES.setLayout(new java.awt.GridLayout(1, 3));

        Panel_minES.setBackground(new java.awt.Color(0, 102, 255));
        Panel_minES.setLayout(new java.awt.BorderLayout());
        Panel_menumpES.add(Panel_minES);

        Panel_maxES.setBackground(new java.awt.Color(0, 102, 255));
        Panel_maxES.setLayout(new java.awt.BorderLayout());
        Panel_menumpES.add(Panel_maxES);

        Panel_cerrarES.setBackground(new java.awt.Color(255, 51, 51));
        Panel_cerrarES.setLayout(new java.awt.BorderLayout());
        Panel_menumpES.add(Panel_cerrarES);

        headerES.add(Panel_menumpES, java.awt.BorderLayout.LINE_END);

        Seleccionar_estudiante.getContentPane().add(headerES, java.awt.BorderLayout.PAGE_START);

        Panel_inferiorES.setBackground(new java.awt.Color(254, 254, 254));
        Panel_inferiorES.setLayout(new java.awt.BorderLayout());

        OpcionesInferiorBL1.setBackground(new java.awt.Color(255, 255, 255));
        OpcionesInferiorBL1.setLayout(new java.awt.GridLayout(1, 2));

        Panel_searchBL1.setBackground(new java.awt.Color(255, 255, 255));
        Panel_searchBL1.setPreferredSize(new java.awt.Dimension(400, 70));

        txtBusquedaestudiante.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusquedaestudiante.setPreferredSize(new java.awt.Dimension(320, 30));
        txtBusquedaestudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaestudianteActionPerformed(evt);
            }
        });
        txtBusquedaestudiante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaestudianteKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaestudianteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout Panel_searchBL1Layout = new javax.swing.GroupLayout(Panel_searchBL1);
        Panel_searchBL1.setLayout(Panel_searchBL1Layout);
        Panel_searchBL1Layout.setHorizontalGroup(
            Panel_searchBL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_searchBL1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusquedaestudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );
        Panel_searchBL1Layout.setVerticalGroup(
            Panel_searchBL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_searchBL1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtBusquedaestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        OpcionesInferiorBL1.add(Panel_searchBL1);

        paneloptionsBL1.setBackground(new java.awt.Color(255, 255, 255));
        paneloptionsBL1.setPreferredSize(new java.awt.Dimension(200, 70));

        btnRegistroestudiante.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistroestudiante.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnRegistroestudiante.setForeground(new java.awt.Color(1, 1, 1));
        btnRegistroestudiante.setText("<html><h3>Aceptar</h3>");
        btnRegistroestudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroestudiante.setFocusPainted(false);
        btnRegistroestudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroestudianteActionPerformed(evt);
            }
        });

        btnCancelarestudiante.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarestudiante.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelarestudiante.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelarestudiante.setText("<html><h3>Cancelar</h3>");
        btnCancelarestudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelarestudiante.setFocusPainted(false);
        btnCancelarestudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarestudianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneloptionsBL1Layout = new javax.swing.GroupLayout(paneloptionsBL1);
        paneloptionsBL1.setLayout(paneloptionsBL1Layout);
        paneloptionsBL1Layout.setHorizontalGroup(
            paneloptionsBL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneloptionsBL1Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(btnRegistroestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneloptionsBL1Layout.setVerticalGroup(
            paneloptionsBL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneloptionsBL1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneloptionsBL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistroestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OpcionesInferiorBL1.add(paneloptionsBL1);

        Panel_inferiorES.add(OpcionesInferiorBL1, java.awt.BorderLayout.PAGE_START);

        tblAlumnosestudiante.setAutoCreateRowSorter(true);
        tblAlumnosestudiante.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tblAlumnosestudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAlumnosestudiante.setAutoscrolls(false);
        tblAlumnosestudiante.setFocusable(false);
        tblAlumnosestudiante.setGridColor(new java.awt.Color(172, 172, 172));
        tblAlumnosestudiante.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblAlumnosestudiante.setRowHeight(28);
        tblAlumnosestudiante.getTableHeader().setReorderingAllowed(false);
        tblAlumnosestudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosestudianteMouseClicked(evt);
            }
        });
        tblAlumnosestudiante.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblAlumnosestudiantePropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(tblAlumnosestudiante);

        Panel_inferiorES.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        Seleccionar_estudiante.getContentPane().add(Panel_inferiorES, java.awt.BorderLayout.CENTER);

        FrameAuxiliar.setLocation(new java.awt.Point(0, 0));
        FrameAuxiliar.setMinimumSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblAuxAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblAuxAlumnos);

        tblAuxLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblAuxLibros);

        jLabel6.setText("Alumnos");

        jLabel8.setText("Libros");

        tblAuxPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblAuxPrestamos);

        jLabel9.setText("Prestamos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FrameAuxiliar.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Plus_informacion.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Plus_informacion.setTitle("Informacion de prestamo");
        Plus_informacion.setAlwaysOnTop(true);
        Plus_informacion.setMinimumSize(new java.awt.Dimension(550, 430));
        Plus_informacion.setSize(new java.awt.Dimension(550, 430));

        header2.setBackground(new java.awt.Color(0, 102, 255));
        header2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(520, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        header2.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        Plus_informacion.getContentPane().add(header2, java.awt.BorderLayout.PAGE_START);

        Panel_prestamos_principal1.setLayout(new javax.swing.BoxLayout(Panel_prestamos_principal1, javax.swing.BoxLayout.Y_AXIS));

        plusinfo1.setBackground(new java.awt.Color(255, 255, 255));

        PlusInfo_ta1.setEditable(false);
        PlusInfo_ta1.setColumns(20);
        PlusInfo_ta1.setRows(5);
        jScrollPane8.setViewportView(PlusInfo_ta1);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/squarebook.png"))); // NOI18N

        javax.swing.GroupLayout plusinfo1Layout = new javax.swing.GroupLayout(plusinfo1);
        plusinfo1.setLayout(plusinfo1Layout);
        plusinfo1Layout.setHorizontalGroup(
            plusinfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        plusinfo1Layout.setVerticalGroup(
            plusinfo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo1Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_prestamos_principal1.add(plusinfo1);

        plusinfo2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/squarechild.png"))); // NOI18N

        PlusInfo_ta2.setEditable(false);
        PlusInfo_ta2.setColumns(20);
        PlusInfo_ta2.setRows(5);
        PlusInfo_ta2.setPreferredSize(new java.awt.Dimension(200, 80));
        jScrollPane9.setViewportView(PlusInfo_ta2);

        javax.swing.GroupLayout plusinfo2Layout = new javax.swing.GroupLayout(plusinfo2);
        plusinfo2.setLayout(plusinfo2Layout);
        plusinfo2Layout.setHorizontalGroup(
            plusinfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        plusinfo2Layout.setVerticalGroup(
            plusinfo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo2Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_prestamos_principal1.add(plusinfo2);

        plusinfo3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/colck51.png"))); // NOI18N

        PlusInfo_ta3.setEditable(false);
        PlusInfo_ta3.setColumns(20);
        PlusInfo_ta3.setRows(5);
        jScrollPane11.setViewportView(PlusInfo_ta3);

        javax.swing.GroupLayout plusinfo3Layout = new javax.swing.GroupLayout(plusinfo3);
        plusinfo3.setLayout(plusinfo3Layout);
        plusinfo3Layout.setHorizontalGroup(
            plusinfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );
        plusinfo3Layout.setVerticalGroup(
            plusinfo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plusinfo3Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Panel_prestamos_principal1.add(plusinfo3);

        bottom1.setBackground(new java.awt.Color(254, 254, 254));
        bottom1.setPreferredSize(new java.awt.Dimension(540, 25));
        bottom1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 10));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        bottom1.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(520, 10));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        bottom1.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        bottom1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        bottom1.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(520, 10));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Aceptar");
        jButton4.setMinimumSize(new java.awt.Dimension(80, 36));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, java.awt.BorderLayout.CENTER);

        bottom1.add(jPanel6, java.awt.BorderLayout.CENTER);

        Panel_prestamos_principal1.add(bottom1);

        Plus_informacion.getContentPane().add(Panel_prestamos_principal1, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SiBi");
        setBackground(java.awt.SystemColor.controlLtHighlight);

        header.setBackground(new java.awt.Color(0, 102, 255));
        header.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        header.setLayout(new java.awt.BorderLayout());

        PanelPrestamosTOP.setBackground(new java.awt.Color(254, 254, 254));
        PanelPrestamosTOP.setPreferredSize(new java.awt.Dimension(1280, 110));
        PanelPrestamosTOP.setLayout(new java.awt.BorderLayout());

        PanelPrestamosCenter.setBackground(new java.awt.Color(254, 254, 254));
        PanelPrestamosCenter.setMinimumSize(new java.awt.Dimension(100, 30));
        PanelPrestamosCenter.setLayout(new java.awt.GridBagLayout());

        txtBusquedaPrestamos.setMinimumSize(new java.awt.Dimension(80, 30));
        txtBusquedaPrestamos.setPreferredSize(new java.awt.Dimension(320, 30));
        txtBusquedaPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaPrestamosActionPerformed(evt);
            }
        });
        txtBusquedaPrestamos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaPrestamosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaPrestamosKeyPressed(evt);
            }
        });
        PanelPrestamosCenter.add(txtBusquedaPrestamos, new java.awt.GridBagConstraints());

        lblerase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblerase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/Eraser.png"))); // NOI18N
        lblerase.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblerase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblerase.setPreferredSize(new java.awt.Dimension(30, 30));
        lblerase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbleraseMouseClicked(evt);
            }
        });
        PanelPrestamosCenter.add(lblerase, new java.awt.GridBagConstraints());

        PanelPrestamosTOP.add(PanelPrestamosCenter, java.awt.BorderLayout.CENTER);

        PanelPrestamosRight.setBackground(new java.awt.Color(254, 254, 254));
        PanelPrestamosRight.setPreferredSize(new java.awt.Dimension(400, 110));

        btnRegistro.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistro.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add_black.png"))); // NOI18N
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(1, 1, 1));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh_black.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_filtroprestamos.setBackground(new java.awt.Color(255, 255, 255));
        btn_filtroprestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filter_black.png"))); // NOI18N
        btn_filtroprestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_filtroprestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtroprestamosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPrestamosRightLayout = new javax.swing.GroupLayout(PanelPrestamosRight);
        PanelPrestamosRight.setLayout(PanelPrestamosRightLayout);
        PanelPrestamosRightLayout.setHorizontalGroup(
            PanelPrestamosRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrestamosRightLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(btn_filtroprestamos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistro)
                .addGap(50, 50, 50))
        );
        PanelPrestamosRightLayout.setVerticalGroup(
            PanelPrestamosRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrestamosRightLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelPrestamosRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_filtroprestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelPrestamosRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistro)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        PanelPrestamosTOP.add(PanelPrestamosRight, java.awt.BorderLayout.EAST);

        PanelPrestamosLeft.setBackground(new java.awt.Color(254, 254, 254));
        PanelPrestamosLeft.setMaximumSize(new java.awt.Dimension(32767, 110));
        PanelPrestamosLeft.setMinimumSize(new java.awt.Dimension(0, 110));
        PanelPrestamosLeft.setPreferredSize(new java.awt.Dimension(400, 110));
        PanelPrestamosLeft.setLayout(new java.awt.GridLayout(1, 0));

        lblPrestamosTotales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrestamosTotales.setText("<html><center><h1>#</h1><h3>Prestamos</h3></center>");
        PanelPrestamosLeft.add(lblPrestamosTotales);

        Panelnumerosstatus.setBackground(new java.awt.Color(255, 255, 255));
        Panelnumerosstatus.setLayout(new java.awt.BorderLayout());

        jLabel10.setPreferredSize(new java.awt.Dimension(24, 30));
        Panelnumerosstatus.add(jLabel10, java.awt.BorderLayout.PAGE_START);

        jLabel11.setPreferredSize(new java.awt.Dimension(50, 10));
        Panelnumerosstatus.add(jLabel11, java.awt.BorderLayout.PAGE_END);

        Statusall.setBackground(new java.awt.Color(255, 255, 255));
        Statusall.setLayout(new java.awt.GridLayout(2, 3));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/Pendiente.png"))); // NOI18N
        Statusall.add(jLabel4);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/Warning.png"))); // NOI18N
        Statusall.add(jLabel7);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_menu/Danger.png"))); // NOI18N
        Statusall.add(jLabel5);

        lbl_numero_pendientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_numero_pendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_pendientes.setText("PEN");
        Statusall.add(lbl_numero_pendientes);

        lbl_numero_ude.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_numero_ude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_ude.setText("UDE");
        Statusall.add(lbl_numero_ude);

        lbl_numero_tex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_numero_tex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_tex.setText("TEX");
        Statusall.add(lbl_numero_tex);

        Panelnumerosstatus.add(Statusall, java.awt.BorderLayout.CENTER);

        PanelPrestamosLeft.add(Panelnumerosstatus);

        PanelPrestamosTOP.add(PanelPrestamosLeft, java.awt.BorderLayout.LINE_START);

        header.add(PanelPrestamosTOP, java.awt.BorderLayout.SOUTH);

        lbl_encabezado_prestamos.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbl_encabezado_prestamos.setForeground(new java.awt.Color(254, 254, 254));
        lbl_encabezado_prestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_encabezado_prestamos.setText("<html><h1>Prestamos</h1>");
        lbl_encabezado_prestamos.setPreferredSize(new java.awt.Dimension(200, 50));
        lbl_encabezado_prestamos.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        lbl_encabezado_prestamos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lbl_encabezado_prestamosMouseDragged(evt);
            }
        });
        lbl_encabezado_prestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_encabezado_prestamosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lbl_encabezado_prestamosMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_encabezado_prestamosMouseClicked(evt);
            }
        });
        header.add(lbl_encabezado_prestamos, java.awt.BorderLayout.CENTER);

        lbl_cerrar.setFont(new java.awt.Font("Gargi-1.2b", 1, 12)); // NOI18N
        lbl_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/baseline_keyboard_backspace_white_18dp.png"))); // NOI18N
        lbl_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
        });
        header.add(lbl_cerrar, java.awt.BorderLayout.LINE_START);

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        PanelAuxBottomP.setBackground(new java.awt.Color(254, 254, 254));
        PanelAuxBottomP.setPreferredSize(new java.awt.Dimension(1280, 50));

        javax.swing.GroupLayout PanelAuxBottomPLayout = new javax.swing.GroupLayout(PanelAuxBottomP);
        PanelAuxBottomP.setLayout(PanelAuxBottomPLayout);
        PanelAuxBottomPLayout.setHorizontalGroup(
            PanelAuxBottomPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1281, Short.MAX_VALUE)
        );
        PanelAuxBottomPLayout.setVerticalGroup(
            PanelAuxBottomPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(PanelAuxBottomP, java.awt.BorderLayout.PAGE_END);

        PanelAuxRightP.setBackground(new java.awt.Color(254, 254, 254));
        PanelAuxRightP.setMinimumSize(new java.awt.Dimension(50, 0));
        PanelAuxRightP.setPreferredSize(new java.awt.Dimension(50, 471));

        javax.swing.GroupLayout PanelAuxRightPLayout = new javax.swing.GroupLayout(PanelAuxRightP);
        PanelAuxRightP.setLayout(PanelAuxRightPLayout);
        PanelAuxRightPLayout.setHorizontalGroup(
            PanelAuxRightPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        PanelAuxRightPLayout.setVerticalGroup(
            PanelAuxRightPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        getContentPane().add(PanelAuxRightP, java.awt.BorderLayout.LINE_END);

        PanelAuxLeftP.setBackground(new java.awt.Color(254, 254, 254));
        PanelAuxLeftP.setPreferredSize(new java.awt.Dimension(50, 471));

        javax.swing.GroupLayout PanelAuxLeftPLayout = new javax.swing.GroupLayout(PanelAuxLeftP);
        PanelAuxLeftP.setLayout(PanelAuxLeftPLayout);
        PanelAuxLeftPLayout.setHorizontalGroup(
            PanelAuxLeftPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        PanelAuxLeftPLayout.setVerticalGroup(
            PanelAuxLeftPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );

        getContentPane().add(PanelAuxLeftP, java.awt.BorderLayout.LINE_START);

        PanelAuxCenterP.setBackground(new java.awt.Color(254, 254, 254));
        PanelAuxCenterP.setLayout(new java.awt.GridLayout(1, 0));

        tblPrestamos.setAutoCreateRowSorter(true);
        tblPrestamos.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPrestamos.setAutoscrolls(false);
        tblPrestamos.setFocusable(false);
        tblPrestamos.setGridColor(new java.awt.Color(172, 172, 172));
        tblPrestamos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblPrestamos.setRowHeight(28);
        tblPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPrestamosMouseClicked(evt);
            }
        });
        tblPrestamos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblPrestamosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrestamos);

        PanelAuxCenterP.add(jScrollPane1);

        getContentPane().add(PanelAuxCenterP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomsizeTablaPrestamo() {
        tblPrestamos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblPrestamos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblPrestamos.getColumnModel().getColumn(2).setPreferredWidth(10);
        tblPrestamos.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblPrestamos.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPrestamos.getColumnModel().getColumn(5).setPreferredWidth(10);
        tblPrestamos.getColumnModel().getColumn(6).setPreferredWidth(10);
        tblPrestamos.getColumnModel().getColumn(7).setPreferredWidth(20);
        tblPrestamos.getColumnModel().getColumn(8).setPreferredWidth(80);
        tblPrestamos.setRowHeight(30);
    }

    private void mostrarTablaPrestamos() {

        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro;";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del cliente", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});

            NumeroPrestamosTotales = model.getRowCount();
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());
            CustomsizeTablaPrestamo();
            mostrarPrestamosTotales();
            RefreshNumStatus();

            mostrarTablaAuxAlumnos();
            mostrarTablaAuxLibros();
            mostrarTablaAuxPrestamos();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void EliminarPrestamos(int idp) {

        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();
        try {

            String queryep = "DELETE FROM prestamo WHERE id_prestamo=" + idp + ";";
            con.con.createStatement().executeUpdate(queryep);
        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void mostrarPendientes() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'pendiente';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());

            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void mostrarTiempoexcedido() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'tiempo excedido';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());

            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();
    }

    private void mostrarUltimodia() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'ultimo dia de entrega';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());

            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void mostrar_pendientes_timepoexcedido() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'pendiente' or p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'tiempo excedido';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());
            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void mostrar_pendiente_ultimoday() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'pendiente' or p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'ultimo dia de entrega';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());

            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void mostrar_ultimoday_tiempoexcedido() {
        Logic.conexion con = new Logic.conexion();
        con.ConectarBasedeDatos();

        try {
            String query1 = "call status();";
            PreparedStatement pstmt1 = con.con.prepareStatement(query1);
            ResultSet rs1 = pstmt1.executeQuery();

            String query = "select p.id_prestamo, a.nombre, a.apellido_paterno, a.apellido_materno, l.nombre, p.docente, p.fecha_salida, p.fecha_devolucion, p.estado from prestamo p, alumno a, libro l where p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'ultimo dia de entrega' or p.matricula = a.matricula and p.id_libro = l.id_libro and estado = 'tiempo excedido';";
            PreparedStatement pstmt = con.con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            model = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            model.setColumnIdentifiers(new Object[]{"Id_prestamo", "Nombre del alumno", "Apelido paterno", "Apelido materno", "Libro", "Docente", "Fecha de salida", "Fecha de devolucion", "Estado"});
            tblPrestamos.setModel(model);
            tblPrestamos.setDefaultRenderer(Object.class,
                    new Logic.Prestamos_Render());

            CustomsizeTablaPrestamo();

        } catch (SQLException e) {
            System.out.println(e);
        }
        con.DesconectarBasedeDatos();

    }

    private void actualizarBusqueda() {

        txtBusquedaPrestamos.getDocument().addDocumentListener(new DocumentListener() {
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
                String search = txtBusquedaPrestamos.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sorter
                        = new TableRowSorter<>(model);
                tblPrestamos.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
            }
        }
        );
    }

    private void placeHolder() {
        TextPrompt ph = new TextPrompt(" Buscar", txtBusquedaPrestamos);
    }

    private void actualizarBusquedalibro() {
        txtBusquedalibro.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent delibro) {
                filterTablelibro();
            }

            @Override
            public void removeUpdate(DocumentEvent delibro) {
                filterTablelibro();
            }

            @Override
            public void changedUpdate(DocumentEvent delibro) {
                filterTablelibro();
            }

            public void filterTablelibro() {
                String searchlibro = txtBusquedalibro.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sorterlibro
                        = new TableRowSorter<>(modellibros);
                tblLibros.setRowSorter(sorterlibro);
                sorterlibro.setRowFilter(RowFilter.regexFilter("(?i)" + searchlibro));
            }
        }
        );
    }

    private void placeHolderlibro() {
        TextPrompt phlibro = new TextPrompt("Buscar", txtBusquedalibro);
    }

    private void actualizarBusquedaestudiante() {

        txtBusquedaestudiante.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent deestudiante) {
                filterTableestudiante();
            }

            @Override
            public void removeUpdate(DocumentEvent deestudiante) {
                filterTableestudiante();
            }

            @Override
            public void changedUpdate(DocumentEvent deestudiante) {
                filterTableestudiante();
            }

            public void filterTableestudiante() {
                String searchestudiante = txtBusquedaestudiante.getText().toUpperCase();
                TableRowSorter<DefaultTableModel> sorter
                        = new TableRowSorter<>(modelestudiante);
                tblAlumnosestudiante.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchestudiante));
            }
        }
        );
    }

    private void placeHolderestudiante() {
        TextPrompt phestudiante = new TextPrompt(" Buscar", txtBusquedaestudiante);
    }

    private void mostrarMenuDeOpciones() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem Prestamospopeditar = new JMenuItem("Editar");
        JMenuItem Prestamospopeliminar = new JMenuItem("Eliminar");
        JMenuItem Prestamospopplusinfo = new JMenuItem("Mas informacion");
        
        popupMenu.setPopupSize(130, 100);

        popupMenu.add(Prestamospopeditar);
        popupMenu.add(Prestamospopeliminar);
        popupMenu.add(Prestamospopplusinfo);
 
        tblPrestamos.setComponentPopupMenu(popupMenu);

        Prestamospopeditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aem) {
         try{
                if (tblPrestamos.getSelectedRow() != -1) {
                FrameCheck = "Editar";
                ideditar = (int) model.getValueAt(tblPrestamos.getSelectedRow(), 0);
//                prestamo_encabezado.setText("<html><h1>Edicion de prestamo</h1></html>");
RegistroPrestamos.setTitle("Edicion de prestamo");
                RegistroPrestamos.setLocationRelativeTo(null);
                limpiarRegistroPrestamo();
                getValuesbas();
                ta_info_lector.setText(info_lector);
                ta_info_libros.setText(info_libro);

                txtidlibro.setText("" + prestamos_ld_libros);
                txtMatricula.setText("" + prestamos_matricula);
                Date fecha_devolucion =(Date) model.getValueAt(tblPrestamos.getSelectedRow(), 7);
                jdt.setDate(fecha_devolucion);
                RegistroPrestamos.setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null, "Para editar un prestamos primero lo debes de seleccionar");
                        
                 }
                
                      } catch (Exception e) {
                    System.err.println("fallo en la edicion de prestamos: linea 1757+");
                }

            }
        });

        Prestamospopeliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aem) {
                try {
                    int prestamosideliminar = 0;
                    if (tblPrestamos.getSelectedRow() != -1) {
                        prestamosideliminar = (int) model.getValueAt(tblPrestamos.getSelectedRow(), 0);
                        JOptionPane.showMessageDialog(null, "El prestamo " + prestamosideliminar + " fue eliminado");
                        EliminarPrestamos(prestamosideliminar);
                        mostrarTablaPrestamos();

                    } else {
                        JOptionPane.showMessageDialog(null, "Para borrar un prestamos primero lo debes de seleccionar");
                    }
                } catch (Exception e) {
                    System.err.println("fallo en la eliminacion de prestamos: linea 1757+");
                }

            }
        });
        
       ///
       Prestamospopplusinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aem) {
                try {
                    String info_fechas="";
                    ideditar = (int) model.getValueAt(tblPrestamos.getSelectedRow(), 0);
                    if (tblPrestamos.getSelectedRow() != -1) {
                        Date fechasali = (Date) model.getValueAt(tblPrestamos.getSelectedRow(), 6);
                        Date fechadev = (Date) model.getValueAt(tblPrestamos.getSelectedRow(), 7);
                        String statF = (String) model.getValueAt(tblPrestamos.getSelectedRow(), 8);
                        
                        info_fechas="Fecha de salida: "+fechasali+"\nFecha de devolucion: "+fechadev+"\nEstado: "+statF+"";
                        
                        Plus_informacion.setLocationRelativeTo(null);
                       
                        limpiarRegistroPrestamo();
                        getValuesbas();

                        PlusInfo_ta1.setText(info_libro);
                        PlusInfo_ta2.setText(info_lector);
                        PlusInfo_ta3.setText(info_fechas);
                        
                        Plus_informacion.setVisible(true);
                        
                        
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Selecciona un prestamo");
                    }
                } catch (Exception e) {
                    System.err.println("fallo en mas inforamcion de prestamos: linea 2147+");
                }

            }
        });

    }

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        FrameCheck = "Registro";

//        prestamo_encabezado.setText("<html><h1>Registro de prestamo</h1></html>");
RegistroPrestamos.setTitle("Registro de prestamo");
        RegistroPrestamos.setLocationRelativeTo(null);
        limpiarRegistroPrestamo();
        RegistroPrestamos.setVisible(true);

    }//GEN-LAST:event_btnRegistroActionPerformed

    private void tblPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrestamosMouseClicked
        //   System.out.println(tblPrestamos.getValueAt(tblPrestamos.getSelectedRow(), 0));
    }//GEN-LAST:event_tblPrestamosMouseClicked

    private void tblPrestamosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblPrestamosPropertyChange
    }//GEN-LAST:event_tblPrestamosPropertyChange

    private void eliminarElementoDeLaTabla() {
        Logic.conexion cone = new Logic.conexion();
        cone.ConectarBasedeDatos();
        try {
            String query = "sad";
            PreparedStatement pstmt = cone.con.prepareStatement(query);
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
        cone.DesconectarBasedeDatos();
    }

    private void txtBusquedaPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaPrestamosActionPerformed

    }//GEN-LAST:event_txtBusquedaPrestamosActionPerformed

    private void txtBusquedaPrestamosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaPrestamosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaPrestamosKeyTyped

    private void txtBusquedaPrestamosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaPrestamosKeyPressed

    }//GEN-LAST:event_txtBusquedaPrestamosKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cbx_all.setSelected(true);
        cbx_pendientes.setSelected(false);
        cbx_tex.setSelected(false);
        cbx_ude.setSelected(false);

        mostrarTablaPrestamos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        Menu regresar = new Menu();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void lbl_encabezado_prestamosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_encabezado_prestamosMousePressed
        x = evt.getX();
        y = evt.getY();
        lbl_encabezado_prestamos.setCursor(new Cursor(MOVE_CURSOR));

    }//GEN-LAST:event_lbl_encabezado_prestamosMousePressed

    private void lbl_encabezado_prestamosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_encabezado_prestamosMouseDragged
        this.setLocation(evt.getXOnScreen() - (x + 20), evt.getYOnScreen() - y);

    }//GEN-LAST:event_lbl_encabezado_prestamosMouseDragged

    private void btn_filtroprestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtroprestamosActionPerformed
        Point fromFiltroButtonPosition = btn_filtroprestamos.getLocationOnScreen();
        int xpfb = (int) fromFiltroButtonPosition.getX();
        int ypfb = (int) fromFiltroButtonPosition.getY() + 50;
        Point pointForFiltroFrame = new Point(xpfb, ypfb);
        FiltroPrestamos.setAlwaysOnTop(true);
        FiltroPrestamos.setVisible(true);
        FiltroPrestamos.setLocation(pointForFiltroFrame);
        //FiltroPrestamos.setLocationRelativeTo(null);
        btn_filtroprestamos.setEnabled(false);

    }//GEN-LAST:event_btn_filtroprestamosActionPerformed

    private void cbx_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_allMouseClicked
        if (cbx_all.isSelected() == true) {
            cbx_pendientes.setSelected(false);
            cbx_tex.setSelected(false);
            cbx_ude.setSelected(false);
            this.mostrarTablaPrestamos();
        }
    }//GEN-LAST:event_cbx_allMouseClicked

    private void cbx_pendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_pendientesMouseClicked
        try {
            if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                cbx_all.setSelected(false);
                this.mostrarPendientes();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                cbx_all.setSelected(true);
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == false) {
                this.mostrar_pendientes_timepoexcedido();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == true) {
                this.mostrar_pendiente_ultimoday();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == true && cbx_ude.isSelected() == false) {
                this.mostrarTiempoexcedido();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrar_ultimoday_tiempoexcedido();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false && cbx_ude.isSelected() == true) {
                this.mostrarUltimodia();
            } else {
                System.out.println("Error Menu_prestamos//pendientes//cbx IF");
            }

        } catch (Exception e) {
            System.out.println("Error Menu_prestamos//cbx/pendientes");

        }
    }//GEN-LAST:event_cbx_pendientesMouseClicked

    private void cbx_texMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_texMouseClicked
        try {
            if (cbx_tex.isSelected() == true && cbx_pendientes.isSelected() == false && cbx_ude.isSelected() == false) {
                cbx_all.setSelected(false);
                this.mostrarTiempoexcedido();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                cbx_all.setSelected(true);
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == false) {
                this.mostrar_pendientes_timepoexcedido();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                this.mostrarPendientes();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrar_ultimoday_tiempoexcedido();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false && cbx_ude.isSelected() == true) {
                this.mostrarUltimodia();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == true) {
                this.mostrar_pendiente_ultimoday();
            } else {
                System.out.println("Error Menu_prestamos//cbx/tex IF");
            }
        } catch (Exception e) {
            System.out.println("Error Menu_prestamos//cbx/tex");

        }
    }//GEN-LAST:event_cbx_texMouseClicked

    private void cbx_udeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_udeMouseClicked
        try {
            if (cbx_ude.isSelected() == true && cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false) {
                cbx_all.setSelected(false);
                this.mostrarUltimodia();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                cbx_all.setSelected(true);
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrarTablaPrestamos();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == true && cbx_ude.isSelected() == false) {
                this.mostrar_pendientes_timepoexcedido();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == false) {
                this.mostrarPendientes();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == true && cbx_ude.isSelected() == false) {
                this.mostrarTiempoexcedido();
            } else if (cbx_pendientes.isSelected() == false && cbx_tex.isSelected() == true && cbx_ude.isSelected() == true) {
                this.mostrar_ultimoday_tiempoexcedido();
            } else if (cbx_pendientes.isSelected() == true && cbx_tex.isSelected() == false && cbx_ude.isSelected() == true) {
                this.mostrar_pendiente_ultimoday();
            } else {
                System.err.println("Error Menu_prestamos //cbx/last IF");
            }
        } catch (Exception e) {
            System.out.println("Error Menu_prestamos//cbx/ude");

        }
    }//GEN-LAST:event_cbx_udeMouseClicked

    private void btn_aceptar_fitroestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_fitroestadoActionPerformed
        btn_filtroprestamos.setEnabled(true);
        FiltroPrestamos.dispose();
    }//GEN-LAST:event_btn_aceptar_fitroestadoActionPerformed

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed

        mostrarTablaLibros();
        Seleccionar_libro.setLocationRelativeTo(null);
        Seleccionar_libro.setAlwaysOnTop(true);
        Seleccionar_libro.setVisible(true);

        placeHolderlibro();
        actualizarBusquedalibro();

    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    private void btnBuscarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnoActionPerformed
        mostrarTablaAlumnosestudiante();
        Seleccionar_estudiante.setLocationRelativeTo(null);
        Seleccionar_estudiante.setAlwaysOnTop(true);
        Seleccionar_estudiante.setVisible(true);

        placeHolderestudiante();
        actualizarBusquedaestudiante();
    }//GEN-LAST:event_btnBuscarAlumnoActionPerformed

    private void btn_aceptar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptar_prestamoActionPerformed

        try {
            if (FrameCheck.equals("Registro") == true) {
                if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() != null) {
                    String matricula = txtMatricula.getText();
                    int id_libro = Integer.parseInt(txtidlibro.getText());
                    String docente = mpodn.lbl_menu_nombre.getText();
                    String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
                    String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
                    String año = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
                    String fecha_devolucion = año + "-" + mes + "-" + dia;
                    Logic.conexion con = new Logic.conexion();
                    con.ConectarBasedeDatos();

                    Statement statement = con.sentencia;
                    try {
                        statement.executeUpdate("insert into prestamo (matricula,id_libro,Docente,fecha_salida,fecha_devolucion,estado ) values ('" + matricula + "'," + id_libro + ",'" + docente + "',CURDATE(),'" + fecha_devolucion + "','---');");
                        JOptionPane.showMessageDialog(null, "Prestamo añadido con exito");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo añadir el prestamo");
                        System.out.println(ex);
                    }
                    mostrarTablaPrestamos();
                    cbx_all.setSelected(true);
                    cbx_pendientes.setSelected(false);
                    cbx_tex.setSelected(false);
                    cbx_ude.setSelected(false);

                    RegistroPrestamos.dispose();

                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Lector\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Lector\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Lector", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Lector", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema, revisa que los datos que ingresaste sean los correctos", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }
            //INICIO DE EDITAR
            if (FrameCheck.equals("Editar") == true) {
                if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() != null) {
                    String matricula = txtMatricula.getText();
                    int id_libro = Integer.parseInt(txtidlibro.getText());
                    String docente = mpodn.lbl_menu_nombre.getText();
                    String dia = Integer.toString(jdt.getCalendar().get(Calendar.DAY_OF_MONTH));
                    String mes = Integer.toString(jdt.getCalendar().get(Calendar.MONTH) + 1);
                    String año = Integer.toString(jdt.getCalendar().get(Calendar.YEAR));
                    String fecha_devolucion = año + "-" + mes + "-" + dia;

                    Logic.conexion con = new Logic.conexion();
                    con.ConectarBasedeDatos();

                    Statement statement = con.sentencia;
                    try {
                        statement.executeUpdate("UPDATE prestamo SET matricula='" + matricula + "',id_libro = '" + id_libro + "',Docente = '" + docente + "',fecha_devolucion ='" + fecha_devolucion + "' WHERE id_prestamo=" + ideditar + ";");
                        JOptionPane.showMessageDialog(null, "Prestamo editado con exito");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo editar el prestamo");
                        System.out.println(ex);
                    }
                    mostrarTablaPrestamos();
                    cbx_all.setSelected(true);
                    cbx_pendientes.setSelected(false);
                    cbx_tex.setSelected(false);
                    cbx_ude.setSelected(false);

                    RegistroPrestamos.dispose();

                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Lector\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Lector\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Lector", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == false && ta_info_lector.getText().equals(info_lectorDefault) == true && jdt.getDate() != null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Lector", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else if (ta_info_libros.getText().equals(info_libroDefault) == true && ta_info_lector.getText().equals(info_lectorDefault) == false && jdt.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "Faltan los siguientes datos:\n-Libro\n-Fecha de devolucion", "Mensaje", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un problema, revisa que los datos que ingresaste sean los correctos", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema, revisa que los datos que ingresaste sean los correctos...", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btn_aceptar_prestamoActionPerformed

    private void btn_cancelar_prestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar_prestamoActionPerformed
        RegistroPrestamos.dispose();
    }//GEN-LAST:event_btn_cancelar_prestamoActionPerformed

    private void txtBusquedalibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedalibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedalibroActionPerformed

    private void txtBusquedalibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedalibroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedalibroKeyTyped

    private void txtBusquedalibroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedalibroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedalibroKeyPressed

    private void btnRegistrolibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrolibroActionPerformed
        if (tblLibros.getSelectedRow() != -1) {
            id_libro = (int) modellibros.getValueAt(tblLibros.getSelectedRow(), 0);
            nombrelibro = (String) modellibros.getValueAt(tblLibros.getSelectedRow(), 1);
            tipo = (String) modellibros.getValueAt(tblLibros.getSelectedRow(), 2);
            subgenero = (String) modellibros.getValueAt(tblLibros.getSelectedRow(), 3);
            num_paginas = (int) modellibros.getValueAt(tblLibros.getSelectedRow(), 4);
            info_libro = "Informacion del libro:\nNombre: " + getNombrelibro() + " \nTipo: " + getTipo() + " \nSubgenero: " + getSubgenero() + " \nNumero de paginas: " + getNum_paginas();
            ta_info_libros.setText(info_libro);

            prestamos_ld_libros = id_libro;
            txtidlibro.setText("" + prestamos_ld_libros);

            Seleccionar_libro.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un libro");
        }


    }//GEN-LAST:event_btnRegistrolibroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Seleccionar_libro.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
        //    System.out.println(tblLibros.getValueAt(tblLibros.getSelectedRow(), 0));
    }//GEN-LAST:event_tblLibrosMouseClicked

    private void tblLibrosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblLibrosPropertyChange
        if (tblLibros.isEditing()) {
            // System.out.println("changing");

        }
    }//GEN-LAST:event_tblLibrosPropertyChange

    private void txtBusquedaestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaestudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaestudianteActionPerformed

    private void txtBusquedaestudianteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaestudianteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaestudianteKeyTyped

    private void txtBusquedaestudianteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaestudianteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaestudianteKeyPressed

    private void btnRegistroestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroestudianteActionPerformed

        if (tblAlumnosestudiante.getSelectedRow() != -1) {
            matriculaestudiante = (String) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 0);
            nombreestudiante = (String) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 1);
            apellidoPestudiante = (String) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 2);
            apellidoMestudiante = (String) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 3);
            gradoestudiante = (int) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 4);
            grupoestudiante = (String) modelestudiante.getValueAt(tblAlumnosestudiante.getSelectedRow(), 5);

            info_lector = "Informacion del lector:\nNombre: " + getNombreestudiante() + "\nApellido paterno: " + getApellidoPestudiante() + " \nApellido materno: " + getApellidoMestudiante() + " \nGrado: " + getGradoestudiante() + " \nGrupo: " + getGrupoestudiante();
            ta_info_lector.setText(info_lector);

            prestamos_matricula = matriculaestudiante;
            txtMatricula.setText("" + prestamos_matricula);

            Seleccionar_estudiante.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un estudiante");
        }

    }//GEN-LAST:event_btnRegistroestudianteActionPerformed

    private void btnCancelarestudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarestudianteActionPerformed
        Seleccionar_estudiante.dispose();
    }//GEN-LAST:event_btnCancelarestudianteActionPerformed

    private void tblAlumnosestudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosestudianteMouseClicked
        //    System.out.println(tblLibros.getValueAt(tblLibros.getSelectedRow(), 0));
    }//GEN-LAST:event_tblAlumnosestudianteMouseClicked

    private void tblAlumnosestudiantePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblAlumnosestudiantePropertyChange
        if (tblAlumnosestudiante.isEditing()) {
            // System.out.println("changing");

        }
    }//GEN-LAST:event_tblAlumnosestudiantePropertyChange

    private void lbl_encabezado_prestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_encabezado_prestamosMouseClicked
        if (tblPrestamos.getSelectedRow() != -1) {
            ideditar = (int) model.getValueAt(tblPrestamos.getSelectedRow(), 0);
            FrameAuxiliar.setVisible(true);
            getValuesbas();
            JOptionPane.showMessageDialog(null, ideditar + "  " + model.getValueAt(tblPrestamos.getSelectedRow(), 2) + "\nrowPrestamos : " + rowPrestamos + "\nidlibrovalue : " + id_librogv + "\nmatricula value : " + matriculagv + "\ninfo libro= " + info_libro);
        } else {
            JOptionPane.showMessageDialog(null, "nada nada nada nada nada nada");

        }
    }//GEN-LAST:event_lbl_encabezado_prestamosMouseClicked

    private void lbleraseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbleraseMouseClicked
        txtBusquedaPrestamos.setText("");
    }//GEN-LAST:event_lbleraseMouseClicked

    private void lbl_encabezado_prestamosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_encabezado_prestamosMouseReleased
        lbl_encabezado_prestamos.setCursor(new Cursor(DEFAULT_CURSOR));

    }//GEN-LAST:event_lbl_encabezado_prestamosMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Plus_informacion.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
//comment

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
            java.util.logging.Logger.getLogger(Menu_prestamos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_prestamos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_prestamos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_prestamos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_prestamos().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuxiliarPane;
    private javax.swing.JFrame FiltroPrestamos;
    private javax.swing.JFrame FrameAuxiliar;
    private javax.swing.JPanel LEFT_book;
    private javax.swing.JPanel LEFT_reader;
    private javax.swing.JPanel OpcionesInferiorBL;
    private javax.swing.JPanel OpcionesInferiorBL1;
    private javax.swing.JPanel PanelAuxBottomP;
    private javax.swing.JPanel PanelAuxCenterP;
    private javax.swing.JPanel PanelAuxLeftP;
    private javax.swing.JPanel PanelAuxRightP;
    private javax.swing.JPanel PanelPrestamosCenter;
    private javax.swing.JPanel PanelPrestamosLeft;
    private javax.swing.JPanel PanelPrestamosRight;
    private javax.swing.JPanel PanelPrestamosTOP;
    private javax.swing.JPanel Panel_cerrarES;
    private javax.swing.JPanel Panel_fecha;
    private javax.swing.JPanel Panel_inferiorBL;
    private javax.swing.JPanel Panel_inferiorES;
    private javax.swing.JPanel Panel_lector;
    private javax.swing.JPanel Panel_libro;
    private javax.swing.JPanel Panel_maxES;
    private javax.swing.JPanel Panel_menumpES;
    private javax.swing.JPanel Panel_minES;
    private javax.swing.JPanel Panel_prestamos_principal;
    private javax.swing.JPanel Panel_prestamos_principal1;
    private javax.swing.JPanel Panel_searchBL;
    private javax.swing.JPanel Panel_searchBL1;
    private javax.swing.JPanel Panelnumerosstatus;
    public static javax.swing.JTextArea PlusInfo_ta1;
    public static javax.swing.JTextArea PlusInfo_ta2;
    public static javax.swing.JTextArea PlusInfo_ta3;
    private javax.swing.JFrame Plus_informacion;
    private javax.swing.JPanel Prestamo_filtro;
    private javax.swing.JPanel RIGHT_book;
    private javax.swing.JPanel RIGHT_reader;
    private javax.swing.JFrame RegistroPrestamos;
    private javax.swing.JFrame Seleccionar_estudiante;
    private javax.swing.JFrame Seleccionar_libro;
    private javax.swing.JPanel Statusall;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel bottom1;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnCancelarestudiante;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnRegistroestudiante;
    private javax.swing.JButton btnRegistrolibro;
    private javax.swing.JButton btn_aceptar_fitroestado;
    private javax.swing.JButton btn_aceptar_prestamo;
    private javax.swing.JButton btn_cancelar_prestamo;
    public static javax.swing.JButton btn_filtroprestamos;
    private javax.swing.JCheckBox cbx_all;
    private javax.swing.JCheckBox cbx_pendientes;
    private javax.swing.JCheckBox cbx_tex;
    private javax.swing.JCheckBox cbx_ude;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JPanel header2;
    private javax.swing.JPanel headerES;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JLabel lblPrestamosTotales;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_encabezado_prestamos;
    public static javax.swing.JLabel lbl_numero_pendientes;
    public static javax.swing.JLabel lbl_numero_tex;
    public static javax.swing.JLabel lbl_numero_ude;
    private javax.swing.JLabel lblerase;
    private javax.swing.JPanel paneloptionsBL;
    private javax.swing.JPanel paneloptionsBL1;
    private javax.swing.JPanel plusinfo1;
    private javax.swing.JPanel plusinfo2;
    private javax.swing.JPanel plusinfo3;
    public static javax.swing.JTextArea ta_info_lector;
    public static javax.swing.JTextArea ta_info_libros;
    public static javax.swing.JScrollPane ta_info_librosscroll;
    public static javax.swing.JTable tblAlumnosestudiante;
    public static javax.swing.JTable tblAuxAlumnos;
    public static javax.swing.JTable tblAuxLibros;
    public static javax.swing.JTable tblAuxPrestamos;
    public static javax.swing.JTable tblLibros;
    public static javax.swing.JTable tblPrestamos;
    private javax.swing.JTextField txtBusquedaPrestamos;
    private javax.swing.JTextField txtBusquedaestudiante;
    private javax.swing.JTextField txtBusquedalibro;
    public static javax.swing.JTextField txtMatricula;
    public static javax.swing.JTextField txtidlibro;
    // End of variables declaration//GEN-END:variables
}
