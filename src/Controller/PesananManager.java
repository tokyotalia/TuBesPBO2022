
package Controller;

import Model.Pesanan;

public class PesananManager {
    static PesananManager instance;
    private Pesanan pesanan;

    public static PesananManager getInstance(){
        if(instance == null){
            instance = new PesananManager();
        }
        return instance;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }
}
