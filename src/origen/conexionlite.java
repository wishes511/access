/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package origen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class conexionlite {

    Connection connect;

    public Connection getconexionC(String ruta) throws ClassNotFoundException, IOException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection("jdbc:sqlite:" + ruta);
        return connect;
    }

    public void setbd(Connection c, String ruta) {
        PreparedStatement st;
        try {
            String q;
            c.setAutoCommit(false);
            q = "CREATE TABLE Datos (\n"
                    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + " localizarbd STRING (0, 200) );";

            st = c.prepareStatement(q);
            st.executeUpdate();
            st = c.prepareStatement("insert into Datos(localizarbd) values('" + ruta + "')");
            st.executeUpdate();
            c.commit();
        } catch (Exception ex) {
            try {
                Logger.getLogger(conexionlite.class.getName()).log(Level.SEVERE, null, ex);
                c.rollback();
//                System.out.println("Algo esta mal en la bd \n" + ex.getMessage());
            } catch (SQLException ex1) {
                Logger.getLogger(conexionlite.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public String getbd(Connection c) {
        String resp = "";
        try {
            String query = "select localizarbd from Datos";
            Statement smt;
            ResultSet df;
            smt = c.createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                resp = df.getString("localizarbd");
            }
            df.close();
            smt.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionlite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
}
