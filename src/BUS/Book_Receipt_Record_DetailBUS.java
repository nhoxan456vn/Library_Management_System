/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Receipt_Record_DetailDAO;
import DTO.Book_Receipt_Record_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Receipt_Record_DetailBUS {
    private static ArrayList<Book_Receipt_Record_DetailDTO> arrBookReciptRecord = new ArrayList<>();
    private Book_Receipt_Record_DetailDAO bookReceiptRecordDetailDAO = new Book_Receipt_Record_DetailDAO();

    public Book_Receipt_Record_DetailBUS() {
        arrBookReciptRecord = bookReceiptRecordDetailDAO.readDB();
    }
    
    public void readDB(){
        arrBookReciptRecord = bookReceiptRecordDetailDAO.readDB();
    }
    
    public Boolean add(Book_Receipt_Record_DetailDTO brrddao){
        Boolean check = bookReceiptRecordDetailDAO.add(brrddao);
        if (check){
            arrBookReciptRecord.add(brrddao);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookReceiptRecordDetailDAO.del(id);
        if (check){
            for (Book_Receipt_Record_DetailDTO brrddto : arrBookReciptRecord){
                if (brrddto.getReceipt_detail_id() == id){
                    arrBookReciptRecord.remove(brrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Receipt_Record_DetailDTO brrddto){
        Boolean check = bookReceiptRecordDetailDAO.upd(brrddto);  
        if (check){
            for (Book_Receipt_Record_DetailDTO b : arrBookReciptRecord){
                if (b.getReceipt_detail_id() == brrddto.getReceipt_detail_id()){
                    arrBookReciptRecord.set(arrBookReciptRecord.indexOf(b), brrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Receipt_Record_DetailDTO> getArrBRRD() {
        readDB();
        return arrBookReciptRecord;
    }
    
    public int getArrSize(){
        return arrBookReciptRecord.size();
    }
}
