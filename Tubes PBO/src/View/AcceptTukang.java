/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.Interface;
import Controller.TukangManager;
import Model.Pesanan;
import Model.Tukang;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class AcceptTukang extends JFrame implements Interface {

    JFrame frame;
    JList<String> JListTukang;
    JScrollPane sc;
    JPanel panel;
    String pesananTerpilih = "";
    JButton button_acc, buttonBack;
    int id_Tukang;
    ArrayList<Tukang> listTukang = new ArrayList<>();

    public AcceptTukang() {
        setTitle("List Tukang");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        seeList();
        setVisible(true);
    }

    private void seeList() {
        Action action = new Action();
        ListEvent le = new ListEvent();
        listTukang = DatabaseControl.getReqTukang();
        DefaultListModel<String> lm = new DefaultListModel<>();
        for (int i = 0; i < listTukang.size(); i++) {
            lm.addElement("Nama Tukang= " + listTukang.get(i).getNama() + " => kategori = " + listTukang.get(i).getKategori() + " => no=" + listTukang.get(i).getNoTelp());
        }

        JListTukang = new JList<>(lm);
        JListTukang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JListTukang.addListSelectionListener(le);

        sc = new JScrollPane(JListTukang);
        getContentPane().add(sc);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        button_acc = new JButton("Accept");
        button_acc.setPreferredSize(new Dimension(150, 30));
        button_acc.addActionListener(action);
        buttonBack = new JButton("Back");
        buttonBack.setPreferredSize(new Dimension(150, 30));
        buttonBack.addActionListener(action);
        panel.add(button_acc);
        panel.add(buttonBack);

        getContentPane().add(panel, "South");
    }

    class ListEvent implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if (JListTukang.getSelectedIndex() > -1) {
                id_Tukang = listTukang.get(JListTukang.getSelectedIndex()).getIdTukang();
                pesananTerpilih = JListTukang.getSelectedValue();
            }
        }

    }

    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "Accept":
                    if (pesananTerpilih.equals("")) {
                        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        System.out.println(id_Tukang);
                        if (DatabaseControl.updateAcceptTukang(id_Tukang)) {
                            JOptionPane.showMessageDialog(null, "Tukang Telah Diterima!!");
                            setVisible(false);
                            new MenuAdmin();
                        }
                    }
                    break;
                case "Back":
                    setVisible(false);
                    new MenuAdmin();
                default:
                    break;
            }
        }

    }
}
