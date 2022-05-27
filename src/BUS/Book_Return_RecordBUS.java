/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Return_RecordDAO;
import DTO.Book_Return_RecordDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Return_RecordBUS {
    private static ArrayList<Book_Return_RecordDTO> arrBookReturnRecord = new ArrayList<>();
    private Book_Return_RecordDAO bookReturnRecordDAO = new Book_Return_RecordDAO();

    public Book_Return_RecordBUS() {
        arrBookReturnRecord = bookReturnRecordDAO.readDB();
    }
    
    public void readDB(){
        arrBookReturnRecord = bookReturnRecordDAO.readDB();
    }
    
    public Boolean add(Book_Return_RecordDTO brrdto){
        Boolean check = bookReturnRecordDAO.add(brrdto);
        if (check){
            arrBookReturnRecord.add(brrdto);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookReturnRecordDAO.del(id);
        if (check){
            for (Book_Return_RecordDTO brrdto : arrBookReturnRecord){
                if (brrdto.getRt_id() == id){
                    arrBookReturnRecord.remove(brrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Return_RecordDTO brrdto){
        Boolean check = bookReturnRecordDAO.upd(brrdto);  
        if (check){
            for (Book_Return_RecordDTO b : arrBookReturnRecord){
                if (b.getRt_id()== brrdto.getBr_id()){
                    arrBookReturnRecord.set(arrBookReturnRecord.indexOf(b), brrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Return_RecordDTO> getArrBRR() {
        readDB();
        return arrBookReturnRecord;
    }
    
    public int getArrSize(){
        return arrBookReturnRecord.size();
    }
}
