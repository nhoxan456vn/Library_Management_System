/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Receipt_RecordDAO;
import DTO.Book_Receipt_RecordDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Receipt_RecordBUS {
    private static ArrayList<Book_Receipt_RecordDTO> arrBookReceiptRecord = new ArrayList<>();
    private Book_Receipt_RecordDAO bookReceiptRecordDAO = new Book_Receipt_RecordDAO();

    public Book_Receipt_RecordBUS() {
        arrBookReceiptRecord = bookReceiptRecordDAO.readDB();
    }
    
    public void readDB(){
        arrBookReceiptRecord = bookReceiptRecordDAO.readDB();
    }
    
    public Boolean add(Book_Receipt_RecordDTO brrdto){
        Boolean check = bookReceiptRecordDAO.add(brrdto);
        if (check){
            arrBookReceiptRecord.add(brrdto);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookReceiptRecordDAO.del(id);
        if (check){
            for (Book_Receipt_RecordDTO brrdto : arrBookReceiptRecord){
                if (brrdto.getReceipt_id() == id){
                    arrBookReceiptRecord.remove(brrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Receipt_RecordDTO brrdto){
        Boolean check = bookReceiptRecordDAO.upd(brrdto);  
        if (check){
            for (Book_Receipt_RecordDTO b : arrBookReceiptRecord){
                if (b.getReceipt_id() == brrdto.getReceipt_id()){
                    arrBookReceiptRecord.set(arrBookReceiptRecord.indexOf(b), brrdto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Receipt_RecordDTO> getArrBRR() {
        readDB();
        return arrBookReceiptRecord;
    }
    
    public int getArrSize(){
        return arrBookReceiptRecord.size();
    }
}
