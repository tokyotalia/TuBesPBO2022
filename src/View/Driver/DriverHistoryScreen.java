/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Driver;

import Controller.DatabaseControl;
import Controller.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import Model.Pesanan;
import Model.PesananFood;

/**
 *
 * @author Asus
 */
public class DriverHistoryScreen extends JFrame implements ActionListener {

    private JFrame framedata;
    private JTable tabeldata;
    private JScrollPane sp;

    public DriverHistoryScreen() {
        framedata = new JFrame();
        framedata.setSize(600, 400);
        framedata.setLocationRelativeTo(null);
        framedata.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        DatabaseControl ctrl = new DatabaseControl();
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        ArrayList<Pesanan> listPesananDriver = new ArrayList<>();
        listPesanan = ctrl.getAllPesanan();

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

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
