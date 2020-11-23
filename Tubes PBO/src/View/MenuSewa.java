/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerManager;
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
public class MenuSewa {
    JFrame frame;
    JLabel labelPilih;
    JButton buttonBack, buttonLogout, buttonHomeCleaning, buttonLaundry, buttonShoes;
    public MenuSewa(){
        frame = new JFrame("Pemilihan Jasa");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelPilih = new JLabel("Silahkan Pilih Jasa yang Diinginkan");
        labelPilih.setBounds(90, 10, 200, 100);
        
        buttonLaundry = new JButton("Laundry");
        buttonLaundry.setBounds(90, 90, 200, 30);
        buttonLaundry.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new Laundry();
            }
        });
        buttonHomeCleaning = new JButton("Home Cleaning");
        buttonHomeCleaning.setBounds(90, 130, 200, 30);
        buttonHomeCleaning.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new HomeCleaning();
            }
        });
        buttonShoes = new JButton("Shoes and Care");
        buttonShoes.setBounds(90, 170, 200, 30);
        buttonShoes.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new ShoesAndCare();
            }
        });
        buttonBack = new JButton("Back");
        buttonBack.setBounds(30, 290, 100, 30);
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuCustomer();
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
        frame.add(labelPilih);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.add(buttonHomeCleaning);
        frame.add(buttonLaundry);
        frame.add(buttonShoes);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
