
package Model;

public class Pesanan {
    private int id_pesanan;
    private Customers customer;
    private Driver driver;
    private String tanggalpemesanan;
    private String metodepembayaran;
    private int totalharga;
    private StatusPesanan statusP;
    
    public Pesanan(){
    
    }

    public Pesanan(int id_pesanan, Customers customer, Driver driver, String tanggalpemesanan, String metodepembayaran, int totalharga, StatusPesanan statusP) {
        this.id_pesanan = id_pesanan;
        this.customer = customer;
        this.driver = driver;
        this.tanggalpemesanan = tanggalpemesanan;
        this.metodepembayaran = metodepembayaran;
        this.totalharga = totalharga;
        this.statusP = statusP;
    }

    public int getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getTanggalpemesanan() {
        return tanggalpemesanan;
    }

    public void setTanggalpemesanan(String tanggalpemesanan) {
        this.tanggalpemesanan = tanggalpemesanan;
    }

    public String getMetodepembayaran() {
        return metodepembayaran;
    }

    public void setMetodepembayaran(String metodepembayaran) {
        this.metodepembayaran = metodepembayaran;
    }

    public int getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(int totalharga) {
        this.totalharga = totalharga;
    }

    public StatusPesanan getStatus() {
        return statusP;
    }

    public void setStatus(StatusPesanan statusP) {
        this.statusP = statusP;
    }

}