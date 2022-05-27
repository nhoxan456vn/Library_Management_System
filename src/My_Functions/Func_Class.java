/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Functions;

import DAO.DBConnection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manh Hai
 */
public class Func_Class {
    DBConnection connection;
    
    public void displayImageByPath(int width, int height, String imagePath, JLabel label) {
        
        ImageIcon imgIco;
        
        try {
            // get the image from project resoures
            imgIco = new ImageIcon(getClass().getResource(imagePath));
        } catch (Exception e) {
            // get the image from desktop
            imgIco = new ImageIcon(imagePath);
        }
        
        // make the image fit the jlabel
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }
    
    public void displayImageByBytes(int width, int height, byte[] imageByte, JLabel label) {
        // get the image
        ImageIcon imgIco = new ImageIcon(imageByte);
        
        // make the image fit the jlabel
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        // set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }
    
    // create a function to return resultSet
    // we will use this function to reduce the code when populating the arrayList
    
//    public ResultSet getData(String query) {
//        PreparedStatement ps;
//        ResultSet rs = null;
//        
//        try {
//            ps = dBConnection.getConnection().prepareStatement(query);
//            rs = ps.executeQuery();
//        } catch (SQLException ex) {
//            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return rs;
//    }
    
    // create a funtion to count the number or data
    public int countData(String tableName) {
        connection = new DBConnection();
        String countQuery = "SELECT COUNT(*) as total FROM `"+tableName+"`";
        ResultSet rs = connection.SQLQuery(countQuery);
        
        int total = 0;
        try {
            if(rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
    }
    
    // create a function to customize the jtable
    public void customTable(JTable table) {
        table.setSelectionBackground(new Color(249, 105, 14));
        table.setSelectionForeground(Color.white);
        table.setRowHeight(35);
        table.setShowGrid(false);
        table.setBackground(new Color(248, 248, 248));
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.orange);
    }
    
    // create a function to customize the jtable header
    public void customTableHeader(JTable table, Color brColor, Integer fontSize) {
        table.getTableHeader().setBackground(brColor);
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, fontSize));
        table.getTableHeader().setOpaque(false);
    }
}
