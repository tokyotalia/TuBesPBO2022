/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import View.LoginScreen;
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

public class AdminScreen extends JFrame implements ActionListener{
    private JFrame frame;
    private JLabel labeljudul;
    private JButton datadriverbutton, hapusDriverButton, logoutbutton;

    public AdminScreen() {
        frame = new JFrame("Admin");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labeljudul = new JLabel("Silahkan Pilih ");
        labeljudul.setBounds(165, 10, 200, 30);
        
        datadriverbutton = new JButton("Lihat History Driver");
        datadriverbutton.setBounds(100, 50, 200, 30);
        datadriverbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatDriver();
            }
        });
        
        hapusDriverButton = new JButton("Hapus Driver");
        hapusDriverButton.setBounds(100, 100, 200, 30);
        hapusDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HapusDriver();
            }
        });
        
        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(100, 150, 200, 30);
        logoutbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen();
            }
        });
        
        frame.add(labeljudul);
        frame.add(datadriverbutton);
        frame.add(hapusDriverButton);
        frame.add(logoutbutton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        String command = ae.getActionCommand();
//        switch(command){
//            case"Lihat Riwayat Driver":
//               frame.setVisible(false);
//               new RiwayatDriverScreen();
//            break;
//            case"Logout":
//                frame.setVisible(false);
//                new LoginScreen();
//                break;
//            default:
//                break;
//        }
    }
    
    public static void main(String[] args) {
        new AdminScreen();
    }
}

