
package Model;

public class PesananFood extends Pesanan{
    private int ID_PesananFood;
    private String Alamat_Pengantaran;
    private DetailPesanan detail;

    public PesananFood() {
    }

    public PesananFood(int ID_PesananFood, String Alamat_Pengantaran, DetailPesanan detail, int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, int totalharga) {
        super(id_pesanan, customer, driver, tanggalpemesanan, metodepembayaran, totalharga);
        this.ID_PesananFood = ID_PesananFood;
        this.Alamat_Pengantaran = Alamat_Pengantaran;
        this.detail = detail;
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

    public DetailPesanan getDetail() {
        return detail;
    }

    public void setDetail(DetailPesanan detail) {
        this.detail = detail;
    }
}
