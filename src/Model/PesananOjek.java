
package Model;

public class PesananOjek extends Pesanan {
    private int id_pesananojek;
    private String Alamat_Penjemputan;
    private String Alamat_Destinasi;
    private String JenisKendaraan;
    
    public PesananOjek(){
    }

    public PesananOjek(int id_pesananojek, String Alamat_Penjemputan, String Alamat_Destinasi, String JenisKendaraan, int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, int totalharga, StatusPesanan statusP) {
        super(id_pesanan, customer, driver, tanggalpemesanan, metodepembayaran, totalharga, statusP);
        this.id_pesananojek = id_pesananojek;
        this.Alamat_Penjemputan = Alamat_Penjemputan;
        this.Alamat_Destinasi = Alamat_Destinasi;
        this.JenisKendaraan = JenisKendaraan;
    }

    public int getId_pesananojek() {
        return id_pesananojek;
    }

    public void setId_pesananojek(int id_pesananojek) {
        this.id_pesananojek = id_pesananojek;
    }

    public String getAlamat_Penjemputan() {
        return Alamat_Penjemputan;
    }

    public void setAlamat_Penjemputan(String Alamat_Penjemputan) {
        this.Alamat_Penjemputan = Alamat_Penjemputan;
    }

    public String getAlamat_Destinasi() {
        return Alamat_Destinasi;
    }

    public void setAlamat_Destinasi(String Alamat_Destinasi) {
        this.Alamat_Destinasi = Alamat_Destinasi;
    }

    public String getJenisKendaraan() {
        return JenisKendaraan;
    }

    public void setJenisKendaraan(String JenisKendaraan) {
        this.JenisKendaraan = JenisKendaraan;
    }

}
