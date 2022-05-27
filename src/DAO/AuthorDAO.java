/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AuthorDTO;
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
public class AuthorDAO {
    DBConnection connection;
    
    public ArrayList<AuthorDTO> readDB(){
        connection = new DBConnection();
        ArrayList<AuthorDTO> arrAuthor = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `author`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String expertise = rs.getString("expertise");
                    String about = rs.getString("about");
                    arrAuthor.add(new AuthorDTO(id, firstName, lastName, expertise, about));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Author");
        } 
        finally{
            connection.closeConnection();
        }
        return arrAuthor;
    }
    
    public Boolean add(AuthorDTO author){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `author`(`firstName`, `lastName`, `expertise`, `about`) "
                + "VALUES ('"
                + author.getFirstName()+ "','"
                + author.getLastName()+ "','"
                + author.getExpertise()+ "','"
                + author.getAbout()+ "')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `author` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(AuthorDTO author){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `author` SET "
                + "`firstName`='"+author.getFirstName()+"',"
                + "`lastName`='"+author.getLastName()+"',"
                + "`expertise`='"+author.getExpertise()+"',"
                + "`about`='"+author.getAbout()+"' "
                + "WHERE `id`='"+author.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasAuthorID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `author` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
