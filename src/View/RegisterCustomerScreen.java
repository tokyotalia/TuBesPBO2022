/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Model.Customers;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author William
 */
public class RegisterCustomerScreen extends JFrame implements ActionListener{
    private JFrame RegisterCustomer;
    private JLabel labeljudul, labelnama, labelusername, labelpassword, labelalamat;
    private JTextField fieldnama, fieldusername, fieldalamat;
    private JPasswordField fieldpassword;
    private JButton RegisterCustomerButton, RegisterCustBackButton;
    
    public RegisterCustomerScreen(){
        RegisterCustomer = new JFrame("Register Customer");
        RegisterCustomer.setSize(400, 400);
        RegisterCustomer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        RegisterCustomer.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelnama = new JLabel("Nama");
        labelnama.setBounds(45, 50, 100, 30);
        
        fieldnama = new JTextField();
        fieldnama.setBounds(150, 50, 200, 30);
        
        labelusername = new JLabel("Username");
        labelusername.setBounds(45, 100, 100, 30);
        
        fieldusername = new JTextField();
        fieldusername.setBounds(150, 100, 200, 30);
        
        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 150, 100, 30);
        
        fieldpassword = new JPasswordField();
        fieldpassword.setBounds(150, 150, 200, 30);  
        
        labelalamat = new JLabel("Alamat");
        labelalamat.setBounds(45, 200, 100, 30);
        
        fieldalamat = new JTextField();
        fieldalamat.setBounds(150, 200, 200, 30);
        
        RegisterCustomerButton = new JButton("Confirm");
        RegisterCustomerButton.setBounds(45,250,300,30);
        RegisterCustomerButton.addActionListener(this);
        
        RegisterCustBackButton = new JButton("Back");
        RegisterCustBackButton.setBounds(45,300,300,30);
        RegisterCustBackButton.addActionListener(this);
        
        RegisterCustomer.add(labeljudul);
        RegisterCustomer.add(labelnama);
        RegisterCustomer.add(fieldnama);
        RegisterCustomer.add(labelusername);
        RegisterCustomer.add(fieldusername);
        RegisterCustomer.add(labelpassword);
        RegisterCustomer.add(fieldpassword);
        RegisterCustomer.add(labelalamat);
        RegisterCustomer.add(fieldalamat);
        RegisterCustomer.add(RegisterCustomerButton);
        RegisterCustomer.add(RegisterCustBackButton);
        RegisterCustomer.setLayout(null);
        RegisterCustomer.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        DatabaseControl con = new DatabaseControl();
        User user = new User();
        Customers customers = new Customers();
        String command = ae.getActionCommand();
        switch(command){
            case "Confirm":
                
                if (fieldnama.getText().equals("") || fieldusername.getText().equals("") || fieldpassword.getPassword().equals("") || fieldalamat.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Silahkan diisi dengan lengkap ", "Error", JOptionPane.ERROR_MESSAGE);
                
                }else {
                    user.setNama(fieldnama.getText());
                    user.setUsername(fieldusername.getText());
                    user.setPassword(new String (fieldpassword.getPassword()));
                    customers.setAlamat(fieldalamat.getText());
                    user.setTipe(2);
                    con.Register(user);
                    customers.setId_User(con.Register(user));
                    con.RegisterCustomer(customers);
                    JOptionPane.showMessageDialog(null, "Berhasil Register ", "Information", JOptionPane.INFORMATION_MESSAGE);
                }   
                
//                RegisterCustomer.setVisible(false);
//                new LoginScreen();
            break;
            case "Back":
                RegisterCustomer.setVisible(false);
                new RegisterScreen();
        }
    }
}
