/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;


/**
 *
 * @author William
 */
public class RegisterScreen extends JFrame implements ActionListener{
    private JFrame Register;
    private JLabel labeljudul;
    private JRadioButton RBCustomer, RBDriver;
    private JButton confirmbutton , backbutton;
       
    public RegisterScreen(){
    Register = new JFrame("Register");
    Register.setSize(400, 300);
    Register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    Register.setLocationRelativeTo(null);
    
    labeljudul = new JLabel("Silahkan pilih ");
    labeljudul.setBounds(150, 30, 200, 30);
    
    RBCustomer = new JRadioButton("Customer");
    RBCustomer.setBounds(100, 80, 100, 30);
    
    RBDriver = new JRadioButton("Driver");
    RBDriver.setBounds(200, 80, 100, 30);
    
    ButtonGroup group = new ButtonGroup();
        
    confirmbutton = new JButton("Confirm");
    confirmbutton.setBounds(140, 140, 100, 30);
    confirmbutton.addActionListener(this);
    
    backbutton = new JButton("Back");
    backbutton.setBounds(140, 190, 100, 30);
    backbutton.addActionListener(this);
        
    Register.add(labeljudul);
    Register.add(RBCustomer);
    Register.add(RBDriver);
    group.add(RBCustomer);
    group.add(RBDriver);
    Register.add(confirmbutton);
    Register.add(backbutton);
    Register.setLayout(null);
    Register.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String Pilihan;
        String command = ae.getActionCommand();
        switch(command){
            case "Confirm":
                if(RBCustomer.isSelected()){
                    Pilihan = "Customer";
                    Register.setVisible(false);
                    new RegisterCustomerScreen();
                }else{
                    Pilihan = "Driver";
                    Register.setVisible(false);
                    new RegisterDriverScreen();
                }
            break;
            case "Back":
                Register.setVisible(false);
                new LoginScreen();
            break;
        }
    }
    public static void main(String[] args) {
        new RegisterScreen();
    }
    
}
