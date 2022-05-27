/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LibrarianDTO;
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
public class LibrarianDAO {
    DBConnection connection;
    
    public ArrayList<LibrarianDTO> readDB(){
        connection = new DBConnection();
        ArrayList<LibrarianDTO> arrLibrarian = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `librarian`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id  = rs.getInt("librarian_id");
                    int user_id = rs.getInt("user_id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String gender = rs.getString("gender");
                    String picture = rs.getString("picture");
                    arrLibrarian.add(new LibrarianDTO(id, user_id, firstName, lastName, phone, email, gender, address, picture));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Librarian");
        } 
        finally{
            connection.closeConnection();
        }
        return arrLibrarian;
    }
    
    public Boolean add(LibrarianDTO librarian){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `librarian`(`user_id`, `firstName`, `lastName`, `phone`, `email`, `address`, `gender`, `picture`) "
                + "VALUES ('"+librarian.getUser_id()+"','"
                +librarian.getFirstName()+"','"
                +librarian.getLastName()+"','"
                +librarian.getPhoneNumber()+"','"
                +librarian.getEmail()+"','"
                +librarian.getAddress()+"','"
                +librarian.getGender()+"','"
                +librarian.getPicture()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `librarian` WHERE `librarian_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(LibrarianDTO librarian){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `librarian` SET "
                + "`user_id`='"+librarian.getUser_id()
                +"',`firstName`='"+librarian.getFirstName()
                +"',`lastName`='"+librarian.getLastName()
                +"',`phone`='"+librarian.getPhoneNumber()
                +"',`email`='"+librarian.getEmail()
                +"',`address`='"+librarian.getAddress()
                +"',`gender`='"+librarian.getGender()
                +"',`picture`='"+librarian.getPicture()
                +"' WHERE `librarian_id`='"+librarian.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasLibrarianID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `librarian` WHERE `librarian_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(LibrarianDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }

    public ArrayList<LibrarianDTO> getArrLibrarian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
