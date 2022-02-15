/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class UserEdit extends javax.swing.JFrame {
private DefaultTableModel tab;
    /**
     * Creates new form UserEdit
     */
   
    public UserEdit() {
        initComponents();
        setTitle("Pengaturan Akun");
        setLocationRelativeTo(this);
        awal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("User Setting");
    }
    private Connection Con = (Connection) new Koneksi().connect();
    private Statement stm;
    private void tampil(){
        DefaultTableModel tabelUser = new DefaultTableModel();
        tabelUser.addColumn("USER ID");
        tabelUser.addColumn("NAMA");
        tabelUser.addColumn("NRP");
        tabelUser.addColumn("PASSWORD");
        tabelUser.addColumn("JABATAN");
        tabelUser.addColumn("LOKASI");
        tabelUser.addColumn("AKSES");
        
        try {
            String sql= "SELECT *FROM user";
            stm = (Statement) Con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                Object[] o = new Object[7];
                o[0] = rs.getString("user_id");
                o[1] = rs.getString("nama");
                o[2] = rs.getString("nrp");
                o[3] = rs.getString("password");
                o[4] = rs.getString("jabatan");
                o[5] = rs.getString("s_location");
                o[6] = rs.getString("akses");
                tabelUser.addRow(o);
            }
            table1.setModel(tabelUser);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void simpan(){
        String user_id = txtId.getText();
        String nama = txtNama.getText();
        String nrp = txtNrp.getText();
        String password = txtPass.getText();
        String jabatan = txtjabatan.getText();
        String lokasi = txtLoc.getText();
        String akses = String.valueOf(cmbPilih.getSelectedItem());
        try{
            stm = (Statement) Con.createStatement();
            String sql ="INSERT INTO user VALUES('"+user_id+"','"+nama+"','"+nrp+"','"+password+"','"+jabatan+"','"+lokasi+"','"+akses+"')";
            int executeUpdate = stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "BERHASIL DI SIMPAN", "TAMBAH USER",JOptionPane.INFORMATION_MESSAGE);
            txtId.setText("");
            txtNama.setText("");
            txtNrp.setText("");
            txtPass.setText("");
            txtLoc.setText("");
            txtjabatan.setText("");
            cmbPilih.setSelectedItem("- PILIH -");
        }catch(Exception  e){
              JOptionPane.showMessageDialog(null, "ID " +txtId.getText()+" Sudah Ada", "GAGAL", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void clear(){
        txtId.setText("");
        txtNama.setText("");
        txtNrp.setText("");
        txtPass.setText("");
        txtLoc.setText("");
        txtjabatan.setText("");
        cmbPilih.setSelectedItem("- PILIH -");
    }
    private void cari(){
        String user_id = txtId.getText();
        try {
            
            stm = (Statement) Con.createStatement();
            String sql = "SELECT * FROM user WHERE user_id LIKE '"+user_id+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                txtNama.setText(rs.getString(2));
                txtNrp.setText(rs.getString(3));
                txtPass.setText(rs.getString(4));
                txtjabatan.setText(rs.getString(5));
                txtLoc.setText(rs.getString(6));
                cmbPilih.setSelectedItem(rs.getString(7));
                txtId.setEnabled(true);
                txtjabatan.setEnabled(true);
                txtLoc.setEnabled(true);
                txtNama.setEnabled(true);
                txtNrp.setEnabled(true);
                txtPass.setEnabled(true);
                cmbPilih.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(null, "DATA TIDAK DITEMUKAN");
                awal();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+e,"GAGAL",JOptionPane.WARNING_MESSAGE);
        }
    }
    private void edit(){
        String user_id = txtId.getText();
        String nama = txtNama.getText();
        String nrp = txtNrp.getText();
        String password = txtPass.getText();
        String jabatan = txtjabatan.getText();
        String lokasi = txtLoc.getText();
        String akses = String.valueOf(cmbPilih.getSelectedItem());
        
        try {
            stm = (Statement) Con.createStatement();
            String sql = "UPDATE user SET nama = '"+nama+"',nrp='"+nrp+"',password='"+password+"',jabatan= '"+jabatan+"',"
                    + " s_location='"+lokasi+"' WHERE user_id LIKE '"+user_id+"'";
            stm.executeUpdate(sql);
            stm.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
        }finally {
            tampil();
        }
    }
    private void hapus(){
        String user_id = txtId.getText();
        int opsi = JOptionPane.showConfirmDialog(null, "Data Yang di Hapus Tidak Bisa Dikembalikan, Teruskan Hapus ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                try {
                stm = (Statement) Con.createStatement();
                String sql="DELETE FROM user WHERE user_id LIKE '"+user_id+"'";
                stm.executeUpdate(sql);
                    txtId.setText("");
                    txtNama.setText("");
                    txtNrp.setText("");
                    txtPass.setText("");
                    txtjabatan.setText("");
                    txtLoc.setText("");
                    cmbPilih.setSelectedItem("- Pilih -");
             }catch (Exception e) { 
                JOptionPane.showMessageDialog(null, "Eror: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
        }finally {
            tampil();
        }
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
            }else {
            
                    }
    }
    protected void ok(){
        cari();
        btnEdit.setEnabled(true);
        btnBatal.setEnabled(true);
        btnHapus.setEnabled(true);
        btnSimpan.setEnabled(false);
    }
    
    protected void awal(){
        btnEdit.setEnabled(false);
        btnBatal.setEnabled(false);
        btnHapus.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnOk.setEnabled(false);
        txtId.setEnabled(false);
        txtjabatan.setEnabled(false);
        txtLoc.setEnabled(false);
        txtNama.setEnabled(false);
        txtNrp.setEnabled(false);
        txtPass.setEnabled(false);
        cmbPilih.setEnabled(false);
    }
    protected void batal(){
        clear();
        btnEdit.setEnabled(false);
        btnBatal.setEnabled(false);
        btnHapus.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnOk.setEnabled(true);
        txtId.setEnabled(true);
        txtjabatan.setEnabled(false);
        txtLoc.setEnabled(false);
        txtNama.setEnabled(false);
        txtNrp.setEnabled(false);
        txtPass.setEnabled(false);
        cmbPilih.setEnabled(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnList = new javax.swing.JLabel();
        btnPlus = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNrp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbPilih = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtjabatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtLoc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(229, 225, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 504, 230));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(229, 225, 216));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Pengaturan Akun");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 300, 30));

        btnList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/checklist.png"))); // NOI18N
        btnList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListMouseClicked(evt);
            }
        });
        jPanel1.add(btnList, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 50));

        btnPlus.setBackground(new java.awt.Color(255, 255, 255));
        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SR/gambar/plus (1).png"))); // NOI18N
        btnPlus.setContentAreaFilled(false);
        btnPlus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 50, 50));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("List");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 40, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tambah User");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 70, 20));

        jPanel2.setBackground(new java.awt.Color(79, 59, 56));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(229, 225, 216));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("USER ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 60, 20));
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 72, -1));

        jLabel3.setText("NAMA");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 60, 20));
        jPanel3.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 137, -1));

        jLabel4.setText("NRP");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 20));
        jPanel3.add(txtNrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 137, -1));

        jLabel5.setText("PASSWORD");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 20));
        jPanel3.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 137, -1));

        jLabel6.setText("AKSES");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cmbPilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- PILIH -", "admin", "store" }));
        jPanel3.add(cmbPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 79, -1));

        jLabel1.setText("JABATAN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 20));
        jPanel3.add(txtjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 69, -1));

        btnSimpan.setBackground(new java.awt.Color(156, 111, 105));
        btnSimpan.setForeground(new java.awt.Color(79, 59, 56));
        btnSimpan.setText("SIMPAN");
        btnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 84, -1));

        btnBatal.setBackground(new java.awt.Color(156, 111, 105));
        btnBatal.setForeground(new java.awt.Color(79, 59, 56));
        btnBatal.setText("BATAL");
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel3.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 84, -1));

        btnEdit.setBackground(new java.awt.Color(156, 111, 105));
        btnEdit.setForeground(new java.awt.Color(79, 59, 56));
        btnEdit.setText("EDIT");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 84, -1));

        btnOk.setForeground(new java.awt.Color(79, 59, 56));
        btnOk.setText("OK");
        btnOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        jPanel3.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 11, -1, -1));

        btnHapus.setBackground(new java.awt.Color(156, 111, 105));
        btnHapus.setForeground(new java.awt.Color(79, 59, 56));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 84, -1));

        jLabel7.setText("LOKASI");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 15));
        jPanel3.add(txtLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 69, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 350));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        ok();
        
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(txtId.getText().equals("") ||txtjabatan.getText().equals("") ||txtLoc.getText().equals("") || txtNama.getText().equals("")|| txtNrp.getText().equals("")|| cmbPilih.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SR System", JOptionPane.INFORMATION_MESSAGE);
         }else{
        edit();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
         if(txtId.getText().equals("") ||txtjabatan.getText().equals("") ||txtLoc.getText().equals("") || txtNama.getText().equals("")|| txtNrp.getText().equals("")|| cmbPilih.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SR System", JOptionPane.INFORMATION_MESSAGE);
         }else{
        simpan();
        tampil();
         }
    }//GEN-LAST:event_btnSimpanActionPerformed
    
    private void btnListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListMouseClicked
        // TODO add your handling code here:
        tampil();
        txtId.setEnabled(true);
        btnOk.setEnabled(true);
    }//GEN-LAST:event_btnListMouseClicked

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        // TODO add your handling code here:
        btnOk.setEnabled(false);
        btnBatal.setEnabled(true);
        btnSimpan.setEnabled(true);
        txtId.setEnabled(true);
        txtjabatan.setEnabled(true);
        txtLoc.setEnabled(true);
        txtNama.setEnabled(true);
        txtNrp.setEnabled(true);
        txtPass.setEnabled(true);
        cmbPilih.setEnabled(true);
        
    }//GEN-LAST:event_btnPlusActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_table1MouseClicked

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
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JLabel btnList;
    private javax.swing.JButton btnOk;
    private javax.swing.JToggleButton btnPlus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table1;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLoc;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNrp;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtjabatan;
    // End of variables declaration//GEN-END:variables
}
