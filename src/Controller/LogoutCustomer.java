
package Controller;

import Model.Logout;
import View.LoginScreen;
import javax.swing.JOptionPane;

public class LogoutCustomer implements Logout {
    @Override
    public void logout(){
        DatabaseControl ctrl = new DatabaseControl();
        ctrl.updateCustomer(CustomerManager.getInstance().getCustomer());    
        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi ini!");
        UserManager.getInstance().setUser(null);
        new LoginScreen();
    }
}
