
package Model;

public class PesananFood extends Pesanan{
    private int ID_PesananFood;
    private String Alamat_Pengantaran;
    private Keranjang detail;
    private StatusPesanan status;

    public PesananFood() {
    }

    public PesananFood(int ID_PesananFood, String Alamat_Pengantaran, Keranjang detail, StatusPesanan status, int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, int totalharga) {
        super(id_pesanan, customer, driver, tanggalpemesanan, metodepembayaran, totalharga);
        this.ID_PesananFood = ID_PesananFood;
        this.Alamat_Pengantaran = Alamat_Pengantaran;
        this.detail = detail;
        this.status = status;
    }

    public int getID_PesananFood() {
        return ID_PesananFood;
    }

    public void setID_PesananFood(int ID_PesananFood) {
        this.ID_PesananFood = ID_PesananFood;
    }

    public String getAlamat_Pengantaran() {
        return Alamat_Pengantaran;
    }

    public void setAlamat_Pengantaran(String Alamat_Pengantaran) {
        this.Alamat_Pengantaran = Alamat_Pengantaran;
    }

    public Keranjang getDetail() {
        return detail;
    }

    public void setDetail(Keranjang detail) {
        this.detail = detail;
    }

    public StatusPesanan getStatus() {
        return status;
    }

    public void setStatus(StatusPesanan status) {
        this.status = status;
    }
    
}
