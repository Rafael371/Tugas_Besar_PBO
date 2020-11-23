/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateTable{
    static DatabaseHandler conn = new DatabaseHandler();
    public static Statement stm;
    
    public CreateTable(){
        conn.connect();
        String sql = "";
        try{
            stm = (Statement) conn.con.createStatement();
            
            sql = "CREATE TABLE User (" +
"                   id_user INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   username VARCHAR(10) NOT NULL," +
"                   password VARCHAR(10) NOT NULL," +
"                   email VARCHAR(20) NOT NULL," +
"                   no_telp  INT(13) NOT NULL," +
"                   point_user INT NOT NULL," +
"                   saldo_user INT(7) NOT NULL," +
"                 )";
            stm.execute(sql);
            
            sql = "CREATE TABLE Tukang(" +
"                   id_tukang INT NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   username_tukang VARCHAR(10) NOT NULL," +
"                   password_tukang VARCHAR(10) NOT NULL," +
"                   penilaian_tukang FLOAT NOT NULL," +
"                   email_tukang VARCHAR(20) NOT NULL," +
"                   no_telp_tukang  INT(12) NOT NULL," +
"                   kategori_tukang VARCHAR(15) NOT NULL" +
"                   status_tukang VARCHAR(10) NOT NULL," +
"                   saldo_honor_tukang INT(7) NOT NULL," +
"                 )";
                    stm.execute(sql);
            
            sql = "CREATE TABLE Admin(" +
"                   id_admin VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   username_admin VARCHAR(10) NOT NULL," +
"                   password_admin VARCHAR(10) NOT NULL," +
"                   email_tukang VARCHAR(20) NOT NULL," +
"                 )";
                    stm.execute(sql);
                    
            sql = "CREATE TABLE Order(" +
"                   id_order VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   tanggal_order DATE(10) NOT NULL," +
"                   alamat_order VARCHAR(30) NOT NULL," +
"                   harga_order INT(7) NOT NULL," +
"                   penilain_order INT(1) NOT NULL" +
"                    )";
                    stm.execute(sql);
                    
            sql = "CREATE TABLE orderRuangan(" +
"                   id_order VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   jumlah_ruangan INT(2) NOT NULL," +
"                   jumlah_jam VARCHAR(30) NOT NULL," +
"                    )";
                    stm.execute(sql);
 
            sql = "CREATE TABLE orderCuciSepatu(" +
"                   id_order VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   jumlah_sepatu INT(2) NOT NULL," +
"                   nama_sepatu VARCHAR(30) NOT NULL," +
"                    )";
                    stm.execute(sql);
                    
            sql = "CREATE TABLE orderLaundry(" +
"                   id_order VARCHAR(10) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
"                   jumlah_kilo INT(2) NOT NULL," +
"                    )";
                    stm.execute(sql);
                    stm.close();
            conn.disconnect();
        }catch (Exception e){
            System.err.println("Connection Failure" + e.getMessage());
        }
    }
}
