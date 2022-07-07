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
public class DriverHistoryScreen extends JFrame implements ActionListener{
    private JFrame framedata = new JFrame();
    private JTable tabeldata;
    private JButton backbutton;
    private JScrollPane sp;

    public DriverHistoryScreen() {
        framedata.setSize(600,400);
        framedata.setLocationRelativeTo(null);
        framedata.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DatabaseControl ctrl = new DatabaseControl();
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        ArrayList<Pesanan> listPesananDriver = new ArrayList<>();
        listPesanan = ctrl.getAllPesanan(); //masuk DB control getAllPesanan
        
        for(int i = 0; i < listPesanan.size(); i++){
            if(listPesanan.get(i).getDriver().getId_driver() == DriverManager.getInstance().getDrivers().getId_driver()){
                listPesananDriver.add(listPesanan.get(i));
            }
        }
        
        int baris = listPesananDriver.size();
        int kolom = 8;
        String data[][] = new String[baris][kolom];
        
        for(int i = 0 ; i < listPesananDriver.size(); i++){
            data[i][0] = Integer.toString(listPesananDriver.get(i).getId_pesanan());
            data[i][1] = listPesananDriver.get(i).getCustomer().getNama();
            data[i][2] = listPesananDriver.get(i).getAlamatAwal();
            data[i][3] = listPesananDriver.get(i).getALamatAkhir();
            data[i][4] = Integer.toString(listPesananDriver.get(i).getJarak());
            data[i][5] = listPesananDriver.get(i).getMetodepembayaran();
            data[i][6] = listPesananDriver.get(i).getTanggalpemesanan();
            data[i][7] = Integer.toString(listPesananDriver.get(i).getTotalharga());
        }
        String tabelkolom[] = {"ID","NamaPemesan","Alamat jemput","Alamat antar","Jarak","Metode Bayar", "Tanggal Pemesanan", "Total Harga"};
        tabeldata = new JTable(data,tabelkolom);
        tabeldata.setBounds(150,200,400,300);
        
        sp = new JScrollPane(tabeldata);
        
        framedata.add(sp);
        //framedata.add(backbutton);
        framedata.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
