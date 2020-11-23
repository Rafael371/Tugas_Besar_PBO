/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.PesananManager;
import Controller.TukangManager;
import Model.Tukang;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ShoesAndCareFinder {
    public ShoesAndCareFinder(){
        
        ArrayList<Tukang> allTukang = DatabaseControl.getAllTukang();
        Tukang tukang = new Tukang();
        boolean ketemu = false;
        for(int i = 0; (!ketemu) && (i < allTukang.size()); i++){
            if(allTukang.get(i).getStatus().equals("Ready") && allTukang.get(i).getKategori().equals("Shoes And Care")){
                ketemu = true;
                tukang = allTukang.get(i);
            }
        }
        if(!ketemu){
            JOptionPane.showMessageDialog(null, "Maaf, tukang tidak ditemukan\nSilahkan pesan dilain waktu!!");
            new MenuCustomer();
        }else{
            TukangManager.getInstance().setTukang(tukang);
            JOptionPane.showMessageDialog(null, "Tukang ditemukan!!");
            JOptionPane.showMessageDialog(null, "Nama : " + TukangManager.getInstance().getTukang().getNama() + "\nKategori : " + TukangManager.getInstance().getTukang().getKategori());
            PesananManager.getInstance().getPesanan().setKategori("Shoes And Care");
            TukangManager.getInstance().getTukang().setStatus("Not Available");
            new MenuPembayaran();
        }
        
    }
}
