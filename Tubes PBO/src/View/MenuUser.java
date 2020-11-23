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
public class MenuUser extends JFrame implements ActionListener{
    JFrame frame;
    JButton buttonOrderRumah, buttonOrderShoes, buttonOrderLaundry, buttonExit ;
    public MenuUser(){
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        buttonOrderRumah = new JButton("Order Bersih Rumah");
        buttonOrderRumah.setBounds(90, 90, 200, 50);
        buttonOrderRumah.addActionListener(this);
        buttonOrderShoes = new JButton("Order Bersih Sepatu");
        buttonOrderShoes.setBounds(90, 150, 200, 50);
        buttonOrderShoes.addActionListener(this);
        buttonOrderLaundry = new JButton("Order laundry");
        buttonOrderLaundry.setBounds(90, 210, 200, 50);
        buttonOrderLaundry.addActionListener(this);
        buttonExit = new JButton("Exit");
        buttonExit.setBounds(140, 270, 100, 50);
        buttonExit.addActionListener(this);
        
        frame.add(buttonOrderRumah);
        frame.add(buttonOrderShoes);
        frame.add(buttonOrderLaundry);
        frame.add(buttonExit);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Order Bersih Rumah":
                frame.setVisible(false);
                new HomeCleaning();
            case "Order Bersih Sepatu":
                frame.setVisible(false);
                new ShoesAndCare();
            case "Order Laundry":
                frame.setVisible(false);
                new Laundry();
            case "Exit":
                frame.setVisible(false);
                new MainMenu();
        }
    }
}
