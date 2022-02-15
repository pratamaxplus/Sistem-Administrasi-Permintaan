/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import com.toedter.calendar.JDateChooser;
import java.awt.JobAttributes;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class report extends javax.swing.JFrame {
    private Connection Con = new Koneksi().connect();
    private Statement stm;
   

    /**
     * Creates new form report
     */
    public report() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Report");
    }
    private void saldo(){
        
        int cetak;
        if ((cetak = JOptionPane.showConfirmDialog(null,"Cetak Laporan Saldo Budget?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
            InputStream streamLaporan = getClass().getResourceAsStream("/LAPORAN/saldo_budget.jasper");
            try {
          
            HashMap hash = new HashMap();
            //hash.put("kode", pilihan);
            stm=(Statement) Con.createStatement();
            JasperPrint jprint = JasperFillManager.fillReport(streamLaporan, hash, Con);
            JasperViewer.viewReport(jprint, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
    private void pemakaian_budget(){
        
        int cetak;
        if ((cetak = JOptionPane.showConfirmDialog(null,"Cetak Laporan Pemakaian Budget?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
            InputStream streamLaporan = getClass().getResourceAsStream("/LAPORAN/pemakaian_budget.jasper");
            try {
            HashMap hash = new HashMap();
            //hash.put("tgl1", tanggal1);
            //hash.put("tgl2", tanggal2);
            stm=(Statement) Con.createStatement();
           
            JasperPrint jprint = JasperFillManager.fillReport(streamLaporan, hash, Con);
            JasperViewer.viewReport(jprint, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        datasr = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        saldo = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pemakaian = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tolak = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(229, 225, 216));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(156, 111, 105));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 59, 56));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Service Request");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        datasr.setBackground(new java.awt.Color(156, 111, 105));
        datasr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/printer.png"))); // NOI18N
        datasr.setContentAreaFilled(false);
        datasr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datasr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datasrActionPerformed(evt);
            }
        });
        jPanel4.add(datasr, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 70, 70));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 730, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saldo.setBackground(new java.awt.Color(156, 111, 105));
        saldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/printer.png"))); // NOI18N
        saldo.setContentAreaFilled(false);
        saldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoActionPerformed(evt);
            }
        });
        jPanel5.add(saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 70, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 59, 56));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Saldo Budget");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 730, 90));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(79, 59, 56));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Laporan Pemakaian Budget");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 330, -1));

        pemakaian.setBackground(new java.awt.Color(156, 111, 105));
        pemakaian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/printer.png"))); // NOI18N
        pemakaian.setContentAreaFilled(false);
        pemakaian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pemakaian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemakaianActionPerformed(evt);
            }
        });
        jPanel6.add(pemakaian, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 70, 70));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 730, 90));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 59, 56));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Laporan Data Service Request Ditolak");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, -1));

        tolak.setBackground(new java.awt.Color(156, 111, 105));
        tolak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/printer.png"))); // NOI18N
        tolak.setContentAreaFilled(false);
        tolak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tolak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tolakActionPerformed(evt);
            }
        });
        jPanel7.add(tolak, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 70, 70));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 730, 90));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 750, 430));

        jPanel1.setBackground(new java.awt.Color(229, 225, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judul.setBackground(new java.awt.Color(229, 225, 216));
        judul.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        judul.setForeground(new java.awt.Color(79, 59, 56));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("Cetak Report");
        judul.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 750, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoActionPerformed
        // TODO add your handling code here:
        saldo();
    }//GEN-LAST:event_saldoActionPerformed

    private void pemakaianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemakaianActionPerformed
        // TODO add your handling code here:
       pemakaian_budget();
    }//GEN-LAST:event_pemakaianActionPerformed

    private void tolakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tolakActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Cetak Data Service Request Ditolak ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                InputStream streamLaporan = getClass().getResourceAsStream("/LAPORAN/data_user.jasper");
                try {
                    
                    stm=(Statement) Con.createStatement();
                    HashMap parameter = new HashMap();
                    JasperPrint jprint = JasperFillManager.fillReport(streamLaporan, parameter, Con);
                    JasperViewer.viewReport(jprint, false);
                    //JasperViewer.setDefaultLookAndFeelDecorated(true);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
    }//GEN-LAST:event_tolakActionPerformed

    private void datasrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datasrActionPerformed
        // TODO add your handling code here:
         
      
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new java.util.Locale("id"));
            //String tanggal = sdf.format(txtdate.getDate());     
            int opsi = JOptionPane.showConfirmDialog(null, "Cetak Data Service Request ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (opsi == JOptionPane.YES_OPTION){
                        InputStream streamLaporan = getClass().getResourceAsStream("/LAPORAN/data_sr.jasper");
                        try {
                            
                            stm =(Statement) Con.createStatement();
                            HashMap hash = new HashMap();
                           //hash.put("kode", tanggal);
                            
                            JasperPrint jprint =JasperFillManager.fillReport(streamLaporan, hash, Con);
                            JasperViewer.viewReport(jprint, false);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e);
                        }
                    }
                    
                    
                    
                    

    }//GEN-LAST:event_datasrActionPerformed

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
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton datasr;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel judul;
    private javax.swing.JToggleButton pemakaian;
    private javax.swing.JToggleButton saldo;
    private javax.swing.JToggleButton tolak;
    // End of variables declaration//GEN-END:variables
}