package View.Admin;

import Controller.DatabaseControl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LihatDriver extends JFrame implements ActionListener {

    private JFrame frame;
    private JLabel judul, labelId;
    private JTextField idField;
    private JButton find, cancel;

    public LihatDriver() {
        frame = new JFrame("Lihat Driver");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        judul = new JLabel("Lihat Driver");
        judul.setBounds(160, 10, 200, 30);

        labelId = new JLabel("ID Driver:");
        labelId.setBounds(45, 50, 100, 30);

        idField = new JTextField();
        idField.setBounds(130, 50, 200, 30);

        find = new JButton("Find");
        find.setBounds(100, 100, 100, 30);
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatProfileDriver(Integer.parseInt(idField.getText()));
                frame.setVisible(false);
            }
        });
        
        cancel = new JButton("Back");
        cancel.setBounds(200, 100, 100, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminScreen();
                frame.setVisible(false);
            }
        });
        
        frame.add(judul);
        frame.add(labelId);
        frame.add(idField);
        frame.add(find);
        frame.add(cancel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override

    public void actionPerformed(ActionEvent e) {

    }
}
