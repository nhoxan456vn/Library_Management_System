
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BookDTO;
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
public class BookDAO {
    DBConnection connection;
    
    public ArrayList<BookDTO> readDB(){
        connection = new DBConnection();
        ArrayList<BookDTO> arrBook = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `book`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String isbn = rs.getString("isbn");
                    int genre_id = rs.getInt("genre_id");
                    int author_id = rs.getInt("author_id");
                    String publisher = rs.getString("publisher");
                    double price = rs.getDouble("price");
                    String date_reveived = rs.getString("date_received");
                    String description = rs.getString("description");
                    int totalQuantity = rs.getInt("totalQuantity");
                    int borrowQuantity = rs.getInt("borrowQuantity");
                    String picture = rs.getString("picture");
                    arrBook.add(new BookDTO(id, name, isbn, genre_id, author_id, publisher, price, date_reveived, description, totalQuantity, borrowQuantity, picture));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Book");
        } 
        finally{
            connection.closeConnection();
        }
        return arrBook;
    }
    
    public Boolean add(BookDTO book){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `book`(`isbn`, `name`, `author_id`, `genre_id`, `publisher`, `price`, `date_received`, `description`, `picture`, `totalQuantity`, `borrowQuantity`) "
                + "VALUES ('"+book.getIsbn()+"','"
                +book.getName()+"','"
                +book.getAuthor_id()+"','"
                +book.getGenre_id()+"','"
                +book.getPublisher()+"','"
                +book.getPrice()+"','"
                +book.getDate_received()+"','"
                +book.getDescription()+"','"
                +book.getPicture()+"','"
                +book.getTotalQuantity()+"','"
                +book.getBorrowQuantity()+"')"); 
        connection.closeConnection();
        return check;
    }
    
    public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean del(String isbn){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `book` WHERE `isbn` = '"+isbn+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(BookDTO book){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `book` "
                + "SET `name`='"+book.getName()
                +"' ,`author_id`='"+book.getAuthor_id()
                +"' ,`genre_id`='"+book.getGenre_id()
                +"' ,`totalQuantity`='"+book.getTotalQuantity()
                +"' ,`publisher`='"+book.getPublisher()
                +"' ,`price`='"+book.getPrice()
                +"' ,`date_received`='"+book.getDate_received()
                +"' ,`description`='"+book.getDescription()
                +"' ,`picture`='"+book.getPicture()
                +"' WHERE `isbn` ='"+book.getIsbn()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasBookID(int id) {
        connection = new DBConnection();
        boolean result = false;
        String query = "SELECT * FROM `book` WHERE `id`='"+id+"'";
        ResultSet rs = connection.SQLQuery(query);
        if (rs != null){
            result = true;
        }
        connection.closeConnection();
        return result;
    }
    
    public Boolean hasISBN(String isbn) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `book` WHERE `isbn`='"+isbn+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
    
    public ArrayList<BookDTO> bookListByName(String value) {
        connection = new DBConnection();
        ArrayList<BookDTO> bList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `book` WHERE `name` LIKE '%"+value+"%' OR `description` LIKE '%"+value+"%'";
        ResultSet rs = connection.SQLQuery(selectQuery);
        BookDTO bookDTO;
        
        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String isbn = rs.getString("isbn");
                String name = rs.getString("name");
                int author_id = rs.getInt("author_id");
                int genre_id = rs.getInt("genre_id");
                int quantity = rs.getInt("totalQuantity");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                String date_received = rs.getString("date_received");
                String description = rs.getString("description");
                String cover = rs.getString("picture");
                
                bookDTO = new BookDTO(id, name, isbn, genre_id, author_id, publisher, price, date_received, description, quantity, cover);
                bList.add(bookDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        
        return bList;
    }
    
    public ArrayList<BookDTO> bookListByDate(String dateFrom, String dateTo) {
        connection = new DBConnection();
        ArrayList<BookDTO> bList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `book` WHERE `date_received` BETWEEN '"+ dateFrom + "' AND '" + dateTo + "'";
        ResultSet rs = connection.SQLQuery(selectQuery);
        BookDTO bookDTO;
        
        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String isbn = rs.getString("isbn");
                String name = rs.getString("name");
                int author_id = rs.getInt("author_id");
                int genre_id = rs.getInt("genre_id");
                int quantity = rs.getInt("totalQuantity");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                String date_received = rs.getString("date_received");
                String description = rs.getString("description");
                String cover = rs.getString("picture");
                
                bookDTO = new BookDTO(id, name, isbn, genre_id, author_id, publisher, price, date_received, description, quantity, cover);
                bList.add(bookDTO);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        
        return bList;
    }
    
    public ResultSet displayBooksCover() {
        connection = new DBConnection();
        String selectQuery = "SELECT `picture` FROM `book` ORDER BY `id` LIMIT 5";
        ResultSet rs = connection.SQLQuery(selectQuery);
        connection.closeConnection();
        return  rs;
    }
    
    public ResultSet searchBookByISBN(String _isbn) {
        connection = new DBConnection();
        String selectQuery = "SELECT * FROM `book` WHERE `isbn` = '"+ _isbn +"'";
        ResultSet rs = connection.SQLQuery(selectQuery);
        connection.closeConnection();
        return rs;
    }
}
