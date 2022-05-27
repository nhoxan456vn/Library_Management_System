/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Receipt_RecordDTO;
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
public class Book_Receipt_RecordDAO {
    DBConnection connection;
    
    public ArrayList<Book_Receipt_RecordDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Receipt_RecordDTO> arrBook_Receipt_Record = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_receipt_record`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int receipt_id  = rs.getInt("receipt_id");
                    int supplier_id = rs.getInt("supplier_id");
                    int librarian_id = rs.getInt("librarian_id");
                    String date = rs.getString("date");
                    int totalMoney = rs.getInt("totalMoney");
                    int totalQuantity = rs.getInt("totalQuantity");
                    arrBook_Receipt_Record.add(new Book_Receipt_RecordDTO(receipt_id, librarian_id, supplier_id, date, totalQuantity, totalMoney));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Receipt_Record");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Receipt_Record;
    }
    
    public Boolean add(Book_Receipt_RecordDTO book_Receipt_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_receipt_record`(`supplier_id`, `librarian_id`, `date`, `totalMoney`, `totalQuantity`) "
                + "VALUES ('"+book_Receipt_Record.getSupplier_id()+"','"
                +book_Receipt_Record.getLibrarian_id()+"','"
                +book_Receipt_Record.getDate()+"','"
                +book_Receipt_Record.getTotalMoney()+"','"
                +book_Receipt_Record.getTotalQuantity()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_receipt_record` WHERE `receipt_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Receipt_RecordDTO book_Receipt_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_receipt_record` SET `supplier_id`='"+book_Receipt_Record.getSupplier_id()+"',`librarian_id`='"+book_Receipt_Record.getLibrarian_id()+"',`date`='"+book_Receipt_Record.getDate()+"',`totalMoney`='"+book_Receipt_Record.getTotalMoney()+"',`totalQuantity`='"+book_Receipt_Record.getTotalQuantity()+"' WHERE `receipt_id`='"+book_Receipt_Record.getReceipt_id()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Receipt_RecordID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_receipt_record` WHERE `receipt_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Receipt_RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();           
        }

        return result;
    }
}
