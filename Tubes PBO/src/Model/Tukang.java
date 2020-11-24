/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AdminManager;
import Controller.DatabaseControl;
import Controller.TukangManager;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Tukang extends PersonSelainAdmin{
    private String status;
    private String kategori;
    private double saldo;
    private int idTukang;
    
    public int getIdTukang(){
        return idTukang;
    }
    public void setIdTukang(int idTukang){
        this.idTukang = idTukang;
    }
    public String getKategori(){
        return kategori;
    }
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void register() {
    
    }

    @Override
    public boolean login(String username, String password) {
        ArrayList<Tukang> allTukang = DatabaseControl.getAllTukang();
        boolean cek = false;
        for(int i = 0; (i < allTukang.size()) && (!cek); i++){
            if(allTukang.get(i).getUsername().equals(username) && allTukang.get(i).getPassword().equals(password) && allTukang.get(i).getStatus().equals("Ready")){
                cek = true;
                TukangManager.getInstance().setTukang(allTukang.get(i));
            }
        }
        return cek;
    }
}
