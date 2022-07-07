
package View.Customer;

import Controller.DatabaseControl;
import Model.Keranjang;
import View.Customer.PembayaranFoodScreen;
import Model.Food;
import Model.Restaurant;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class OrderFoodScreen implements ActionListener{
    private JFrame frame;
    private JLabel labelJudul;
    private JLabel[] labelMakanan;
    private JTextField[] tfMakanan;
    private JButton buttonsubmit,buttoncancel;
    private ArrayList<Food> listFoodRestaurant = new ArrayList<>();
    
    public OrderFoodScreen(Restaurant restaurant){
        frame = new JFrame("Go Food");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labelJudul = new JLabel("Pilih Menu");
        labelJudul.setBounds(130,5,300,50);
        labelJudul.setFont(new Font(labelJudul.getFont().getName(), labelJudul.getFont().getStyle(), 28));
        
        DatabaseControl ctrl = new DatabaseControl();
        ArrayList<Food> listFood = new ArrayList<>();
        listFood = ctrl.getAllFood();
        
        int counter = 0;
        int x1 = 25, x2 = 130;
        int y = 50;
        
        for(int i = 0; i < listFood.size(); i++){
            if(listFood.get(i).getRestaurant().getId_restaurant() == restaurant.getId_restaurant()){
                listFoodRestaurant.add(listFood.get(i));
            }
        }
        
        labelMakanan = new JLabel[listFoodRestaurant.size()];
        tfMakanan = new JTextField[listFoodRestaurant.size()];
        
        for(int i = 0; i < listFood.size(); i++){
            if(listFood.get(i).getRestaurant().getId_restaurant() == restaurant.getId_restaurant()){
                labelMakanan[counter] = new JLabel(listFood.get(i).getNamamakanan());
                tfMakanan[counter] = new JTextField();
                if(y < 350){
                    y += 50;
                    x1 += 105;
                    x2 += 105;
                }
                labelMakanan[counter].setBounds(x1, y, 100, 30);
                tfMakanan[counter].setBounds(x2, y, 50, 30);
                
                counter++;
            }
        }
        
        buttonsubmit = new JButton("Next");
        buttonsubmit.setBounds(50,300,100,30);
        buttonsubmit.addActionListener(this);
        
        buttoncancel = new JButton("Cancel");
        buttoncancel.setBounds(200,300,100,30);
        buttoncancel.addActionListener(this);
        
        for(int i = 0; i < listFoodRestaurant.size(); i++){
            frame.add(labelMakanan[i]);
            frame.add(tfMakanan[i]);
        }
        
        frame.add(labelJudul);
        frame.add(buttonsubmit);
        frame.add(buttoncancel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         String command = ae.getActionCommand();
        switch(command){
            case"Next":
                ArrayList<Keranjang> listDetailPesanan = new ArrayList<>();
                          
                boolean cek = false;
                
                for(int i = 0; i < listFoodRestaurant.size(); i++){
                    if(!tfMakanan[i].getText().equals("")){
                        cek = true;
                        Keranjang detailPesanan = new Keranjang();
                        detailPesanan.setId_makanan(listFoodRestaurant.get(i).getIdmakanan());
                        detailPesanan.setNamaMenu(listFoodRestaurant.get(i).getNamamakanan());
                        detailPesanan.setHargaSatuan(listFoodRestaurant.get(i).getHargamakanan());
                        detailPesanan.setQuantity(Integer.parseInt(tfMakanan[i].getText()));
                        listDetailPesanan.add(detailPesanan);
                    }
                }
                
                if(!cek){
                    JOptionPane.showMessageDialog(null, "Harap Lakukan Input!!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    
                    frame.setVisible(false);
                    new PembayaranFoodScreen(listDetailPesanan);
                }
                
                                           
            break;
            case"Cancel":
                frame.setVisible(false);
                new UpFood();
            default:
                break;
        }
    }
}
