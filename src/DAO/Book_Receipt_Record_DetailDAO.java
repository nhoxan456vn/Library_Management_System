/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Receipt_Record_DetailDTO;
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
public class Book_Receipt_Record_DetailDAO {
    DBConnection connection;
    
    public ArrayList<Book_Receipt_Record_DetailDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Receipt_Record_DetailDTO> arrBook_Receipt_Record_Detail = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_receipt_record_detail`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int receipt_detail_id = rs.getInt("receipt_detail_id");
                    int receipt_id = rs.getInt("receipt_id");
                    int book_id = rs.getInt("book_id");
                    int unitPrice = rs.getInt("unitPrice");
                    int quantity = rs.getInt("quantity");
                    int amount = rs.getInt("amount");
                    arrBook_Receipt_Record_Detail.add(new Book_Receipt_Record_DetailDTO(receipt_detail_id, receipt_id, book_id, unitPrice, quantity, amount));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Receipt_Record_Detail");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Receipt_Record_Detail;
    }
    
    public Boolean add(Book_Receipt_Record_DetailDTO book_Receipt_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_receipt_record_detail`(`receipt_id`, `book_id`, `unitPrice`, `quantity`, `amount`) "
                + "VALUES ('"
                +book_Receipt_Record_Detail.getReceipt_id()+"','"
                +book_Receipt_Record_Detail.getBook_id()+"','"
                +book_Receipt_Record_Detail.getUnitPrice()+"','"
                +book_Receipt_Record_Detail.getQuantity()+"','"
                +book_Receipt_Record_Detail.getAmount()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_receipt_record_detail` WHERE `receipt_detail_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Receipt_Record_DetailDTO book_Receipt_Record_Detail){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_receipt_record_detail` SET "
                + "`receipt_id`='"+book_Receipt_Record_Detail.getReceipt_id()
                +"',`book_id`='"+book_Receipt_Record_Detail.getBook_id()
                +"',`unitPrice`='"+book_Receipt_Record_Detail.getUnitPrice()
                +"',`quantity`='"+book_Receipt_Record_Detail.getQuantity()
                +"',`amount`='"+book_Receipt_Record_Detail.getAmount()
                +"' WHERE `receipt_detail_id`='"+book_Receipt_Record_Detail.getReceipt_detail_id()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Receipt_Record_DetailID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_receipt_record_detail` WHERE `receipt_detail_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Receipt_Record_DetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();  
        }
        return result;
    }
}
