/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.TukangManager;
import Model.Pesanan;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author HP
 */
public class PesananCustomer extends JFrame {

    JFrame frame;
    JList<String> JListPesanan;
    JScrollPane sc;
    JPanel panel;
    String pesananTerpilih = "";
    JButton button_acc, buttonBack;
    int id_order;
    ArrayList<Pesanan> listPesanan = new ArrayList<>();
    public PesananCustomer() {
        setTitle("List Tugas");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        seeList();
        setVisible(true);
    }

    private void seeList() {
        Action action = new Action();
        ListEvent le = new ListEvent();
        listPesanan = DatabaseControl.getPesanan(TukangManager.getInstance().getTukang().getIdTukang());
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (int i = 0; i < listPesanan.size(); i++) {
            lm.addElement("Nama Pemesan = " + listPesanan.get(i).getNamaPemesan() + " => Alamat = " + listPesanan.get(i).getAlamat());
        }
        JListPesanan = new JList<>(lm);
        JListPesanan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JListPesanan.addListSelectionListener(le);

        sc = new JScrollPane(JListPesanan);
        getContentPane().add(sc);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        button_acc = new JButton("Accept");
        button_acc.setPreferredSize(new Dimension(150, 30));
        button_acc.addActionListener(action);
        panel.add(button_acc);
        buttonBack = new JButton("Back");
        buttonBack.setPreferredSize(new Dimension(150, 30));
        buttonBack.addActionListener(action);
        panel.add(buttonBack);
        
        getContentPane().add(panel, "South");
    }

    class ListEvent implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (JListPesanan.getSelectedIndex() > -1) {
                id_order = listPesanan.get(JListPesanan.getSelectedIndex()).getIdorder();
                pesananTerpilih = JListPesanan.getSelectedValue();
            }
        }

    }
    
    class Action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch(command){
                case"Accept":
                    if(pesananTerpilih.equals("")){
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if(DatabaseControl.updatePesananTukang(id_order)){
                            JOptionPane.showMessageDialog(null, "Tugas kamu CELECAI!!!");
                            setVisible(false);
                            new MenuTukang();
                        }
                    }
                    break;
                case"Back":
                    setVisible(false);
                    new MenuTukang();
                default:
                    break;
            }
        }
        
    }
}
