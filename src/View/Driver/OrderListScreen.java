/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Driver;


/**
 *
 * @author Mena
 */
 import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
public class OrderListScreen {  
    public static void main(String s[]) {
        JFrame frame = new JFrame("List Orderan ");  
        JPanel panel = new JPanel();  
        panel.setLayout(new FlowLayout());  
        JLabel label = new JLabel(" Daftar Oderan ");  
        JButton button = new JButton();  
        button.setText("Lihat list Oderan ");  
        panel.add(label);  
        panel.add(button);  
        frame.add(panel);  
        frame.setSize(200, 300);  
        frame.setLocationRelativeTo(null);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}  
    

