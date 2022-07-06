/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
                Login.setVisible(false);
            break;
            case "Register":
                Login.setVisible(false);
                new RegisterScreen();
        }
    }
}