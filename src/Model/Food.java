
package Model;

public class Food {
    private int idmakanan;
    private String namamakanan;
    Restaurant restaurant;
    private int hargamakanan;

    public Food() {
    }

    public Food(int idmakanan, String namamakanan, Restaurant restaurant, int hargamakanan) {
        this.idmakanan = idmakanan;
        this.namamakanan = namamakanan;
        this.restaurant = restaurant;
        this.hargamakanan = hargamakanan;
    }

    public int getIdmakanan() {
        return idmakanan;
    }

    public void setIdmakanan(int idmakanan) {
        this.idmakanan = idmakanan;
    }

    public String getNamamakanan() {
        return namamakanan;
    }

    public void setNamamakanan(String namamakanan) {
        this.namamakanan = namamakanan;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getHargamakanan() {
        return hargamakanan;
    }

    public void setHargamakanan(int hargamakanan) {
        this.hargamakanan = hargamakanan;
    }
}
