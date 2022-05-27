/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UserDTO;
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
public class UserDAO {
    DBConnection connection;
    
    public ArrayList<UserDTO> readDB(){
        connection = new DBConnection();
        ArrayList<UserDTO> arrUser = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `user`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String user_type = rs.getString("user_type");

                    arrUser.add(new UserDTO(id, firstName, lastName, userName, password, user_type));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng User");
        } 
        finally{
            connection.closeConnection();
        }
        return arrUser;
    }
    
    public Boolean add(UserDTO user){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `user`(`firstName`, `lastName`, `userName`, `password`, `user_type`) "
                + "VALUES ('"+user.getFirstName()+"','"
                +user.getLastName()+"','"
                +user.getUserName()+"','"
                +user.getPassword()+"','"
                +user.getUserType()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `user` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(UserDTO user){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `user` SET "
                + "`firstName`='"+user.getFirstName()
                +"',`lastName`='"+user.getLastName()
                +"',`userName`='"+user.getUserName()
                +"',`password`='"+user.getPassword()
                +"',`user_type`='"+user.getUserType()
                +"' WHERE `id`='"+user.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasUserID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `user` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
    
    public ResultSet findUser(String username, String password) {
        connection = new DBConnection();
        String selectQuery = "SELECT * FROM `user` WHERE `userName`='"+username+"' AND `password`='"+password+"'";
        ResultSet rs = connection.SQLQuery(selectQuery);
        connection.closeConnection();
        return rs;
    }
    
    public ResultSet findUserName(int id, String username) {
        connection = new DBConnection();
        String selectQuery = "SELECT * FROM `user` WHERE `userName`='" + username + "' AND id <> " + id;;
        ResultSet rs = connection.SQLQuery(selectQuery);
        connection.closeConnection();
        return rs;
    }
}
