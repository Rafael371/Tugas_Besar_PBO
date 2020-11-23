/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Customer;
import Model.Pesanan;
import Model.Tukang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class DatabaseControl {
    static DatabaseHandler conn = new DatabaseHandler();
    public static boolean InsertNewUser(Customer user){
        conn.connect();
        
        String query = "INSERT INTO users (id_user, username, password, nama, email, no_telp, poin_user, saldo_user) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getNama());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getNoTelp());
            stmt.setInt(7, 0);
            stmt.setInt(8, 0);
            
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean InsertNewTukang(Tukang tukang){
        conn.connect();
        
        String query = "INSERT INTO tukang (id_tukang, username, password, nama, ratting, email, no_telp, kategori, status, saldo) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, tukang.getUsername());
            stmt.setString(3, tukang.getPassword());
            stmt.setString(4, tukang.getNama());
            stmt.setFloat(5, tukang.getReview());
            stmt.setString(6, tukang.getEmail());
            stmt.setString(7, tukang.getNoTelp());
            stmt.setString(8, tukang.getKategori());
            stmt.setString(9, tukang.getStatus());
            stmt.setInt(10, 0);
            
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static ArrayList<Customer> getAllUser(){
        ArrayList<Customer> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM users";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Customer user = new Customer();
                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setEmail(rs.getString("email"));
                user.setNoTelp(rs.getString("no_telp"));
                user.setPoinUser(rs.getInt("poin_user"));
                user.setSaldoUser(rs.getInt("saldo_user"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    public static ArrayList<Tukang> getAllTukang(){
        ArrayList<Tukang> allTukang = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM tukang";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Tukang tukang = new Tukang();
                tukang.setIdTukang(rs.getInt("id_tukang"));
                tukang.setUsername(rs.getString("username"));
                tukang.setPassword(rs.getString("password"));
                tukang.setReview(rs.getInt("ratting"));
                tukang.setNama(rs.getString("nama"));
                tukang.setEmail(rs.getString("email"));
                tukang.setNoTelp(rs.getString("no_telp"));
                tukang.setKategori(rs.getString("kategori"));
                tukang.setStatus(rs.getString("status"));
                tukang.setSaldo(rs.getInt("saldo"));
                allTukang.add(tukang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allTukang);
    }
    public static ArrayList<Admin> getAllAdmin(){
        ArrayList<Admin> allAdmin = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM admin";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setNama(rs.getString("nama"));
                admin.setEmail(rs.getString("email"));
                admin.setNoTelp(rs.getString("no_telp"));
                
                allAdmin.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (allAdmin);
    }
    public static boolean InsertNewPesanan(Pesanan pesanan){
        conn.connect();
        
        String query = "INSERT INTO pesanan (id_order, id_user, id_tukang, alamat, kategori, paket, regular, lama, jumlah, total_harga) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, CustomerManager.getInstance().getCustomer().getIdUser());
            stmt.setInt(3, TukangManager.getInstance().getTukang().getIdTukang());
            stmt.setString(4, pesanan.getAlamat());
            stmt.setString(5, pesanan.getKategori());
            if(pesanan.getPaket()){
                stmt.setString(6, "Yes");
                stmt.setString(7, "No");
            }else if(pesanan.getRegular()){
                stmt.setString(6, "No");
                stmt.setString(7, "Yes");
            }
            stmt.setInt(8, pesanan.getLama());
            stmt.setInt(9, pesanan.getJumlah());
            stmt.setInt(10, pesanan.getTotalHarga());
            
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean updateCustomer(Customer user) {
        conn.connect();
        String query = "UPDATE users SET username='" + user.getUsername() + "', "
                + "password='" + user.getPassword() + "', "
                + "nama='" + user.getNama() + "', "
                + "email='" + user.getEmail() + "', "
                + "no_telp='" + user.getNoTelp() + "', "
                + "poin_user=" + user.getPoinUser() + ", "
                + "saldo_user=" + user.getSaldoUser()
                + " WHERE id_user=" + user.getIdUser();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean updateTukang(Tukang tukang) {
        conn.connect();
        String query = "UPDATE tukang SET username='" + tukang.getUsername() + "', "
                + "password='" + tukang.getPassword() + "', "
                + "nama='" + tukang.getNama() + "', "
                + "email='" + tukang.getEmail() + "', "
                + "no_telp='" + tukang.getNoTelp() + "', "
                + "kategori'=" + tukang.getKategori() + "', "
                + "status='" + tukang.getStatus() + "', "
                + "saldo=" + tukang.getSaldo()
                + " WHERE id_tukang=" + tukang.getIdTukang();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
