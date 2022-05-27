/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Borrow_Record_DetailDAO;
import DTO.Book_Borrow_Record_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Borrow_Record_DetailBUS {
    private static ArrayList<Book_Borrow_Record_DetailDTO> arrBookBorrowRecordDetail = new ArrayList<>();
    private Book_Borrow_Record_DetailDAO bookBorrowRecordDetailDAO = new Book_Borrow_Record_DetailDAO();

    public Book_Borrow_Record_DetailBUS() {
        arrBookBorrowRecordDetail = bookBorrowRecordDetailDAO.readDB();
    }
    
    public void readDB(){
        arrBookBorrowRecordDetail = bookBorrowRecordDetailDAO.readDB();
    }
    
    public Boolean add(Book_Borrow_Record_DetailDTO bbrdbus){
        Boolean check = bookBorrowRecordDetailDAO.add(bbrdbus);
        if (check){
            arrBookBorrowRecordDetail.add(bbrdbus);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookBorrowRecordDetailDAO.del(id);
        if (check){
            for (Book_Borrow_Record_DetailDTO bbrddto : arrBookBorrowRecordDetail){
                if (bbrddto.getBr_detail_id() == id){
                    arrBookBorrowRecordDetail.remove(bbrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Borrow_Record_DetailDTO bbrddto){
        Boolean check = bookBorrowRecordDetailDAO.upd(bbrddto);  
        if (check){
            for (Book_Borrow_Record_DetailDTO b : arrBookBorrowRecordDetail){
                if (b.getBr_detail_id() == bbrddto.getBr_detail_id()){
                    arrBookBorrowRecordDetail.set(arrBookBorrowRecordDetail.indexOf(b), bbrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Borrow_Record_DetailDTO> getArrBBRD() {
        readDB();
        return arrBookBorrowRecordDetail;
    }
    
    public int getArrSize(){
        return arrBookBorrowRecordDetail.size();
    }
}
