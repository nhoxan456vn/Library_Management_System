/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PublisherDTO;
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
public class PublisherDAO {
    DBConnection connection;
    
    public ArrayList<PublisherDTO> readDB(){
        connection = new DBConnection();
        ArrayList<PublisherDTO> arrPublisher = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `publisher`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    arrPublisher.add(new PublisherDTO(id, name));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Publisher");
        } 
        finally{
            connection.closeConnection();
        }
        return arrPublisher;
    }
    
    public Boolean add(PublisherDTO publisher){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `publisher`(`name`) VALUES ('"+publisher.getName()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `publisher` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(PublisherDTO publisher){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `publisher` SET `name`='"+publisher.getName()+"' WHERE `id`='"+publisher.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasPublisherID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `publisher` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(PublisherDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
