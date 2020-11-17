/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package origen;

import Modelo.Pedidos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 *
 * @author GATEWAY1-
 */
public class Importarexcel extends javax.swing.JFrame {

    JFileChooser filechooser = new JFileChooser();
    JFileChooser filechooser2 = new JFileChooser();
    Connection sqlite;
    String rutaaccess = "";
    int programa = 0;

    /**
     * Creates new form EtiqAndrea
     */
    public Importarexcel() {
        super("Conversor de Archivo de andrea a Excel");
        initComponents();
        this.setLocationRelativeTo(null);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Excel", "xlsx");
        filechooser.setFileFilter(filtro);
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Base de datos Access", "accdb");
        filechooser2.setFileFilter(filtro2);
        cargabds();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        archivo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        archivo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButton1.setText("read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        archivo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        archivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        archivo1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        archivo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel1.setText("Base de datos de access:");

        jLabel2.setText("Archivo Excel seleccionado");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/1491313940-repeat_82991.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(archivo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jButton1)
                                .addGap(43, 43, 43)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(archivo, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton2)))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(archivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {

            File file = filechooser.getSelectedFile();
            archivo.setText(file.getAbsolutePath());
            FileReader fr = null;
            BufferedReader br = null;
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                // Leemos el libro de trabajo de Excel formato OOXML
                FileInputStream fac = new FileInputStream(new File(file.getAbsolutePath()));

                Workbook workbook = new XSSFWorkbook(fac);
                //System.out.println("numero de hojas "+workbook.getNumberOfSheets());
                int hojas = workbook.getNumberOfSheets();
                Sheet hoja = workbook.getSheetAt(hojas - 1);
                ArrayList<String> data = new ArrayList<>();
//Recorremos las filas del documento
                Iterator rows = hoja.rowIterator();
                DataFormatter formatter = new DataFormatter();
                int y = 0;
                boolean band = true;
                ArrayList<Pedidos> arrped = new ArrayList<>();
                while (rows.hasNext() && band) {
                    Row row = (Row) rows.next();
                    Iterator cells = row.cellIterator();
//                    System.out.println("");
                    Pedidos p = new Pedidos();
                    int i = 0;
                    if (y != 0 && y != 1 && y != 2 && y != 4 && y != 5 && y != 6) {
                        while (cells.hasNext()) {
                            Cell cell = (Cell) cells.next();
                            String contenidoCelda = formatter.formatCellValue(cell);
                            data.add(contenidoCelda);
                            if (i == 0 && contenidoCelda.equals("")) {//finalizar ciclos de lectura
                                cells.remove();
                                band = false;
                                break;
                            }
                            if (i != 0) {// todo diferente a la primer columna del archivo
                                leerdatos(i, y, p, contenidoCelda);//metodo para meter todo en un objeto
                                //System.out.print(i + "-" + contenidoCelda + "/ ");
                            }
                            i++;
                        }
                        if(p.getPrograma()!=0){
                        arrped.add(p);
                        }
                    }
                    System.out.println(p.getTotalpares());

                    y++;
                }
                //analizaarray(arrped);
                Connection caccess;
                conexionaccess conac = new conexionaccess();
                caccess = conac.getConnection(rutaaccess);
                conac.insertardatos(caccess, arrped);

//                for (int i = 0; i < arrped.size(); i++) {
//                    System.out.println(arrped.get(i).getPrograma()+" "+arrped.get(i).getTotalpares());
//                }
                // titulos de columnas
                JOptionPane.showMessageDialog(null, "Proceso Completo!", "Top Suelas", JOptionPane.INFORMATION_MESSAGE);
                programa = 0;
            } catch (Exception ex) {
                Logger.getLogger(Importarexcel.class.getName()).log(Level.SEVERE, null, ex);
                programa = 0;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        actualizabds();
    }//GEN-LAST:event_jLabel3MousePressed

//    private void analizaarray(ArrayList<Pedidos> arr){
//        for(int i =0;i<arr.size();i++){
//            if(arr.get(i).getPrograma()==0 && arr.get(i).getModelo().equals("NULL")){
//            arr.remove(i);
//            }
//        }
//    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //formateafecha("10/5/20");
        Connection caccess;
        conexionaccess conac = new conexionaccess();
        caccess = conac.getConnection(rutaaccess);
        conac.prueba(caccess);
    }//GEN-LAST:event_jButton2ActionPerformed
    private String formateafecha(String fecha) {
        String dia = "", mes = "", y;
        int cont = 0;
        String dato = "";
        for (int i = 0; i < fecha.length(); i++) {//FOR DE LONGITUD DE LA CADENA
            if (fecha.charAt(i) == '/' || i == fecha.length()) {//SI ENCUENTRA EK CARACTER USARA LO QUE HAY EN LA VARIABLE DATO
                System.out.println(dato.length());
                if (cont == 0) {//ALMACENAR EN VARIABLE MES
                    if (dato.length() == 2) {
                        mes += dato + "/";
                    } else {
                        mes += "0" + dato + "/";
                    }
                }
                if (cont == 1) {//DIA
                    if (dato.length() == 2) {
                        dia += dato + "/";
                    } else {
                        dia += "0" + dato + "/";
                    }
                }
                cont++;
                dato = "";
            } else {
                dato += fecha.charAt(i);
            }
        }
        y = "20" + dato;//AÑO
        //System.out.println(dia+mes+y);
        return mes + dia + y;//SE REGRESA DE ESTA FORMA PORQUE ASI LO NECESITA ACCESS
    }

