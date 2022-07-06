/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Driver;

/**
 *
 * @author William
 */
public class DriverManager {
    static DriverManager instance;
    private Driver driver;
    private boolean login;
    
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
    
    public Driver getDrivers() {
        return driver;
    }

    public void setDrivers(Driver driver) {
        this.driver = driver;
    }
    public boolean getLogin(){
        return login;
    }
    public void setLogin(boolean login){
        this.login = login;
    }
}
