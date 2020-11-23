/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AdminManager;
import Controller.DatabaseControl;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Admin extends Person{
    private int idAdmin;
    private double saldo;
    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public boolean login(String username, String password) {
        ArrayList<Admin> allAdmin = DatabaseControl.getAllAdmin();
        boolean cek = false;
        for(int i = 0; (i < allAdmin.size()) && (!cek); i++){
            if(allAdmin.get(i).getUsername().equals(username) && allAdmin.get(i).getPassword().equals(password)){
                cek = true;
                AdminManager.getInstance().setAdmin(allAdmin.get(i));
            }
        }
        return cek;
    }
    
}
