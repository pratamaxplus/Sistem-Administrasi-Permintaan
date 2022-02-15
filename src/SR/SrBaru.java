/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class SrBaru extends javax.swing.JFrame {

    java.util.Date tanggal = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    private final String tgl = smpdtfmt.format(tanggal);
    private Statement stm;
    private Connection Con = new Koneksi().connect();
    private DefaultTableModel tabelSR;
    /**
     * Creates new form SrBaru
     */
    public SrBaru() {
        initComponents();
        tabelSR = new DefaultTableModel();
        tabel.setModel(tabelSR);
        tabelSR.addColumn("ID");
        tabelSR.addColumn("JENIS");
        tabelSR.addColumn("DESKRIPSI");
        tabelSR.addColumn("JUMLAH");
        txtTgl.setText(tgl);
        txtNama.requestFocus();
        no_sr();
        nama();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Create Request");
        
    }
    public final void tampil(){
        
        
        tabelSR.getDataVector().removeAllElements();
        tabelSR.fireTableDataChanged();
        try {
            stm = (Statement) Con.createStatement();
            String sql = "SELECT * FROM tmp_srbaru";
            ResultSet r = stm.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[4];
                o[0] = r.getString("id_sr");
                o[1] = r.getString("jenis_permintaan");
                o[2] = r.getString("deskripsi");
                o[3] = r.getString("jml");
               
                tabelSR.addRow(o);
            }
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
        }
   
    } 

    private void submit(){
           
           try {
            Connection c = new Koneksi().connect();
            java.sql.Statement s = c.createStatement();
            String sql = "SELECT * FROM tmp_srbaru";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                
                String sqla = "INSERT INTO srbaru VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         
                PreparedStatement p = c.prepareStatement(sqla);
                p.setString(1, null);
                p.setString(2, txtTgl.getText());
                p.setString(3, txtNmr.getText());
                p.setString(4, txtNama.getText());
                p.setString(5, txtLoc.getText());
                p.setString(6, r.getString("jenis_permintaan"));
                p.setString(7, r.getString("deskripsi"));
                p.setString(8, r.getString("jml"));
                p.setString(9, "Terkirim");
                
                
                p.executeUpdate();
                p.close();
                
                
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }finally{
         try {
            String sqla ="TRUNCATE `tmp_srbaru";
            java.sql.Connection conn=(Connection) new Koneksi().connect();
            java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Submit SR", "Info", JOptionPane.INFORMATION_MESSAGE);
            tampil();
          
            txtNama.requestFocus(true);
            cmbReq.setSelectedItem("- Pilih -");
            cmbReq.setEnabled(true);
            no_sr();
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
     }
}
    private void nama(){
        String kode = txtLoc.getText();
        try {
            stm = (Statement)Con.createStatement();
            String sql = "SELECT nama_toko FROM lokasi WHERE s_location LIKE '"+kode+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                namatoko.setText(rs.getNString(1));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
         
    private void batal(){
            
            txtNama.setText("");
            cmbReq.setSelectedItem("-Pilih-");
            txtDesk1.setText("");
            txtQty1.setText("");
            cmbReq.setEnabled(true);
            
    }
    private void no_sr(){
        try{
            stm = (Statement) Con.createStatement();
            String sql = "SELECT * FROM srbaru ORDER by nomor_sr desc";
            ResultSet rs = stm.executeQuery(sql);
            
            if (rs.next()) {
                String nmsr = rs.getString("nomor_sr").substring(2);
                String AN = "" + (Integer.parseInt(nmsr) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                txtNmr.setText("SR"+ Nol + AN);
            } else {
                txtNmr.setText("SR0001");//nomer+"-"+"0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
   
   
    private void tambah() {
         if(txtNmr.getText().equals("") || txtNama.getText().equals("") ||cmbReq.getSelectedItem().equals("") || txtDesk1.getText().equals("")|| txtQty1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Info", JOptionPane.INFORMATION_MESSAGE);
         }else {
             
             String nama = txtNama.getText();
             String jenis = String.valueOf(cmbReq.getSelectedItem());
             String desk = txtDesk1.getText();
             String jml = txtQty1.getText();
             
             try{
                 Connection Con = new Koneksi().connect();
                 String sql = "INSERT INTO tmp_srbaru VALUES (?,?,?,?)";
                 
                PreparedStatement s = Con.prepareStatement(sql);
                s.setString(1, null);
                s.setString(2, jenis);
                s.setString(3, desk);
                s.setString(4, jml);
                 
                s.executeUpdate();
                s.close();
             }catch (SQLException e){
                 JOptionPane.showMessageDialog(null, e);
             }finally{
                 no_sr();
                 cmbReq.setSelectedItem("");
                 txtDesk1.setText("");
                 txtQty1.setText("");
                 JOptionPane.showMessageDialog(null, "Data Tersimpan");
                 tampil();
                 cmbReq.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTgl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        cmbReq = new javax.swing.JComboBox<>();
        txtQty1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDesk1 = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNmr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        namatoko = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(79, 59, 56));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(201, 193, 176));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        judul.setBackground(new java.awt.Color(229, 225, 216));
        judul.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        judul.setForeground(new java.awt.Color(79, 59, 56));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("Input SR");
        judul.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        jPanel2.setBackground(new java.awt.Color(201, 193, 176));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTgl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTgl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 90, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Site Lokasi");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Qty");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 30, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Permintaan");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nama");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 20));

        txtLoc.setEditable(false);
        jPanel2.add(txtLoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 90, -1));

        jLabel7.setText(":");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 10, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jPanel2.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 190, -1));

        cmbReq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Perbaikan", "Unit Baru" }));
        cmbReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReqActionPerformed(evt);
            }
        });
        jPanel2.add(cmbReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 150, -1));
        jPanel2.add(txtQty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 40, 30));

        jLabel8.setText(":");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 10, -1));

        jLabel9.setText(":");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 10, -1));

        jLabel10.setText(":");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 10, -1));

        jLabel11.setText(":");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 10, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Deskripsi Permintaan");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 20));

        jLabel13.setText(":");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 10, -1));
        jPanel2.add(txtDesk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 280, 30));

        btnTambah.setBackground(new java.awt.Color(156, 111, 105));
        btnTambah.setForeground(new java.awt.Color(79, 59, 56));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 90, 30));

        btnSimpan.setBackground(new java.awt.Color(156, 111, 105));
        btnSimpan.setForeground(new java.awt.Color(79, 59, 56));
        btnSimpan.setText("Submit");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 90, 30));

        btnBatal.setBackground(new java.awt.Color(156, 111, 105));
        btnBatal.setForeground(new java.awt.Color(79, 59, 56));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel2.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 90, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("No SR");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tanggal");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 140, 20));

        jLabel24.setText(":");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 10, -1));

        txtNmr.setEditable(false);
        jPanel2.add(txtNmr, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 90, -1));

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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 630, 120));

        namatoko.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        namatoko.setText("jLabel3");
        jPanel2.add(namatoko, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 320, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 670, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void cmbReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbReqActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        submit();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        tambah();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int hapus;
        if ((hapus = JOptionPane.showConfirmDialog(null,"Yakin batal?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
        try{
        
        int i = tabel.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) tabelSR.getValueAt(i, 0);
        
        stm = (Statement) Con.createStatement();
        stm.executeUpdate("delete from tmp_srbaru where id_sr = '"+id+ "'");
        
        no_sr();
        tampil();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(SrBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SrBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SrBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SrBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SrBaru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbReq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel namatoko;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtDesk1;
    public static final javax.swing.JTextField txtLoc = new javax.swing.JTextField();
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNmr;
    private javax.swing.JTextField txtQty1;
    private javax.swing.JLabel txtTgl;
    // End of variables declaration//GEN-END:variables

}