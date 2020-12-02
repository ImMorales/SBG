package Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexion {

    private static String usuario_bd = "root";
    private static String password_bd = "papibowser1999";
    private static String bd = "SiBi";

    public Connection con;
    public Statement sentencia;
    public ResultSet resultado;

    public void ConectarBasedeDatos() {
        try {
            final String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/SiBi";
            con = (Connection) DriverManager.getConnection(url_bd, usuario_bd, password_bd);
            sentencia = (Statement) con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void DesconectarBasedeDatos() {
        try {
            if (con != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static String getUsuario_bd() {
        return usuario_bd;
    }

    public static String getPassword_bd() {
        return password_bd;
    }

    public static String getBd() {
        return bd;
    }

}
