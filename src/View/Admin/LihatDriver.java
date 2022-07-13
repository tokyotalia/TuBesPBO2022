/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import Controller.DatabaseControl;
import Controller.DriverManager;
import Model.Driver;
import Model.Pesanan;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Wilson
 */
public class LihatDriver extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel judul, labelId;
    private JTextField idField;
    private JButton find, cancel;
    
    public LihatDriver(){
        frame = new JFrame("Lihat History Driver");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        judul = new JLabel("Lihat History Driver");
        judul.setBounds(160, 10, 200, 30);
        
        labelId = new JLabel("ID Driver:");
        labelId.setBounds(45, 50, 100, 30);
        
        idField = new JTextField();
        idField.setBounds(130, 50, 200, 30);
        
        find = new JButton("Find");
        find.setBounds(100, 100, 100, 30);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame framedata;
                JTable tabeldata;
                JScrollPane sp;

                framedata = new JFrame();
                framedata.setSize(600, 400);
                framedata.setLocationRelativeTo(null);
                framedata.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                ArrayList<Pesanan> listPesananDriver = new ArrayList<>();
                listPesanan = ctrl.getAllPesananByDriverId(Integer.parseInt(idField.getText()));

                for (int i = 0; i < listPesanan.size(); i++) {
                    if (listPesanan.get(i).getDriver().getId_driver() == DriverManager.getInstance().getDrivers().getId_driver()) {
                        listPesananDriver.add(listPesanan.get(i));
                    }
                }

                    int baris = listPesananDriver.size();
                    int kolom = 8;
                    String data[][] = new String[baris][kolom];

                    for (int i = 0; i < listPesananDriver.size(); i++) {
                        data[i][0] = Integer.toString(listPesananDriver.get(i).getId_pesanan());
                        data[i][1] = listPesananDriver.get(i).getCustomer().getNama();
                        data[i][2] = listPesananDriver.get(i).getMetodepembayaran();
                        data[i][3] = listPesananDriver.get(i).getTanggalpemesanan();
                        data[i][4] = Integer.toString(listPesananDriver.get(i).getTotalharga());
                    }
                    String tabelkolom[] = {"ID", "Nama Pemesan", "Metode Bayar", "Tanggal Pemesanan", "Total Harga"};
                    tabeldata = new JTable(data, tabelkolom);
                    tabeldata.setBounds(1, 1, 300, 300);

                    sp = new JScrollPane(tabeldata); 

                    framedata.add(sp);
                    framedata.setVisible(true);
                }
                });

                cancel = new JButton("Cancel");
                cancel.setBounds(205, 100, 100, 30);
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new AdminScreen();
                    }
                });
        
        frame.add(judul);
        frame.add(labelId);
        frame.add(idField);
        frame.add(find);
        frame.add(cancel);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
    }
}
