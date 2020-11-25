/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.PesananManager;
import Controller.TukangManager;
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
public class MenuPembayaran {
    JFrame frame;
    private JLabel labelMenuPembayaran, labelNamaCust, labelNamaTukang, labelAlamat, labelKategori, labelPaket, labelRegular, labelJam, labelDiskon, labelTotalHarga;
    private JLabel labelIsiNamaCust, labelIsiNamaTukang, labelIsiAlamat, labelIsiKategori, labelIsi, labelIsiJam, labelIsiDiskon, labelIsiTotalHarga;
    private JButton buttonSelesai;
    private int totalHarga;
    private int tukarPoin=100;
    public MenuPembayaran(){
        frame = new JFrame("Payment");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labelMenuPembayaran = new JLabel("Menu Pembayaran");
        labelMenuPembayaran.setBounds(150, 10, 150, 20);
        labelNamaCust = new JLabel("Nama Customer");
        labelNamaCust.setBounds(20, 40, 100, 20);
        labelIsiNamaCust = new JLabel(CustomerManager.getInstance().getCustomer().getNama());
        labelIsiNamaCust.setBounds(250, 40, 100, 20);
        labelNamaTukang = new JLabel("Nama Tukang");
        labelNamaTukang.setBounds(20, 70, 100, 20);
        labelIsiNamaTukang = new JLabel(TukangManager.getInstance().getTukang().getNama());
        labelIsiNamaTukang.setBounds(250, 70, 100, 20);
        labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(20, 100, 100, 20);
        labelIsiAlamat = new JLabel(PesananManager.getInstance().getPesanan().getAlamat());
        labelIsiAlamat.setBounds(250, 100, 100, 20);
        labelKategori = new JLabel("Kategori");
        labelKategori.setBounds(20, 130, 100, 20);
        labelIsiKategori = new JLabel(TukangManager.getInstance().getTukang().getKategori());
        labelIsiKategori.setBounds(250, 130, 100, 20);
        labelPaket = new JLabel("Paket");
        labelRegular = new JLabel("Regular");
        labelTotalHarga = new JLabel("Total Harga");
        labelJam = new JLabel("Lama Pengerjaan");
        
        switch(TukangManager.getInstance().getTukang().getKategori()){
            case "Home Cleaning":
                if(PesananManager.getInstance().getPesanan().getPaket()){
                    labelPaket.setBounds(20, 160, 100, 20);
                    labelIsi = new JLabel("Paket " + PesananManager.getInstance().getPesanan().getJumlah() + " Ruangan");
                    labelIsi.setBounds(250, 160, 100, 20);
                    labelJam.setBounds(20, 190, 100, 20);
                    labelIsiJam = new JLabel(PesananManager.getInstance().getPesanan().getLama() + " Jam");
                    labelIsiJam.setBounds(250, 190, 100, 20);
                    labelDiskon = new JLabel("Diskon");
                    labelDiskon.setBounds(20, 220, 100, 20);
                    labelIsiDiskon = new JLabel(PesananManager.getInstance().getPesanan().getDiskon() + "%");
                    labelIsiDiskon.setBounds(250, 220, 100, 20);
                    totalHarga = (PesananManager.getInstance().getPesanan().getJumlah() * 50000) + (PesananManager.getInstance().getPesanan().getLama() * 10000);
                    totalHarga = totalHarga - (totalHarga * (PesananManager.getInstance().getPesanan().getDiskon() / 100));
                    
                    labelTotalHarga.setBounds(20, 250, 100, 20);
                    labelIsiTotalHarga = new JLabel("Rp. " + String.valueOf(totalHarga));
                    labelIsiTotalHarga.setBounds(250, 250, 100, 20);
                    
                    frame.add(labelPaket);
                    frame.add(labelIsi);
                    frame.add(labelJam);
                    frame.add(labelIsiJam);
                    frame.add(labelDiskon);
                    frame.add(labelIsiDiskon);
                    frame.add(labelTotalHarga);
                    frame.add(labelIsiTotalHarga);
                }else if(PesananManager.getInstance().getPesanan().getRegular()){
                    labelRegular.setBounds(20, 160, 100, 20);
                    labelIsi = new JLabel(PesananManager.getInstance().getPesanan().getJumlah() + " Ruangan");
                    labelIsi.setBounds(250, 160, 100, 20);
                    labelJam.setBounds(20, 190, 100, 20);
                    labelIsiJam = new JLabel(PesananManager.getInstance().getPesanan().getLama() + " Jam");
                    labelIsiJam.setBounds(250, 190, 100, 20);
                    totalHarga = (PesananManager.getInstance().getPesanan().getJumlah() * 50000) + (PesananManager.getInstance().getPesanan().getLama() * 10000);
                    labelTotalHarga.setBounds(20, 250, 100, 20);
                    labelIsiTotalHarga = new JLabel("Rp. " + String.valueOf(totalHarga));
                    labelIsiTotalHarga.setBounds(250, 250, 100, 20);
                    
                    frame.add(labelRegular);
                    frame.add(labelIsi);
                    frame.add(labelJam);
                    frame.add(labelIsiJam);
                    frame.add(labelTotalHarga);
                    frame.add(labelIsiTotalHarga);
                }
                break;
            case "Laundry":
                labelRegular.setBounds(20, 160, 100, 20);
                labelIsi = new JLabel(PesananManager.getInstance().getPesanan().getJumlah() + " kilo");
                labelIsi.setBounds(250, 160, 100, 20);
                
                totalHarga = (PesananManager.getInstance().getPesanan().getJumlah() * 10000);
                labelTotalHarga.setBounds(20, 250, 100, 20);
                labelIsiTotalHarga = new JLabel("Rp. " + String.valueOf(totalHarga));
                labelIsiTotalHarga.setBounds(250, 250, 100, 20);
                    
                frame.add(labelRegular);
                frame.add(labelIsi);
                frame.add(labelTotalHarga);
                frame.add(labelIsiTotalHarga);
                break;
            case "Shoes And Care":
                labelRegular.setBounds(20, 160, 100, 20);
                labelIsi = new JLabel(PesananManager.getInstance().getPesanan().getJumlah() + " pasang sepatu");
                labelIsi.setBounds(250, 160, 100, 20);
                
                totalHarga = (PesananManager.getInstance().getPesanan().getJumlah() * 45000);
                labelTotalHarga.setBounds(20, 250, 100, 20);
                labelIsiTotalHarga = new JLabel("Rp. " + String.valueOf(totalHarga));
                labelIsiTotalHarga.setBounds(250, 250, 100, 20);
                    
                frame.add(labelRegular);
                frame.add(labelIsi);
                frame.add(labelTotalHarga);
                frame.add(labelIsiTotalHarga);
                break;
        }
        
        buttonSelesai = new JButton("Selesai");
        buttonSelesai.setBounds(150, 280, 100, 20);
        buttonSelesai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int banyakPoinUser=CustomerManager.getInstance().getCustomer().getPoinUser();
                if(banyakPoinUser >= 100){
                    int jawab = JOptionPane.showConfirmDialog(null, "ingin menggunakan poin? poin anda " + banyakPoinUser, "Tukar Poin", JOptionPane.YES_NO_OPTION);
                    if(jawab == JOptionPane.YES_OPTION){
                        CustomerManager.getInstance().getCustomer().setPoinUser(CustomerManager.getInstance().getCustomer().getPoinUser()-100);
                        totalHarga=totalHarga*0;
                    }
                }
                CustomerManager.getInstance().getCustomer().setSaldoUser(CustomerManager.getInstance().getCustomer().getSaldoUser() - totalHarga);
                PesananManager.getInstance().getPesanan().setTotalHarga(totalHarga);
                JOptionPane.showMessageDialog(null, "Saldo Anda Telah Dipotong!!\nTerima Kasih Telah Menggunakan Jasa Kami!!");
                CustomerManager.getInstance().getCustomer().setPoinUser(CustomerManager.getInstance().getCustomer().getPoinUser() + 1);
                TukangManager.getInstance().getTukang().setStatus("Ready");
                double totalPendapatan = TukangManager.getInstance().getTukang().getSaldo()+(totalHarga-(totalHarga*0.3));
                double pendapatanAdmin = totalHarga*0.3;
                DatabaseControl.updateSaldoAdmin(pendapatanAdmin);
                //System.out.println(totalPendapatan);
                TukangManager.getInstance().getTukang().setSaldo(totalPendapatan);
                
                DatabaseControl.InsertNewPesanan(PesananManager.getInstance().getPesanan());
                frame.setVisible(false);
                DatabaseControl.updateTukang(TukangManager.getInstance().getTukang());
                new MenuCustomer();
            }

        });
        frame.add(labelMenuPembayaran);
        frame.add(labelNamaCust);
        frame.add(labelIsiNamaCust);
        frame.add(labelNamaTukang);
        frame.add(labelIsiNamaTukang);
        frame.add(labelAlamat);
        frame.add(labelIsiAlamat);
        frame.add(labelKategori);
        frame.add(labelIsiKategori);
        frame.add(buttonSelesai);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
