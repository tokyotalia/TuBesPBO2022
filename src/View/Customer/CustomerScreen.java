package View.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import View.Customer.UpJek;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author William
 */
public class CustomerScreen extends JFrame implements ActionListener{
    private JFrame frame;
    private JLabel labeljudul;
    private JButton gojekbutton,gofoodbutton,topupbutton,userprofilebutton,historybutton;
    public CustomerScreen(){
        frame = new JFrame("Login");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(160, 10, 200, 30);
        
        gojekbutton = new JButton("GoJek");
        gojekbutton.setBounds(100, 50, 200, 30);
        gojekbutton.addActionListener(this);
        
        gofoodbutton = new JButton("GoFood");
        gofoodbutton.setBounds(100, 100, 200, 30);
        gofoodbutton.addActionListener(this);
        
        topupbutton = new JButton("TopUp");
        topupbutton.setBounds(100, 150, 200, 30);
        topupbutton.addActionListener(this);
        
        userprofilebutton = new JButton("UserProfile");
        userprofilebutton.setBounds(100, 200, 200, 30);
        userprofilebutton.addActionListener(this);
        
        historybutton = new JButton("History");
        historybutton.setBounds(100, 250, 200, 30);
        historybutton.addActionListener(this);
        
        frame.add(labeljudul);
        frame.add(gojekbutton);
        frame.add(gofoodbutton);
        frame.add(topupbutton);
        frame.add(userprofilebutton);
        frame.add(historybutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"GoJek":
                frame.setVisible(false);
                new UpJek();
                break;
            case"GoFood":
                frame.setVisible(false);
                new UpFood();
                break;
            case"TopUp":
                frame.setVisible(false);
                new TopupScreen();
                break;
            case"UserProfile":
                frame.setVisible(false);
                new MenuProfile();
                break;
            case"History":
                frame.setVisible(false);
                new MenuHistory();
                break;
            default:
                break;
        }
    }
}
