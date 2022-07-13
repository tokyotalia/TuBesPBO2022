/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Customer;

import Controller.CustomerManager;
import Controller.DatabaseControl;
import Controller.LogoutCustomer;
import Controller.UserManager;
import View.LoginScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ProfileScreen {
    private JFrame ProfileScreen;
    private JLabel labelNama, labelUsername, labelAlamat, labelSaldoUp, labelIsiNama, labelIsiUsername, labelIsiAlamat, labelIsiSaldo;
    private JButton buttonBack, buttonLogout;
    

    public ProfileScreen(){
        ProfileScreen = new JFrame("My Profile");
        ProfileScreen.setSize(450, 250);
        ProfileScreen.setLocationRelativeTo(null);
        ProfileScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelNama = new JLabel("Nama");
        labelNama.setBounds(50, 10, 100, 20);
        
        labelIsiNama = new JLabel(UserManager.getInstance().getUser().getNama());
        labelIsiNama.setBounds(120, 10, 200, 20);
        
        labelUsername = new JLabel("Username");
        labelUsername.setBounds(50, 40, 100, 20);
        
        labelIsiUsername = new JLabel(UserManager.getInstance().getUser().getUsername());
        labelIsiUsername.setBounds(120, 40, 200, 20);
        
        labelAlamat = new JLabel("Alamat");
        labelAlamat.setBounds(50, 70, 100, 20);
        
        labelIsiAlamat = new JLabel(CustomerManager.getInstance().getCustomer().getAlamat());
        labelIsiAlamat.setBounds(120, 70, 200, 20);
        
        labelSaldoUp = new JLabel("Saldo Up-Pay");
        labelSaldoUp.setBounds(50, 100, 100, 20);
        
        labelIsiSaldo = new JLabel("Rp. " + CustomerManager.getInstance().getCustomer().getSaldoUp());
        labelIsiSaldo.setBounds(120, 100, 200, 20);
        
        buttonBack = new JButton("Back");
        buttonBack.setBounds(100, 180, 100, 20);
        
        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(210, 180, 100, 20);
        
        ProfileScreen.add(labelNama);
        ProfileScreen.add(labelUsername);
        ProfileScreen.add(labelAlamat);
        ProfileScreen.add(labelSaldoUp);
        ProfileScreen.add(labelIsiNama);
        ProfileScreen.add(labelIsiUsername);
        ProfileScreen.add(labelIsiSaldo);
        ProfileScreen.add(buttonBack);
        ProfileScreen.add(buttonLogout);
        ProfileScreen.add(labelIsiAlamat);
        ProfileScreen.setLayout(null);
        ProfileScreen.setVisible(true);
        
        buttonLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin Logout?");
                switch(jawab){
                    case JOptionPane.YES_OPTION:
                    LogoutCustomer logout = new LogoutCustomer();
                    logout.logout();
                    ProfileScreen.setVisible(false);
                }
            }
        });
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ProfileScreen.setVisible(false);
                new CustomerScreen();
            }
        }); 
    }
}