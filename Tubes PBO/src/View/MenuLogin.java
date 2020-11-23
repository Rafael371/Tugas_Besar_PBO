/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Admin;
import Model.Customer;
import Model.Person;
import Model.Tukang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class MenuLogin extends JFrame{
    JFrame frame;
    JTextField tfUsername;
    JPasswordField tfPassword;
    JLabel username, password;
    JButton buttonLogin, buttonBackToMainMenu;
    public MenuLogin() {
        frame = new JFrame("Login User");
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        username = new JLabel();
        username.setText("username:");
        username.setBounds(10,0,150,50);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(100,15, 500, 20);
        
        password = new JLabel();
        password.setText("Password :  ");
        password.setBounds(10,25,150,50);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(100,40, 500, 20);
        
        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(50, 70, 80, 30);
        buttonLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Customer customer = new Customer();
                Tukang tukang = new Tukang();
                Admin admin = new Admin();
                if(customer.login(tfUsername.getText(), tfPassword.getText())){
                    frame.setVisible(false);
                    new MenuCustomer();
                }else if(tukang.login(tfUsername.getText(), tfPassword.getText())){
                    frame.setVisible(false);
                    new MenuTukang();
                }else if(admin.login(tfUsername.getText(), tfPassword.getText())){
                    frame.setVisible(false);
                    new MenuAdmin();
                }else{
                    JOptionPane.showMessageDialog(null, "Username / Password Salah!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonBackToMainMenu = new JButton("Main Menu");
        buttonBackToMainMenu.setBounds(200,70,100,30);
        buttonBackToMainMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MainMenu();
            }
        });
        
        frame.add(buttonBackToMainMenu);
        frame.add(buttonLogin);
        frame.add(username);
        frame.add(tfUsername);
        frame.add(password);
        frame.add(tfPassword);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
