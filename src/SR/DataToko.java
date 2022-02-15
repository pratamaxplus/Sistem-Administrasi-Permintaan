/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class DataToko extends javax.swing.JFrame {


    /**
     * Creates new form DataToko
     */
    public DataToko() {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        btnSimpan.setEnabled(false);
        tableList.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        tableList.getTableHeader().setOpaque(false);
        tableList.getTableHeader().setBackground(new Color(153,153,255));
        tableList.getTableHeader().setForeground(new Color(255,255,255));
        tableList.setRowHeight(25);
        tableBudget.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        tableBudget.getTableHeader().setOpaque(false);
        tableBudget.getTableHeader().setBackground(new Color(153,153,255));
        tableBudget.getTableHeader().setForeground(new Color(255,255,255));
        tableBudget.setRowHeight(25);
        tampil();
        budget();
        awal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private Connection Con = new Koneksi().connect();
    private Statement stm;
  
    public void tampil(){
        DefaultTableModel tableToko = new DefaultTableModel();
        tableToko.addColumn("Site Location");
        tableToko.addColumn("Order Type");
        tableToko.addColumn("Nama Toko");
        tableToko.addColumn("Address");
        
        try {
            String sql= "SELECT *FROM lokasi";
            stm = (Statement) Con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Object[] o = new Object[4];
                o[0] = rs.getString("s_location");
                o[1] = rs.getString("order_type");
                o[2] = rs.getString("nama_toko");
                o[3] = rs.getString("address");
                tableToko.addRow(o);
            }
            tableList.setModel(tableToko);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void simpan(){
        String site = txtLocation.getText();
        String order = String.valueOf(cmbOrder.getSelectedItem()); 
        String desc = txtDeskripsi.getText();
        String cost = txtCost.getText();
        String io = txtIo.getText();
        String add = txtAddress.getText();
       
        try{
            stm= (Statement) Con.createStatement();
            String sql ="INSERT INTO lokasi VALUES('"+site+"','"+order+"','"+desc+"','"+add+"','"+cost+"','"+io+"')";
            int executeUpdate = stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "BERHASIL DI SIMPAN", "TAMBAH USER",JOptionPane.INFORMATION_MESSAGE);
            txtLocation.setText("");
            cmbOrder.setSelectedItem("Pilih");
            txtDeskripsi.setText("");
            txtCost.setText("");
            txtIo.setText("");
            txtAddress.setText("");
            tampil();
            
        }catch(Exception  e){
              JOptionPane.showMessageDialog(null, "ERORR"+ e, "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void batal(){
            txtLocation.setText("");
            cmbOrder.setSelectedItem("Pilih");
            txtDeskripsi.setText("");
            txtCost.setText("");
            txtIo.setText("");
            txtAddress.setText("");
            btnSimpan.setEnabled(false);
            
    }
    private void budget(){
        DefaultTableModel tableSaldo = new DefaultTableModel();
        tableSaldo.addColumn("Internal Order");
        tableSaldo.addColumn("Cost Center");
        tableSaldo.addColumn("Nama Toko");
        tableSaldo.addColumn("Saldo");
        
        try{
            String sql = "SELECT budget_toko.internal_order,  lokasi.cost_center,"
                    + "lokasi.nama_toko,FORMAT(budget_toko.saldo, 0) FROM budget_toko, lokasi WHERE budget_toko.internal_order = lokasi.internal_order";
            stm = (Statement) Con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
             while (rs.next()){
                Object[] o = new Object[4];
                o[0] = rs.getString("internal_order");
                o[1] = rs.getString("cost_center");
                o[2] = rs.getString("nama_toko");
                o[3] = rs.getString(4);
                tableSaldo.addRow(o);
        }
            tableBudget.setModel(tableSaldo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void cari(){
        DefaultTableModel tableToko = new DefaultTableModel();
        tableToko.addColumn("Site Location");
        tableToko.addColumn("Order Type");
        tableToko.addColumn("Nama Toko");
        tableToko.addColumn("Address");
        tableToko.addColumn("Cost Center");
        tableToko.addColumn("Internal Order");
        
        String order = txFind.getText();
        try {
            String sql= "SELECT* FROM lokasi WHERE order_type LIKE '%"+order+"%' OR nama_toko LIKE '%"+order+"%'";
            stm = (Statement) Con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Object[] o = new Object[6];
                o[0] = rs.getString("s_location");
                o[1] = rs.getString("order_type");
                o[2] = rs.getString("nama_toko");
                o[3] = rs.getString("address");
                o[4] = rs.getString("cost_center");
                o[5] = rs.getString("internal_order");
                tableToko.addRow(o);
                tableList.setModel(tableToko);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
    }
        
}
    private void awal(){
        txtAddress.setEnabled(false);
        txtCost.setEnabled(false);
        txtDeskripsi.setEnabled(false);
        txtIo.setEnabled(false);
        txtLocation.setEnabled(false);
        btnBatal.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(true);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        cmbOrder = new javax.swing.JComboBox<>();
        txtDeskripsi = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        txtIo = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBudget = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txFind = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 225, 216));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Site Location", "Order Type", "Nama Toko", "Address"
            }
        ));
        tableList.setFocusable(false);
        tableList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableList.setRowHeight(25);
        tableList.setSelectionBackground(new java.awt.Color(247, 0, 23));
        tableList.setShowVerticalLines(false);
        tableList.getTableHeader().setReorderingAllowed(false);
        tableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 700, 240));

        jPanel3.setBackground(new java.awt.Color(156, 111, 105));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Order Type");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Site Location");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Description");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Cost Center");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("I.O");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Address");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));

        jLabel13.setText(":");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 10, -1));

        jLabel14.setText(":");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 10, -1));

        jLabel15.setText(":");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 10, -1));

        jLabel16.setText(":");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 10, -1));

        jLabel17.setText(":");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 10, -1));

        jLabel18.setText(":");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 10, -1));

        txtLocation.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 70, 20));

        cmbOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "DP04", "DJ04", "DH04" }));
        cmbOrder.setBorder(null);
        jPanel2.add(cmbOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 70, 20));

        txtDeskripsi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 280, 30));

        txtCost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 110, 30));

        txtIo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtIo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, 30));

        txtAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 560, 290));

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 80, 30));

        btnEdit.setText("Tambah");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 90, 30));

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel3.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 80, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 610, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cari :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 80, 50, 30));

        tableBudget.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tableBudget.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Internal Order", "Cost Center", "Nama Toko", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tableBudget);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 417, 700, 270));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Budget");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, 150, 40));

        jPanel4.setBackground(new java.awt.Color(156, 111, 105));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 225, 216));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Data Toko");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1380, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 100, 40));

        txFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFindActionPerformed(evt);
            }
        });
        txFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txFindKeyTyped(evt);
            }
        });
        jPanel1.add(txFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 80, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
        tampil();
        budget();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
        awal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        txtAddress.setEnabled(true);
        txtCost.setEnabled(true);
        txtDeskripsi.setEnabled(true);
        txtIo.setEnabled(true);
        txtLocation.setEnabled(true);
        btnBatal.setEnabled(true);
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
    }//GEN-LAST:event_btnEditActionPerformed

    private void txFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFindActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txFindActionPerformed

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListMouseClicked
        // TODO add your handling code here:
         int hapus;
        if ((hapus = JOptionPane.showConfirmDialog(null,"Hapus Data Toko?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
        try{
        
        int i = tableList.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) tableList.getValueAt(i, 0);
        
        stm = (com.mysql.jdbc.Statement) Con.createStatement();
        stm.executeUpdate("delete from lokasi where s_location = '"+id+ "'");
        
        
        tampil();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_tableListMouseClicked

    private void txFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txFindKeyTyped
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txFindKeyTyped

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
            java.util.logging.Logger.getLogger(DataToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataToko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataToko().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBudget;
    private javax.swing.JTable tableList;
    private javax.swing.JTextField txFind;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JTextField txtIo;
    private javax.swing.JTextField txtLocation;
    // End of variables declaration//GEN-END:variables
}
