
package View.Driver;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.DriverManager;
import Controller.LogoutDriver;
import Controller.PesananOjekManager;
import Model.Pesanan;
import Model.PesananFood;
import Model.PesananOjek;
import Model.StatusDriver;
import Model.StatusPesanan;
import View.Driver.DriverProfileScreen;
import View.LoginScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class DriverScreen extends JFrame implements ActionListener{
    private JFrame frame;
    private JLabel labeljudul;
    private JButton driverprofilebutton,logoutbutton, donebutton, cancelbutton;
    private boolean cekFood = false, cekOjek = false;
    private Pesanan pesanan = new Pesanan();
    private Pesanan pesanan2 = new Pesanan();
    private PesananFood pesananFood = new PesananFood();
    private PesananOjek pesananOjek = new PesananOjek();
    private DatabaseControl ctrl = new DatabaseControl();
    public DriverScreen() {
        frame = new JFrame("Driver Screen");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(160, 10, 200, 30);

        driverprofilebutton = new JButton("DriverProfile");
        driverprofilebutton.setBounds(100, 100, 200, 30);
        driverprofilebutton.addActionListener(this);
        
        int y = 150; 
        
        if(DriverManager.getInstance().getDrivers().getStatus().equals(StatusDriver.TAKEN)){
            ArrayList<Pesanan> listPesanan = new ArrayList<>();
            ArrayList<PesananFood> listPesananFood = new ArrayList<>();
            ArrayList<PesananOjek> listPesananOjek = new ArrayList<>();
            listPesanan = ctrl.getAllPesanan();
            listPesananFood = ctrl.getAllPesananFood();
            listPesananOjek = ctrl.getAllPesananOjek();
            
            for(int i = 0; i < listPesanan.size(); i++){
                if(listPesanan.get(i).getDriver().getId_driver() == DriverManager.getInstance().getDrivers().getId_driver()){
                    pesanan = listPesanan.get(i);
                    for(int j = 0; j < listPesananFood.size(); j++){
                        if(listPesanan.get(i).getId_pesanan() == listPesananFood.get(j).getId_pesanan()&& listPesananFood.get(j).getStatus()==StatusPesanan.DELIVERING){
                            cekFood = true;
                            pesananFood = listPesananFood.get(j);
                        }
                    }
                    for(int j = 0; j < listPesananOjek.size(); j++){
                        if(listPesanan.get(i).getId_pesanan() == listPesananOjek.get(j).getId_pesanan()&& listPesananOjek.get(j).getStatus()==StatusPesanan.RIDING){
                            cekOjek = true;
                            pesananOjek = listPesananOjek.get(j);
                        }
                    }
                }
            }
            for(int i = 0; i < listPesanan.size(); i++){
                if(listPesanan.get(i).getCustomer().getId_customer() == CustomerManager.getInstance().getCustomer().getId_customer()){
                    pesanan2 = listPesanan.get(i);
                }
            }
            donebutton = new JButton("Selesaikan Pesanan");
            donebutton.setBounds(100, y, 200, 30);
            donebutton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(cekFood){
                        ctrl.updateStatusPesananFood(StatusPesanan.SELESAI.name(), pesananFood.getID_PesananFood());
                        DriverManager.getInstance().getDrivers().setStatus(StatusDriver.AVAILABLE);
                    }else if(cekOjek){
                        ctrl.updateStatusPesananOjek(StatusPesanan.SELESAI.name(), pesananOjek.getId_pesananojek());
                        DriverManager.getInstance().getDrivers().setStatus(StatusDriver.AVAILABLE);
                    }
                    if(pesanan.getMetodepembayaran().equals("Up-Pay")) {
                        DriverManager.getInstance().getDrivers().setSaldoUp(DriverManager.getInstance().getDrivers().getSaldoUp()+pesanan.getTotalharga());
                    }
                    DriverManager.getInstance().getDrivers().setPendapatan(DriverManager.getInstance().getDrivers().getPendapatan()+pesanan.getTotalharga());
                    JOptionPane.showMessageDialog(null, "Pesanan Selesai!!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    ctrl.updateStatusDriver(StatusDriver.AVAILABLE.name(), DriverManager.getInstance().getDrivers().getId_driver());
                    frame.setVisible(false);
                    new DriverScreen();
                }
            });
            cancelbutton = new JButton("Cancel Pesanan");
            cancelbutton.setBounds(100, y+50, 200, 30);
            cancelbutton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(cekFood){
                        ctrl.updateStatusPesananFood(StatusPesanan.CANCELLED.name(), pesananFood.getID_PesananFood());
                        DriverManager.getInstance().getDrivers().setStatus(StatusDriver.AVAILABLE);
                    }else if(cekOjek){
                        ctrl.updateStatusPesananOjek(StatusPesanan.CANCELLED.name(), pesananOjek.getId_pesananojek());
                        DriverManager.getInstance().getDrivers().setStatus(StatusDriver.AVAILABLE);
                    } 
                    if(pesanan2.getMetodepembayaran().equals("Up-Pay")) {
                        CustomerManager.getInstance().getCustomer().setSaldoUp(CustomerManager.getInstance().getCustomer().getSaldoUp() + pesanan2.getTotalharga());
                        ctrl.updateCustomer(CustomerManager.getInstance().getCustomer());
                    }
                    JOptionPane.showMessageDialog(null, "Pesanan Di cancel!!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    ctrl.updateStatusDriver(StatusDriver.AVAILABLE.name(), DriverManager.getInstance().getDrivers().getId_driver());
                    frame.setVisible(false);
                    new DriverScreen();
                }
                    });
                    frame.add(donebutton);
                    frame.add(cancelbutton);
                    y += 50;
        }else{
            y = 150;
        }
        
        logoutbutton = new JButton("LogOut");
        logoutbutton.setBounds(100, y, 200, 30);
        logoutbutton.addActionListener(this);
        
        
        frame.add(labeljudul);
        frame.add(driverprofilebutton);
        frame.add(logoutbutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"DriverProfile":
                frame.setVisible(false);
                new DriverProfileScreen();
                break;
            case"LogOut":
                LogoutDriver logout = new LogoutDriver();
                logout.logout();
                frame.setVisible(false);
                break;
            default:
                break;
        }
    }  
}
