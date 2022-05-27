/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Borrow_RecordDTO;
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
public class Book_Borrow_RecordDAO {
    DBConnection connection;
    
    public ArrayList<Book_Borrow_RecordDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Borrow_RecordDTO> arrBook_Borrow_Record = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_borrow_record`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int br_id = rs.getInt("br_id");
                    int member_id  = rs.getInt("member_id");
                    int librarian_id = rs.getInt("librarian_id");
                    String borrowDate = rs.getString("borrowDate");
                    String termDate = rs.getString("termDate");
                    int totalQuantity = rs.getInt("totalQuantity");
                    arrBook_Borrow_Record.add(new Book_Borrow_RecordDTO(br_id, librarian_id, member_id, borrowDate, termDate, totalQuantity));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Borrow_Record");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Borrow_Record;
    }
    
    public Boolean add(Book_Borrow_RecordDTO Book_Borrow_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_borrow_record`(`member_id`, `librarian_id`, `borrowDate`, `termDate`, `totalQuantity`) "
                + "VALUES ('"+Book_Borrow_Record.getMember_id()+"','"
                +Book_Borrow_Record.getLibrarian_id()+"','"
                +Book_Borrow_Record.getBorrowDate()+"','"
                +Book_Borrow_Record.getTermDate()+"','"
                +Book_Borrow_Record.getTotalQuantity()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_borrow_record` WHERE `br_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Borrow_RecordDTO Book_Borrow_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_borrow_record` "
                + "SET `member_id`='"+Book_Borrow_Record.getMember_id()
                +"',`librarian_id`='"+Book_Borrow_Record.getLibrarian_id()
                +"',`borrowDate`='"+Book_Borrow_Record.getBorrowDate()
                +"',`termDate`='"+Book_Borrow_Record.getTermDate()
                +"',`totalQuantity`='"+Book_Borrow_Record.getTotalQuantity()
                +"' WHERE `br_id`='"+Book_Borrow_Record.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Borrow_RecordID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_borrow_record` WHERE `br_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Borrow_RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
