/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package origen;

/**
 *
 * @author GATEWAY1-
 */
import Modelo.Pedidos;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexionaccess {

    Connection ccn = null;
    Statement st = null;

    public conexionaccess() {

    }

    public Connection getConnection(String ruta) {
        try {
            String rutafile = ruta;
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

    public void prueba(Connection c){
    try{
        c.setAutoCommit(false);
        String query="insert into prueba(fechas) values(#10/05/2020#)";
                PreparedStatement ps1 = c.prepareStatement(query);
                System.out.println(query);
                ps1.executeUpdate();
                ps1.close();
                c.commit();
    }catch(Exception e){
        try {
            c.rollback();
            Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException ex) {
            Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    public boolean insertardatos(Connection c, ArrayList<Pedidos> arr) {
        try {
            c.setAutoCommit(false);
            for (int i = 1; i < arr.size(); i++) {// RECORRER TODO EL ARRAY 
                int prog = arr.get(i).getPrograma();
                int lote = arr.get(i).getLote();
                int pedido = arr.get(i).getPedido();
                String agente=arr.get(i).getAgente();
                String cliente = arr.get(i).getAgente();
                String modelo = arr.get(i).getModelo();
                String color = arr.get(i).getColor();
                int p15 = arr.get(i).getP15();
                int p16 = arr.get(i).getP16();
                int p17 = arr.get(i).getP17();
                int p18 = arr.get(i).getP18();
                int p19 = arr.get(i).getP19();
                int p20 = arr.get(i).getP20();
                int p21 = arr.get(i).getP21();
                int p22 = arr.get(i).getP22();
                int p23 = arr.get(i).getP23();
                int p24 = arr.get(i).getP24();
                int p25 = arr.get(i).getP25();
                int p26 = arr.get(i).getP26();
                int p27 = arr.get(i).getP27();
                int p28 = arr.get(i).getP28();
                int p29 = arr.get(i).getP29();
                int p30 = arr.get(i).getP30();
                int p31 = arr.get(i).getP31();
                int pares = arr.get(i).getTotalpares();
                String fechar = arr.get(i).getFecharecepcion();
                String fechae = arr.get(i).getFechaentrega();
                String obs = arr.get(i).getObservaciones();
                String op = arr.get(i).getOperacion();
                String horma = arr.get(i).getHorma();
                String oc = arr.get(i).getOrdencompra();
                String query="insert into pedidos(programa,lote,pedido,cliente,agente,"//CONSULTA
                        + "modelo,color,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,totalpares,"
                        + "fecharecepcion,fechaentrega,observaciones,operacion,horma,ordencompra) values(" + prog + "," + lote + "," + pedido
                        + ",'" + cliente + "','"+agente+"','" + modelo + "','" + color + "'," + p15 + "," + p16 + "," + p17 + "," + p18 + "," + p19 + "," +
                        p20 + "," + p21 + "," + p22 + "," + p23+ "," + p24 + "," + p25 + "," + p26 + "," + p27 + "," + p28 + "," + p29 + "," +
                        p30 + "," + p31 + "," + pares + ",#" + fechar + "#,#" + fechae+ "#,'" + obs + "','" + op + "','" + horma + "','" + oc + "')";
                PreparedStatement ps1 = c.prepareStatement(query);
                System.out.println(query);
                ps1.executeUpdate();
                ps1.close();
            }
            c.commit();//AFIRMAR INSERCION DE DATOS
            return true;
        } catch (Exception e) {
            try {
                c.rollback();
                 Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, e);
            } catch (SQLException ex) {
                Logger.getLogger(conexionaccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

}
