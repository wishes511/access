/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etiquetaandrea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author GATEWAY1-
 */
public class EtiqAndrea extends javax.swing.JFrame {

    JFileChooser filechooser = new JFileChooser();

    /**
     * Creates new form EtiqAndrea
     */
    public EtiqAndrea() {
        super("Conversor de Archivo de andrea a Excel");
        initComponents();
        this.setLocationRelativeTo(null);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Zebra Label", "ZPL");
        filechooser.setFileFilter(filtro);
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButton1.setText("Seleccione archivo ZPL (Archivo descargado de andrea)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        archivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        archivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Clic para 2da. Version");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(archivo, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(archivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            archivo.setText(file.getAbsolutePath());
            File archivos = new File("etiq.xls");
            FileReader fr = null;
            BufferedReader br = null;
            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                // Creamos el libro de trabajo de Excel formato OOXML
                Workbook workbook = new HSSFWorkbook();
                Sheet s = workbook.createSheet("Hoja");
                // titulos de columnas
                String[] titulo = {"CODIGO", "COD", "LOTE", "COLOR", "COLOR2", "MER", "BRA", "USA", "MEX", "MER1", "BRA1", "USA1", "MEX1"};
                Row row = s.createRow(0);
                for (int i = 0; i < titulo.length; i++) {
                    Cell c = row.createCell(i);
                    c.setCellValue(titulo[i]);
                }
//                 cuerpo del archivo
                int contador = 1;
                int continterno = 0;
                String linea;
                boolean flag = false;
                boolean flag2 = false;
                ArrayList<String> arr = new ArrayList<>();//lista donde se guardara el cuerpo de informacion del archivo
                //Obetener solamente los datos que se necesitan
                while ((linea = br.readLine()) != null) {
                    String val = "";
                    String a = "";
                    if (linea.length() > 9) {// filtro para descartar las lineas innecesarias
                        for (int i = 0; i < linea.length(); i++) {// ciclo para identificar si hay algo usable en la linea
                            a += linea.charAt(i) + "";
                            if (a.equals("FO420") || a.equals("FO510") || a.equals("FO600") || a.equals("FO670") || a.equals("NOSE") || a.equals("COY") || a.equals("ISSTRNWARE") || a.equals("ILSTRNWARE")|| a.equals("FT")||a.equals("PQ0")) {
                                i = linea.length();
                            } else if (a.equals("BY3")) {
                                arr.add("BY3");
//                                row = s.createRow(contador);
                                contador++;
                                continterno = 0;
                                a = "";
                            } else if (verificaexpresion(a)) {
                                a = "";
                                flag = false;
                                flag2 = false;
                            } else if (linea.charAt(i) == ' ') {
                                a += " ";
                            } else if (a.equals("FD")) {// si encuentra un token FD tomara el siguiente valor
                                flag = true;
                                a = "";
                                val = cadena(linea, i);
                                i = linea.length();
                            } else if (flag) {
                                val += linea.charAt(i) + "";
                            } else if (a.equals("PQ") ) {
                                flag2 = true;
                                a = "";
                                val = cadena(linea, i);
                                val = (val.equals("NOSE") || val.equals("0001")) ? "" : val;
                                i = linea.length();
                            } else if (flag2) {
                                val += linea.charAt(i) + "";
                            }
                        }
                        if (!val.isEmpty()) {
                            arr.add(val);
                        }
//                        Cell c = row.createCell(continterno);
//                        c.setCellValue(val);
//                        continterno++;
                    }
                }
                int conta = 0;
                int lin = 1;
                //ciclo para imprimir datos guardados en la lista hacia el excel
                for (int i = 0; i < arr.size(); i++) {
                     System.out.println(arr.get(i) + "-" + i+" /"+conta);
                    if (conta == 14) {
                        System.out.println(arr.get(i) + "-" + i);
                        int aux = Integer.parseInt(arr.get(i));// obtener numero de etiquetas
                        for (int j = 0; j < aux; j++) {// imprimir numero de etiquetas
                            row = s.createRow(lin);
                            int contint = 0;
                            //impresion de celdas por numero de columna
                            for (int z = (i - conta) + 1; z < i; z++) {
                                Cell c = row.createCell(contint);
                                c.setCellValue(arr.get(z));
                                contint++;
                            }
                            lin++;
                        }
                        conta = 0;
                    } else {
                        conta++;
                    }
                }
                FileOutputStream out = new FileOutputStream(archivos);
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(null, "Proceso Completo!", "Athletic", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EtiqAndrea.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EtiqAndrea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        EtiqAndrea1 a = new EtiqAndrea1();
        a.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EtiqAndrea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtiqAndrea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtiqAndrea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtiqAndrea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EtiqAndrea().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel archivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}