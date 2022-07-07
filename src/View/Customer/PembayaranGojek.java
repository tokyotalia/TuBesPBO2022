
package View.Customer;

import Controller.CustomerManager;
import View.Customer.MenuGojek;
import Controller.DatabaseControl;
import Controller.PesananManager;
import Controller.PesananOjekManager;
import Model.Driver;
import Model.StatusDriver;
//import View.Customer.CustomerScreen;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class PembayaranGojek implements ActionListener{
    private JFrame framepembayarangojek = new JFrame();
    private JLabel labelnamapemesan, labelalamatjemput, labelalamattujuan,labeljarak, labeltotalharga,
            labelisinamapemesan, labelisialamatjemput, labelisialamattujuan, labelisijarak, labelisitotalharga,
            labelmetodepembayaran ,labeljudul;
    private JComboBox cBmetodepembayaran;
    private JButton buttonBack, buttonSubmit, buttonCancel;
    private int jarak;  
    private int totalharga;
    
    public PembayaranGojek(){
        framepembayarangojek.setSize(900,600);
        framepembayarangojek.setLocationRelativeTo(null);
        framepembayarangojek.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Label
        labeljudul = new JLabel("PEMBAYARAN OJEK");
        labeljudul.setBounds(300,20,300,50);
        labeljudul.setFont(new Font(labeljudul.getFont().getName(), labeljudul.getFont().getStyle(), 28));
        
        labelnamapemesan = new JLabel("Nama Pemesan: ");
        labelnamapemesan.setBounds(20,80,100,50);             
        
        labelalamatjemput = new JLabel("Alamat Penjemputan: ");
        labelalamatjemput.setBounds(20,100,150,50);
                
        labelalamattujuan= new JLabel("Alamat Tujuan: ");        
        labelalamattujuan.setBounds(20,150,100,50);
        
        labeljarak = new JLabel("Jarak : ");
        labeljarak.setBounds(20,200,100,50);
        
        labeltotalharga = new JLabel("Total Harga: ");
        labeltotalharga.setBounds(20,250,100,50);
        
        labelmetodepembayaran = new JLabel("Pilih Metode Pembayarannya: ");
        labelmetodepembayaran.setBounds(20,300,170,50);

        
        labelisinamapemesan = new JLabel(PesananManager.getInstance().getPesanan().getCustomer().getNama());
        labelisinamapemesan.setBounds(230,80,300,50);
        
        labelisialamatjemput = new JLabel(PesananOjekManager.getInstance().getPesananojek().getAlamat_Penjemputan());
        labelisialamatjemput.setBounds(230,100,300,50);
        
        labelisialamattujuan = new JLabel(PesananOjekManager.getInstance().getPesananojek().getAlamat_Destinasi());
        labelisialamattujuan.setBounds(230,150,300,50);
        
        Random angkarandom = new Random();
        jarak = angkarandom.nextInt(10) + 1;
        labelisijarak = new JLabel(jarak + "KM");
        labelisijarak.setBounds(230,200,300,50);
        
        int harga = 0;
        if(PesananOjekManager.getInstance().getPesananojek().getJenisKendaraan().equals("Motor")){
            harga = 3500;
        }else if(PesananOjekManager.getInstance().getPesananojek().getJenisKendaraan().equals("Mobil")){
            harga = 5000;
        }
        totalharga = harga * jarak;
        labelisitotalharga = new JLabel(Integer.toString(totalharga));
        labelisitotalharga.setBounds(230,250,300,50);
        
        
        //Combo Box
        String metodepembayaran[] = {"Up-Pay","Tunai"};
        cBmetodepembayaran = new JComboBox(metodepembayaran);
        cBmetodepembayaran.setBounds(230,300,170,50);
        

        //Button
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(100,400,100,50);
        buttonSubmit.addActionListener(this);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(300,400,100,50);
        buttonBack.addActionListener(this);
        
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(500,400,100,50);
        buttonCancel.addActionListener(this);
        
        framepembayarangojek.add(labeljudul);
        framepembayarangojek.add(labelnamapemesan);
        framepembayarangojek.add(labelalamatjemput);
        framepembayarangojek.add(labelalamattujuan);
        framepembayarangojek.add(labeljarak);
        framepembayarangojek.add(labeltotalharga);
        framepembayarangojek.add(labelmetodepembayaran);
        framepembayarangojek.add(labelisinamapemesan);
        framepembayarangojek.add(labelisialamatjemput);
        framepembayarangojek.add(labelisialamattujuan);
        framepembayarangojek.add(labelisijarak);
        framepembayarangojek.add(labelisitotalharga);
        framepembayarangojek.add(cBmetodepembayaran);
        framepembayarangojek.add(buttonBack);
        framepembayarangojek.add(buttonSubmit);
        framepembayarangojek.add(buttonCancel);
        
        framepembayarangojek.setLayout(null);
        framepembayarangojek.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Submit":
                if((cBmetodepembayaran.getItemAt(cBmetodepembayaran.getSelectedIndex()).equals("Tunai")) || (CustomerManager.getInstance().getCustomer().getSaldoUp() >= totalharga)){
                    PesananManager.getInstance().getPesanan().setMetodepembayaran((String) cBmetodepembayaran.getItemAt(cBmetodepembayaran.getSelectedIndex()));
                    PesananManager.getInstance().getPesanan().setTotalharga(totalharga);
                    Date date = new Date();
                    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
                    String tanggal = s.format(date);
                    PesananManager.getInstance().getPesanan().setTanggalpemesanan(tanggal);
                    DatabaseControl ctrl = new DatabaseControl();
                
                    ArrayList<Driver> listDriver = new ArrayList<>();
                    Driver driver = new Driver();
                    listDriver = ctrl.getAllDriver();
                    boolean cek = false;
                
                    for(int i = 0; i < listDriver.size(); i++){
                        if(listDriver.get(i).getStatus().equals(StatusDriver.AVAILABLE) && listDriver.get(i).getJeniskendaraan().equals(PesananOjekManager.getInstance().getPesananojek().getJenisKendaraan())){
                            cek = true;
                            driver = listDriver.get(i);
                            driver.setStatus(StatusDriver.TAKEN);
                            break;
                        }
                    }
                    if(cek){
                        if(cBmetodepembayaran.getItemAt(cBmetodepembayaran.getSelectedIndex()).equals("Up-Pay")){
                            CustomerManager.getInstance().getCustomer().setSaldoUp(CustomerManager.getInstance().getCustomer().getSaldoUp() - totalharga);
                        }
                        
                        ctrl.updateStatusDriver(StatusDriver.TAKEN.name(), driver.getId_driver());
                        
                        PesananManager.getInstance().getPesanan().setDriver(driver);
                
                        ctrl.insertNewPesanan(PesananManager.getInstance().getPesanan());
                
                        PesananOjekManager.getInstance().getPesananojek().setId_pesanan(ctrl.getPesananTerbaru().getId_pesanan());
                
                        ctrl.insertNewPesananOjek(PesananOjekManager.getInstance().getPesananojek());
                
                        JOptionPane.showMessageDialog(null, "Pemesanan Berhasil!!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Pemesanan Gagal!! Tidak Ada Driver Yang Siap", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Saldo Up-Pay Tidak Cukup!!, Silahkan memakai Tunai atau Top Up terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
                }
                framepembayarangojek.setVisible(false);
//                new CustomerScreen();
                
            break;
            case "Back":
                framepembayarangojek.setVisible(false);
                new MenuGojek();
            break;
            case "Cancel":
                framepembayarangojek.setVisible(false);
//                new CustomerScreen();
        }
    }
    
}
