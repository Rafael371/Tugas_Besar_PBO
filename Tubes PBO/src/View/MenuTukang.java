/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TukangManager;
import Controller.DatabaseControl;
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
public class MenuTukang extends JFrame{
    JFrame frame;
    private JButton buttonLogout, buttonPesananCustomer, buttonKeuangan;
    private JLabel labelWelcome, labelSaldo;
    public MenuTukang(){
        DatabaseControl.updateTukang(TukangManager.getInstance().getTukang());
        
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelWelcome = new JLabel("Welcome " + TukangManager.getInstance().getTukang().getNama());
        labelWelcome.setBounds(50, 10, 150, 50);
        
        buttonPesananCustomer = new JButton("Mari Kerja");
        buttonPesananCustomer.setBounds(90, 120, 200, 30);
        buttonPesananCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new PesananCustomer(); 
            }
        });
        
        buttonKeuangan = new JButton("Keuangan Tukang");
        buttonKeuangan.setBounds(90, 170, 200, 30);
        buttonKeuangan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Keuangan Anda adalah Rp. " + TukangManager.getInstance().getTukang().getSaldo());
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
        frame.add(buttonLogout);
        frame.add(buttonPesananCustomer);
        frame.add(buttonKeuangan);
        frame.setLayout(null);
        frame.setVisible(true);
    
    }
}
