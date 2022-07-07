
package Controller;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseControl {
    
    static DatabaseHandler conn = new DatabaseHandler();
    
     public static ArrayList<User>getAllUser(){
        conn.connect();
        ArrayList<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM user";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setId_User(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setTipe(rs.getInt("tipe"));
                listUser.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUser;
    }
    
    public static ArrayList<Driver>getAllDriver(){
        conn.connect();
        String query = "SELECT * FROM driver";
        ArrayList<Driver> listDriver = new ArrayList<>();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Driver driver = new Driver();
                User user = new Driver();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("ID_User"))){
                        user = listUser.get(i);
                    }
                }
                
                driver.setId_driver(rs.getInt("ID_Driver"));
                driver.setJeniskendaraan(rs.getString("Jenis_Kendaraan"));
                driver.setPlatnomor(rs.getString("Plat_Nomor"));
                driver.setPendapatan(rs.getInt("Pendapatan"));
                driver.setSaldoUp(rs.getInt("Saldo_Driver"));
                driver.setStatus(StatusDriver.valueOf(rs.getString("Status")));
                
                driver.setId_User(user.getId_User());
                driver.setNama(user.getNama());
                driver.setUsername(user.getUsername());
                driver.setPassword(user.getPassword());
                driver.setTipe(user.getTipe());
                
                listDriver.add(driver);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listDriver;
    }
    
    public static Customers getCustomerByIdCustomer(int idCustomer){
        conn.connect();
        String query = "SELECT * FROM customer WHERE ID_Customers = '" + idCustomer + "'";
        Customers customers = new Customers();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("ID_User"))){
                        user = listUser.get(i);
                    }
                }
                
                customers.setId_customer(rs.getInt("ID_Customers"));
                customers.setAlamat(rs.getString("Alamat"));
                customers.setSaldoUp(rs.getInt("Saldo_Up-Pay"));
                
                customers.setId_User(user.getId_User());
                customers.setNama(user.getNama());
                customers.setUsername(user.getUsername());
                customers.setPassword(user.getPassword());
                customers.setTipe(user.getTipe());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
    
    public static Driver getDriverByIdDriver(int idDriver){
        conn.connect();
        String query = "SELECT * FROM driver WHERE ID_Driver = '" + idDriver + "'";
        Driver driver = new Driver();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("id_user"))){
                        user = listUser.get(i);
                    }
                }
                
                driver.setId_driver(rs.getInt("ID_Driver"));
                driver.setJeniskendaraan(rs.getString("Jenis_Kendaraan"));
                driver.setPlatnomor(rs.getString("Plat_Nomor"));
                driver.setPendapatan(rs.getInt("Pendapatan"));
                driver.setSaldoUp(rs.getInt("Saldo_Driver"));
                driver.setStatus(StatusDriver.valueOf(rs.getString("Status")));
                
                driver.setId_User(user.getId_User());
                driver.setNama(user.getNama());
                driver.setUsername(user.getUsername());
                driver.setPassword(user.getPassword());
                driver.setTipe(user.getTipe());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return driver;
    }
    
    public static boolean updateStatusDriver(String status, int idDriver){
        conn.connect();
        String query = "UPDATE driver SET status = '" + status + "' WHERE id_Driver = " + idDriver;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewPesanan(Pesanan pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan (ID,ID_Customer,ID_Driver,Tanggal_Pemesanan,Metode_Pembayaran,Total_Harga,) values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getCustomer().getId_customer());
            stmt.setInt(3, pesanan.getDriver().getId_driver());
            stmt.setString(4, pesanan.getTanggalpemesanan());
            stmt.setString(5, pesanan.getMetodepembayaran());
            stmt.setInt(6, pesanan.getTotalharga());
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewPesananOjek(PesananOjek pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan_ojek (ID_PesananOjek,ID_Pesanan,Jenis_Kendaraan,Alamat_Penjemputan,Alamat_Destinasi) values (?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getId_pesanan());
            stmt.setString(3, pesanan.getJenisKendaraan());
            stmt.setString(4, pesanan.getAlamat_Penjemputan());
            stmt.setString(5, pesanan.getAlamat_Destinasi());
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        
    public static Pesanan getPesananTerbaru(){
        conn.connect();
        Pesanan pesanan = new PesananOjek();
        PesananOjek pesananojek = new PesananOjek();
        String query = "SELECT * FROM pesanan ORDER BY ID_Pesanan DESC LIMIT 1";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            DatabaseControl ctrl = new DatabaseControl();
            
            while(rs.next()){
                pesanan.setId_pesanan(rs.getInt("ID_Pesanan"));
                pesanan.setCustomer(ctrl.getCustomerByIdCustomer(rs.getInt("ID_Customer")));
                pesanan.setDriver(ctrl.getDriverByIdDriver(rs.getInt("ID_Driver")));
                pesanan.setTanggalpemesanan(rs.getString("Tanggal_Pemesanan"));
                pesanan.setMetodepembayaran(rs.getString("Metode_Pembayaran"));
                pesanan.setTotalharga(rs.getInt("Total_Harga"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pesanan;
    }
    
    public static ArrayList<Restaurant> getAllRestaurant(){
        conn.connect();
        ArrayList<Restaurant> listRestaurant = new ArrayList<>();
        String query = "SELECT * FROM restaurant";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setId_restaurant(rs.getInt("ID_Restaurant"));
                restaurant.setNamarestaurant(rs.getString("Nama_Restaurant"));
                restaurant.setAlamatrestaurant(rs.getString("Alamat"));
                listRestaurant.add(restaurant);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listRestaurant;
    }
    
    public static ArrayList<Food> getAllFood(){
        conn.connect();
        ArrayList<Food> listFood = new ArrayList<>();
        String query = "SELECT * FROM makanan";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Restaurant> listRestaurant = new ArrayList<>();
                listRestaurant = ctrl.getAllRestaurant();
                Restaurant restaurant = new Restaurant();
                for(int i = 0; i < listRestaurant.size(); i++){
                    if(listRestaurant.get(i).getId_restaurant() == rs.getInt("ID_Restoran")){
                        restaurant = listRestaurant.get(i);
                    }
                }
                
                Food food = new Food();
                food.setIdmakanan(rs.getInt("ID_Makanan"));
                food.setRestaurant(restaurant);
                food.setNamamakanan(rs.getString("Nama_Makanan"));
                food.setHargamakanan(rs.getInt("Harga_Makanan"));
                
                listFood.add(food);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listFood;
    }
    
    public static boolean insertNewPesananFood(PesananFood pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan_food (ID_PesananFood,ID_Pesanan,Alamat_Pengantaran,Status_Pesanan) values (?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getId_pesanan());
            stmt.setString(3, pesanan.getAlamat_Pengantaran());
            stmt.setString(4, pesanan.getStatus().name());
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
