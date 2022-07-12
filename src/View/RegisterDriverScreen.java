/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseControl;
import Controller.DatabaseHandler;
import Model.Driver;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author William
 */
public class RegisterDriverScreen extends JFrame implements ActionListener {

    private JFrame RegisterDriver;
    private JLabel labeljudul, labelnama, labelusername, labelpassword, labeljeniskendaran, labelplatnomor;
    private JRadioButton RBMotor, RBMobil;
    private JTextField fieldnama, fieldusername, fieldplatnomor;
    private JPasswordField fieldpassword;
    private JButton RegisterDriverButton, RegisterDriverBackButton;

    public RegisterDriverScreen() {
        RegisterDriver = new JFrame("Register Driver");
        RegisterDriver.setSize(400, 450);
        RegisterDriver.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        RegisterDriver.setLocationRelativeTo(null);

        labeljudul = new JLabel("Silahkan Insert Data Dibawah ");
        labeljudul.setBounds(100, 10, 200, 30);

        labelnama = new JLabel("Nama");
        labelnama.setBounds(45, 50, 100, 30);

        fieldnama = new JTextField();
        fieldnama.setBounds(150, 50, 200, 30);

        labelusername = new JLabel("Username");
        labelusername.setBounds(45, 100, 100, 30);

        fieldusername = new JTextField();
        fieldusername.setBounds(150, 100, 200, 30);

        labelpassword = new JLabel("Password");
        labelpassword.setBounds(45, 150, 100, 30);

        fieldpassword = new JPasswordField();
        fieldpassword.setBounds(150, 150, 200, 30);

        labeljeniskendaran = new JLabel("Jenis Kendaraan");
        labeljeniskendaran.setBounds(43, 200, 100, 30);

        RBMotor = new JRadioButton("Motor");
        RBMotor.setBounds(155, 200, 100, 30);

        RBMobil = new JRadioButton("Mobil");
        RBMobil.setBounds(255, 200, 100, 30);

        ButtonGroup group = new ButtonGroup();

        labelplatnomor = new JLabel("Plat Nomor");
        labelplatnomor.setBounds(45, 250, 100, 30);

        fieldplatnomor = new JTextField();
        fieldplatnomor.setBounds(150, 250, 200, 30);

        RegisterDriverButton = new JButton("Confirm");
        RegisterDriverButton.setBounds(45, 300, 300, 30);
        RegisterDriverButton.addActionListener(this);

        RegisterDriverBackButton = new JButton("Back");
        RegisterDriverBackButton.setBounds(45, 350, 300, 30);
        RegisterDriverBackButton.addActionListener(this);

        RegisterDriver.add(labeljudul);
        RegisterDriver.add(labelnama);
        RegisterDriver.add(fieldnama);
        RegisterDriver.add(labelusername);
        RegisterDriver.add(fieldusername);
        RegisterDriver.add(labelpassword);
        RegisterDriver.add(fieldpassword);
        RegisterDriver.add(labeljeniskendaran);
        RegisterDriver.add(RBMotor);
        RegisterDriver.add(RBMobil);
        group.add(RBMotor);
        group.add(RBMobil);
        RegisterDriver.add(labelplatnomor);
        RegisterDriver.add(fieldplatnomor);
        RegisterDriver.add(RegisterDriverButton);
        RegisterDriver.add(RegisterDriverBackButton);
        RegisterDriver.setLayout(null);
        RegisterDriver.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        DatabaseControl con = new DatabaseControl();
        User user = new User();
        Driver driver = new Driver();
        String command = ae.getActionCommand();
        switch (command) {
            case "Confirm":

                String Jeniskendaraan = "Motor";
                if (RBMobil.isShowing()) {
                    Jeniskendaraan = "Mobil";
                }
                if (fieldnama.getText().equals("") || fieldusername.getText().equals("") || fieldpassword.getPassword().equals("") || fieldplatnomor.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Silahkan diisi dengan lengkap ", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    user.setNama(fieldnama.getText());
                    user.setUsername(fieldusername.getText());
                    user.setPassword(new String(fieldpassword.getPassword()));
                    user.setTipe(3);
                    driver.setJeniskendaraan(Jeniskendaraan);
                    driver.setPlatnomor(fieldplatnomor.getText());
                    con.Register(user);
                    driver.setId_User(con.getIdUserTerbaru().getId_User());
                    con.RegisterDriver(driver);
                    JOptionPane.showMessageDialog(null, "Berhasil Register ", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                RegisterDriver.setVisible(false);
                new LoginScreen();
                break;
            case "Back":
                RegisterDriver.setVisible(false);
                new RegisterScreen();
        }
    }

}
