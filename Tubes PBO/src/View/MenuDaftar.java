/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Model.Customer;
import Model.Tukang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class MenuDaftar extends JFrame {

    JFrame frame;
    private JTextField tfEmail, tfUsername, tfNama, tfNoTelp;
    private JPasswordField tfPassword, tfCocokPassword;
    private JLabel email, username, password, cocokPassword, nama, noTelp;
    private JButton buttonDaftar, buttonBackToMainMenu;
    private ButtonGroup bg1, bg2;
    private JRadioButton radioUser, radioTukang, radioShoes, radioLaundry, radioHomeCleaning;

    public MenuDaftar() {
        frame = new JFrame("Daftar User");
        frame.setSize(740, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //username
        username = new JLabel();
        username.setText("username:");
        username.setBounds(10, 0, 150, 50);

        tfUsername = new JTextField();
        tfUsername.setBounds(210, 15, 500, 20);

        //password
        password = new JLabel();
        password.setText("Password :  ");
        password.setBounds(10, 25, 150, 50);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(210, 40, 500, 20);

        //pencocokan password
        cocokPassword = new JLabel();
        cocokPassword.setText("masukkan Password sekali lagi :  ");
        cocokPassword.setBounds(10, 50, 200, 50);

        tfCocokPassword = new JPasswordField();
        tfCocokPassword.setBounds(210, 65, 500, 20);

        //nama
        nama = new JLabel();
        nama.setText("Nama Anda:  ");
        nama.setBounds(10, 75, 150, 50);

        tfNama = new JTextField();
        tfNama.setBounds(210, 90, 500, 20);

        //email
        email = new JLabel();
        email.setText("Email :  ");
        email.setBounds(10, 100, 150, 50);

        tfEmail = new JTextField();
        tfEmail.setBounds(210, 115, 500, 20);

        //no.telp
        noTelp = new JLabel();
        noTelp.setText("No. Telepon Anda:  ");
        noTelp.setBounds(10, 125, 150, 50);

        tfNoTelp = new JTextField();
        tfNoTelp.setBounds(210, 140, 500, 20);

        //buton Daftar
        buttonDaftar = new JButton("Daftar");
        buttonDaftar.setBounds(50, 215, 80, 30);
        buttonDaftar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputPassword = new String(tfPassword.getPassword());
                String inputCocokPassword = new String(tfCocokPassword.getPassword());
                if (tfEmail.getText().equals("") || tfUsername.getText().equals("") || tfNama.getText().equals("")
                        || tfNoTelp.getText().equals("") || inputPassword.equals("") || inputCocokPassword.equals("") || (!radioUser.isSelected() && !radioTukang.isSelected())) {
                    JOptionPane.showMessageDialog(null, "Data Harus Terisi Semua!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (radioUser.isSelected()) {
                        Customer user = new Customer();
                        user.setUsername(tfUsername.getText());
                        user.setPassword(tfPassword.getText());
                        user.setNama(tfNama.getText());
                        user.setEmail(tfEmail.getText());
                        user.setNoTelp(tfNoTelp.getText());
                        user.setPoinUser(0);
                        user.setSaldoUser(0);
                        DatabaseControl.InsertNewUser(user);

                        JOptionPane.showMessageDialog(null, "Akun telah terbuat!! Silahkan Login", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(false);
                        new MenuLogin();
                    } else if (radioTukang.isSelected()) {
                        if (!radioShoes.isSelected() && !radioHomeCleaning.isSelected() && !radioLaundry.isSelected()) {
                            JOptionPane.showMessageDialog(null, "pilih salah satu kategori!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Tukang tukang = new Tukang();
                            tukang.setUsername(tfUsername.getText());
                            tukang.setPassword(tfPassword.getText());
                            tukang.setNama(tfNama.getText());
                            tukang.setEmail(tfEmail.getText());
                            tukang.setNoTelp(tfNoTelp.getText());
                            tukang.setStatus("Requested");
                            tukang.setSaldo(0);
                            if (radioShoes.isSelected()) {
                                tukang.setKategori(radioShoes.getText());
                            } else if (radioLaundry.isSelected()) {
                                tukang.setKategori(radioLaundry.getText());
                            } else if (radioHomeCleaning.isSelected()) {
                                tukang.setKategori(radioHomeCleaning.getText());
                            }
                            DatabaseControl.InsertNewTukang(tukang);

                            JOptionPane.showMessageDialog(null, "Akun telah terbuat!! Silahkan Login", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                            frame.setVisible(false);
                            new MenuLogin();
                        }
                    }
                }
            }
        });

        buttonBackToMainMenu = new JButton("Main Menu");
        buttonBackToMainMenu.setBounds(200, 215, 100, 30);
        buttonBackToMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MainMenu();
            }
        });

        //pilih akun
        radioUser = new JRadioButton("Register as User");
        radioTukang = new JRadioButton("Register as Tukang");
        radioUser.setBounds(70, 165, 150, 35);
        radioTukang.setBounds(270, 165, 150, 35);
        radioShoes = new JRadioButton("Shoes And Care");
        radioLaundry = new JRadioButton("Laundry");
        radioHomeCleaning = new JRadioButton("Home Cleaning");
        radioShoes.setBounds(70, 190, 150, 35);
        radioLaundry.setBounds(270, 190, 150, 35);
        radioHomeCleaning.setBounds(470, 190, 150, 35);
        buttonDaftar.setBounds(50, 240, 80, 30);
        buttonBackToMainMenu.setBounds(200, 240, 100, 30);
        bg2 = new ButtonGroup();
        bg2.add(radioShoes);
        radioShoes.setVisible(false);
        bg2.add(radioLaundry);
        radioLaundry.setVisible(false);
        bg2.add(radioHomeCleaning);
        radioHomeCleaning.setVisible(false);
        frame.add(radioShoes);
        frame.add(radioLaundry);
        frame.add(radioHomeCleaning);
        radioTukang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                radioLaundry.setVisible(true);
                radioHomeCleaning.setVisible(true);
                radioShoes.setVisible(true);
                buttonDaftar.setBounds(50, 240, 80, 30);
                buttonBackToMainMenu.setBounds(200, 240, 100, 30);
            }
        });
        radioUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radioShoes.isVisible() && radioHomeCleaning.isVisible() && radioLaundry.isVisible()) {
                    radioShoes.setVisible(false);
                    radioLaundry.setVisible(false);
                    radioHomeCleaning.setVisible(false);
                }
                buttonDaftar.setBounds(50, 215, 80, 30);
                buttonBackToMainMenu.setBounds(200, 215, 100, 30);
            }
        });
        bg1 = new ButtonGroup();
        bg1.add(radioUser);
        bg1.add(radioTukang);

        frame.add(radioUser);
        frame.add(radioTukang);
        frame.add(buttonBackToMainMenu);
        frame.add(buttonDaftar);
        frame.add(username);
        frame.add(email);
        frame.add(tfEmail);
        frame.add(tfUsername);
        frame.add(password);
        frame.add(tfPassword);
        frame.add(cocokPassword);
        frame.add(tfCocokPassword);
        frame.add(nama);
        frame.add(tfNama);
        frame.add(noTelp);
        frame.add(tfNoTelp);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}
