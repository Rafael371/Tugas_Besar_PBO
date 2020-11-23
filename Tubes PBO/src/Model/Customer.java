/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Customer extends PersonSelainAdmin{
    private int poinUser;
    private int saldoUser;
    private int idUser;
    
    public int getIdUser(){
        return idUser;
    }
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    public int getSaldoUser(){
        return saldoUser;
    }
    public void setSaldoUser(int saldoUser){
        this.saldoUser = saldoUser;
    }
    public int getPoinUser() {
        return poinUser;
    }
    public void setPoinUser(int poinUser) {
        this.poinUser = poinUser;
    }
    @Override
    public void register() {
    
    }

    @Override
    public boolean login(String username, String password) {
        ArrayList<Customer> allCustomer = DatabaseControl.getAllUser();
        boolean cek = false;
        for(int i = 0; (i < allCustomer.size()) && (!cek); i++){
            if(allCustomer.get(i).getUsername().equals(username) && allCustomer.get(i).getPassword().equals(password)){
                cek = true;
                CustomerManager.getInstance().setCustomer(allCustomer.get(i));
            }
        }
        return cek;
    }

}
   
