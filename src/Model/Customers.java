
package Model;

public class Customers extends User{
    private int id_customer;
    private int SaldoUp;
    private String alamat;
    
    public Customers(){
    }

    public Customers(int id_customer, int SaldoUp, String alamat, int id_User, String nama, String username, String password, int tipe) {
        super(id_User, nama, username, password, tipe);
        this.id_customer = id_customer;
        this.SaldoUp = SaldoUp;
        this.alamat = alamat;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getSaldoUp() {
        return SaldoUp;
    }

    public void setSaldoUp(int SaldoUp) {
        this.SaldoUp = SaldoUp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
