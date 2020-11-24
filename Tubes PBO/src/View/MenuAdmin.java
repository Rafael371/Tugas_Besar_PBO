/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminManager;
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
public class MenuAdmin extends JFrame{
    JFrame frame;
    private JButton buttonLogout, buttonAcceptTukang, buttonBlockTukang, buttonKeuangan;
    private JLabel labelSaldo;
    public MenuAdmin(){
        DatabaseControl.updateAdmin(AdminManager.getInstance().getAdmin());
        
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        buttonAcceptTukang = new JButton("Accept Tukang");
        buttonAcceptTukang.setBounds(90, 90, 200, 30);
        buttonAcceptTukang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new AcceptTukang(); 
            }
        });
        
        buttonBlockTukang = new JButton("Block Tukang");
        buttonBlockTukang.setBounds(90, 130, 200, 30);
        buttonBlockTukang.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new BlockTukang(); 
            }
        });
        
        buttonKeuangan = new JButton("Keuangan Perusahaan");
        buttonKeuangan.setBounds(90, 170, 200, 30);
        buttonKeuangan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Keuangan Perusahaan adalah Rp. " + AdminManager.getInstance().getAdmin().getSaldo());
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
        frame.add(buttonLogout);
        frame.add(buttonAcceptTukang);
        frame.add(buttonBlockTukang);
        frame.add(buttonKeuangan);
        frame.setLayout(null);
        frame.setVisible(true);
    
    }
}
