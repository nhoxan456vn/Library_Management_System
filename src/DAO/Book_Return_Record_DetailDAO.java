/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Return_Record_DetailDTO;
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
public class Book_Return_Record_DetailDAO {
    DBConnection connection;
    
    public ArrayList<Book_Return_Record_DetailDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Return_Record_DetailDTO> arrBook_Return_Record_Detail = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_return_record_detail`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int rt_detail_id = rs.getInt("rt_detail_id");
                    int rt_id = rs.getInt("rt_id");
                    int book_id = rs.getInt("book_id");
                    String status = rs.getString("status");
                    String termDate = rs.getString("termDate");
                    String returnDate = rs.getString("returnDate");
                    int fine = rs.getInt("fine");
                    arrBook_Return_Record_Detail.add(new Book_Return_Record_DetailDTO(rt_detail_id, rt_id, book_id, status, termDate, returnDate, fine));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Return_Record_Detail");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Return_Record_Detail;
    }
    
    public Boolean add(Book_Return_Record_DetailDTO book_Return_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_return_record_detail`(`rt_id`, `book_id`, `status`, `termDate`, `returnDate`, `fine`) "
                + "VALUES ('"
                +book_Return_Record_Detail.getRt_id()+"','"
                +book_Return_Record_Detail.getBook_id()+"','"
                +book_Return_Record_Detail.getStatus()+"','"
                +book_Return_Record_Detail.getTermDate()+"','"
                +book_Return_Record_Detail.getReturnDate()+"','"
                +book_Return_Record_Detail.getFine()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_return_record_detail` WHERE `rt_detail_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Return_Record_DetailDTO book_Return_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_return_record_detail` SET "
                + "`rt_id`='"+book_Return_Record_Detail.getRt_id()
                +"',`book_id`='"+book_Return_Record_Detail.getBook_id()
                +"',`status`='"+book_Return_Record_Detail.getStatus()
                +"',`termDate`='"+book_Return_Record_Detail.getTermDate()
                +"',`returnDate`='"+book_Return_Record_Detail.getReturnDate()
                +"',`fine`='"+book_Return_Record_Detail.getFine()
                +"' WHERE `rt_detail_id`='"+book_Return_Record_Detail.getRt_detail_id()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Return_Record_DetailID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_return_record_detail` WHERE `rt_detail_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Return_Record_DetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
