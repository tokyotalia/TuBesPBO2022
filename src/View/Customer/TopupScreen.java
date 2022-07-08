/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author William
 */

public class TopupScreen implements ActionListener{
    private JFrame Login;
    private JLabel labelTopUp,labeljudul;
    private JTextField fieldTopUp;
    private JButton confirmbutton, backbutton;
    
    public TopupScreen(){
        Login = new JFrame("Top Up");
        Login.setSize(400, 300);
        Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Login.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Menu Top Up");
        labeljudul.setBounds(100, 10, 200, 30);
        
        labelTopUp = new JLabel("Masukan Jumlah");
        labelTopUp.setBounds(45, 75, 100, 30);
        
        fieldTopUp = new JTextField();
        fieldTopUp.setBounds(150, 75, 200, 30);        
        
        confirmbutton = new JButton("Confirm");
        confirmbutton.setBounds(45,150,300,30);
        confirmbutton.addActionListener(this);
        
        backbutton = new JButton("Back");
        backbutton.setBounds(45, 200, 300, 30);
        backbutton.addActionListener(this);
              
        Login.add(labeljudul);
        Login.add(confirmbutton);
        Login.add(backbutton);
        Login.add(fieldTopUp);
        Login.add(labelTopUp);
        Login.setLayout(null);
        Login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}