    private void cargabds() {
        conexionaccess a = new conexionaccess();
        Connection c;
        try {
//        c=a.getConnection();
//        a.insertardato(c);
//        a.Desconexion();
            File f = new File("acess.db");
            if (!f.exists()) {
                FileWriter fichero = null;
                fichero = new FileWriter(f);
                PrintWriter pw = new PrintWriter(fichero);
                fichero.close();
                conexionlite con = new conexionlite();
                sqlite = con.getconexionC(f.getAbsolutePath());
                int returnval = filechooser2.showOpenDialog(this);
                if (returnval == JFileChooser.APPROVE_OPTION) {
                    File file = filechooser2.getSelectedFile();
                    String ruta = file.getAbsolutePath();
                    archivo1.setText(ruta);
                    con.setbd(sqlite, ruta);
                    rutaaccess = ruta;
                }
            } else {
                conexionlite con = new conexionlite();
                sqlite = con.getconexionC(f.getAbsolutePath());
                String resp = con.getbd(sqlite);
                if (resp.equals("")) {
                    JOptionPane.showMessageDialog(null, "CONEXION ERRONEA");
                } else {
//                    conexionaccess cona = new conexionaccess();
//                    Connection acdb = cona.getConnection();
//                    cona.insertardato(acdb);
                    rutaaccess = resp;
                    archivo1.setText(resp);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void actualizabds() {
        conexionaccess a = new conexionaccess();
        Connection c;
        try {
            int returnval = filechooser2.showOpenDialog(this);
            if (returnval == JFileChooser.APPROVE_OPTION) {
                File file = filechooser2.getSelectedFile();
                String ruta = file.getAbsolutePath();
                File f = new File("acess.db");
                conexionlite con = new conexionlite();
                sqlite = con.getconexionC(f.getAbsolutePath());
                con.actualizaces(sqlite, ruta);
                rutaaccess = f.getAbsolutePath();
                archivo1.setText(ruta);
                JOptionPane.showMessageDialog(null, "ACTUALIZACION COMPLETA");
            }
//        c=a.getConnection();
//        a.insertardato(c);
//        a.Desconexion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void Nuevosregistros(ArrayList<Pedidos> arr) {
        conexionaccess c = new conexionaccess();
        Connection conac = c.getConnection(rutaaccess);
        if (c.insertardatos(conac, arr)) {
            JOptionPane.showMessageDialog(null, "IMPORTACION COMPLETA");
        } else {
            JOptionPane.showMessageDialog(null, "ERROR AL IMPORTAR, VERIFIQUE EL ARCHIVO");
        }
    }
//CADA COLUMNA QUE ENCUENTRE ES UN NUMERO Y ESTA IDENTIFICADO EN EL SWITCH
    private void leerdatos(int i, int y, Pedidos p, String contenidoCelda) {
        try {
            if (y == 3) {//
                if (i == 5) {
                    p.setPrograma(Integer.parseInt(contenidoCelda));
                    programa = Integer.parseInt(contenidoCelda);//GUARDAR PROGRAMA PARA LAS DEMAS LINEAS
                }
            } else {
                switch (i) {//pasar dato de i que son columnas y objeto pedidos
                    case 1:
                        p.setLote(Integer.parseInt(contenidoCelda));
                        break;
                    case 2:
                        p.setPedido(Integer.parseInt(contenidoCelda));
                        break;
                    case 3:
                        p.setCliente(contenidoCelda);
                        break;
                    case 4:
                        p.setAgente(contenidoCelda);
                        break;
                    case 5:
                        p.setModelo(contenidoCelda);
                        break;
                    case 6:
                        p.setColor(contenidoCelda);
                        break;
                    case 7://pares
                        p.setP15((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 8:
                        p.setP16((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 9:
                        p.setP17((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 10:
                        p.setP18((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 11:
                        p.setP19((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 12:
                        p.setP20((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 13:
                        p.setP21((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 14:
                        p.setP22((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 15:
                        p.setP23((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 16:
                        p.setP24((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 17:
                        p.setP25((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 18:
                        p.setP26((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 19:
                        p.setP27((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 20:
                        p.setP28((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 21:
                        p.setP29((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 22:
                        p.setP30((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 23:
                        p.setP31((contenidoCelda.equals("")) ? 0 : Integer.parseInt(contenidoCelda));
                        break;
                    case 24:
                        sumapares(p);
                        p.setPrograma(programa);
                        break;
                    case 25:
                        //SE HACE UN FORMATEO DE FECHA
                        p.setFecharecepcion(formateafecha(contenidoCelda));
                        break;
                    case 26:
                        p.setFechaentrega(formateafecha(contenidoCelda));
                        break;
                    case 27:
                        p.setObservaciones(contenidoCelda);
                        break;
                    case 28:
                        p.setOperacion(contenidoCelda);
                        break;
                    case 29:
                        p.setHorma(contenidoCelda);
                        break;
                    case 30:
                        p.setOrdencompra(contenidoCelda);
                        break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Top Suelas", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void sumapares(Pedidos p) {
        int suma = p.getP15() + p.getP16() + p.getP17() + p.getP18() + p.getP19() + p.getP20() + p.getP21() + p.getP22() + p.getP23()
                + p.getP24() + p.getP25() + p.getP26() + p.getP27() + p.getP28() + p.getP29() + p.getP30();
        p.setTotalpares(suma);
    }

    private String cadena(String linea, int index) {
        String cadenas = "";
        for (int i = index + 1; i < linea.length(); i++) {

            if (linea.charAt(i) == ' ' || linea.charAt(i) == '.' || (linea.charAt(i) == '/') || (linea.charAt(i) == '-')) {
                cadenas += linea.charAt(i);
            } else if (verificaexpresion(linea.charAt(i) + "")) {
                i = linea.length();
            } else {
                cadenas += linea.charAt(i);
            }
        }
//        System.out.println(cadenas);
        return cadenas;
    }

    public boolean verificaexpresion(String cad) {
        boolean resp = false;
        String patt = "[0-9A-Za-z/-]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (!match.matches()) {
            resp = true;
        }
        return resp;
    }

    public boolean verificanumeros(String cad) {
        boolean resp = false;
        String patt = "[0-9]*";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (!match.matches()) {
            resp = true;
        }
        return resp;
    }

    public void resp() {
        Map<String, Object[]> datos = new TreeMap<String, Object[]>();
//                int contador =0;
//                fila = pagina.createRow(0);
//                while ((linea = br.readLine()) != null) {
//                    System.out.println(linea);
//                    if(contador==2){
//                        Cell celda = fila.createCell(contador);
//                        
//                    }
//                }
    }

    /**
     *
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
            java.util.logging.Logger.getLogger(Importarexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Importarexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Importarexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Importarexcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Importarexcel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel archivo;
    private javax.swing.JLabel archivo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
