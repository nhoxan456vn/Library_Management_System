/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.AuthorDAO;
import DTO.AuthorDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class AuthorBUS {
    private static ArrayList<AuthorDTO> arrAuthor = new ArrayList<>();
    private AuthorDAO authorDAO = new AuthorDAO();

    public AuthorBUS() {
        arrAuthor = authorDAO.readDB();
    }
    
    public void readDB(){
        arrAuthor = authorDAO.readDB();
    }
    
    public Boolean add(AuthorDTO author){
        Boolean check = authorDAO.add(author);
        if (check){
            arrAuthor.add(author);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = authorDAO.del(id);
        if (check){
            for (AuthorDTO author : arrAuthor){
                if (author.getId() == id){
                    arrAuthor.remove(author);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(AuthorDTO author){
        Boolean check = authorDAO.upd(author);  
        if (check){
            for (AuthorDTO a : arrAuthor){
                if (a.getId() == author.getId()){
                    arrAuthor.set(arrAuthor.indexOf(a), author);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<AuthorDTO> getArrAuthor() {
        readDB();
        return arrAuthor;
    }
    
    public int getArrSize(){
        return arrAuthor.size();
    }

    public AuthorDTO getAuthorByID(int author_id) {
        if(authorDAO.hasAuthorID(author_id)) {
            AuthorDTO adto = new AuthorDTO();
            for (AuthorDTO authorDTO : arrAuthor) {
                if(authorDTO.getId() == author_id) {
                    adto = authorDTO;
                    return authorDTO;
                }
            }
        }
        return null;
    }
    
    
}
