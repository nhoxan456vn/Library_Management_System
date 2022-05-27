/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SupplierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manh Hai
 */
public class SupplierDAO {
    DBConnection connection;
    
    public ArrayList<SupplierDTO> readDB(){
        connection = new DBConnection();
        ArrayList<SupplierDTO> arrSupplier = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `author`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int supplier_id = rs.getInt("supplier_id");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    arrSupplier.add(new SupplierDTO(supplier_id, name, phone, address));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Supplier");
        } 
        finally{
            connection.closeConnection();
        }
        return arrSupplier;
    }
    
    public Boolean add(SupplierDTO supplier){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `supplier`(`name`, `phone`, `address`) "
                + "VALUES ('"+supplier.getName()+"','"
                +supplier.getPhoneNumber()+"','"
                +supplier.getAddress()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `supplier` WHERE `supplier_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(SupplierDTO supplier){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `supplier` SET "
                + "`name`='"+supplier.getName()
                +"',`phone`='"+supplier.getPhoneNumber()
                +"',`address`='"+supplier.getAddress()
                +"' WHERE `supplier_id`='"+supplier.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasAuthorID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `supplier` WHERE `supplier_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }

 
}
