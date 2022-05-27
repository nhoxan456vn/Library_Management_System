/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LibrarianDAO;
import DTO.LibrarianDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class LibrarianBUS {
    private static ArrayList<LibrarianDTO> arrLibrarian = new ArrayList<>();
    private LibrarianDAO librarianDAO = new LibrarianDAO();

    public LibrarianBUS() {
        arrLibrarian = librarianDAO.readDB();
    }
    
    public void readDB(){
        arrLibrarian = librarianDAO.readDB();
    }
    
    public Boolean add(LibrarianDTO librarian){
        Boolean check = librarianDAO.add(librarian);
        if (check){
            arrLibrarian.add(librarian);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = librarianDAO.del(id);
        if (check){
            for (LibrarianDTO librarian : arrLibrarian){
                if (librarian.getId() == id){
                    arrLibrarian.remove(librarian);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(LibrarianDTO librarian){
        Boolean check = librarianDAO.upd(librarian);  
        if (check){
            for (LibrarianDTO l : arrLibrarian){
                if (l.getId() == librarian.getId()){
                    arrLibrarian.set(arrLibrarian.indexOf(l), librarian);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<LibrarianDTO> getArrLibrarian() {
        readDB();
        return arrLibrarian;
    }
    
    public int getArrSize(){
        return arrLibrarian.size();
    }
}
