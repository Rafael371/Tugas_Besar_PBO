/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class MenuTransaksi {
    JFrame frame;
    JLabel labelNominal, labelVA, labelTanggal, labelTransaksi, labelGambar;
    JLabel labelIsiNominal, labelIsiVA, labelIsiTanggal;
    JButton buttonSelesai, buttonBack, buttonLogout;
    public MenuTransaksi(int saldo){
        frame = new JFrame("Clean and Care");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelGambar = new JLabel("");
        labelGambar.setIcon(new ImageIcon("src/image/asd.jpg"));
        labelGambar.setBounds(30, 190, 300, 100);
        
        labelTransaksi = new JLabel("Transaksi");
        labelTransaksi.setBounds(150, 20, 100, 20);
        labelTransaksi.setFont(new Font(labelTransaksi.getFont().getName(), labelTransaksi.getFont().getStyle(), 18));
        labelNominal = new JLabel("Nominal Saldo");
        labelNominal.setBounds(30, 50, 100, 20);
        labelNominal.setFont(new Font(labelNominal.getFont().getName(), labelNominal.getFont().getStyle(), 13));
        labelIsiNominal = new JLabel("Rp. " + String.valueOf(saldo));
        labelIsiNominal.setBounds(260, 50, 100, 20);
        labelIsiNominal.setFont(new Font(labelIsiNominal.getFont().getName(), labelIsiNominal.getFont().getStyle(), 13));
        labelVA = new JLabel("BCA VIRTUAL ACCOUNT");
        labelVA.setBounds(80, 80, 300, 20);
        labelVA.setFont(new Font(labelVA.getFont().getName(), labelVA.getFont().getStyle(), 18));
        labelIsiVA = new JLabel("4564954486165");
        labelIsiVA.setBounds(130, 120, 150, 20);
        labelIsiVA.setFont(new Font(labelIsiVA.getFont().getName(), labelIsiVA.getFont().getStyle(), 18));
        labelTanggal = new JLabel("Tanggal Pembelian");
        labelTanggal.setBounds(30, 160, 150, 20);
        labelTanggal.setFont(new Font(labelTanggal.getFont().getName(), labelTanggal.getFont().getStyle(), 13));
        labelIsiTanggal = new JLabel(getTanggal());
        labelIsiTanggal.setBounds(260, 160, 150, 20);
        labelIsiTanggal.setFont(new Font(labelIsiTanggal.getFont().getName(), labelIsiTanggal.getFont().getStyle(), 13));
        
        buttonSelesai = new JButton("Selesai");
        buttonSelesai.setBounds(140, 300, 100, 30);
        buttonSelesai.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CustomerManager.getInstance().getCustomer().setSaldoUser(CustomerManager.getInstance().getCustomer().getSaldoUser() + saldo);
                JOptionPane.showMessageDialog(null, "Terima Kasih Telah Melakukan Top Up!!!");
                frame.setVisible(false);
                new MenuCustomer();
            }
        });
        buttonBack = new JButton("Back");
        buttonBack.setBounds(30, 290, 100, 30);
        buttonBack.addActionListener(new ActionListener(){
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
        
        frame.add(labelGambar);
        frame.add(labelTransaksi);
        frame.add(labelNominal);
        frame.add(labelIsiNominal);
        frame.add(labelVA);
        frame.add(labelIsiVA);
        frame.add(labelTanggal);
        frame.add(labelIsiTanggal);
        frame.add(buttonSelesai);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public String getTanggal() {
        Calendar now = Calendar.getInstance();
        String tanggal, bulan, tahun;
        tahun = String.valueOf(now.get(Calendar.YEAR));
            
        bulan = String.valueOf(1+now.get(Calendar.MONTH));
        if(Integer.parseInt(bulan) > 12){
            bulan = "01";
        }else if(now.get(Calendar.MONTH) < 10){
            bulan = "0" + bulan;
        }else{
            bulan = bulan;
        }
        if(now.get(Calendar.DATE) < 10){
            tanggal = "0" + String.valueOf(now.get(Calendar.DATE));
        }else{
            tanggal = String.valueOf(now.get(Calendar.DATE));
        }
        String tgl = tanggal + "-" + bulan + "-" + tahun;
        
        return tgl;
    }
}
