
package Model;

public class Restaurant {
    private int id_retaurant;
    private String namarestaurant;
    private String alamatrestaurant;
    
    public Restaurant(){
        
    }

    public Restaurant(int id_retaurant, String namarestaurant, String alamatrestaurant) {
        this.id_retaurant = id_retaurant;
        this.namarestaurant = namarestaurant;
        this.alamatrestaurant = alamatrestaurant;
    }

    public int getId_restaurant() {
        return id_retaurant;
    }

    public void setId_restaurant(int id_retaurant) {
        this.id_retaurant = id_retaurant;
    }

    public String getNamarestaurant() {
        return namarestaurant;
    }

    public void setNamarestaurant(String namarestaurant) {
        this.namarestaurant = namarestaurant;
    }

    public String getAlamatrestaurant() {
        return alamatrestaurant;
    }

    public void setAlamatrestaurant(String alamatrestaurant) {
        this.alamatrestaurant = alamatrestaurant;
    }

}
