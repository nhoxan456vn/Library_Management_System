/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Manh Hai
 */
public class DBConnection {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private String DBName = null;
    private String username = null;
    private String password = null;
    
    private final String ipAddress = "localhost:1433";
    
    public DBConnection(){
        if (checkDriver() == true){
            this.DBName = "QLTV";
            this.username = "sa";
            this.password = "123456";
            setupConnection();
        }
    }
    
    public DBConnection(String DBName, String username, String password){
        if (checkDriver()){
            this.DBName = DBName;
            this.username = username;
            this.password = password;
            setupConnection();
        }
    }
    
    private boolean checkDriver(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver”");
            return true;
        }
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Không tìm thấy MySql Driver.");
            System.err.print(e);
            return false;
        }
    }
    
    private void setupConnection(){
        try{
            String DBurl = "jdbc:sqlserver://hostname:1433;databaseName=QLTV";
            String username="sa"; String password= "123456";
            conn = DriverManager.getConnection(DBurl, username, password);
            Connection conn= DriverManager.getConnection(DBurl,username, password);
            stmt = conn.createStatement();
            System.out.println("Thành Công! Đã kết nối tới " + DBName);
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Không thể kết nối tới " + DBName);
            System.err.println(e);
        }
    }
    
    private boolean checkConnection(){
        if (conn == null || stmt == null){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Chưa thiết lập kết nối tới " + DBName + ". Vui lòng đăng nhập để thiết lập kết nối!");
            return false;
        }
        else{
            return true;
        }
    }
    
    public ResultSet SQLQuery(String query){
        if (checkConnection()){
            try{
                rs = stmt.executeQuery(query);
                System.out.println(query + " truy vấn thành công!");
                return rs;
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Lỗi!!! Không thể truy vấn dữ liệu");
                return null;
            }
        }
        else{
            return null;
        }
    }
    
    public boolean SQLUpdate(String update){
        if (checkConnection()){
             try{
                stmt.executeUpdate(update);
                System.out.println(update + " cập nhật thành công!");
                return true;
            }
            catch (SQLException e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Lỗi!!! Không thể cập nhật dữ liệu");
                return false;
            }
        }
        else{
            return false;
        }
    }
    
    public void closeConnection(){
        try{
            if (conn != null){
                conn.close();
            }
            if (stmt != null){
                stmt.close();
            }
            System.out.println("Đã ngắt kết nối tới Database.");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Không thể đóng kết nối tới " + DBName);
        }
    }
}
