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
import javax.swing.WindowConstants;
/**
 *
 * @author HP
 */
public class MainMenu extends JFrame implements ActionListener{
    JFrame frame;
    JButton buttonLogin;
    JButton buttonDaftar;
    JButton buttonExit;
        
    public MainMenu(){
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(90, 90, 200, 50);
        buttonLogin.addActionListener(this);
        buttonDaftar = new JButton("Daftar");
        buttonDaftar.setBounds(90, 150, 200, 50);
        buttonDaftar.addActionListener(this);
        buttonExit = new JButton("Exit");
        buttonExit.setBounds(140, 220, 100, 50);
        buttonExit.addActionListener(this);
        
        frame.add(buttonExit);
        frame.add(buttonLogin);
        frame.add(buttonDaftar);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command) {
            case "Login":
                frame.setVisible(false);
                new MenuLogin();
                break;
            case "Daftar":
                frame.setVisible(false);
                new MenuDaftar();
                break;
            case "Exit": 
                System.exit(0);
                break;
        }
    }
}
