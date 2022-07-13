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
public class HapusDriver extends JFrame implements ActionListener {
    
    private JFrame frame;
    private JLabel labelJudul, labelId;
    private JTextField id;
    private JButton delete, cancel;
    
    public HapusDriver() {
        frame = new JFrame("Delete Driver");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        labelJudul = new JLabel("Hapus Driver");
        labelJudul.setBounds(160, 10, 200, 30);
        
        labelId = new JLabel("ID Driver:");
        labelId.setBounds(100, 50, 100, 30);
        
        id = new JTextField();
        id.setBounds(205, 50, 200, 30);
        
        delete = new JButton("Delete");
        delete.setBounds(100, 100, 100, 30);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DeleteConfirmation(Integer.parseInt(id.getText()));
            }
        });
        
        cancel = new JButton("Cancel");
        cancel.setBounds(205, 100, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AdminScreen();
            }
        });
        
        frame.add(labelJudul);
        frame.add(labelId);
        frame.add(id);
        frame.add(delete);
        frame.add(cancel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
