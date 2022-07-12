/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Wilson
 */
public class LihatDriver extends JFrame implements ActionListener {
    private JFrame frame;
    private JLabel judul, labelId;
    private JTextField nama;
    private JButton find, cancel;
    
    public LihatDriver(){
        frame = new JFrame("Lihat History Driver");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        judul = new JLabel("Lihat History Driver");
        judul.setBounds(160, 10, 200, 30);
        
        labelId = new JLabel("ID Driver:");
        labelId.setBounds(100, 50, 100, 30);
        
        nama = new JTextField();
        nama.setBounds(205, 50, 200, 30);
        
        find = new JButton("Find");
        find.setBounds(100, 100, 100, 30);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Isi Function Lihat Driver
            }
        });
        
        cancel = new JButton("Cancel");
        cancel.setBounds(205, 100, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminScreen();
            }
        });
        
        frame.add(judul);
        frame.add(labelId);
        frame.add(nama);
        frame.add(find);
        frame.add(cancel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
            public void actionPerformed(ActionEvent e) {
                
            }
}
