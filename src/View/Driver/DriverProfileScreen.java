/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Driver;

import Controller.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Mena
 */
public class DriverProfileScreen extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel labeljudul,labelnamadriver,labeljeniskendaraan,labelplatno,labelsaldo,labelpendapatan,
            labelisinama,labelisijeniskendaraan,labelisiplatno,labelisisaldo,labelisipendapatan,labeltariksaldo;
    private JTextField fieldnominal;
    private JButton tariksaldobutton,backbutton,lihatriwayatbutton;
    
    public DriverProfileScreen() {
        frame = new JFrame("Driver Screen");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Data Driver ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        labelnamadriver = new JLabel("Nama Driver ");
        labelnamadriver.setBounds(45,50,100,30);
        
        labelisinama = new JLabel(DriverManager.getInstance().getDrivers().getNamaDriver());
        labelisinama.setBounds(150,50,100,30);
        
        labeljeniskendaraan = new JLabel("Kendaraan");
        labeljeniskendaraan.setBounds(45,100,100,30);
        
        labelisijeniskendaraan = new JLabel(DriverManager.getInstance().getDrivers().getJeniskendaraan());
        labelisijeniskendaraan.setBounds(150,100,100,30);
        
        labelplatno = new JLabel("Plat Nomor");
        labelplatno.setBounds(45,150,100,30);
        
        labelisiplatno = new JLabel(DriverManager.getInstance().getDrivers().getPlatnomor());
        labelisiplatno.setBounds(150,150,100,30);
        
        labelsaldo = new JLabel("Saldo Ovo");
        labelsaldo.setBounds(45,200,100,30);
        
        labelisisaldo = new JLabel("Rp. " + Integer.toString(DriverManager.getInstance().getDrivers().getSaldoUp()) + ",-");
        labelisisaldo.setBounds(150,200,100,30);
        
        labelpendapatan = new JLabel("Pendapatan");
        labelpendapatan.setBounds(45,250,100,30);
        
        labelisipendapatan = new JLabel("Rp. " + Integer.toString(DriverManager.getInstance().getDrivers().getPendapatan()) + ",-");
        labelisipendapatan.setBounds(150,250,100,30);
        
        labeltariksaldo = new JLabel("Nominal");
        labeltariksaldo.setBounds(45,300,100,30);
        
        fieldnominal = new JTextField("");
        fieldnominal.setBounds(150,300,100,30);
        
        tariksaldobutton = new JButton("TarikSaldo");
        tariksaldobutton.addActionListener(this);
        tariksaldobutton.setBounds(70,350,100,30);
        
        backbutton = new JButton("Back");
        backbutton.addActionListener(this);
        backbutton.setBounds(180,350,100,30);
        
        lihatriwayatbutton = new JButton("LihatRiwayat");
        lihatriwayatbutton.addActionListener(this);
        lihatriwayatbutton.setBounds(70,400,200,30);
      
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
        frame.add(labeltariksaldo);
        frame.add(fieldnominal);
        frame.add(tariksaldobutton);
        frame.add(backbutton);
        frame.add(lihatriwayatbutton);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"TarikSaldo":
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin menarik Rp. " + fieldnominal.getText() + ",-?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                        if(Integer.parseInt(fieldnominal.getText()) < DriverManager.getInstance().getDrivers().getSaldoOvo()){
                            DriverManager.getInstance().getDrivers().setSaldoOvo(DriverManager.getInstance().getDrivers().getSaldoOvo() - Integer.parseInt(fieldnominal.getText()));
                            JOptionPane.showMessageDialog(null, "Penarikan Berhasil!!", "Information", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Saldo Ovo Kurang!!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                }
                
                frame.setVisible(false);
                new DriverScreen();
            break;
            case"Back":
                frame.setVisible(false);
                new DriverScreen();
                break;
            case"LihatRiwayat":
                frame.setVisible(false);
                new RiwayatDriverScreen();
            default:
                break;
        }
    }
}
