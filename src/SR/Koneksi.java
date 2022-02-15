/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SR;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Koneksi {
    private Connection koneksi;
    public Connection connect(){
         try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi Berhasil");
        }
        catch(ClassNotFoundException ex){
            System.out.println("Koneksi Gagal" +ex);
        }
        String url="jdbc:mysql://localhost:3306/db_sr";
        try{
            koneksi=DriverManager.getConnection(url,"root","");
            System.out.println("berhasil koneksi database");
        }
        catch (SQLException ex){
            System.out.println("gagal koneksi database" +ex);
        }
        return koneksi;
    }
    
}
