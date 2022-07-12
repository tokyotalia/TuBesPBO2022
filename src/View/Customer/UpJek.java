
package View.Customer;

import Controller.CustomerManager;
import Controller.PesananManager;
import Controller.PesananOjekManager;
import Model.Pesanan;
import Model.PesananOjek;
import View.Customer.CustomerScreen;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UpJek implements ActionListener{
    private JFrame frame = new JFrame();
    private JLabel labelalamatjemput, labelalamattujuan, labeljeniskendaraan,labeljudul;
    private JTextField fieldalamatjemput, fieldalamattujuan;
    private JComboBox cBjeniskendaraan;
    private JButton buttonBack, buttonSubmit, buttonGPS;
    
    public UpJek(){
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Label
        labeljudul = new JLabel("OJEK ONLINE");
        labeljudul.setBounds(300,20,300,50);
        labeljudul.setFont(new Font(labeljudul.getFont().getName(), labeljudul.getFont().getStyle(), 28));
        
        labelalamatjemput = new JLabel("Silahkan Masukkan Alamat Penjemputan: ");
        labelalamatjemput.setBounds(20,100,300,50);
                
        labelalamattujuan = new JLabel("Silahkan Masukkan Alamat Tujuan: ");
        labelalamattujuan.setBounds(20,160,300,50);
                
        labeljeniskendaraan = new JLabel("Pilih Jenis Kendaraan: ");
        labeljeniskendaraan.setBounds(20,220,300,50);
        
        // Text Field
        fieldalamatjemput = new JTextField();
        fieldalamatjemput.setBounds(280,100,300,50);
                
        fieldalamattujuan = new JTextField();
        fieldalamattujuan.setBounds(280,160,300,50);
        
        String jeniskendaraan[] = {"Motor","Mobil"};
        //Combo Box
        cBjeniskendaraan = new JComboBox(jeniskendaraan);
        cBjeniskendaraan.setBounds(280,220,300,50);
        
        //Button
        buttonBack = new JButton("Back");
        buttonBack.setBounds(400,300,100,50);
        buttonBack.addActionListener(this);
        
        buttonSubmit = new JButton("Submit");
        buttonSubmit.setBounds(200,300,100,50);
        buttonSubmit.addActionListener(this);
        
        buttonGPS = new JButton("Alamat Pribadi");
        buttonGPS.setBounds(600,100,200,50);
        buttonGPS.addActionListener(this);
        
        frame.add(labeljudul);
        frame.add(labelalamatjemput);
        frame.add(labelalamattujuan);
        frame.add(labeljeniskendaraan);
        frame.add(fieldalamatjemput);
        frame.add(fieldalamattujuan);
        frame.add(cBjeniskendaraan);
        frame.add(buttonBack);
        frame.add(buttonSubmit);
        frame.add(buttonGPS);
       
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Submit":
                PesananOjek pesananojek = new PesananOjek();
                Pesanan pesanan = new PesananOjek();
                pesananojek.setAlamat_Penjemputan(fieldalamatjemput.getText());
                pesananojek.setAlamat_Destinasi(fieldalamattujuan.getText());
                pesanan.setCustomer(CustomerManager.getInstance().getCustomer());
                pesananojek.setJenisKendaraan((String) cBjeniskendaraan.getItemAt(cBjeniskendaraan.getSelectedIndex()));
                PesananManager.getInstance().setPesanan(pesanan);
                PesananOjekManager.getInstance().setPesananojek(pesananojek);
                frame.setVisible(false);
                new PembayaranGojek();
            break;
            case "Back":
                new CustomerScreen();
            break;
            case "Alamat Pribadi":
                fieldalamatjemput.setText(CustomerManager.getInstance().getCustomer().getAlamat());
            break;
        }
    }
}
