/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.WindowConstants;
/**
 *
 * @author Wilson
 */
public class DeleteConfirmation extends JFrame implements ActionListener {
    
    private JFrame frame;
    private JLabel alert;
    private JButton yes, no;
    
    public DeleteConfirmation() {
        frame = new JFrame("Delete Confirmation");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        alert = new JLabel("Are You Sure Want To Delete It?");
        alert.setBounds(160, 10, 200, 30);
        
        yes = new JButton("Yes");
        yes.setBounds(100, 50, 100, 30);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Function Hapus
                new HapusDriver();
            }
        });
        
        no = new JButton("No");
        no.setBounds(205, 50, 100, 30);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HapusDriver();
            }
        });
        
        frame.add(alert);
        frame.add(yes);
        frame.add(no);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
