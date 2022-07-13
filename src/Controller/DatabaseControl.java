
package Controller;

import Model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatabaseControl {
    
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static boolean Register(User user) {
        conn.connect();
        String query = "INSERT INTO user(ID_User, Nama, Username, Password, Tipe) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, user.getNama());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getTipe());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    } 
    
        public static User getIdUserTerbaru(){
        conn.connect();
        User user = new User();
        String query = "SELECT ID_User FROM user ORDER BY ID_User DESC LIMIT 1";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            DatabaseControl ctrl = new DatabaseControl();
            
            while(rs.next()){
                user.setId_User(rs.getInt("ID_User"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static boolean RegisterCustomer(Customers customers){
        conn.connect();
        String query = "INSERT INTO customer(ID_Customer, ID_User, Alamat, Saldo_Up_Pay) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, customers.getId_User());
            stmt.setString(3, customers.getAlamat());
            stmt.setInt(4, 0);
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean RegisterDriver(Driver driver){
        conn.connect();
        String query = "INSERT INTO driver(ID_Driver, ID_User, Jenis_Kendaraan, Plat_Nomor, Saldo_Driver, Pendapatan, Status) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, driver.getId_User());
            stmt.setString(3, driver.getJeniskendaraan());
            stmt.setString(4, driver.getPlatnomor());
            stmt.setInt(5, 0);
            stmt.setInt(6, 0);
            stmt.setString(7, StatusDriver.AVAILABLE.name());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
     public static ArrayList<User>getAllUser(){
        conn.connect();
        ArrayList<User> listUser = new ArrayList<>();
        String query = "SELECT * FROM user";
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setId_User(rs.getInt("ID_User"));
                user.setNama(rs.getString("Nama"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setTipe(rs.getInt("Tipe"));
                listUser.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listUser;
    }
     
    public static ArrayList<Customers> getAllCustomer(){
        conn.connect();
        String query = "SELECT * FROM customer";
        ArrayList<Customers> listCustomer = new ArrayList<>();
        
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Customers customers = new Customers();
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == (rs.getInt("ID_User"))){
                        user = listUser.get(i);
                    }
                }
                
                customers.setId_customer(rs.getInt("ID_Customer"));
                customers.setAlamat(rs.getString("Alamat"));
                customers.setSaldoUp(rs.getInt("Saldo_Up_Pay"));
                
                customers.setId_User(user.getId_User());
                customers.setNama(user.getNama());
                customers.setUsername(user.getUsername());
                customers.setPassword(user.getPassword());
                customers.setTipe(user.getTipe());
                
                listCustomer.add(customers);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    public static ArrayList<Admin> getAllAdmin(){
        conn.connect();
        String query = "SELECT * FROM admin";
        ArrayList<Admin> listAdmin = new ArrayList<>();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Admin admin = new Admin();
                User user = new User();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ctrl.getAllUser();
                
                for(int i = 0; i < listUser.size(); i++){
                    if(listUser.get(i).getId_User() == rs.getInt("ID_User")){
                        user = listUser.get(i);
                    }
                }
                
                admin.setId_admin(rs.getInt("ID_Admin"));
                
                admin.setId_User(user.getId_User());
                admin.setNama(user.getNama());
                admin.setUsername(user.getUsername());
                admin.setPassword(user.getPassword());
                admin.setTipe(user.getTipe());
                
                listAdmin.add(admin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listAdmin;
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
                User user = new User();
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
        String query = "SELECT * FROM customer WHERE ID_Customer = '" + idCustomer + "'";
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
                
                customers.setId_customer(rs.getInt("ID_Customer"));
                customers.setAlamat(rs.getString("Alamat"));
                customers.setSaldoUp(rs.getInt("Saldo_Up_Pay"));
                
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
        String query = "UPDATE driver SET Status = '" + status + "' WHERE ID_Driver = " + idDriver;
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
        String query = "INSERT INTO pesanan (ID_Pesanan,ID_Customer,ID_Driver,Total_Harga,Tanggal_Pemesanan,Metode_Pembayaran) values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getCustomer().getId_customer());
            stmt.setInt(3, pesanan.getDriver().getId_driver());
            stmt.setInt(4, pesanan.getTotalharga());
            stmt.setString(5, pesanan.getTanggalpemesanan());
            stmt.setString(6, pesanan.getMetodepembayaran());   
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean insertNewPesananOjek(PesananOjek pesanan){
        conn.connect();
        String query = "INSERT INTO pesanan_ojek (ID_PesananOjek,ID_Pesanan,Jenis_Kendaraan,Alamat_Penjemputan,Alamat_Destinasi,Status_Pesanan) values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setInt(2, pesanan.getId_pesanan());
            stmt.setString(3, pesanan.getJenisKendaraan());
            stmt.setString(4, pesanan.getAlamat_Penjemputan());
            stmt.setString(5, pesanan.getAlamat_Destinasi());
            stmt.setString(6, pesanan.getStatus().name());
            
            stmt.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        
    public static Pesanan getPesananTerbaru(){
        conn.connect();
        Pesanan pesanan = new Pesanan();
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
    
    public static ArrayList<Pesanan> getAllPesanan(){
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan";
        DatabaseControl ctrl = new DatabaseControl();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pesanan pesanan = new Pesanan();
                pesanan.setId_pesanan(rs.getInt("ID_Pesanan"));
                pesanan.setCustomer(ctrl.getCustomerByIdCustomer(rs.getInt("ID_Customer")));
                pesanan.setDriver(ctrl.getDriverByIdDriver(rs.getInt("ID_Driver")));
                pesanan.setTanggalpemesanan(rs.getString("Tanggal_Pemesanan"));
                pesanan.setMetodepembayaran(rs.getString("Metode_Pembayaran"));
                pesanan.setTotalharga(rs.getInt("Total_Harga"));
                listPesanan.add(pesanan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesanan;
    }
    
    public static ArrayList<Pesanan> getAllPesananByDriverId(int idDriver){
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan WHERE ID_Driver = '" + idDriver + "'";
        DatabaseControl ctrl = new DatabaseControl();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pesanan pesanan = new Pesanan();
                pesanan.setId_pesanan(rs.getInt("ID_Pesanan"));
                pesanan.setCustomer(ctrl.getCustomerByIdCustomer(rs.getInt("ID_Customer")));
                pesanan.setDriver(ctrl.getDriverByIdDriver(rs.getInt("ID_Driver")));
                pesanan.setTanggalpemesanan(rs.getString("Tanggal_Pemesanan"));
                pesanan.setMetodepembayaran(rs.getString("Metode_Pembayaran"));
                pesanan.setTotalharga(rs.getInt("Total_Harga"));
                listPesanan.add(pesanan);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesanan;
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
                    if(listRestaurant.get(i).getId_restaurant() == rs.getInt("ID_Restaurant")){
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
    
    public static ArrayList<PesananFood> getAllPesananFood(){
        ArrayList<PesananFood> listPesananFood = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan_food";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Pesanan pesanan = new Pesanan();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                listPesanan = ctrl.getAllPesanan();
                PesananFood pesananFood = new PesananFood();
                
                for(int i = 0; i < listPesanan.size(); i++){
                    if(listPesanan.get(i).getId_pesanan() == rs.getInt("ID_Pesanan")){
                        pesanan = listPesanan.get(i);
                    }
                }
                
                pesananFood.setID_PesananFood(rs.getInt("ID_PesananFood"));
                pesananFood.setId_pesanan(rs.getInt("ID_Pesanan"));
                pesananFood.setAlamat_Pengantaran(rs.getString("Alamat_Pengantaran"));
                pesananFood.setStatus(StatusPesanan.valueOf(rs.getString("Status_Pesanan")));
                
                pesananFood.setId_pesanan(pesanan.getId_pesanan());
                pesananFood.setCustomer(pesanan.getCustomer());
                pesananFood.setDriver(pesanan.getDriver());
                pesananFood.setTanggalpemesanan(pesanan.getTanggalpemesanan());
                pesananFood.setMetodepembayaran(pesanan.getMetodepembayaran());
                pesananFood.setTotalharga(pesanan.getTotalharga());
                
                listPesananFood.add(pesananFood);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesananFood;
    }
    
    public static ArrayList<PesananOjek> getAllPesananOjek(){
        ArrayList<PesananOjek> listPesananOjek = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM pesanan_ojek";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                PesananOjek pesananOjek = new PesananOjek();
                Pesanan pesanan = new Pesanan();
                DatabaseControl ctrl = new DatabaseControl();
                ArrayList<Pesanan> listPesanan = new ArrayList<>();
                listPesanan = ctrl.getAllPesanan();
                
                for(int i = 0; i < listPesanan.size(); i++){
                    if(listPesanan.get(i).getId_pesanan() == rs.getInt("id_pesanan")){
                        pesanan = listPesanan.get(i);
                    }
                }
                pesananOjek.setId_pesananojek(rs.getInt("ID_PesananOjek"));
                pesananOjek.setAlamat_Penjemputan(rs.getString("Alamat_Penjemputan"));
                pesananOjek.setAlamat_Destinasi(rs.getString("Alamat_Destinasi"));
                pesananOjek.setJenisKendaraan(rs.getString("Jenis_Kendaraan"));
                pesananOjek.setStatus(StatusPesanan.valueOf(rs.getString("Status_Pesanan")));
                
                pesananOjek.setId_pesanan(pesanan.getId_pesanan());
                pesananOjek.setCustomer(pesanan.getCustomer());
                pesananOjek.setDriver(pesanan.getDriver());
                pesananOjek.setTanggalpemesanan(pesanan.getTanggalpemesanan());
                pesananOjek.setMetodepembayaran(pesanan.getMetodepembayaran());
                pesananOjek.setTotalharga(pesanan.getTotalharga());
  
                listPesananOjek.add(pesananOjek);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listPesananOjek;
    }
    
    public static boolean updateStatusPesananFood(String status, int idPesananFood){
        conn.connect();
        String query = "UPDATE pesanan_food SET Status_Pesanan = '" + status + "' WHERE ID_PesananFood = " + idPesananFood;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        
    public static boolean updateStatusPesananOjek(String status, int idPesananOjek){
        conn.connect();
        String query = "UPDATE pesanan_ojek SET Status_Pesanan = '" + status + "' WHERE ID_PesananOjek = " + idPesananOjek;
        try{
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean updateCustomer(Customers customer) {
        conn.connect();
        String query = "UPDATE customer SET Saldo_Up_Pay=" + customer.getSaldoUp() + " WHERE ID_Customer=" + customer.getId_customer();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean updateDriver(Driver driver) {
        conn.connect();
        String query = "UPDATE driver SET Saldo_Driver=" + driver.getSaldoUp() + ", Pendapatan=" + driver.getPendapatan() + " WHERE ID_Driver=" + driver.getId_driver();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    public static boolean DeleteDriver(int idDriver) {
        conn.connect();
        String query = "SET foreign_key_checks = 0";
        String query2 = "DELETE FROM driver WHERE ID_Driver='" + idDriver + "'";
        String query3 = "SET foreign_key_checks = 1";
        try {
            Statement stmt = conn.con.createStatement();
            int i = stmt.executeUpdate(query);
            int j = stmt.executeUpdate(query2);
            int k = stmt.executeUpdate(query3);
            if (j == 0) {
                JOptionPane.showMessageDialog(null, "Gagal Dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            }
            return (true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
            e.printStackTrace();
            return (false);
        }
    }
    
    public static int SelectUserDriver(int idDriver) {
        conn.connect();
        int id = 0;
        String query = "SELECT ID_User FROM driver WHERE ID_Driver='" + idDriver + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                id = rs.getInt("ID_User");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
            e.printStackTrace();
        }
        return id;
    }
    
    public static boolean DeleteUserDriver(int id) {
        conn.connect();
        String query = "DELETE FROM user WHERE ID_User='" + id + "'";
        try {
            Statement stmt = conn.con.createStatement();
            int i = stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
            e.printStackTrace();
            return (false);
        }
    }
}
