
package Controller;

import Model.PesananOjek;

public class PesananOjekManager {
    static PesananOjekManager instance;
    private PesananOjek pesananojek;
    
    public static PesananOjekManager getInstance(){
        if(instance == null){
            instance = new PesananOjekManager();
        }
        return instance;
    }

    public PesananOjek getPesananojek() {
        return pesananojek;
    }

    public void setPesananojek(PesananOjek pesananojek) {
        this.pesananojek = pesananojek;
    }
    
}
