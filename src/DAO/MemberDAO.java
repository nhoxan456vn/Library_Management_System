/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MemberDTO;
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
public class MemberDAO {
    DBConnection connection;
    
    public ArrayList<MemberDTO> readDB(){
        connection = new DBConnection();
        ArrayList<MemberDTO> arrMember = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM `member`";
            ResultSet rs = connection.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phoneNumber = rs.getString("phoneNumber");
                    String email = rs.getString("email");
                    String gender = rs.getString("gender");
                    String picture = rs.getString("picture");
                    arrMember.add(new MemberDTO(id, firstName, lastName, phoneNumber, email, gender, picture));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Member");
        } 
        finally{
            connection.closeConnection();
        }
        return arrMember;
    }
    
    public Boolean add(MemberDTO member){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("INSERT INTO `member`(`firstName`, `lastName`, `phoneNumber`, `email`, `gender`, `picture`) VALUES ('"+member.getFirstName()+"','"+member.getLastName()+"','"+member.getPhoneNumber()+"','"+member.getEmail()+"','"+member.getGender()+"','"+member.getPicture()+"')"); 
        connection.closeConnection();
        return check;
    }
    
     public Boolean del(int id){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("DELETE FROM `member` WHERE `id` = " + id);
        connection.closeConnection();
        return check;
    }
    
    public Boolean upd(MemberDTO member){
        connection = new DBConnection();
        Boolean check = connection.SQLUpdate("UPDATE `member` SET "
                + "`firstName`='"+member.getFirstName()
                +"',`lastName`='"+member.getLastName()
                +"',`phoneNumber`='"+member.getPhoneNumber()
                +"',`email`='"+member.getEmail()
                +"',`gender`='"+member.getGender()
                +"',`picture`='"+member.getPicture()
                +"' WHERE `id`='"+member.getId()+"'");
        connection.closeConnection();
        return check;
    }
    
    public Boolean hasMemberID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `member` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
    
    public ArrayList<MemberDTO> MemberByName(String value) {
        connection = new DBConnection();
        ArrayList<MemberDTO> mList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `member` WHERE `firstName` LIKE '%"+value+"%' OR `lastName` LIKE '%"+value+"%'";
        ResultSet rs = connection.SQLQuery(selectQuery);
        MemberDTO member;
        try {
            while(rs.next()) {
                member = new MemberDTO(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("gender"), rs.getString("picture"));
                mList.add(member);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.closeConnection();
        return mList;
    }

    public boolean hasID(int id) {
        connection = new DBConnection();
        boolean result = false;
        try {
            String query = "SELECT * FROM `member` WHERE `id`='"+id+"'";
            ResultSet rs = connection.SQLQuery(query);
            result = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connection.closeConnection();
        }
        return result;
    }
}
