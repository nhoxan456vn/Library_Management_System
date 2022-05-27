/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Borrow_Record_DetailDTO;
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
public class Book_Borrow_Record_DetailDAO {
    DBConnection connection;
    
    public ArrayList<Book_Borrow_Record_DetailDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Borrow_Record_DetailDTO> arrBook_Borrow_Record_Detail = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_borrow_record_detail`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int br_detail_id = rs.getInt("br_detail_id");
                    int br_id = rs.getInt("br_id");
                    int book_id = rs.getInt("book_id");
                    String status = rs.getString("status");
                    arrBook_Borrow_Record_Detail.add(new Book_Borrow_Record_DetailDTO(br_detail_id, br_id, book_id, status));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Borrow_Record_Detail");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Borrow_Record_Detail;
    }
    
    public Boolean add(Book_Borrow_Record_DetailDTO book_Borrow_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_borrow_record_detail`(`br_id`, `book_id`, `status`) "
                + "VALUES ('"+book_Borrow_Record_Detail.getBr_id()+"','"
                +book_Borrow_Record_Detail.getBook_id()+"','"
                +book_Borrow_Record_Detail.getStatus()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_borrow_record_detail` WHERE `br_detail_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Borrow_Record_DetailDTO book_Borrow_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_borrow_record_detail` SET "
                + "`br_id`='"+book_Borrow_Record_Detail.getBr_id()
                +"',`book_id`='"+book_Borrow_Record_Detail.getBook_id()
                +"',`status`='"+book_Borrow_Record_Detail.getStatus()
                +"' WHERE `br_detail_id`='"+book_Borrow_Record_Detail.getBr_detail_id()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Borrow_Record_DetailID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_borrow_record_detail"
                + "` WHERE `br_detail_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Borrow_Record_DetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();            
        }

        return result;
    }
}
