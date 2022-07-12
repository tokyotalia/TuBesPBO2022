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
        labeljudul.setBounds(150, 10, 200, 30);
        
        gojekbutton = new JButton("UpJek");
        gojekbutton.setBounds(100, 50, 200, 30);
        gojekbutton.addActionListener(this);
        
        gofoodbutton = new JButton("UpFood");
        gofoodbutton.setBounds(100, 100, 200, 30);
        gofoodbutton.addActionListener(this);
        
        topupbutton = new JButton("TopUp");
        topupbutton.setBounds(100, 150, 200, 30);
        topupbutton.addActionListener(this);
        
        userprofilebutton = new JButton("User Profile");
        userprofilebutton.setBounds(100, 200, 200, 30);
        userprofilebutton.addActionListener(this);       
        
        frame.add(labeljudul);
        frame.add(gojekbutton);
        frame.add(gofoodbutton);
        frame.add(topupbutton);
        frame.add(userprofilebutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case"UpJek":
                frame.setVisible(false);
                new UpJek();
                break;
            case"UpFood":
                frame.setVisible(false);
                new UpFood();
                break;
            case"TopUp":
                frame.setVisible(false);
                new TopupScreen();
                break;
            case"User Profile":
                frame.setVisible(false);
                new ProfileScreen();
                break;
            default:
                break;
        }
    }
}
