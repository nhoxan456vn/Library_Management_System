/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Book_Return_Record_DetailDAO;
import DTO.Book_Return_Record_DetailDTO;
import java.util.ArrayList;

/**
 *
 * @author Manh Hai
 */
public class Book_Return_Record_DetailBUS {
    private static ArrayList<Book_Return_Record_DetailDTO> arrBookReturnRecordDetail = new ArrayList<>();
    private Book_Return_Record_DetailDAO bookReturnRecordDetailDAO = new Book_Return_Record_DetailDAO();

    public Book_Return_Record_DetailBUS() {
        arrBookReturnRecordDetail = bookReturnRecordDetailDAO.readDB();
    }
    
    public void readDB(){
        arrBookReturnRecordDetail = bookReturnRecordDetailDAO.readDB();
    }
    
    public Boolean add(Book_Return_Record_DetailDTO brrddto){
        Boolean check = bookReturnRecordDetailDAO.add(brrddto);
        if (check){
            arrBookReturnRecordDetail.add(brrddto);
        }
        return check;
    }
    
    public Boolean del(int id){
        Boolean check = bookReturnRecordDetailDAO.del(id);
        if (check){
            for (Book_Return_Record_DetailDTO brrddto : arrBookReturnRecordDetail){
                if (brrddto.getRt_detail_id() == id){
                    arrBookReturnRecordDetail.remove(brrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean upd(Book_Return_Record_DetailDTO brrddto){
        Boolean check = bookReturnRecordDetailDAO.upd(brrddto);  
        if (check){
            for (Book_Return_Record_DetailDTO b : arrBookReturnRecordDetail){
                if (b.getRt_detail_id()== brrddto.getRt_detail_id()){
                    arrBookReturnRecordDetail.set(arrBookReturnRecordDetail.indexOf(b), brrddto);
                    break;
                }
            }
        } 
        return check;
    }
    
    public ArrayList<Book_Return_Record_DetailDTO> getArrBRRD() {
        readDB();
        return arrBookReturnRecordDetail;
    }
    
    public int getArrSize(){
        return arrBookReturnRecordDetail.size();
    }
}
