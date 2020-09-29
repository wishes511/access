/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etiquetaandrea;

/**
 *
 * @author GATEWAY1-
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexionaccess {

    Connection ccn = null;
    Statement st = null;

    public conexionaccess() {
        
    }

    public Connection getConnection() {
        try {
            String rutafile = "C:\\af\\Database1.accdb";
            String Url = "jdbc:ucanaccess://" + rutafile;
            ccn = DriverManager.getConnection(Url);
            st = ccn.createStatement();
            System.out.println("listo");
        } catch (SQLException e) {
            Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "CONEXION ERRONEA " + e);
        }
        return ccn;
    }

    public void Desconexion() {
        try {
            ccn.close();
            //System.exit(0);
        } catch (SQLException ex) {
            Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertardato(Connection c) {
        try {
            c.setAutoCommit(false);
            PreparedStatement ps1 = c.prepareStatement("insert into user(nombre,contrasena) values('abcd','polaina')");
            ps1.executeUpdate();
            ps1.close();
            c.commit();
        } catch (Exception e) {
           
        }

    }

}
