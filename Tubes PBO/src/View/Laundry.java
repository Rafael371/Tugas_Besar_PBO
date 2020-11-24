/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Garis;
import Controller.PesananManager;
import Model.Pesanan;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author HP
 */
public class Laundry extends JFrame {
    JFrame frame;
    JLabel labelRegular, labelTanggal, labelJam, labelPaket, labelbasabasi;
    JButton buttonPesan, buttonBack, buttonLogout;
    JTextField tfRegular;
    
    public Laundry() {
        frame = new JFrame("Laundry");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        labelPaket = new JLabel("Paket");
        labelPaket.setBounds(260, 60, 100, 30);
        labelPaket.setFont(new Font(labelPaket.getFont().getName(), labelPaket.getFont().getStyle(), 18));
        labelRegular = new JLabel("Regular");
        labelRegular.setBounds(50, 60, 100, 30);
        labelRegular.setFont(new Font(labelRegular.getFont().getName(), labelRegular.getFont().getStyle(), 18));
        labelbasabasi = new JLabel("Kilo = ");
        labelbasabasi.setBounds(20, 120, 50, 30);
        labelTanggal = new JLabel(getTanggal());
        labelTanggal.setBounds(5, 10, 100, 30);
        labelTanggal.setFont(new Font(labelTanggal.getFont().getName(), labelTanggal.getFont().getStyle(), 18));
        labelJam = new JLabel(getWaktu());
        labelJam.setBounds(300, 10, 100, 30);
        labelJam.setFont(new Font(labelJam.getFont().getName(), labelJam.getFont().getStyle(), 18));
        
        tfRegular = new JTextField();
        tfRegular.setBounds(70, 125, 100, 20);
        buttonPesan = new JButton("Pesan");
        buttonPesan.setBounds(58, 200, 80, 20);
        buttonPesan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String alamat = JOptionPane.showInputDialog("Masukkan Alamat Lengkap Anda");
                Pesanan pesanan = new Pesanan();
                PesananManager.getInstance().setPesanan(pesanan);
                PesananManager.getInstance().getPesanan().setJumlah(Integer.parseInt(tfRegular.getText()));
                PesananManager.getInstance().getPesanan().setAlamat(alamat);
                PesananManager.getInstance().getPesanan().setPaket(false);
                PesananManager.getInstance().getPesanan().setRegular(true);
                frame.setVisible(false);
                
                new LaundryFinder();
            }
        });
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(50, 290, 100, 30);
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuSewa();
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
        Garis garis = new Garis();
        
        frame.add(labelbasabasi);
        frame.add(labelPaket);
        frame.add(buttonPesan);
        frame.add(buttonBack);
        frame.add(buttonLogout);
        frame.add(tfRegular);
        frame.add(labelRegular);
        frame.add(labelTanggal);
        frame.add(labelJam);
        frame.add(garis);
        frame.setVisible(true);
        
        new Thread(){
            public void run(){
                while(true){
                    String waktu = getWaktu();
                    labelJam.setText(waktu);
                }
            }
        }.start();
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
    public String getWaktu() {
        Calendar now = Calendar.getInstance();
        String detik, menit, jam;
        if(now.get(Calendar.HOUR) < 10){
            jam = "0" + String.valueOf(now.get(Calendar.HOUR));
        }else{
            jam = String.valueOf(now.get(Calendar.HOUR));
        }
        if(now.get(Calendar.MINUTE) < 10){
            menit = "0" + String.valueOf(now.get(Calendar.MINUTE));
        }else{
            menit = String.valueOf(now.get(Calendar.MINUTE));
        }
        if(now.get(Calendar.SECOND) < 10){
            detik = "0" + String.valueOf(now.get(Calendar.SECOND));
        }else{
            detik = String.valueOf(now.get(Calendar.SECOND));
        }
        String waktu = jam + ":" + menit + ":" + detik;
        return waktu;
    }
}
