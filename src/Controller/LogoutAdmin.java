
package Controller;

import Model.Logout;
import View.LoginScreen;
import javax.swing.JOptionPane;

public class LogoutAdmin implements Logout {
    @Override
    public void logout(){
        JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan aplikasi ini!");
        UserManager.getInstance().setUser(null);
        new LoginScreen();
    }
}
