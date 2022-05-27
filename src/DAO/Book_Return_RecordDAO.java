/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book_Return_RecordDTO;
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
public class Book_Return_RecordDAO {
    DBConnection connection;
    
    public ArrayList<Book_Return_RecordDTO> readDB(){
        connection = new DBConnection();
        ArrayList<Book_Return_RecordDTO> arrBook_Return_Record = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book_return_record`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int rt_id = rs.getInt("rt_id");
                    int br_id = rs.getInt("br_id");
                    int librarian_id = rs.getInt("librarian_id");
                    int member_id = rs.getInt("member_id");
                    int totalQuantity = rs.getInt("totalQuantity");
                    arrBook_Return_Record.add(new Book_Return_RecordDTO(rt_id, br_id, member_id, librarian_id, totalQuantity));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book_Return_Record");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook_Return_Record;
    }
    
    public Boolean add(Book_Return_RecordDTO book_Return_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book_return_record`(`br_id`, `librarian_id`, `member_id`, `totalQuantity`) VALUES ('"+book_Return_Record.getBr_id()+"','"+book_Return_Record.getLibrarian_id()+"','"+book_Return_Record.getMember_id()+"','"+book_Return_Record.getTotalQuantity()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book_return_record` WHERE `rt_id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(Book_Return_RecordDTO book_Return_Record){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book_return_record` SET "
                + "`br_id`='"+book_Return_Record.getBr_id()
                +"',`librarian_id`='"+book_Return_Record.getLibrarian_id()
                +"',`member_id`='"+book_Return_Record.getMember_id()
                +"',`totalQuantity`='"+book_Return_Record.getTotalQuantity()
                +"' WHERE `rt_id`='"+book_Return_Record.getRt_id()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBook_Return_RecordID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book_return_record` WHERE `rt_id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Book_Return_RecordDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
