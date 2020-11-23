/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class MenuTopUp {
    JFrame frame;
    JLabel labelPilih;
    JButton buttonBack, buttonLogout, button20, button50, button70, button100, button150, button200, button500, button1000;
    public MenuTopUp(){
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelPilih = new JLabel("Silahkan Pilih Nominal");
        labelPilih.setBounds(150, 10, 150, 20);
        button20 = new JButton("Rp. 20.000,-");
        button20.setBounds(20, 50, 120, 30);
        button20.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(20000);
            }
        });
        button50 = new JButton("Rp. 50.000,-");
        button50.setBounds(20, 100, 120, 30);
        button50.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(50000);
            }
        });
        button70 = new JButton("Rp. 70.000,-");
        button70.setBounds(20, 150, 120, 30);
        button70.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(70000);
            }
        });
        button100 = new JButton("Rp. 100.000,-");
        button100.setBounds(20, 200, 120, 30);
        button100.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(100000);
            }
        });
        button150 = new JButton("Rp. 150.000,-");
        button150.setBounds(240, 50, 120, 30);
        button150.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(150000);
            }
        });
        button200 = new JButton("Rp. 200.000,-");
        button200.setBounds(240, 100, 120, 30);
        button200.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(200000);
            }
        });
        button500 = new JButton("Rp. 500.000,-");
        button500.setBounds(240, 150, 120, 30);
        button500.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(500000);
            }
        });
        button1000 = new JButton("Rp. 1.000.000,-");
        button1000.setBounds(240, 200, 120, 30);
        button1000.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuTransaksi(1000000);
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
        frame.add(button20);
        frame.add(button50);
        frame.add(button70);
        frame.add(button100);
        frame.add(button150);
        frame.add(button200);
        frame.add(button500);
        frame.add(button1000);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
