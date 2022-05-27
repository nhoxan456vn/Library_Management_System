/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.GenreDTO;
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
public class GenreDAO {
    DBConnection connection;
    
    public ArrayList<GenreDTO> readDB(){
        connection = new DBConnection();
        ArrayList<GenreDTO> arrGenre = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `genre`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    arrGenre.add(new GenreDTO(id, name));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Genre");
        } 
        finally{
            connection.closeConnection();
        }
        return arrGenre;
    }
    
    public Boolean add(GenreDTO genre){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `genre`(`name`) VALUES ('"+genre.getName()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `genre` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(GenreDTO genre){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `genre` SET `name`='"+genre.getName()+"' WHERE `id`='"+genre.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasGenreID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `genre` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
    
    public ResultSet getGenresMap() {
        connection = new DBConnection();
        String selectQuery = "SELECT * FROM `genre`";
        ResultSet rs = connection.SQLQuery(selectQuery);
        connection.closeConnection();
        return rs;
    }
}
