/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import java.sql.*;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRPrintXmlLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class DataSR extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    public DataSR() {
        initComponents();
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("SR Data");
    }
    private Connection Con = new Koneksi().connect();
    private Statement stm;
    private void tampil(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new java.util.Locale("id"));
        String tanggal = sdf.format(txtTgl.getDate());
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Tanggal");
        tabel.addColumn("No SR");
        tabel.addColumn("Nama Toko");
        tabel.addColumn("Description");
        tabel.addColumn("Qty");
        //tabel.addColumn("Status");
        try {
            //join table database table srbaru & table lokasi
            
            String sql= "SELECT tgl,nomor_sr,nama_toko,deskripsi,jml FROM srbaru,lokasi WHERE srbaru.s_location = lokasi.s_location and srbaru.tgl LIKE '"+tanggal+"'";
            stm = (Statement) Con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Object[] o = new Object[5];
                o[0] = rs.getString("tgl");
                o[1] = rs.getString("nomor_sr");
                o[2] = rs.getString("nama_toko");
                o[3] = rs.getString("deskripsi");
                o[4] = rs.getString("jml");
                tabel.addRow(o);
            }
            tableSR.setModel(tabel);
        }
    
        catch (Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTgl = new com.toedter.calendar.JDateChooser();
        btnOk = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSR = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(201, 193, 176));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(79, 59, 56));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(229, 225, 216));
        jLabel3.setText("Data SR per Tanggal");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 20));

        txtTgl.setDateFormatString("yyyy/MM/dd");
        txtTgl.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        txtTgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTglKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTglKeyTyped(evt);
            }
        });
        jPanel2.add(txtTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 130, 20));

        btnOk.setBackground(new java.awt.Color(156, 111, 105));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel2.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 560, 80));

        jPanel3.setBackground(new java.awt.Color(79, 59, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "No SR", "Nama Toko", "Description", "Qty", "Status"
            }
        ));
        tableSR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSRMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSR);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 330));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 560, 340));

        jPanel4.setBackground(new java.awt.Color(79, 59, 56));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 225, 216));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Data SR");
        jPanel4.add(jLabel2);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 225, 216));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Click For Print");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 320, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_btnOkActionPerformed

    private void txtTglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTglKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTglKeyReleased

    private void txtTglKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTglKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtTglKeyTyped

    private void tableSRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSRMouseClicked
        // TODO add your handling code here:
        int cetak;
        if ((cetak = JOptionPane.showConfirmDialog(null,"Cetak SR?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
         InputStream streamLaporan = getClass().getResourceAsStream("/LAPORAN/sr_form.jasper");
         try{
         int i = tableSR.getSelectedRow();
                 if (i== -1) {
                return;
            }
            stm=(Statement)Con.createStatement();
            String id = (String) tableSR.getValueAt(i, 1);
            HashMap hash = new HashMap();
            hash.put("kode",id);
            JasperPrint Laporan = JasperFillManager.fillReport(streamLaporan, hash, Con);
            JasperViewer.viewReport(Laporan, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }finally{
            
            String st = "Diterima";
            try {
                stm = (Statement) Con.createStatement();
                int i = tableSR.getSelectedRow();
                 if (i== -1) {
                return;
                 }
                String id = (String) tableSR.getValueAt(i, 1);
                String sq ="UPDATE srbaru SET status = '"+st+"' WHERE nomor_sr LIKE '"+id+"'";
                stm.executeUpdate(sq);
                stm.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        
        }
    }//GEN-LAST:event_tableSRMouseClicked

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
            java.util.logging.Logger.getLogger(DataSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSR;
    private com.toedter.calendar.JDateChooser txtTgl;
    // End of variables declaration//GEN-END:variables
}
