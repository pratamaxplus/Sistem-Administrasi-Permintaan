  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ASUS
 */
public class MenuToko extends javax.swing.JFrame {
private DefaultTableModel tabelSR;
    /**
     * Creates new form MenuToko
     */
    public MenuToko() {
        initComponents();
        setLocationRelativeTo(this);
        tabelSR = new DefaultTableModel();
        tabel.setModel(tabelSR);
        tabelSR.addColumn("Tanggal");
        tabelSR.addColumn("ID");
        tabelSR.addColumn("JENIS");
        tabelSR.addColumn("DESKRIPSI");
        tabelSR.addColumn("JUMLAH");
        tabelSR.addColumn("Status");
        panelSR.setVisible(false);
        setTitle("Store Menu");
    }
    private Connection Con = new Koneksi().connect();
    private Statement stm;
    private void tampil(){
        tabelSR.getDataVector().removeAllElements();
        tabelSR.fireTableDataChanged();
        String kode = SrBaru.txtLoc.getText();
        try {
            stm = (Statement) Con.createStatement();
            String sql = "SELECT tgl,nomor_sr,jenis_permintaan,deskripsi,jml,status FROM srbaru WHERE s_location LIKE '"+kode+"'";
            ResultSet r = stm.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("tgl");
                o[1] = r.getString("nomor_sr");
                o[2] = r.getString("jenis_permintaan");
                o[3] = r.getString("deskripsi");
                o[4] = r.getString("jml");
                o[5] = r.getString("status");
               
                tabelSR.addRow(o);
            }
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
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
        panelSR = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        refresh = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnOut = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLokasi = new javax.swing.JLabel();
        btnLokasi1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 225, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSR.setBackground(new java.awt.Color(229, 225, 216));
        panelSR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(156, 111, 105));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 225, 216));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("List SR");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 20, 640, 40));

        panelSR.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 70));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        panelSR.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 600, 290));

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        panelSR.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 80, -1));

        jPanel1.add(panelSR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 650, 430));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/supermarket.png"))); // NOI18N
        jLabel7.setToolTipText("");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 130, 140));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(156, 111, 105));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Buat SR Baru");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 130, 20));

        Store.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Store.setForeground(new java.awt.Color(156, 111, 105));
        Store.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Store, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 150, 30));

        btnOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/exit.png"))); // NOI18N
        btnOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOutMouseClicked(evt);
            }
        });
        jPanel1.add(btnOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jPanel4.setBackground(new java.awt.Color(156, 111, 105));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/exit.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel4.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 50, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 225, 216));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Store Menu");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 30));

        btnLokasi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLokasi.setForeground(new java.awt.Color(229, 225, 216));
        btnLokasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLokasi.setText("DAFTAR SR");
        btnLokasi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        btnLokasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLokasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLokasiMouseClicked(evt);
            }
        });
        jPanel4.add(btnLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, 30));

        btnLokasi1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLokasi1.setForeground(new java.awt.Color(229, 225, 216));
        btnLokasi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLokasi1.setText("HOME");
        btnLokasi1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        btnLokasi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLokasi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLokasi1MouseClicked(evt);
            }
        });
        jPanel4.add(btnLokasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 230, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOutMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOutMouseClicked

    private void btnLokasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLokasiMouseClicked
        // TODO add your handling code here:
        panelSR.setVisible(true);
        tampil();
    }//GEN-LAST:event_btnLokasiMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        new SrBaru().setVisible(true);
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnLokasi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLokasi1MouseClicked
        // TODO add your handling code here:
        panelSR.setVisible(false);
    }//GEN-LAST:event_btnLokasi1MouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(MenuToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuToko().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JLabel Store = new javax.swing.JLabel();
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnLokasi;
    private javax.swing.JLabel btnLokasi1;
    private javax.swing.JLabel btnOut;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelSR;
    private javax.swing.JToggleButton refresh;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}