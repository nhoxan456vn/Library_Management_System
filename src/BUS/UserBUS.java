/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.UserDAO;
import DTO.UserDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manh Hai
 */
public class UserBUS {
    private static ArrayList<UserDTO> arrUser = new ArrayList<>();
    private UserDAO userDAO = new UserDAO();

    public UserBUS() {
        arrUser = userDAO.readDB();
    }
    
    public void readDB(){
        arrUser = userDAO.readDB();
    }
    
    public Boolean add(UserDTO user){
        Boolean check = userDAO.add(user);
        if (check){
            arrUser.add(user);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = userDAO.del(id);
        if (check){
            for (UserDTO user : arrUser){
                if (user.getId() == id){
                    arrUser.remove(user);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(UserDTO user){
        Boolean check = userDAO.upd(user);  
        if (check){
            for (UserDTO u : arrUser){
                if (u.getId() == user.getId()){
                    arrUser.set(arrUser.indexOf(u), user);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<UserDTO> getArrUser() {
        readDB();
        return arrUser;
    }
    
    public int getArrSize(){
        return arrUser.size();
    }
    
    public UserDTO tryLogin(String username, String password) {
        for (UserDTO userDTO : arrUser) {
            if(userDTO.getUserName().equals(username) && userDTO.getPassword().equals(password)) {
                return userDTO;
            }
        }
        return null;
    }
    
    public boolean checkUserNameExsit(int id, String username) {
        ResultSet rs = userDAO.findUserName(id, username);
        boolean exist = false;

        try {
            while(rs.next()) {
                exist = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserBUS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exist;
    }
}
