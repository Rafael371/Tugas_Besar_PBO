/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Tukang;

/**
 *
 * @author HP
 */
public class TukangManager {
    static TukangManager instance;
    private Tukang tukang;

    public static TukangManager getInstance() {
        if (instance == null) {
            instance = new TukangManager();
        }
        return instance;
    }
    
    public Tukang getTukang() {
        return tukang;
    }

    public void setTukang(Tukang tukang) {
        this.tukang = tukang;
    }
}
