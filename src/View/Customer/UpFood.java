
package View.Customer;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.PesananFoodManager;
import Controller.PesananManager;
import Model.Pesanan;
import Model.PesananFood;
import Model.Restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UpFood implements ActionListener{
    private JFrame frame = new JFrame("Go Food");
    private JLabel restaurantlabel,labeljudul,labeltujuan;
    private JTextField fieldtujuan;
    private JButton buttonsubmit,buttonback;
    private JComboBox cbRestaurant;
    private ArrayList<Restaurant> listRestaurant = new ArrayList<>();
    
    public UpFood(){
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        restaurantlabel = new JLabel("Pilih Restaurant");
        restaurantlabel.setBounds(45,50,100,30);
        
        
        DatabaseControl ctrl = new DatabaseControl();
        listRestaurant = ctrl.getAllRestaurant();
        
        int banyak = listRestaurant.size();
        String[] resto = new String[banyak];
        
        for(int i = 0 ; i < listRestaurant.size(); i++){
            resto[i] = listRestaurant.get(i).getNamarestaurant();
        }
        cbRestaurant = new JComboBox(resto);
        cbRestaurant.setBounds(150, 50, 200, 30);
        
        labeltujuan = new JLabel("Alamat Tujuan");
        labeltujuan.setBounds(45,100,100,30);
        
        fieldtujuan = new JTextField();
        fieldtujuan.setBounds(150,100,200,30);
        
        buttonsubmit = new JButton("Next");
        buttonsubmit.setBounds(150,150,100,30);
        buttonsubmit.addActionListener(this);
        
        buttonback = new JButton("Back");
        buttonback.setBounds(150,200,100,30);
        buttonback.addActionListener(this);
        
        frame.add(labeljudul);
        frame.add(fieldtujuan);
        frame.add(buttonsubmit);
        frame.add(buttonback);
        frame.add(cbRestaurant);
        frame.add(restaurantlabel);  
        frame.add(labeltujuan);
        
        frame.setLayout(null);
        frame.setVisible(true);
                
    }

    public void actionPerformed(ActionEvent ae) {
          String command = ae.getActionCommand();
        switch(command){
            case"Next":
                Pesanan pesanan = new Pesanan();
                PesananFood pesananfood = new PesananFood();
                pesanan.setCustomer(CustomerManager.getInstance().getCustomer());
                pesananfood.setAlamat_Pengantaran(fieldtujuan.getText());
                PesananFoodManager.getInstance().setPesananfood(pesananfood);
                PesananManager.getInstance().setPesanan(pesanan);
                
                Restaurant restaurant = new Restaurant();
                for(int i = 0; i < listRestaurant.size(); i++){
                    if(listRestaurant.get(i).getNamarestaurant().equals((String)cbRestaurant.getItemAt(cbRestaurant.getSelectedIndex()))){
                        restaurant = listRestaurant.get(i);
                    }
                }
                
                frame.setVisible(false);
                new OrderFoodScreen(restaurant);
            break;
            case"Back":
                frame.setVisible(false);
//                new CustomerScreen();
                break;           
            default:
                break;
        }
    }
}
