
package Controller;

import Model.Logout;
import View.LoginScreen;
import javax.swing.JOptionPane;

public class LogoutDriver implements Logout{
    @Override
    public void logout(){
        DatabaseControl ctrl = new DatabaseControl();
        ctrl.updateDriver(DriverManager.getInstance().getDrivers());
        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi ini!");
        new LoginScreen();
    }
}
