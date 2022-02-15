/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class MenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form MenuAdmin
     */
    public MenuAdmin() {
        initComponents();
        setLocationRelativeTo(this);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setJam();
        setTitle("Admin Menu");
        }
        private Connection Con = new Koneksi().connect();
        private Statement stm;
        
         public final void setJam(){
        ActionListener taskPerformer = new ActionListener() {

                    @Override
        public void actionPerformed(ActionEvent evt) {
        String nol_jam = "", nol_menit = "",nol_detik = "";

        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();

        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik= "0";

        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);

        waktu.setText(jam+":"+menit+":"+detik+"");
        }
        };
        new Timer(1000, taskPerformer).start();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btndist = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(156, 111, 105));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(229, 225, 216));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 225, 216));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Admin Menu");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 270, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/gear.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 50, 50));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/exit.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 50, 50));

        jLabel4.setBackground(new java.awt.Color(229, 225, 216));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 225, 216));
        jLabel4.setText("Keluar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 130, 30));

        jLabel12.setBackground(new java.awt.Color(229, 225, 216));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(229, 225, 216));
        jLabel12.setText("Pengaturan User");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 710));

        panel1.setBackground(new java.awt.Color(229, 225, 216));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/operator.png"))); // NOI18N
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 80, 60));

        Nama.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Nama.setForeground(new java.awt.Color(156, 111, 105));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panel1.add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 70, 120, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/content.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 140, 140));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/process.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, 140, 140));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/portfolio.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 130, 140));

        jLabel13.setBackground(new java.awt.Color(156, 111, 105));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(156, 111, 105));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Service Request System");
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 660, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(156, 111, 105));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Report");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 570, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(156, 111, 105));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Data SR");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 140, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(156, 111, 105));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Proses SR");
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 570, 140, 30));

        btndist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/print.png"))); // NOI18N
        btndist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndistMouseClicked(evt);
            }
        });
        panel1.add(btndist, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 420, 140, 140));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(156, 111, 105));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Data Toko");
        panel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 130, 30));

        waktu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        waktu.setForeground(new java.awt.Color(156, 111, 105));
        waktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        waktu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel1.add(waktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 100, 120, 40));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        jMenuBar1.setBackground(new java.awt.Color(229, 225, 216));
        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);

        jMenu1.setBackground(new java.awt.Color(229, 225, 216));
        jMenu1.setText("Contact");

        jMenuItem1.setText("IT");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Procurement");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Facility");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        new UserEdit().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new DataSR().setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        new ProsesSR().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        new DataToko().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btndistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistMouseClicked
        // TODO add your handling code here:
        new report().setVisible(true);
    }//GEN-LAST:event_btndistMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Kontak.info.setText("Divisi IT");
        new Kontak().setVisible(true);
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Kontak.info.setText("Divisi Procurement");
        new Kontak().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Kontak.info.setText("Facility Management");
        new Kontak().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel Nama = new javax.swing.JLabel();
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btndist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel1;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}