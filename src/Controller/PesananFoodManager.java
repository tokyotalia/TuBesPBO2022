
package Controller;

import Model.PesananFood;

public class PesananFoodManager {
    static PesananFoodManager instance;
    private PesananFood pesananfood;
    
    public static PesananFoodManager getInstance(){
        if(instance == null){
            instance = new PesananFoodManager();
        }
        return instance;
    }

    public PesananFood getPesananfood() {
        return pesananfood;
    }

    public void setPesananfood(PesananFood pesananfood) {
        this.pesananfood = pesananfood;
    }
}
