
package Model;

public class Admin extends User{
    private int id_admin;
    
    public Admin(){
        
    }

    public Admin(int id_admin, String alamat) {
        this.id_admin = id_admin;
    }

    public Admin(int id_admin, String alamat, int id_User, String nama, String username, String password, String noHp, String email, String tanggallahir, int tipe) {
        super(id_User, nama, username, password, tipe);
        this.id_admin = id_admin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
}