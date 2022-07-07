/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.AdminManager;
import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.DriverManager;
import Controller.UserManager;
import Model.Admin;
import Model.Customers;
import Model.Driver;
import Model.User;
import View.Admin.AdminScreen;
import View.Customer.CustomerScreen;
import View.Driver.DriverScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Mena
 */
public class LoginScreen  extends JFrame implements ActionListener{
    private JFrame Login;
    private JLabel labelusername,labelpassword,labeljudul;
    private JTextField fieldusername,fieldemail;
    private JPasswordField fieldpassword;
    private JButton confirmbutton, registerbutton;
    
    public LoginScreen(){
        Login = new JFrame("Login");
        Login.setSize(400, 300);
        Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelusername = new JLabel("UserName");
        labelusername.setBounds(45, 50, 100, 30);
        
        fieldusername = new JTextField();
        fieldusername.setBounds(150, 50, 200, 30);
        
        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 100, 100, 30);
        
        fieldpassword = new JPasswordField();
        fieldpassword.setBounds(150, 100, 200, 30);        
        
        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(45,150,300,30);
        confirmbutton.addActionListener(this);
        
        registerbutton = new JButton("Register");
        registerbutton.setBounds(45,200,300,30);
        registerbutton.addActionListener(this);
        
              
        Login.add(labeljudul);
        Login.add(confirmbutton);
        Login.add(registerbutton);
        Login.add(fieldusername);
        Login.add(labelusername);
        Login.add(labelpassword);
        Login.add(fieldpassword);
        Login.setLayout(null);
        Login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch(command){
            case "Confirm":
                String username = fieldusername.getText();
                String password = new String(fieldpassword.getPassword());
                User user = new User();
                if(username.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null, "Silahkan isikan email dan password anda", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(user.cekLogin(username, password)){
                    DatabaseControl ctrl = new DatabaseControl();
                    if(UserManager.getInstance().getUser().getTipe() == 1){
                        ArrayList<Admin> listAdmin = new ArrayList<>();
                        listAdmin = ctrl.getAllAdmin();
                        for(int i = 0; i < listAdmin.size(); i++){
                            if(listAdmin.get(i).getId_User() == UserManager.getInstance().getUser().getId_User()){
                                AdminManager.getInstance().setAdmin(listAdmin.get(i));
                            }
                        }
                        Login.setVisible(false);
                        new AdminScreen();
                    }else if(UserManager.getInstance().getUser().getTipe() == 2){
                        ArrayList<Customers> listCustomer = new ArrayList<>();
                        listCustomer = ctrl.getAllCustomer();
                        for(int i = 0; i < listCustomer.size(); i++){
                            if(listCustomer.get(i).getId_User() == UserManager.getInstance().getUser().getId_User()){
                                CustomerManager.getInstance().setCustomer(listCustomer.get(i));
                            }
                        }
                        Login.setVisible(false);
                        new CustomerScreen();
                    }else if(UserManager.getInstance().getUser().getTipe() == 3){
                        ArrayList<Driver> listDriver = new ArrayList<>();
                        listDriver = ctrl.getAllDriver();
                        for(int i = 0; i < listDriver.size(); i++){
                            if(listDriver.get(i).getId_User() == UserManager.getInstance().getUser().getId_User()){
                                DriverManager.getInstance().setDrivers(listDriver.get(i));
                            }
                        }
                        Login.setVisible(false);
                        new DriverScreen();
                    }
                }else if(!user.cekLogin(username, password)){
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            break;
            case "Register":
                Login.setVisible(false);
                new RegisterScreen();
        }
    }
}