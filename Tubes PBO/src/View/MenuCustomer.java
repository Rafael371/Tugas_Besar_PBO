/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.TukangManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class MenuCustomer {
    JFrame frame;
    private JButton buttonLogout, buttonSewa, buttonPoin, buttonTopUp;
    private JLabel labelWelcome, labelSaldo;
    
    public MenuCustomer(){
        DatabaseControl.updateCustomer(CustomerManager.getInstance().getCustomer());
        
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelWelcome = new JLabel("Welcome " + CustomerManager.getInstance().getCustomer().getNama());
        labelSaldo = new JLabel("Saldo : Rp. " + CustomerManager.getInstance().getCustomer().getSaldoUser());
        labelWelcome.setBounds(50, 10, 150, 50);
        labelSaldo.setBounds(260, 10, 150, 50);
        
        buttonSewa = new JButton("Sewa Jasa");
        buttonSewa.setBounds(90, 90, 200, 30);
        buttonSewa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(CustomerManager.getInstance().getCustomer().getSaldoUser() < 20000){
                    JOptionPane.showMessageDialog(null, "Harap Isi Saldo min. Rp. 20.000,- Terlebih Dahulu!!");
                }else{
                    frame.setVisible(false);
                    new MenuSewa();
                }
            }
        });
        buttonPoin = new JButton("Lihat Poin");
        buttonPoin.setBounds(90, 130, 200, 30);
        buttonPoin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Poin Anda saat ini adalah " + CustomerManager.getInstance().getCustomer().getPoinUser() + "\nSilahkan melakukan pemesanan sebanyak " + (100-CustomerManager.getInstance().getCustomer().getPoinUser()) + "x untuk mendapatkan pembayaran gratis!!");
            }
        });
        buttonTopUp = new JButton("Top Up Saldo");
        buttonTopUp.setBounds(90, 170, 200, 30);
        buttonTopUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTopUp();
            }
        });
        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(250, 290, 100, 30);
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Anda yakin ingin logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi kami!!");
                        frame.setVisible(false);
                        new MainMenu();
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                }
            }
        });
        frame.add(labelWelcome);
        frame.add(labelSaldo);
        frame.add(buttonLogout);
        frame.add(buttonSewa);
        frame.add(buttonPoin);
        frame.add(buttonTopUp);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
