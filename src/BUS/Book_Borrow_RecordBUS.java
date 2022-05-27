/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Borrow_RecordDAO;
import DTO.Book_Borrow_RecordDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Borrow_RecordBUS {
    private static ArrayList<Book_Borrow_RecordDTO> arrBookBorrowRecord = new ArrayList<>();
    private Book_Borrow_RecordDAO bookBorrowRecordDAO = new Book_Borrow_RecordDAO();

    public Book_Borrow_RecordBUS() {
        arrBookBorrowRecord = bookBorrowRecordDAO.readDB();
    }
    
    public void readDB(){
        arrBookBorrowRecord = bookBorrowRecordDAO.readDB();
    }
    
    public Boolean add(Book_Borrow_RecordDTO bookBorrowRecord){
        Boolean check = bookBorrowRecordDAO.add(bookBorrowRecord);
        if (check){
            arrBookBorrowRecord.add(bookBorrowRecord);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookBorrowRecordDAO.del(id);
        if (check){
            for (Book_Borrow_RecordDTO bbrdto : arrBookBorrowRecord){
                if (bbrdto.getId() == id){
                    arrBookBorrowRecord.remove(bbrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Borrow_RecordDTO bbrdto){
        Boolean check = bookBorrowRecordDAO.upd(bbrdto);  
        if (check){
            for (Book_Borrow_RecordDTO b : arrBookBorrowRecord){
                if (b.getId() == bbrdto.getId()){
                    arrBookBorrowRecord.set(arrBookBorrowRecord.indexOf(b), bbrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Borrow_RecordDTO> getArrBBR() {
        readDB();
        return arrBookBorrowRecord;
    }
    
    public int getArrSize(){
        return arrBookBorrowRecord.size();
    }
}
