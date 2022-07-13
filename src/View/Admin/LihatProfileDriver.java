
package View.Admin;

import Controller.DatabaseControl;
import Controller.DriverManager;
import Model.Driver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LihatProfileDriver extends JFrame implements ActionListener{

    private JFrame frame;
    private JLabel labeljudul, labelnamadriver, labeljeniskendaraan, labelplatno, labelsaldo, labelpendapatan,
            labelisinama, labelisijeniskendaraan, labelisiplatno, labelisisaldo, labelisipendapatan, labelstatus, labelisistatus;
    private JButton backbutton, lihatriwayatbutton;
    int x;
    
    public LihatProfileDriver(int id){
        DatabaseControl ctrl = new DatabaseControl();
        Driver driver = new Driver();
        driver = ctrl.getDriverByIdDriver(id);
        x = id;
        frame = new JFrame("Driver Screen");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Data Driver ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        labelnamadriver = new JLabel("Nama Driver ");
        labelnamadriver.setBounds(45,50,100,30);
        
        labelisinama = new JLabel(driver.getNama());
        labelisinama.setBounds(150,50,100,30);
        
        labeljeniskendaraan = new JLabel("Kendaraan");
        labeljeniskendaraan.setBounds(45,100,100,30);
        
        labelisijeniskendaraan = new JLabel(driver.getJeniskendaraan());
        labelisijeniskendaraan.setBounds(150,100,100,30);
        
        labelplatno = new JLabel("Plat Nomor");
        labelplatno.setBounds(45,150,100,30);
        
        labelisiplatno = new JLabel(driver.getPlatnomor());
        labelisiplatno.setBounds(150,150,100,30);
        
        labelsaldo = new JLabel("Saldo Up-Pay");
        labelsaldo.setBounds(45,200,100,30);
        
        labelisisaldo = new JLabel("Rp. " + driver.getSaldoUp() + ",-");
        labelisisaldo.setBounds(150,200,100,30);
        
        labelpendapatan = new JLabel("Pendapatan");
        labelpendapatan.setBounds(45,250,100,30);
        
        labelisipendapatan = new JLabel("Rp. " + driver.getPendapatan() + ",-");
        labelisipendapatan.setBounds(150,250,100,30);
        
        labelstatus = new JLabel("Status");
        labelstatus.setBounds(45,300,100,30);
        
        labelisistatus = new JLabel(driver.getStatus().name());
        labelisistatus.setBounds(150,300,100,30);
        
        backbutton = new JButton("Back");
        backbutton.addActionListener(this);
        backbutton.setBounds(250,400,100,30);
        
        lihatriwayatbutton = new JButton("Lihat Riwayat");
        lihatriwayatbutton.addActionListener(this);
        lihatriwayatbutton.setBounds(45,400,200,30);
        
        frame.add(labeljudul);
        frame.add(labelnamadriver);
        frame.add(labelisinama);
        frame.add(labeljeniskendaraan);
        frame.add(labelisijeniskendaraan);
        frame.add(labelplatno);
        frame.add(labelisiplatno);
        frame.add(labelsaldo);
        frame.add(labelisisaldo);
        frame.add(labelpendapatan);
        frame.add(labelisipendapatan);
        frame.add(backbutton);
        frame.add(lihatriwayatbutton);
        frame.add(labelstatus);
        frame.add(labelisistatus);
        frame.setLayout(null);
        frame.setVisible(true);
        
       }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"Back":
                frame.setVisible(false);
                new AdminScreen();
                break;
            case"Lihat Riwayat":
                new LihatRiwayatDriver(x);
            default:
                break;
        }
    }
}
